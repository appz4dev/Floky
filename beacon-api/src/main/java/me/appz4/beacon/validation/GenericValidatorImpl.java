package me.appz4.beacon.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.util.StringUtils;

public class GenericValidatorImpl implements GenericValidator {
	
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";  
	
	private Pattern emailPattern = Pattern.compile(EMAIL_PATTERN);  
	
	@Override
	public boolean isValidEmail(String data) {
		if(data == null) return false;
		if(!StringUtils.hasText(data)) return false;
		Matcher matcher = emailPattern.matcher(data);  
		if (!matcher.matches()) {
			return false;
		}
		return true;
	}
	
	@Override
	public boolean notEmptyOrWhitespace(String data) {
		if (data == null ||!StringUtils.hasText(data)) {
			return false;
		}
		return true;
	}
	
}
