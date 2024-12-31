package com.bio.literatura.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)//al llamar el json tiene mas informacion este @JsonIgnoreProperties no ayuda a ignorar esa informacion que no solicitamos y que solo se quede la que si llamamos

public record DatosLibro() {
}
