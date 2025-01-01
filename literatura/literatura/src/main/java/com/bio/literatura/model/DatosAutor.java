package com.bio.literatura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)

public record DatosAutor(@JsonAlias ("title") String titulo,
                         @JsonAlias  ("authors") List<DatosInformacion> autores) {

}
