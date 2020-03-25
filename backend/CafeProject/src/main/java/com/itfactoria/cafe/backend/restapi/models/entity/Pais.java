/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itfactoria.cafe.backend.restapi.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author jaironino
 */
@Entity
@Table(name="paises")
public class Pais implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull(message = "Nombre no puede estar vacio")
    private String nombre;
    
    @NotNull(message = "Prefijo telefono identficacion no puede estar vacio")
    private int prefijotel;
    
    @NotNull(message = "iso identficacion no puede estar vacio")
    private String iso;
    
    //@NotNull(message = "estado no puede estar vacio")
    /*@OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="estado_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})*/
    //private Estado estado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrefijotel() {
        return prefijotel;
    }

    public void setPrefijotel(int prefijotel) {
        this.prefijotel = prefijotel;
    }

    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }

    /*public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }*/
    
    
    
    
    
}
