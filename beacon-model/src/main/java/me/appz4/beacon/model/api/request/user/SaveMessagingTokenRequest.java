package me.appz4.beacon.model.api.request.user;

import me.appz4.beacon.model.api.ApiRequestWithToken;
import me.appz4.beacon.model.exception.ValidationException;
import me.appz4.beacon.model.validator.IRequestValidator;
import me.appz4.beacon.model.validator.ValidatorUtils;

public class SaveMessagingTokenRequest extends ApiRequestWithToken implements IRequestValidator {
	
	private String type;
	
	private String messagingToken;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMessagingToken() {
		return messagingToken;
	}

	public void setMessagingToken(String messagingToken) {
		this.messagingToken = messagingToken;
	}

	@Override
	public String toString() {
		return "SaveMessagingTokenRequest [type=" + type + ", messagingToken=" + messagingToken + "]";
	}

	@Override
	public boolean onValidate() throws ValidationException {
		ValidatorUtils.isNull(this.messagingToken, "messagingToken");
		ValidatorUtils.isNull(this.type, "type");
		return false;
	}
	
	
	
}
