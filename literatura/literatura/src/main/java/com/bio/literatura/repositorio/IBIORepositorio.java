package com.bio.literatura.repositorio;

import com.bio.literatura.model.Libros;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBIORepositorio extends JpaRepository<Libros, Long> {
}
