package me.appz4.beacon.exception.mappers;

import java.util.Locale;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GenericExceptionMapper extends BaseExceptionMapper implements ExceptionMapper<Throwable> {
	
	@Override 
	public Response toResponse(Throwable ex) {
		return Response.status(200).entity(getResponse(ex, Locale.ENGLISH)).type(MediaType.APPLICATION_JSON).build();	
	}

}