package me.appz4.beacon.service;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.List;

import javax.imageio.ImageIO;

import org.hibernate.criterion.Restrictions;
import org.imgscalr.Scalr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import me.appz4.beacon.amazon.AwsFileManager;
import me.appz4.beacon.dao.ImageDao;
import me.appz4.beacon.model.exception.Errors;
import me.appz4.beacon.model.exception.ServiceException;
import me.appz4.beacon.model.model.Image;
import me.appz4.beacon.model.model.ImageConnectionType;
import me.appz4.beacon.model.model.ImageType;

public class ImageServiceImpl implements ImageService {

	@Autowired
	private ImageDao imageDao;
	
	@Autowired
	private AwsFileManager fileManager;

	@Override
	@Transactional("services")
	public void deleteImage(ImageType type, Long connectionId, ImageConnectionType connectionType) throws Exception {
		Image image = getImage(type, connectionId, connectionType);
		if(image == null) throw new ServiceException(Errors.ERROR_GENERAL);
		imageDao.delete(image);
	}
	
	@Override
	@Transactional("services")
	public Image getImage(ImageType type, Long connectionId, ImageConnectionType connectionType) throws Exception {
		return imageDao.find(
			Restrictions.eq(Image.TYPE, type),
			Restrictions.eq(Image.CONNECTIONID, connectionId),
			Restrictions.eq(Image.CONNECTIONTYPE, connectionType),
			Restrictions.eq(Image.STATUS, 1)
		);
	}
	
	@Override
	@Transactional("services")
	public List<Image> getImages(Long connectionId, ImageConnectionType connectionType) throws Exception {
		return imageDao.findAll(
			Restrictions.eq(Image.CONNECTIONID, connectionId),
			Restrictions.eq(Image.CONNECTIONTYPE, connectionType),
			Restrictions.eq(Image.STATUS, 1)
		);
	}
	
	@Override
	@Transactional("services")
	public Image createImage(ImageType type, BufferedImage source, Long connectionId, ImageConnectionType connectionType, String name, String extension) throws Exception {
		Image image = new Image();
		image.setConnectionId(connectionId);
		image.setConnectionType(connectionType);
		image.setExtension(extension);
		image.setName(name);
		image.setStatus(1);
		image.setType(type);
		return createImage(source, image);
	}
	
	@Override
	@Transactional("services")
	public Image createImage(BufferedImage source, Image image) throws Exception {
		String url = fileManager.write(image.getName(), source, image.getExtension());
		image.setUrl(url);
		image.setCreated(Calendar.getInstance().getTime());
		Long imageId = imageDao.create(image);
		image.setId(imageId);
		return image;
	}
	
	@Override
	public BufferedImage createSquareCroppedFrom(BufferedImage originalImage, int newWidth) {
		int width = originalImage.getWidth();
		int height = originalImage.getHeight();
		BufferedImage resized = null;
		if(height > width) {
			resized = Scalr.resize(originalImage, Scalr.Method.ULTRA_QUALITY, Scalr.Mode.FIT_TO_WIDTH, newWidth, newWidth);
		} 
		else {
			resized = Scalr.resize(originalImage, Scalr.Method.ULTRA_QUALITY, Scalr.Mode.FIT_TO_HEIGHT, newWidth, newWidth);
		}
		BufferedImage cropped = Scalr.crop(resized, newWidth, newWidth);
		BufferedImage imageToSave = new BufferedImage(cropped.getWidth(), cropped.getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics g = imageToSave.getGraphics();
		g.drawImage(cropped, 0, 0, null);
		return imageToSave;
	}

	@Override
	public BufferedImage getImageFrom(InputStream source) throws IOException {
		return ImageIO.read(source);
	}

	@Override
	public BufferedImage createResizedFrom(BufferedImage originalImage, int newWidth, int newHeight) {
		int width = originalImage.getWidth();
		int height = originalImage.getHeight();
		BufferedImage resized = null;
		//Mindig vagy pl. 1024*678 vagy 768*1024 lesz
		if(height > width) {
			resized = Scalr.resize(originalImage,  Scalr.Method.ULTRA_QUALITY, Scalr.Mode.FIT_TO_HEIGHT, newHeight, newWidth, Scalr.OP_ANTIALIAS);
		} 
		else {
			resized = Scalr.resize(originalImage,  Scalr.Method.ULTRA_QUALITY, Scalr.Mode.FIT_TO_WIDTH, newWidth, newHeight, Scalr.OP_ANTIALIAS);
		}
		BufferedImage imageToSave = new BufferedImage(resized.getWidth(), resized.getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics g = imageToSave.getGraphics();
		g.drawImage(resized, 0, 0, null);
		return imageToSave;
	}
	
	@Override
	public byte[] getImageAsBytes(BufferedImage image, String extension) {
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(image, extension, baos);
			baos.flush();
			byte[] imageInByte = baos.toByteArray();
			baos.close();
			return imageInByte;
		}
		catch(IOException e) {
			//TODO logolas
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public void writeToFile(BufferedImage image, String extension, File file) {
		try {
			ImageIO.write(image, extension, file);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	@Transactional("services")
	public void deleteImages(Long connectionId, ImageConnectionType type) throws Exception {
		List<Image> images = getImages(connectionId, type);
		for(Image i : images) {
			fileManager.delete(i.getName());
			imageDao.delete(i);
		}
	}
	
	
	
}
