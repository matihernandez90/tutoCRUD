package com.tutorial.crud.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class PersonaDto {

    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;

    public PersonaDto() {
    }

    public PersonaDto(@NotBlank String nombre, @NotBlank String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	

   
}
