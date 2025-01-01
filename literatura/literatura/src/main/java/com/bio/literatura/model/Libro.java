package com.bio.literatura.model;

import java.util.List;

public class Libro {

	private List<DatosAutor> datosLibros;
	private String titulo;
	private Integer descargas;
	private List<DatosInformacion> autores;
	private String nombre;
	private Integer anioNacimiento;
	private Integer anioMuerte;


	public Libro(List<DatosAutor> datosLibros, String titulo, Integer descargas
				, List<DatosInformacion> autores, String nombre, Integer anioNacimiento, Integer anioMuerte) {
		this.datosLibros = datosLibros;
		this.titulo = titulo;
		this.descargas = descargas;
		this.autores = autores;
		this.nombre = nombre;
		this.anioNacimiento = anioNacimiento;
		this.anioMuerte = anioMuerte;
	}

	public Libro(DatosLibro datosLibro){
		this.datosLibros = datosLibro.resultado();
	}

	public Libro(DatosAutor datosAutor) {
		this.titulo = datosAutor.titulo();
		this.descargas = datosAutor.descargas();
		this.autores = datosAutor.autores();
	}

	public Libro(DatosInformacion datosInformacion) {
		this.nombre = datosInformacion.nombre();
		this.anioNacimiento = datosInformacion.anioNacimiento();
		this.anioMuerte = datosInformacion.anioMuerte();
	}

	public List<DatosAutor> getDatosLibros() {
		return datosLibros;
	}

	public void setDatosLibros(List<DatosAutor> datosLibros) {
		this.datosLibros = datosLibros;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getDescargas() {
		return descargas;
	}

	public void setDescargas(Integer descargas) {
		this.descargas = descargas;
	}

	public List<DatosInformacion> getAutores() {
		return autores;
	}

	public void setAutores(List<DatosInformacion> autores) {
		this.autores = autores;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
}
