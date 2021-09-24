package me.appz4.beacon.service.base;

import java.util.Calendar;
import java.util.Date;

public abstract class AbstractServiceImpl<T> implements AbstractService<T> {
	
	protected Date getNow() {
		return Calendar.getInstance().getTime();
	}
	
}
