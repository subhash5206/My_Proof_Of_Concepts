package in.nareshit.raghu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.nareshit.raghu.model.Product;
import in.nareshit.raghu.service.IProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private IProductService service;

	//1. show Register page
	//.../product/register
	@GetMapping("/register")
	public String showReg() {
		return "ProductRegister";
	}


	//2. on click submit button
	/**
	 * Read Form Data as ModelAttribute
	 * save in database using service.save(p)
	 * return message to UI (ProductRegisterPage)
	 * 
	 */
	@PostMapping("/save")
	public String saveProd(
			@ModelAttribute Product product,
			Model model
			) 
	{
		Integer id = service.saveProduct(product);
		model.addAttribute("message", "SAVED WITH ID : "+id);
		return "ProductRegister";
	}

	//3. Display all rows at UI
	/**
	 * If we enter URL : /product/all in browser
	 * then get all rows as List from Database
	 * send to UI using Model memory.
	 * 
	 */
	@GetMapping("/all")
	public String getAll(Model model) {
		List<Product> list = service.getAllProcust();
		model.addAttribute("list", list);
		return "ProductData";
	}



	//4. Remove one row by Id

	//...delete?id=__
	@GetMapping("/delete")
	public String remove(
			@RequestParam Integer id,
			Model model
			) 
	{
		service.deleteProduct(id);

		//display latest data
		List<Product> list = service.getAllProcust();
		model.addAttribute("list", list);

		//send message to ui
		model.addAttribute("message", "Product '"+id+"' Deleted");

		//return "redirect:all";
		return "ProductData";
	}


	//5. show edit page
	@GetMapping("/edit")
	public String showEdit(
			@RequestParam Integer id, //read input
			Model model
			) 
	{
		//call service to get one object
		Product product  = service.getOneProduct(id);
		//send data to Form For Edit
		model.addAttribute("product", product);

		return "ProductEdit";
	}

	//6. on click update button
	@PostMapping("/update")
	public String update(
			@ModelAttribute Product product,Model model)
	{

		service.updateProduct(product);
		
		//display latest data
		List<Product> list = service.getAllProcust();
		model.addAttribute("list", list);

		//send message to ui
		model.addAttribute("message", "Product '"+product.getProdId()+"' Update");

		//return "redirect:all";
		return "ProductData";
	}




}
