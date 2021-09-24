package me.appz4.beacon.resources;

import org.springframework.beans.factory.annotation.Autowired;

import me.appz4.beacon.model.api.ApiRequest;
import me.appz4.beacon.model.api.ApiRequestWithToken;
import me.appz4.beacon.model.exception.Errors;
import me.appz4.beacon.model.exception.ServiceException;
import me.appz4.beacon.model.exception.ValidationException;
import me.appz4.beacon.model.model.Client;
import me.appz4.beacon.model.model.UserWithToken;
import me.appz4.beacon.model.validator.IRequestValidator;
import me.appz4.beacon.security.ClientContainer;
import me.appz4.beacon.service.UserService;
import me.appz4.beacon.validation.GenericValidator;

public abstract class BaseResource {

	@Autowired
	protected ClientContainer clientContainer;
	
	@Autowired
	protected GenericValidator validatorService;
	
	@Autowired
	protected UserService userService;
	
	protected Client getClient(String clientId) throws ServiceException {
		ApiRequest request = new ApiRequest();
		request.setClientId(clientId);
		return getClient(request);
	}
	
	protected Client getClient(ApiRequest request) throws ServiceException {
		if(!validatorService.notEmptyOrWhitespace(request.getClientId())) {
			throw new ServiceException(Errors.ERROR_CLIENTID);
		}
		Client client = clientContainer.getClientByToken(request.getClientId());
		if(client == null) throw new ServiceException(Errors.ERROR_CLIENTID);
		return client;
	}
	
	protected UserWithToken getUser(String clientId, String token) throws Exception {
		ApiRequestWithToken request = new ApiRequestWithToken();
		request.setClientId(clientId);
		request.setToken(token);
		return getUser(request);
	}
	
	protected UserWithToken getUser(ApiRequestWithToken request) throws Exception {
		getClient(request);
		if(!validatorService.notEmptyOrWhitespace(request.getToken())) {
			throw new ServiceException(Errors.ERROR_TOKEN);
		}
		return userService.loginUserByToken(request.getToken());
	}
	
	protected boolean isValid(IRequestValidator validator) throws ValidationException {
		return validator.onValidate();
	}
	
}
