package br.com.avenuecode.restcontroller;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.avenuecode.entity.ProductEntity;
import br.com.avenuecode.service.ProductService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="product")
public class ProductRestController {

	@Autowired
	private ProductService productService;

	@ApiOperation(value="A method that saves a product.")
	@RequestMapping(value="save", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON)
	public ResponseEntity<ProductEntity> save(@RequestBody ProductEntity product) {
		productService.save(product);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@ApiOperation(value="A method that deletes a product through his ID.")
	@RequestMapping(value="delete/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<ProductEntity> delete(@PathVariable("id") Long id) {
		productService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@ApiOperation(value="A method that returns all products and their relationships.")
	@RequestMapping(value="getAll", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON)
	public ResponseEntity<List<ProductEntity>> getAll() {
		List<ProductEntity> products = productService.findAll();
		return new ResponseEntity<List<ProductEntity>>(products, HttpStatus.OK);
	}

	@ApiOperation(value="A method that returns all products excluding their relationships.")
	@RequestMapping(value="getAllExcludingRelationships", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON)
	public ResponseEntity<List<ProductEntity>> getAllExcludingRelationships() {
		List<ProductEntity> products = productService.findAllExcludingRelationships();
		return new ResponseEntity<List<ProductEntity>>(products, HttpStatus.OK);
	}

	@ApiOperation(value="A method that finds a product based on this ID.") 
	@RequestMapping(value="find/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON)
	public ResponseEntity<ProductEntity> findById(@PathVariable("id") Long id) {
		ProductEntity product = productService.findById(id);
		return new ResponseEntity<ProductEntity>(product, HttpStatus.OK);
	}

	@ApiOperation(value="A method that finds a product based on this ID, excluding his relationships.")
	@RequestMapping(value="findExcludingRelationships/{id}", method=RequestMethod.GET)
	public ResponseEntity<ProductEntity> findByIdExcludingRelationships(@PathVariable("id") Long id) {
		ProductEntity product = productService.findByIdExcludingRelationships(id);
		return new ResponseEntity<ProductEntity>(product, HttpStatus.OK);
	}

	@ApiOperation(value="A method that returns all child products of a parent product.")
	@RequestMapping(value="childs", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON, produces=MediaType.APPLICATION_JSON)
	public ResponseEntity<List<ProductEntity>> childs(@RequestBody ProductEntity product) {
		List<ProductEntity> childs = productService.findProductByParentProduct(product);
		return new ResponseEntity<List<ProductEntity>>(childs, HttpStatus.OK);
	}

}
