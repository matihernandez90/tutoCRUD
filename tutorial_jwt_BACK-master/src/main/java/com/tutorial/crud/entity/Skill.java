package com.tutorial.crud.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Grafen Whor
 */
@Entity
public class Skill {
    
    @Id 
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    
    private Integer porcentaje;
    private String imagen;
    private String nombre;
    private String color;
    
//Constructors
    
    public Skill() {
    }

    public Skill(Integer porcentaje, String imagen, String nombre, String color) {
        this.porcentaje = porcentaje;
        this.imagen = imagen;
        this.nombre = nombre;
        this.color = color;
    }

    //Getters & Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Integer porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    

}
