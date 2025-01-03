package com.bio.literatura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public record DatosInformacion(@JsonAlias ("name") String autor,
                               @JsonAlias ("birth_year") Integer anioNacimiento,
                               @JsonAlias ("death_year") Integer anioMuerte){
}
