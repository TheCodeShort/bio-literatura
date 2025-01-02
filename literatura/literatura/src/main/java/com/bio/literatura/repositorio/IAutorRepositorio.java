package com.bio.literatura.repositorio;

import com.bio.literatura.model.Autor;
import com.bio.literatura.model.Libros;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAutorRepositorio extends JpaRepository<Libros, Long> {
}
