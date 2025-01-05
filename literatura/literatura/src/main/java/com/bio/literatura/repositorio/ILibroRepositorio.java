package com.bio.literatura.repositorio;

import com.bio.literatura.model.Libros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

//JpaRepository<Libros, Long> dice que vamos a traer los metodos de JpaRepository y que vamos a trabajar con la entidad Libros
public interface ILibroRepositorio extends JpaRepository<Libros, Long> {

	Optional<Libros> findByTituloContainsIgnoreCase(String titulo);

	Optional<Libros> findByAutorContainsIgnoreCase(String autor);
	Optional<Libros> findByAnioNacimiento(Integer anioNacimiento);

}
