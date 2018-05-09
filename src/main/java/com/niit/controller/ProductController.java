
package com.niit.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
//import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

//import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
//import javax.validation.Valid;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.niit.model.Product;
import com.niit.service.ProductService;

@Controller
public class ProductController {

	private static final String Product = null;
	@Autowired
	ProductService productService;

	@RequestMapping("/allProducts")
	public String getAllProducts(Model model) {
		List<Product> allProducts = productService.getAllProducts();
		model.addAttribute("products", allProducts);
		return "allProduct";

	}

	@RequestMapping("/viewProduct/{productId}")
	public String getProductById(@PathVariable("productId") int productId, Model model) {
		Product product = productService.getProductById(productId);
		model.addAttribute("products", product);
		return "viewProduct";

	}

	@RequestMapping("/admin/deleteProduct/{productId}")
	public String deleteProduct(@PathVariable int productId, Model model, HttpServletRequest request) {
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "/WEB-INF/resources/images/" + productId + ".png");

		if (Files.exists(path)) {
			try {
				Files.delete(path);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		Product product = productService.getProductById(productId);
		productService.deleteProduct(product);

		return "allProduct";
		
		
	}
	
	@RequestMapping("/admin/updateProductForm/{id}")
	public String updateProductForm(@PathVariable("id") int id, Model model) throws IOException{
		
		Product product=productService.getProductById(id);
		model.addAttribute("product", product);
		return "updateProductForm";
	}
	@RequestMapping(value = "/admin/updateProductForm/sumbit", method = RequestMethod.POST)
	public String updateProducFormtPost(@Valid @ModelAttribute("product") Product product, BindingResult result,
			HttpServletRequest request)
	{
		
		
		 if(result.hasErrors()){
	            return "updateProductForm";
	        }


	        MultipartFile productImage = product.getImage();
	        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
	        path = Paths.get(rootDirectory + "/WEB-INF/resources/images/" + product.getProductId() + ".png");

	        if(productImage != null && !productImage.isEmpty()){
	            try {
	                productImage.transferTo(new File(path.toString()));
	            } catch (Exception ex){
	                ex.printStackTrace();
	                throw new RuntimeException("Product image saving failed", ex);
	            }
	        }

	        productService.updateProduct(product);

	        return "redirect:/allProducts";
	}
	
/*
	@RequestMapping("/admin/updateProductForm/{id}")
	public String updateProductForm(@PathVariable("id") int id, Model model) {
		Product product = productService.getProductById(id);

		model.addAttribute("product", product);

		return "updateProductForm";
	}

	@RequestMapping(value = "/product/updateProductForm", method = RequestMethod.POST)
	public String updateProducFormtPost(@Valid @ModelAttribute("product") Product product, BindingResult result,
			HttpServletRequest request) {

		if (result.hasErrors()) {
			return "updateProductForm";
		}

		MultipartFile productImage = product.getImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "/WEB-INF/resources/images/" + product.getProductId() + ".png");

		if (productImage != null && !productImage.isEmpty()) {
			try {
				productImage.transferTo(new File(path.toString()));
			} catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException("Product image saving failed", ex);
			}
		}

		productService.updateProduct(product);
		;

		return "allproduct";*/


	@RequestMapping("/admin/addProduct")
	public String viewAddProductPage(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "addProduct";
	}

	private Path path;

	@RequestMapping(value = "/admin/addProduct", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute("product") Product product, BindingResult result,
			HttpServletRequest request) {
		String filename = null;
		int res = 0;
		if (result.hasErrors()) {
			return "addProduct";

		}

		/*
		 * ServletContext context=context.getServletContext();
		 * System.out.println(context); String
		 * path=context+"/resources/images/"+product.getPid()+".jpg";
		 * System.out.println("Path = "+path);
		 * System.out.println("File name = "+product.getImage().
		 * getOriginalFilename()); File f=new File(path);
		 */
		productService.addProduct(product);
		MultipartFile productImage = product.getImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "/WEB-INF/resources/images/" + product.getProductId() + ".png");
		System.out.println("Path = " + path);
		System.out.println("File name = " + product.getImage().getOriginalFilename());

		if (!product.getImage().isEmpty()) {
			try {
				// filename=p.getImage().getOriginalFilename();
				// byte[] bytes=product.getImage().getBytes();
				/*
				 * BufferedOutputStream bs=new BufferedOutputStream(new
				 * FileOutputStream(f)); bs.write(bytes); bs.close();
				 * System.out.println("Image uploaded");
				 */

				productImage.transferTo(new File(path.toString()));
				System.out.println("Image uploaded");

				// if(result.hasErrors()){
				// return "addProduct";
				// }
			} catch (Exception ex) {
				ex.printStackTrace();
			}

		} else {
			res = 0;
		}
		return "redirect:/allProducts";
		// return "viewProduct";

	}
}