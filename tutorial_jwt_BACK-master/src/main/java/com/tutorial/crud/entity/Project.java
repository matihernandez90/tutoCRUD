package com.tutorial.crud.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Grafen Whor
 */
@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombreProj;
    private String descProj;
    private String imagenProj;

    //Contructors

    public Project() {
    }

    public Project(String nombreProj, String descProj, String imagenProj) {
        this.nombreProj = nombreProj;
        this.descProj = descProj;
        this.imagenProj = imagenProj;
    }
    
    //Getters & Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreProj() {
        return nombreProj;
    }

    public void setNombreProj(String nombreProj) {
        this.nombreProj = nombreProj;
    }

    public String getDescProj() {
        return descProj;
    }

    public void setDescProj(String descProj) {
        this.descProj = descProj;
    }

    public String getImagenProj() {
        return imagenProj;
    }

    public void setImagenProj(String imagenProj) {
        this.imagenProj = imagenProj;
    }
    
    
}


