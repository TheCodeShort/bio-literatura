package com.bio.literatura.repositorio;

import com.bio.literatura.model.Libros;
import org.springframework.data.jpa.repository.JpaRepository;

//JpaRepository<Libros, Long> dice que vamos a traer los metodos de JpaRepository y que vamos a trabajar con la entidad Libros
public interface ILibroRepositorio extends JpaRepository<Libros, Long> {
}
