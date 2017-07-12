package br.com.avenuecode.product;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.imageio.ImageIO;

import org.hibernate.internal.util.collections.CollectionHelper;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.avenuecode.entity.ImageEntity;
import br.com.avenuecode.entity.ProductEntity;
import br.com.avenuecode.service.ProductService;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(value=MethodSorters.NAME_ASCENDING)
public class ProductTests {

//	private static final String BASE_URI = "http://localhost:8080/product";

	@Autowired
	private ProductService productService;
	
	@Test
	public void test1SaveTest() {
		ProductEntity product = createProductExample();
		productService.save(product);
		Assert.assertNotNull(product.getId());
		Assert.assertTrue(CollectionHelper.isNotEmpty(product.getChildProducts()));
		Assert.assertTrue(CollectionHelper.isNotEmpty(product.getImages()));
	}

	@Test
	public void test2GetAllTest() {
		List<ProductEntity> products = productService.findAll();
		Assert.assertTrue(CollectionHelper.isNotEmpty(products));
	}

	@Test
	public void test3GetAllExcludingRelationshipsTest() {
		List<ProductEntity> products = productService.findAllExcludingRelationships();
		Assert.assertTrue(CollectionHelper.isNotEmpty(products));
		ProductEntity product = products.iterator().next();
		Assert.assertNull(product.getImages());
		Assert.assertNull(product.getChildProducts());
		Assert.assertNull(product.getParentProduct());
	}

	@Test
	public void test4FindByIdTest() {
		ProductEntity product = productService.findById(1L);
		Assert.assertNotNull(product);
		Assert.assertNotNull(product.getId());
		Assert.assertEquals("Product Test Name", product.getName());
	}

	@Test
	public void test5FindByIdExcludingRelationshipsTest() {
		ProductEntity product = productService.findByIdExcludingRelationships(1L);
		Assert.assertNotNull(product);
		Assert.assertNotNull(product.getId());
		Assert.assertEquals("Product Test Name", product.getName());
		Assert.assertNull(product.getChildProducts());
		Assert.assertNull(product.getImages());
	}

	@Test
	public void test6FindProductByParentProductTest() {
		ProductEntity parentProduct = new ProductEntity();
		parentProduct.setId(1L);
		List<ProductEntity> childProducts = productService.findProductByParentProduct(parentProduct);
		Assert.assertTrue(CollectionHelper.isNotEmpty(childProducts));
	}

	private ProductEntity createProductExample() {
		ProductEntity product = new ProductEntity();
		product.setName("Product Test Name");
		product.setDescription("Product Test Description");
		ImageEntity image = new ImageEntity();
		image.setProduct(product);
		fillImageFromResource(image);
		product.setImages(new ArrayList<>(Arrays.asList(image)));
		ProductEntity productChild = new ProductEntity();
		productChild.setName("Product Child");
		productChild.setDescription("Product Child Desc");
		productChild.setParentProduct(product);
		product.setChildProducts(new ArrayList<>(Arrays.asList(productChild)));
		return product;
	}

	private void fillImageFromResource(ImageEntity image) {
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

//	@Test @Ignore
//	public void save() {
//		ProductEntity product = createProductExample();
//		Client client = ClientBuilder.newClient();
//		Response response = client.target(BASE_URI+"/save").request(MediaType.APPLICATION_JSON)
//			.post(Entity.entity(product, MediaType.APPLICATION_JSON));
//		assertHttpStatusOk(response);
//	}
//	
//	@Test @Ignore
//	public void getAll() {
//		Client client = ClientBuilder.newClient();
//		Response response = client.target(BASE_URI + "/getAll")
//			.request(MediaType.APPLICATION_JSON).get();
//		List<ProductEntity> products = response.readEntity(new GenericType<List<ProductEntity>>(){});
//		Assert.assertTrue(!CollectionUtils.isEmpty(products));
//		assertHttpStatusOk(response);
//	}
//
//	private void assertHttpStatusOk(Response response) {
//		Assert.assertEquals(HttpStatus.OK.value(), response.getStatus());
//	}

}
