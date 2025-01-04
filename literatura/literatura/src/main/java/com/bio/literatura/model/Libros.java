package com.bio.literatura.model;

import jakarta.persistence.*;

import java.util.ArrayList;
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


	@OneToMany(mappedBy = "libros")//se crea la relacion de uno a muchos
	private List<Autores> autores;

	public Libros( String titulo, Integer descargas, String autor, Integer anioNacimiento, Integer anioMuerte) {
		this.titulo = titulo;
		this.descargas = descargas;
		this.autor = autor;
		this.anioNacimiento = anioNacimiento;
		this.anioMuerte = anioMuerte;
	}

	public Libros(DatosLibro datosLibro) {
		DatosAutor datosAutor = datosLibro.resultado().get(0);
		this.descargas = datosAutor.descargas();
		this.titulo = datosAutor.titulo();

		DatosInformacion datosInformacion = datosAutor.autores().get(0);
		this.autor = datosInformacion.autor();
		this.anioNacimiento = datosInformacion.anioNacimiento();
		this.anioMuerte = datosInformacion.anioMuerte();

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

	public static void setTitulo(String titulo) {
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

	@Override
	public String toString() {
		return "Libros{" +
				"titulo='" + titulo + '\'' +
				", descargas=" + descargas +
				", anioNacimiento=" + anioNacimiento +
				", anioMuerte=" + anioMuerte +
				", nombre='" + autor + '\'' +
				'}';
	}
}

