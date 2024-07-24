package com.WS.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.WS.Service.ProductService;
import com.WS.Service.SessionService;
import com.WS.Dao.ProductDAO;
import com.WS.Entity.Product;

import java.util.Optional;

@Controller
public class ProductController {

	@Autowired
	ProductDAO dao;

	@Autowired
	SessionService session;
	
	@Autowired
	private ProductService productService;

	@RequestMapping("/productDetail/{id}")
	public String GoPageDetail(Model model, @PathVariable("id") String id) {
		Optional<Product> productOpt = productService.findProductById(id);

		if (productOpt.isPresent()) {
			Product product = productOpt.get();
			model.addAttribute("product", product);
			return "user/product_details";
		} else {
			return "redirect:/error";
		}
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/shop")
	public String showShop(Model m, @RequestParam(value = "p", defaultValue = "0") int page) {
		Pageable pageable = PageRequest.of(page, 16);
		Page<Product> productsPage = dao.findAllByNameLike("% %", pageable);
		m.addAttribute("page", productsPage);
		m.addAttribute("currentPage", page);
		return "user/shop";
	}

	@RequestMapping(value = "/shop/shopSort")
	public String sortShop(Model m, @RequestParam(value = "direction", defaultValue = "asc") String direction,
			@RequestParam("keywords") Optional<String> kw, @RequestParam("p") Optional<Integer> p,
			@RequestParam("field") Optional<String> field,
			@RequestParam(value = "category", required = false) String categoryName) {
		Direction sortDirection = direction.equalsIgnoreCase("asc") ? Direction.ASC : Direction.DESC;
		String fieldName = field.orElse("price").toLowerCase();

		Sort sort = Sort.by(sortDirection, fieldName);
		int pageIndex = p.orElse(0);
		if (pageIndex < 0) {
			return "redirect:/product/index";
		}
		Pageable pageable = PageRequest.of(pageIndex, 16, sort);

		Page<Product> productsPage;
		
		String keywords = kw.orElse(session.get("keywords",""));
		session.set("keywords", keywords);
		
		Page<Product> page;
        if (!keywords.isEmpty()) {
            page = dao.findAllByNameLike("%" + keywords + "%", pageable);
        } else {
            page = dao.findAll(pageable);
        }
        
        
		if (categoryName != null && !categoryName.isEmpty()) {
			session.set("categoryName", categoryName);
			productsPage = dao.findByCategoryNameAndSortByPrice(categoryName, pageable);
		} else {
			if(session.get("categoryName", "").equals("")) {
				productsPage = dao.findAll(pageable);
			} else {
				productsPage = dao.findByCategoryNameAndSortByPrice(session.get("categoryName", ""), pageable);
			}
			
		}

		m.addAttribute("page", productsPage);
		m.addAttribute("sortDirection", sortDirection == Direction.ASC ? "asc" : "desc");
		m.addAttribute("currentPage", pageIndex);
		m.addAttribute("selectedCategory", categoryName);

		return "user/shop";
	}

}
