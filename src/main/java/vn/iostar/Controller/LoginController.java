package vn.iostar.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import vn.iostar.Entity.Product;
import vn.iostar.Service.ProductServices;

@Controller
public class LoginController {

	@Autowired
	private ProductServices service;
	
	@PostMapping("login_success_handler")
	public String loginSuccessHandler() {
		System.out.println("Logging user login success...");
		
		return "index";
	}
	
	@PostMapping("login_failure_handler")
	public String loginFailureHandler() {
		System.out.println("Logging failure handler...");
		
		return "login";
	}
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		List<Product> listProducts = service.findAll();
		model.addAttribute("listProducts", listProducts);
		
		return "index";
	}
	
	@GetMapping("/new")
	public String showNewProductForm(Model model, @ModelAttribute("product") Product product) {
		model.addAttribute("product", product);
		
		return "new_product";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product") Product product) {
		service.save(product);
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductForm(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("edit_product");
		
		Product product = service.findById(id);
		mav.addObject("product", product);
		return mav;
	}
	
	public String deleteProduct(@PathVariable Long id) {
		service.deleteById(id);
		
		return "rediriect:/";
	}
	
}
