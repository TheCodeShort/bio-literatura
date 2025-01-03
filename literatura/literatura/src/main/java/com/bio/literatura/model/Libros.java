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
	private String nombre;
	private Integer anioNacimiento;
	private Integer anioMuerte;

	@Transient
	private List<DatosLibro> datosLibros;
	@Transient
	private List<DatosAutor> datosAutor;
	@Transient
	private List<DatosInformacion> datosInformacion;
	/*@ManyToOne//se crea la relacion de muchos a uno con la tabla autor
	private Autor autor;
	public Libros() {}*/

	public Libros(List<DatosLibro> datosLibros, List<DatosAutor> datosAutor, List<DatosInformacion> datosInformacion, String titulo, Integer descargas, String nombre, Integer anioNacimiento, Integer anioMuerte) {
		this.titulo = titulo;
		this.descargas = descargas;
		this.nombre = nombre;
		this.anioNacimiento = anioNacimiento;
		this.anioMuerte = anioMuerte;
		this.datosLibros = datosLibros;
		this.datosAutor =  datosAutor;
		this.datosInformacion = datosInformacion;

	}



	public Libros(DatosAutor datosAutor) {
			this.titulo = datosAutor.titulo();
			this.descargas = datosAutor.descargas();


		}

	public Libros (DatosInformacion datosInformacion){
		this.nombre = datosInformacion.nombre();
		this.anioNacimiento = datosInformacion.anioNacimiento();
		this.anioMuerte = datosInformacion.anioMuerte();
	}

	public Libros(DatosLibro datos) {
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

	@Override
	public String toString() {
		return "Libros{" +
				"titulo='" + titulo + '\'' +
				", descargas=" + descargas +
				", nombre='" + nombre + '\'' +
				", anioNacimiento=" + anioNacimiento +
				", anioMuerte=" + anioMuerte +
				'}';
	}
}

