package com.WS.Controller.admin;


import com.WS.Dao.CategoryDAO;
import com.WS.Dao.ProductDAO;
import com.WS.Dao.SupplierDAO;
import com.WS.Service.CookieService;
import com.WS.Service.ParamService;
import com.WS.Service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/thongke")
public class ThongkeControllerAdmin {
    @Autowired
    private ProductDAO productDao;

    @Autowired
    private CategoryDAO categoryDao;

    @Autowired
    private SupplierDAO supplierDAO;

    @Autowired
    CookieService cookieService;

    @Autowired
    ParamService paramService;

    @Autowired
    SessionService sessionService;


    @GetMapping("/sanpham")
    public String homeAdmin(Model model) {

        List<Object[]> thongKeList = productDao.thongKeSanPham();
        model.addAttribute("thongKeList", thongKeList);

        Pageable pageable = PageRequest.of(0, 3);
        List<Object[]> thongkeTop3TheLoai = productDao.thongketop3theloai(pageable);
        model.addAttribute("thongkeTop3TheLoai",thongkeTop3TheLoai);

        List<Object[]> thongKeSanPhamGioiTinhTrue = productDao.thongKeSanPhamGioiTinhTrue(PageRequest.of(0, 3));
        model.addAttribute("thongKeSanPhamGioiTinhTrue", thongKeSanPhamGioiTinhTrue);

        List<Object[]> thongKeSanPhamGioiTinhFalse = productDao.thongKeSanPhamGioiTinhFalse(PageRequest.of(0, 3));
        model.addAttribute("thongKeSanPhamGioiTinhFalse", thongKeSanPhamGioiTinhFalse);


//        List<Object[]> thongKeTongSoLuongDonHangTheoThangNam = productDao.thongKeTongSoLuongDonHangTheoThangNam();
//        model.addAttribute("thongKeTongSoLuongDonHangTheoThangNam", thongKeTongSoLuongDonHangTheoThangNam);

        return "admin/thongke";
    }
    @GetMapping("/doanhthu")
    public String thongKeDoanhThu(Model model){
        List<Object[]> thongKeTongSoLuongDonHangTheoThangNam = productDao.thongKeTongSoLuongDonHangTheoThangNam();
        model.addAttribute("thongKeTongSoLuongDonHangTheoThangNam", thongKeTongSoLuongDonHangTheoThangNam);
        return "admin/thongkedoanhthu";
    }
}
