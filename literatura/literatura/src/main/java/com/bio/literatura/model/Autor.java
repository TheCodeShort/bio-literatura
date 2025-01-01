package com.bio.literatura.model;

import jakarta.persistence.*;

import java.util.List;
@Entity //se crea la entidad libro
@Table(name = "autor")//se crea la tabla libro
public class Autor {

	@OneToMany(mappedBy = "autor", cascade = CascadeType.ALL,fetch = FetchType.EAGER)//se crea la relacion de uno a muchos con la tabla libro
	private List<Libros> datosLibro;
	public Autor(){}

	@Id//se crea el id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//se genera automaticamente el id (cuando se inserta un nuevo libro se genera automaticamente el id)
	private Long id;//

	@Column(unique = true)//se crea la columna titulo y se le asigna unico
	private String nombre;
	private Integer anioNacimiento;
	private Integer anioMuerte;

	public Autor(String nombre, Integer anioNacimiento, Integer anioMuerte) {
		this.nombre = nombre;
		this.anioNacimiento = anioNacimiento;
		this.anioMuerte = anioMuerte;
	}

	public Autor(DatosInformacion datosLibro ){
		this.nombre = datosLibro.nombre();
		this.anioNacimiento = datosLibro.anioNacimiento();
		this.anioMuerte = datosLibro.anioMuerte();
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
