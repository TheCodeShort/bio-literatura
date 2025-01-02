package com.bio.literatura.model;

import jakarta.persistence.*;

import java.util.List;
@Entity //se crea la entidad libro
@Table(name = "libros")//se crea la tabla libro
public class Libros {


	@Id//se crea el id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//se genera automaticamente el id (cuando se inserta un nuevo libro se genera automaticamente el id)
	private Long id;//

	@Column(unique = true)//se crea la columna titulo y se le asigna unico
	private String titulo;
	private Integer descargas;
	@ManyToOne//se crea la relacion de muchos a uno con la tabla autor
	private Autor autor;
	public Libros() {}

	public Libros(Autor auto, String titulo, Integer descargas) {
		this.autor = autor;
		this.titulo = titulo;
		this.descargas = descargas;
	}

	public Libros(DatosAutor datosAutor) {
		{
			this.titulo = datosAutor.titulo();
			this.descargas = datosAutor.descargas();
		}
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

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	@Override
	public String toString() {
		return "Libros{" +
				"titulo='" + titulo + '\'' +
				", descargas=" + descargas +
				'}';
	}
}

