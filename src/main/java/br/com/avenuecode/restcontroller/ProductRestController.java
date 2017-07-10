package br.com.avenuecode.restcontroller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.avenuecode.entity.Image;
import br.com.avenuecode.entity.Product;
import br.com.avenuecode.service.ProductService;

@RestController
@RequestMapping(value="product")
public class ProductRestController {

	@Autowired
	ProductService productService;
	
//	@Produces(MediaType.APPLICATION_JSON)
	@RequestMapping(value="/getAll", method=RequestMethod.GET)
	public ResponseEntity<List<Product>> getAll() {
		List<Product> product = productService.findAll();
		return new ResponseEntity<List<Product>>(product, HttpStatus.OK);
	}
	
	@Consumes(MediaType.APPLICATION_JSON)
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public ResponseEntity<Product> save(Product product) {
		productService.save(product);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
//	@Consumes(MediaType.APPLICATION_JSON)
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Product> delete(@PathParam("id") Long id) {
		productService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping("/opa")
	public void opa() {
		Product product = new Product();
		product.setId(1L);
		product.setName("Product 1");
		product.setDescription("Description 1");
		
		Image image = new Image();
		image.setProduct(product);
		
		try {
			BufferedImage bi;
			File input = new File("src/test/resources/image002.png");
			bi = ImageIO.read(input);
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write( bi, "jpg", baos );
			baos.flush();
			byte[] imageInByte = baos.toByteArray();
			baos.close();
			
			image.setImage(imageInByte);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		product.setImages(new ArrayList<>());
		product.getImages().add(image);
		
		Product productChild = new Product();
		productChild.setName("Product Child");
		productChild.setDescription("Product Child Desc");
		
		product.setChildProducts(new ArrayList<>());
		product.getChildProducts().add(productChild);
		
		productService.save(product);
		
		System.out.println("GG");
	}
	
}
