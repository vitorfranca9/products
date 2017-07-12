package br.com.avenuecode.image;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
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
import br.com.avenuecode.service.ImageService;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(value=MethodSorters.NAME_ASCENDING)
public class ImageTests {

	@Autowired
	private ImageService imageService;

	@Test
	public void test1SaveImage() {
		ImageEntity image = new ImageEntity();
		byte[] imgBytes = getImageFromResources();
		image.setImage(imgBytes);
		imageService.save(image);
		Assert.assertNotNull(image.getId());
	}

	@Test
	public void test2FindImagesByProductTest() {
		ProductEntity product = new ProductEntity();
		product.setId(1L);
		List<ImageEntity> images = imageService.findByProduct(product);
		Assert.assertTrue(CollectionHelper.isEmpty(images));
	}

	@Test
	public void test3DeleteImage() {
		imageService.delete(1L);
		ImageEntity image = imageService.findById(1L);
		Assert.assertNull(image);
	}

	private byte[] getImageFromResources() {
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(ImageIO.read(new File("src/test/resources/image002.png")), "jpg", baos);
			baos.flush();
			baos.close();
			return baos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
