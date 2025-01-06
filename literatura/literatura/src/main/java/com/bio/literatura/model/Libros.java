package com.bio.literatura.model;

import jakarta.persistence.*;
import jakarta.persistence.Convert;


import java.util.Arrays;
import java.util.List;
@Entity //se crea la entidad libro
@Table(name = "libros")//se crea la tabla libro
public class Libros {
	/*SELECT * FROM libros
DELETE  FROM libros WHERE ID = 15*/

	@Id//se crea el id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//se genera automaticamente el id (cuando se inserta un nuevo libro se genera automaticamente el id)
	private Long id;//

	@Column(unique = true)//se crea la columna titulo y se le asigna unico
	private String titulo;
	private Integer descargas;
	private String autor;
	private Integer anioNacimiento;
	private Integer anioMuerte;
	@Column(name = "lenguaje")
	private String lenguaje;



	@OneToMany(mappedBy = "libros")//se crea la relacion de uno a muchos
	private List<Autores> autores;
	public Libros() {
	}

	public Libros(String titulo, Integer descargas, String autor, Integer anioNacimiento, Integer anioMuerte, String lenguaje) {
		this.titulo = titulo;
		this.descargas = descargas;
		this.autor = autor;
		this.anioNacimiento = anioNacimiento;
		this.anioMuerte = anioMuerte;
		this.lenguaje = lenguaje;

}

	public Libros(DatosLibro datosLibro) {
		DatosAutor datosAutor = datosLibro.resultado().get(0);
		this.descargas = datosAutor.descargas();
		this.titulo = datosAutor.titulo();


		DatosInformacion datosInformacion = datosAutor.autores().get(0);
		this.autor = datosInformacion.autor();
		this.anioNacimiento = datosInformacion.anioNacimiento();
		this.anioMuerte = datosInformacion.anioMuerte();
		this.lenguaje = String.join(",", datosAutor.lenguaje());

	}


	public List<String> getLenguaje() {

		return lenguaje != null ? List.of(lenguaje.split(",")) : List.of();
	}

	public void setLenguaje(List<String> lenguajes) {
		this.lenguaje = String.join(",", lenguajes);
	}

	public Integer getDescargas() {
		return descargas;
	}

	public void setDescargas(Integer descargas) {
		this.descargas = descargas;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getNombre() {
		return autor;
	}

	public void setNombre(String nombre) {
		this.autor = nombre;
	}

	public Integer getAnioNacimiento() {
		return anioNacimiento;
	}

	public void setAnioNacimiento(Integer anioNacimiento) {
		this.anioNacimiento = anioNacimiento;
	}

	public Integer getAnioMuerte() {
		return anioMuerte;
	}

	public void setAnioMuerte(Integer anioMuerte) {
		this.anioMuerte = anioMuerte;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	@Override
	public String toString() {
		return "Titulo de liboros = " + titulo + "\n" +
				"Nombre autor = " + autor + "\n" +
				"Año de nacimiento = " + anioNacimiento + "\n" +
				"Año de muerte = " + anioMuerte + "\n" +
				"Descargas = " + descargas + "\n" +
				"Idioma = " + lenguaje + "\n";

	}
}

