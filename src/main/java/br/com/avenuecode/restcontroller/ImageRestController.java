package br.com.avenuecode.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.avenuecode.entity.Product;
import br.com.avenuecode.service.ImageService;

@RestController
@RequestMapping(value="product")
public class ImageRestController {

	@Autowired
	private ImageService imageService;

	@RequestMapping(value="/find/{id}", method=RequestMethod.GET)
	public ResponseEntity<Product> findById(Product product) {
//		Product product = imageService.findById(id);
//		return new ResponseEntity<>(product, HttpStatus.OK);
		return null;
	}

}
