package com.bio.literatura.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvierteDatos implements IConviertDatos {
	private ObjectMapper objectMapper = new ObjectMapper();//convierte los datos de JSON a objeto o viseversa


	@Override
	public <T> T obtenerDatos(String json, Class<T> clase) {//utilizamos el manejo de erroes.

		try{
			return objectMapper.readValue(json, clase);	//.readValue deserializar un JSON en un objeto Java
		} catch (JsonMappingException e) {
			throw new RuntimeException(e);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}

	}
}
