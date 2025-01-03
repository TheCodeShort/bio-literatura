package com.bio.literatura.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "autores")
public class Autores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String autor;
    private Integer anioNacimiento;
    private Integer anioMuerte;

   @ManyToOne
    private Libros libros;

    public Autores(String nombre, Integer anioNacimiento, Integer anioMuerte) {
        this.autor = nombre;
        this.anioNacimiento = anioNacimiento;
        this.anioMuerte = anioMuerte;
    }

    public Autores(DatosLibro datosLibro) {
        DatosInformacion datosInformacion = datosLibro.resultado().get(0).autores().get(0);
        this.autor = datosInformacion.autor();
        this.anioNacimiento = datosInformacion.anioNacimiento();
        this.anioMuerte = datosInformacion.anioMuerte();

    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
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
        return "Autores{" +
                "anioMuerte=" + anioMuerte +
                ", anioNacimiento=" + anioNacimiento +
                ", autor='" + autor + '\'' +
                '}';
    }
}
