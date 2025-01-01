package com.bio.literatura.principla;

import com.bio.literatura.model.DatosLibro;
import com.bio.literatura.service.ConsumoAPI;
import com.bio.literatura.service.ConvierteDatos;

import java.util.Scanner;

public class Principal {

	private ConsumoAPI consumoAPI = new ConsumoAPI();
	private ConvierteDatos convierteDatos = new ConvierteDatos();

	private Scanner teclado = new Scanner(System.in);
	private final String URL_BASE = "http://gutendex.com/books?/search=";//esta api no necesita registro se puede hacer la consulta sin problemas



	public DatosLibro getDatosLibro(){//se consume la API (realiza la consulta)
		System.out.print("Digite el libro que quiere buscar: ");
		var libro = teclado.nextLine();

		var json = consumoAPI.obtenerDatos(URL_BASE + libro);
		if (json == null || json.isEmpty()) {
			throw new RuntimeException("La API devolvió una respuesta vacía.");
		}
		DatosLibro datosLibro = convierteDatos.obtenerDatos(json, DatosLibro.class);
		return datosLibro;
	}

	public void mostrar(){
		System.out.println(getDatosLibro());
	}
}
