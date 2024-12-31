package com.bio.literatura.principla;

import com.bio.literatura.model.DatosLibro;
import com.bio.literatura.service.ConsumoAPI;
import com.bio.literatura.service.ConvierteDatos;

import java.util.Scanner;

public class Principal {

	private String url = "";

	private ConsumoAPI consumoAPI = new ConsumoAPI();
	private ConvierteDatos convierteDatos = new ConvierteDatos();

	private Scanner teclado = new Scanner(System.in);
	private final String URL_BASE = "http://gutendex.com/books/?search=";//esta api no necesita registro se puede hacer la consulta sin problemas

	public DatosLibro


}
