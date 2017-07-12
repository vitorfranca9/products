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

import br.com.avenuecode.entity.ImageEntity;
import br.com.avenuecode.entity.ProductEntity;
import br.com.avenuecode.service.ImageService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="image")
public class ImageRestController {

	@Autowired
	private ImageService imageService;

	@ApiOperation(value="A method that saves an image.")
	@RequestMapping(value="save", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON)
	public ResponseEntity<ImageEntity> save(@RequestBody ImageEntity image) {
		imageService.save(image);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@ApiOperation(value="A method that deletes an image through his ID.")
	@RequestMapping(value="delete/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<ImageEntity> delete(@PathVariable("id") Long id) {
		imageService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@ApiOperation(value="A method that returns an image through his ID.")
	@RequestMapping(value="find/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON)
	public ResponseEntity<ImageEntity> findById(@PathVariable("id") Long id) {
		ImageEntity image = imageService.findById(id);
		return new ResponseEntity<>(image, HttpStatus.OK);
	}

	@ApiOperation(value="A method that returns all images of a product based on his ID.")
	@RequestMapping(value="images", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON, produces=MediaType.APPLICATION_JSON)
	public ResponseEntity<List<ImageEntity>> images(@RequestBody ProductEntity product) {
		List<ImageEntity> images = imageService.findByProduct(product);
		return new ResponseEntity<List<ImageEntity>>(images, HttpStatus.OK);
	}

}
