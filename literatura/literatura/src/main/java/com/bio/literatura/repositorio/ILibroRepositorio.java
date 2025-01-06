package com.bio.literatura.repositorio;

import com.bio.literatura.model.Libros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

//JpaRepository<Libros, Long> dice que vamos a traer los metodos de JpaRepository y que vamos a trabajar con la entidad Libros
public interface ILibroRepositorio extends JpaRepository<Libros, Long> {

	Optional<Libros> findByTituloContainsIgnoreCase(String titulo);

	Optional<Libros> findByAutorContainsIgnoreCase(String autor);

	List<Libros> findByLenguajeIgnoreCase(String lenguaje);

	@Query("SELECT l FROM Libros l WHERE l.anioNacimiento BETWEEN :startYear AND :endYear")
	List<Libros> findByAnioNacimientoBetween(@Param("startYear") Integer startYear, @Param("endYear") Integer endYear);
}
