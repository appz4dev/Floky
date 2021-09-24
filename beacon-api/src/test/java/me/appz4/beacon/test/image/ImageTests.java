package me.appz4.beacon.test.image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import me.appz4.beacon.model.model.Image;
import me.appz4.beacon.model.model.ImageConnectionType;
import me.appz4.beacon.model.model.ImageType;
import me.appz4.beacon.service.ImageService;

@ContextConfiguration(locations = { "classpath:spring-context.xml" })
public class ImageTests extends AbstractTestNGSpringContextTests {

	@Autowired
	private ImageService imageService;
	
	private final String imagePath = "D:\\Work\\Projects\\beacon\\mockup_v2.0.png";
	
	private Image fullSized;
	
	private Image thumbSized;
	
	private final boolean deleteAtLast = false;
	
	@Test(priority=0)
	public void mockUpload() throws Exception {
		File imageFile = new File(imagePath);
		Assert.assertEquals(imageFile.exists(), true);
		FileInputStream file = new FileInputStream(imageFile);
		BufferedImage image = ImageIO.read(file);
		BufferedImage resized = imageService.createResizedFrom(image, ImageType.LARGE.getWidth(), ImageType.LARGE.getHeight());
		BufferedImage thumb = imageService.createSquareCroppedFrom(resized, ImageType.THUMBNAIL.getWidth());
		String fullName = RandomStringUtils.randomAlphabetic(10);
		fullSized = imageService.createImage(ImageType.LARGE, resized, 1L, ImageConnectionType.BEACON, fullName, "png");
		Assert.assertNotNull(fullSized);
		Assert.assertNotNull(fullSized.getId());
		thumbSized = imageService.createImage(ImageType.THUMBNAIL, thumb, 1L, ImageConnectionType.BEACON, fullName+"_thumb", "png");
		Assert.assertNotNull(thumbSized);
		Assert.assertNotNull(thumbSized.getId());
	}
	
	@Test(priority=1)
	public void getImages() throws Exception {
		List<Image> allImages = imageService.getImages(1L, ImageConnectionType.BEACON);
		Assert.assertEquals(allImages.isEmpty(), false);
		Assert.assertEquals((allImages.size() >= 2), true);
		Image resized = imageService.getImage(ImageType.LARGE, 1L, ImageConnectionType.BEACON);
		Assert.assertNotNull(resized);
		//Assert.assertNotNull(resized.getData());
		//Assert.assertNotEquals(resized.getData().length, 0);
		Image thumbNail = imageService.getImage(ImageType.THUMBNAIL, 1L, ImageConnectionType.BEACON);
		Assert.assertNotNull(thumbNail);
		//Assert.assertNotNull(thumbNail.getData());
		//Assert.assertNotEquals(thumbNail.getData().length, 0);
	}
	
	@Test(priority=2)
	public void deleteImages() throws Exception {
		if(!deleteAtLast) return;
		imageService.deleteImage(ImageType.THUMBNAIL, 1L, ImageConnectionType.BEACON);
		imageService.deleteImage(ImageType.LARGE, 1L, ImageConnectionType.BEACON);
	}
	
}
