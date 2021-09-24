package me.appz4.beacon.dao;

import me.appz4.beacon.dao.base.BaseDaoImpl;
import me.appz4.beacon.model.model.Image;

public class ImageDaoImpl  extends BaseDaoImpl<Image> implements ImageDao {

	public ImageDaoImpl() {
		super(Image.class);
	}

}
