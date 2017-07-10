package br.com.avenuecode.product;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import br.com.avenuecode.entity.Image;
import br.com.avenuecode.entity.Product;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductTests {

	@Test
	public void getAll() {
		Client client = ClientBuilder.newClient();
		Response response = client.target("http://localhost:8080/product/getAll/")
			.request(MediaType.APPLICATION_JSON).get();
		List<Product> products = response.readEntity(new GenericType<List<Product>>(){});
		Assert.assertTrue(CollectionUtils.isEmpty(products));
		Assert.assertEquals(HttpStatus.OK, response.getStatus());
	}

	@Test @Ignore
	public void save() {
		Product product = new Product();
		product.setId(1L);
		product.setName("Product 1");
		product.setDescription("Description 1");
		
		Image image = new Image();
		image.setProduct(product);
		fillStaticImage(image);
		
		product.setImages(new ArrayList<>());
		product.getImages().add(image);
		
		Product productChild = new Product();
		productChild.setName("Product Child");
		productChild.setDescription("Product Child Desc");
		
		product.setChildProducts(new ArrayList<>());
		product.getChildProducts().add(productChild);
		
		Client client = ClientBuilder.newClient();
//		Response response = client.target("http://localhost:8080/product/save/")
//			.request(MediaType.APPLICATION_JSON).post(new Requestentity product);
		Object post = client.target("http://localhost:8080/product/save/")
			.request(MediaType.APPLICATION_JSON).post(
				Entity.entity(product, MediaType.APPLICATION_JSON)
//				Entity.entity(product, MediaType.APPLICATION_JSON), new GenericType<List<Product>>(){}
		);
		System.out.println(post);
		
//		List<Product> products = response.readEntity(new GenericType<List<Product>>(){});
//		Assert.assertTrue(CollectionUtils.isEmpty(products));
//		Assert.assertEquals(HttpStatus.OK, response.getStatus());
	}

	private void fillStaticImage(Image image) {
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
	}

}
