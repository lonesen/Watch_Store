package com.WS.Controller.admin;

import com.WS.Dao.CategoryDAO;
import com.WS.Dao.ProductDAO;
import com.WS.Dao.SupplierDAO;
import com.WS.Entity.Category;
import com.WS.Entity.Product;
import com.WS.Entity.Supplier;
import com.WS.Service.CookieService;
import com.WS.Service.ParamService;
import com.WS.Service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class HomeControllerAdmin {

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


    @GetMapping("/home")
    public String homeAdmin() {
        return "redirect:/admin/thongke/sanpham";
    }
//    @GetMapping("/bieudo")
//    public String getDataFormDB(){
//        List<Product> dataList= productDao.findAll();
//
//    }
    @GetMapping("/OverViewProduct")
    public String xemSanPham(Model model) {
        List<Product> products = productDao.findAllActiveProductV1();
        List<Category> category = categoryDao.findAll();
        List<Supplier> supplier = supplierDAO.findAll();

        model.addAttribute("products", products);
        model.addAttribute("category",category);
        model.addAttribute("supplier",supplier);
        return "admin/sanpham-overview";
    }

    @GetMapping("/sortProducts")
    @ResponseBody
    public List<Product> sortProducts(
            @RequestParam(name = "sortField1", required = false) String sortField1,
            @RequestParam(name = "sortDir1", required = false) String sortDir1,
            @RequestParam(name = "sortField2", required = false) String sortField2,
            @RequestParam(name = "sortDir2", required = false) String sortDir2,
            @RequestParam(name = "categoryName", required = false) String categoryName,
            @RequestParam(name = "supplierName", required = false) String supplierName) {

        Sort sort = Sort.unsorted();

        if (sortField1 != null && sortDir1 != null) {
            sort = Sort.by(Sort.Direction.fromString(sortDir1), sortField1);
        }

        if (sortField2 != null && sortDir2 != null) {
            sort = sort.and(Sort.by(Sort.Direction.fromString(sortDir2), sortField2));
        }

        List<Product> products;
        if (categoryName != null && !categoryName.isEmpty() && supplierName != null && !supplierName.isEmpty()) {
            products = productDao.findAllActiveProductByCategoryAndSupplier(categoryName, supplierName, sort);
        } else if (categoryName != null && !categoryName.isEmpty()) {
            products = productDao.findAllActiveProductByCategoryName(categoryName, sort);
        } else if (supplierName != null && !supplierName.isEmpty()) {
            products = productDao.findAllActiveProductBySupplierName(supplierName, sort);
        } else {
            products = productDao.findAllActiveProductV2(sort);
        }

        // Log sản phẩm để kiểm tra
        products.forEach(product -> {
            System.out.println("Product: " + product.getName() + ", Price: " + product.getPrice());
        });

        return products;
    }
    @GetMapping("/searchProducts")
    @ResponseBody
    public List<Product> searchProducts(@RequestParam(name = "keywords") String keywords) {
        List<Product> products = productDao.searchProductsByNameOrDescription(keywords);
        return products;
    }









    @GetMapping("/OverViewProduct/delete/{id}")
    public String deleteProduct(@PathVariable("id") String id){
        // Tìm sản phẩm theo id
        Product product = productDao.findById(id).orElse(null);
        System.out.println(product+"");
        // Nếu sản phẩm tồn tại
        if (product != null) {
            // Set thuộc tính activated thành false
            product.setActivated(false);
            // Lưu lại sản phẩm
            productDao.save(product);
        }

        // Chuyển hướng về trang tổng quan sản phẩm
        return "redirect:/admin/OverViewProduct";
    }

    @GetMapping("/AddProduct")
    public String OverviewInsertProduct(Model model){
        List<Category> category = categoryDao.findAll();
        List<Supplier> supplier = supplierDAO.findAll();
        model.addAttribute("category",category);
        model.addAttribute("supplier",supplier);
        return "admin/themsanpham";
    }

    @PostMapping("/AddProduct/create")
    public String CreateProduct(Product product, @RequestParam("photo_file") MultipartFile attach, RedirectAttributes redirectAttributes){
        File saveFile = paramService.saveFile(attach, "img");
        product.setImage(saveFile.getName());
        product.setActivated(true);
        productDao.saveAndFlush(product);
        redirectAttributes.addFlashAttribute("message", "Tạo sản phẩm thành công!");
        return "redirect:/admin/AddProduct";
    }
//    @RequestMapping("/AddProduct/edit/{id}")
//    public String editProduct(@PathVariable("id") String id, Model model){
//        Product product = productDao.findProductById(id);
//        model.addAttribute("product",product);
//        List<Product> products = productDao.findAll();
//        model.addAttribute("products",products);
//        return "admin/themsanpham";
//
//    }
    @GetMapping("/AddProduct/edit/{id}")
    public String editProduct(@PathVariable("id") String id, Model model) {
        Product product = productDao.findById(id).orElse(null);
        if (product != null) {
            model.addAttribute("product", product);
        }
        List<Category> category = categoryDao.findAll();
        List<Supplier> supplier = supplierDAO.findAll();
        model.addAttribute("isEdit", true);
        model.addAttribute("category", category);
        model.addAttribute("supplier", supplier);

        return "admin/themsanpham";
    }
    @PostMapping("/AddProduct/update")
    public String updateProduct(Product product, @RequestParam("photo_file") MultipartFile attach, RedirectAttributes redirectAttributes){
        if (!attach.isEmpty()) {
            File saveFile = paramService.saveFile(attach, "img");
            product.setImage(saveFile.getName());
        }
        productDao.saveAndFlush(product);
        redirectAttributes.addFlashAttribute("message", "Cập nhật sản phẩm thành công!");
        return "redirect:/admin/OverViewProduct";
    }

    @GetMapping("/OverViewCategory")
    public String xemCategory(Model model){
//        List<Category> category = productDao.findAllActiveProductV1();
        List<Category> category = categoryDao.findAllActivatedCategory();
        model.addAttribute("category",category);
        return "admin/theloai-overview";
    }

    @GetMapping("/sortCategory")
    @ResponseBody
    public List<Category> sortCategory(
            @RequestParam(name = "sortField1", required = false) String sortField1,
            @RequestParam(name = "sortDir1", required = false) String sortDir1) {

        Sort sort = Sort.unsorted();

        if (sortField1 != null && sortDir1 != null) {
            sort = Sort.by(Sort.Direction.fromString(sortDir1), sortField1);
        }

        List<Category> categories = categoryDao.findAllActivatedCategoryV2(sort);
        return categories;
    }
//    @GetMapping("/searchCategory")
//    @ResponseBody
//    public List<Category> searchCategory(@RequestParam(name = "keywords") String keywords) {
//        List<Category> categories = categoryDao.searchCategoryByName(keywords);
//        return categories;
//    }
@GetMapping("/searchCategory")
@ResponseBody
public List<Category> searchCategory(@RequestParam(name = "keywords", required = false) String keywords) {
    if (keywords == null || keywords.isEmpty()) {
        return categoryDao.findAllActivatedCategory();
    }
    return categoryDao.searchCategoryByName(keywords);
}



    @GetMapping("/AddCategory")
    public String OverviewInsertCategory(Model model){
        return "admin/themtheloai";
    }

    @GetMapping("/OverViewCategory/delete/{id}")
    public String deleteCategory(@PathVariable("id") Integer id){
        // Tìm sản phẩm theo id
        Category category = categoryDao.findById(id).orElse(null);
        System.out.println(category+"");
        // Nếu sản phẩm tồn tại
        if (category != null) {
            // Set thuộc tính activated thành false
            category.setActivated(false);
            // Lưu lại sản phẩm
            categoryDao.save(category);
        }
        return "redirect:/admin/OverViewCategory";
    }


    @GetMapping("/AddCategory/edit/{id}")
    public String editCategory(@PathVariable("id") Integer id, Model model) {
        Category category = categoryDao.findById(id).orElse(null);
        if (category != null) {
            model.addAttribute("category", category);
        }
        model.addAttribute("isEdit", true);
        return "admin/themtheloai";
    }
    @PostMapping("/AddCategory/save")
    public String saveCategory(@ModelAttribute("category") Category category, Model model) {
        if (category.getId() == null) {
            category.setActivated(true);
        }
        categoryDao.saveAndFlush(category);
        return "redirect:/admin/OverViewCategory";
    }

    @GetMapping("/OverViewSupplier")
    public String OverviewInsertSupplier(Model model){
        List<Supplier> supplier = supplierDAO.findAllActivatedSupplier();
        model.addAttribute("supplier",supplier);
        return "admin/nhacungcap-overview";
    }
    @GetMapping("/sortSupplier")
    @ResponseBody
    public List<Supplier> sortSupplier(
            @RequestParam(name = "sortField1", required = false) String sortField1,
            @RequestParam(name = "sortDir1", required = false) String sortDir1) {

        Sort sort = Sort.unsorted();

        if (sortField1 != null && sortDir1 != null) {
            sort = Sort.by(Sort.Direction.fromString(sortDir1), sortField1);
        }

        List<Supplier> suppliers = supplierDAO.findAllActivatedSupplierV2(sort);
        return suppliers;
    }
    @GetMapping("/searchSupplier")
    @ResponseBody
    public List<Supplier> searchSupplier(@RequestParam(name = "keywords", required = false) String keywords) {
        if (keywords == null || keywords.isEmpty()) {
            return supplierDAO.findAllActivatedSupplier();
        }
        return supplierDAO.searchSupplierByName(keywords);
    }
    @GetMapping("/OverViewSupplier/delete/{id}")
    public String deleteSupplier(@PathVariable("id") Integer id){
        // Tìm sản phẩm theo id
        Supplier supplier = supplierDAO.findById(id).orElse(null);
        System.out.println(supplier+"");
        // Nếu sản phẩm tồn tại
        if (supplier != null) {
            // Set thuộc tính activated thành false
            supplier.setActivated(false);
            // Lưu lại sản phẩm
            supplierDAO.save(supplier);
        }
        return "redirect:/admin/OverViewSupplier";
    }

    @GetMapping("/AddSupplier")
    public String OverviewInsertSupplier(){
        return "admin/themnhacungcap";
    }
    @GetMapping("/AddSupplier/edit/{id}")
    public String editSupplier(@PathVariable("id") Integer id, Model model) {
        Supplier supplier = supplierDAO.findById(id).orElse(null);
        if (supplier != null) {
            model.addAttribute("supplier", supplier);
        }
        model.addAttribute("isEdit", true);
        return "admin/themnhacungcap";
    }
    @PostMapping("/AddSupplier/save")
    public String saveSupplier(@ModelAttribute("category") Supplier supplier, Model model) {
        if (supplier.getId() == null) {
            supplier.setActivated(true);
        }
        supplierDAO.saveAndFlush(supplier);
        return "redirect:/admin/OverViewSupplier";
    }
}
