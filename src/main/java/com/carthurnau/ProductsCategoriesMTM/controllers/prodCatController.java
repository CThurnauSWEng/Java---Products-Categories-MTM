package com.carthurnau.ProductsCategoriesMTM.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.carthurnau.ProductsCategoriesMTM.models.Category;
import com.carthurnau.ProductsCategoriesMTM.models.Product;
import com.carthurnau.ProductsCategoriesMTM.services.CategoryService;
import com.carthurnau.ProductsCategoriesMTM.services.ProductService;

@Controller
public class prodCatController {
	
	private final ProductService productService;
	
	private final CategoryService categoryService;
	
	public prodCatController(ProductService productService, CategoryService categoryService) {
		this.productService = productService;
		this.categoryService = categoryService;
	}
	
	@RequestMapping("/")
	public String index(Model model) {
		
		List<Product> allProducts = productService.findAll();
		model.addAttribute("allProducts",allProducts);
		
		List<Category> allCategories = categoryService.findAll();
		model.addAttribute("allCategories",allCategories);
		
		return "index.jsp";
	}
	
	@RequestMapping("/products/new")
	public String newProductForm(Model model) {
		
		// create an instance for the jsp to bind the form to
		Product product = new Product();
		model.addAttribute("product",product);
		
		return "newProductForm.jsp";
		
	}
	
	@RequestMapping(value = "/processNewProduct", method = RequestMethod.POST)
	public String processNewProduct(Model model, @Valid @ModelAttribute("product") Product product, BindingResult result) {
		if (result.hasErrors()) {
			model.addAttribute("product",product);
			return "newProductForm.jsp";
		} else {
			productService.createProduct(product);
			return "redirect:/";
		}
	}
	
	@RequestMapping("/product/{id}")
	public String showProduct(@PathVariable("id") Long id, Model model) {

		//get the requested product
		Product product = productService.findById(id);
		model.addAttribute("product",product);
		
		//send an instance of the category for the jsp to use to access data type info
		Category category = new Category();
		model.addAttribute(category);
		
		// Get all categories this product is already in		
		List<Category> inCategories = product.getCategories();
		model.addAttribute("inCategories",inCategories);
		
		// Get all categories for the drop down menu
		List<Category> otherCategories = categoryService.findAll();
				
		// Remove the categories that already contain this product
		for (Category cat: inCategories) {
			if(otherCategories.contains(cat)) {
				System.out.println("removing: " + cat.getName());
				otherCategories.remove(cat);  
			}
		}

		model.addAttribute("otherCategories",otherCategories);
				
		return "showProductDetail.jsp";
	}
	
	@RequestMapping("/category/{id}")
	public String showCategory(@PathVariable("id") Long id, Model model) {
		
		// Get the requested category
		Category category = categoryService.findById(id);
		model.addAttribute("category",category);
		
		// Send an instance of the product for the jsp to use to access data type info
		Product product = new Product();
		model.addAttribute("product",product);
		
		// Get all of the products already in this category
		List<Product> curProducts = category.getProducts();
		model.addAttribute("curProducts",curProducts);
		
		// Get all products for the drop down menu
		List<Product> otherProducts = productService.findAll();
		
		// Remove the products that are already in this category
		for (Product prod: curProducts) {
			if(otherProducts.contains(prod)) {
				System.out.println("removing: " + prod.getName());
				otherProducts.remove(prod);
			}
		}
		
		model.addAttribute("otherProducts", otherProducts);
		
		return "showCategoryDetail.jsp";
	}
	
	@RequestMapping("/categories/new")
	public String newCategoryForm(Model model) {
		
		// create an instance for the jsp to bind the form to
		Category category = new Category();
		model.addAttribute("category",category);
		
		return "newCategoryForm.jsp";
	}
	
	@RequestMapping(value = "/processNewCategory", method = RequestMethod.POST)
	public String processNewCategory(Model model, @Valid @ModelAttribute("category") Category category, BindingResult result) {
		
		if (result.hasErrors()) {
			System.out.println("Error in processNewCategory");
			model.addAttribute("category",category);
			return "newCategoryForm.jsp";
		} else {
			System.out.println("Success in processNewCategory");
			categoryService.createCategory(category);
			return "redirect:/";
		}
	}
	
	@RequestMapping(value = "/LinkCatToProd", method = RequestMethod.POST)
	public String LinkCatToProd(Model model, @RequestParam("product") Product product, @RequestParam("category") Category category) {
		
		category.getProducts().add(product);
		categoryService.save(category);
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/LinkProdToCat", method=RequestMethod.POST)
	public String LinkProdToCat(Model model, @RequestParam("product") Product product, @RequestParam("category") Category category) {
		
		product.getCategories().add(category);
		productService.save(product);
		
		return "redirect:/";
	}
}
