package me.appz4.beacon.validation;

public interface GenericValidator {

	boolean isValidEmail(String data);

	boolean notEmptyOrWhitespace(String data);

}
