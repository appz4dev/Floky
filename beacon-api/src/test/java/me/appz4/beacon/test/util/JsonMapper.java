package me.appz4.beacon.test.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JsonMapper {
	
	private static ObjectMapper mapper = new ObjectMapper();
	
	static {
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
 		mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
	}
	
	public static <T> String toString(T entity) throws JsonProcessingException {
		return mapper.writeValueAsString(entity);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T toEntity(String entity, T resultType) throws JsonParseException, JsonMappingException, IOException {
		return (T) mapper.readValue(entity, resultType.getClass());
	}
	
	public static <T> T toEntity(String entity, Class<T> clazz) throws JsonParseException, JsonMappingException, IOException {
		return (T) mapper.readValue(entity, clazz);
	}
	
}
