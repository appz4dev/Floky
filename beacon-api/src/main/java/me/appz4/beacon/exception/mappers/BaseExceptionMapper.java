package me.appz4.beacon.exception.mappers;

import java.util.List;
import java.util.Locale;

import me.appz4.beacon.ApplicationContextProvider;
import me.appz4.beacon.model.api.ApiResponse;
import me.appz4.beacon.model.exception.Errors;
import me.appz4.beacon.model.exception.ServiceException;
import me.appz4.beacon.model.exception.ValidationException;

public abstract class BaseExceptionMapper {
	
	protected ApiResponse getResponse(Throwable e, Locale locale) {
		ApiResponse response = new ApiResponse();
		if(e instanceof ServiceException) {
			setServiceException(response, (ServiceException)e, locale);
			e.printStackTrace();
		}
		else if(e instanceof ValidationException) {
			setValidationException(response, (ValidationException)e, locale);
		}
		else if(e instanceof Exception) {
			setException(response, (Exception)e, locale);
			e.printStackTrace();
		}
		response.setError(true);
		//e.printStackTrace();
		return response;
	}
	
	private void setValidationException(ApiResponse response, ValidationException e, Locale locale) {
		String[] params = e.getParams();
		response.setErrorMessage("Missing parameter: "+params[0]);
	}
	
	private void setServiceException(ApiResponse response, ServiceException e, Locale locale) {
		List<String> parameters = e.getParameters();
		String message = ApplicationContextProvider.getApplicationContext().getMessage(e.getMessage(), parameters.toArray(new String[]{}), locale);
		response.setErrorCode(e.getErrorCode());
		response.setErrorMessage(message);
	}
	
	private void setException(ApiResponse response, Exception e, Locale locale) {
		response.setErrorCode(Errors.ERROR_GENERAL.getCode());
		response.setErrorMessage(e.getMessage());
	}

}
