package com.bio.literatura.service;

public interface IConviertDatos {

	<T> T obtenerDatos(String json, Class <T> clase );/*<T> tipo de datos generico*/

}
