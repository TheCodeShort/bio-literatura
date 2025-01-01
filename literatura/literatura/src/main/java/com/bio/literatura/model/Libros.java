package com.bio.literatura.model;

import jakarta.persistence.*;

import java.util.List;
@Entity //se crea la entidad libro
@Table(name = "libros")//se crea la tabla libro
public class Libros {
	@ManyToOne//se crea la relacion de muchos a uno con la tabla autor
	private Autor autor;

	public Libros() {
	}

	@Id//se crea el id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//se genera automaticamente el id (cuando se inserta un nuevo libro se genera automaticamente el id)
	private Long id;//

	@Column(unique = true)//se crea la columna titulo y se le asigna unico
	private List<DatosAutor> datosLibros;
	private String titulo;
	private Integer descargas;

	public Libros(Autor autor, List<DatosAutor> datosLibros, String titulo, Integer descargas) {
		this.autor = autor;
		this.datosLibros = datosLibros;
		this.titulo = titulo;
		this.descargas = descargas;
	}

	public Libros(DatosAutor datosAutor) {
		{
			this.titulo = datosAutor.titulo();
			this.descargas = datosAutor.descargas();
		}
	}
}

