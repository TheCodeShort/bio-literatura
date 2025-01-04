package com.bio.literatura.principla;

import com.bio.literatura.model.*;
import com.bio.literatura.repositorio.ILibroRepositorio;
import com.bio.literatura.service.ConsumoAPI;
import com.bio.literatura.service.ConvierteDatos;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {

	private ConsumoAPI consumoAPI = new ConsumoAPI();
	private ConvierteDatos convierteDatos = new ConvierteDatos();

	private Scanner teclado = new Scanner(System.in);
	private final String URL_BASE = "http://gutendex.com/books/?search=";//esta api no necesita registro se puede hacer la consulta sin problemas
	private final String URL_AÑOS_DESPUES = "https://gutendex.com/books/?author_year_start=";
	private final String URL_AÑOS_ANTES = "&author_year_end=";

	private ILibroRepositorio repositorio;//cracion de la interfaz con su nombre y le creamos un constructor
	public Principal(ILibroRepositorio repository){//evitamos hacer una instanzacion
		this.repositorio = repository;
	}

	public void muestraMenu(){
		System.out.printf("Bienvenido a la aplicacion de busqueda de libros.");
		var opcion = -1;
		while(opcion != 0){
			System.out.println("""
					
					Eligue una opcion.
					""");

			var menu = """
					1. Buscar libro.
					2. Buscar libro por autor.
					3. Buscar libro por rango de años.
					4.
					0. Salir.
					""";
			System.out.println(menu);
			System.out.print("Digita la obcion: ");
			opcion = teclado.nextInt();
			teclado.nextLine();
			switch (opcion){
				case 1:
					busCarLibro();
					break;
				case 2:
					buscarLibroPorAutor();
				case 3:
					buscarLibroPorAutorVivo();
				case 0:
					System.out.println("Gracias por usar el programa");
					break;
				default:
					System.out.println("Opcion no valida");
			}

		}

	}




	private DatosLibro getDatosLibro(){//se consume la API (realiza la consulta)
		System.out.print("digita el titulo del libro: ");
		var libro = teclado.nextLine().strip();
		//El uso de %20 se debe al protocolo de codificación de URLs (definido en el estándar RFC 3986),
		var json = consumoAPI.obtenerDatos(URL_BASE + libro.replace(" ", "%20"));
		if (json == null || json.isEmpty()) {
			throw new RuntimeException("La API devolvió una respuesta vacía.");
		}
		DatosLibro datosLibro = convierteDatos.obtenerDatos(json, DatosLibro.class);
		return datosLibro;
	}

	private void busCarLibro() {
		DatosLibro datos = getDatosLibro();
		List<DatosAutor> datosAutoresAPI = datos.resultado();

		List<String> titulosBaseDatos = repositorio.findAll()
				.stream()
				.map(Libros::getTitulo)
				.collect(Collectors.toList());

		List<Libros> librosNuevos = datosAutoresAPI.stream()
				.filter(datosAutor -> !titulosBaseDatos.contains(datosAutor.titulo())) // Filtrar títulos que no existen en la base de datos
				.map(datosAutor -> {
					DatosInformacion datosInformacion = datosAutor.autores().get(0);
					return new Libros(
							datosAutor.titulo(),
							datosAutor.descargas(),
							datosInformacion.autor(),
							datosInformacion.anioNacimiento(),
							datosInformacion.anioMuerte()
					);
				})
				.collect(Collectors.toList());

		repositorio.saveAll(librosNuevos); // Guardar los nuevos libros en la base de datos
	}
	private void buscarLibroPorAutor() {
		System.out.print("Digita el nombre del autor: ");
		var autor = teclado.nextLine().strip();
		var json = consumoAPI.obtenerDatos(URL_BASE + autor.replace(" ", "%20"));
		DatosLibro datosLibro = convierteDatos.obtenerDatos(json, DatosLibro.class);
		List<DatosAutor> datosAutoresAPI = datosLibro.resultado();

		List<String> titulosBaseDatos = repositorio.findAll()
				.stream()
				.map(Libros::getTitulo)
				.collect(Collectors.toList());

		List<Libros> librosNuevos = datosAutoresAPI.stream()
				.filter(datosAutor -> !titulosBaseDatos.contains(datosAutor.titulo())) // Filtrar títulos que no existen en la base de datos
				.map(datosAutor -> {
					DatosInformacion datosInformacion = datosAutor.autores().get(0);
					return new Libros(
							datosAutor.titulo(),
							datosAutor.descargas(),
							datosInformacion.autor(),
							datosInformacion.anioNacimiento(),
							datosInformacion.anioMuerte()
					);
				})
				.collect(Collectors.toList());

		repositorio.saveAll(librosNuevos); // Guardar los nuevos libros en la base de datos
		System.out.println(datosLibro);
	}

	private DatosLibro datosAños() {
		System.out.print("Digita el año antes de su muerte: ");
		var añoAntes = teclado.nextLine();
		var vivo = Integer.parseInt(añoAntes);

		System.out.print("Diita el años despues: ");
		var añoDespues = teclado.nextLine();
		var muerto = Integer.parseInt(añoDespues);

		var json = consumoAPI.obtenerDatos(URL_AÑOS_DESPUES + vivo + URL_AÑOS_ANTES + muerto);
		DatosLibro datosLibros = convierteDatos.obtenerDatos(json, DatosLibro.class);

		return datosLibros;
	}

	private void buscarLibroPorAutorVivo() { // Buscar libros por autor que estén vivos y se guardan en la base de datos
		DatosLibro datos = datosAños();
		List<DatosAutor> datosAutoresAPI = datos.resultado();

		List<String> titulosBaseDatos = repositorio.findAll()
				.stream()
				.map(Libros::getTitulo)
				.collect(Collectors.toList());

		List<Libros> librosNuevos = datosAutoresAPI.stream()
				.filter(datosAutor -> !titulosBaseDatos.contains(datosAutor.titulo())) // Filtrar títulos que no existen en la base de datos
				.map(datosAutor -> {
					DatosInformacion datosInformacion = datosAutor.autores().get(0);
					return new Libros(
							datosAutor.titulo(),
							datosAutor.descargas(),
							datosInformacion.autor(),
							datosInformacion.anioNacimiento(),
							datosInformacion.anioMuerte()
					);
				})
				.collect(Collectors.toList());

		repositorio.saveAll(librosNuevos); // Guardar los nuevos libros en la base de datos
	}
}

