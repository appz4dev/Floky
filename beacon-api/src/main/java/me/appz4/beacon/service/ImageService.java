package me.appz4.beacon.service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import me.appz4.beacon.model.model.Image;
import me.appz4.beacon.model.model.ImageConnectionType;
import me.appz4.beacon.model.model.ImageType;

public interface ImageService {
	
	BufferedImage getImageFrom(InputStream source) throws IOException;
	
	BufferedImage createResizedFrom(BufferedImage source, int width, int height);
	
	BufferedImage createSquareCroppedFrom(BufferedImage source, int width);

	byte[] getImageAsBytes(BufferedImage image, String extension);

	void writeToFile(BufferedImage image, String extension, File file);

	Image createImage(BufferedImage source, Image image) throws Exception;

	Image createImage(ImageType type, BufferedImage source, Long connectionId, ImageConnectionType connectionType, String name, String extension) throws Exception;

	List<Image> getImages(Long connectionId, ImageConnectionType type) throws Exception;

	Image getImage(ImageType type, Long connectionId, ImageConnectionType connectionType) throws Exception;

	void deleteImage(ImageType type, Long connectionId, ImageConnectionType connectionType) throws Exception;
	
	void deleteImages(Long connectionId, ImageConnectionType type) throws Exception;
}
