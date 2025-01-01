package com.bio.literatura.principla;

import com.bio.literatura.model.DatosLibro;
import com.bio.literatura.service.ConsumoAPI;
import com.bio.literatura.service.ConvierteDatos;

import java.util.Scanner;

public class Principal {

	private ConsumoAPI consumoAPI = new ConsumoAPI();
	private ConvierteDatos convierteDatos = new ConvierteDatos();

	private Scanner teclado = new Scanner(System.in);
	private final String URL_BASE = "http://gutendex.com/books/?search=";//esta api no necesita registro se puede hacer la consulta sin problemas

	public void muestraMenu(){
		var opcion = -1;
		while(opcion != 0){
			System.out.println("""
					Bienvenido a la aplicacion de busqueda de libros.
					
					Eligue una opcion.
					""");

			var menu = """
					1. Buscar libro
					0. Salir
					""";
			System.out.println(menu);
			System.out.print("Digita la obcion: ");
			opcion = teclado.nextInt();
			teclado.nextLine();
			switch (opcion){
				case 1:
					mostrar();
					break;
				case 0:
					System.out.println("Gracias por usar el programa");
					break;
				default:
					System.out.println("Opcion no valida");
			}

		}

	}


	private DatosLibro getDatosLibro(){//se consume la API (realiza la consulta)
		System.out.print("Digite el libro que quiere buscar: ");
		var libro = teclado.nextLine();

		var json = consumoAPI.obtenerDatos(URL_BASE);
		if (json == null || json.isEmpty()) {
			throw new RuntimeException("La API devolvió una respuesta vacía.");
		}
		DatosLibro datosLibro = convierteDatos.obtenerDatos(json, DatosLibro.class);
		return datosLibro;
	}

	private void mostrar(){
		System.out.println(getDatosLibro());
	}
}
