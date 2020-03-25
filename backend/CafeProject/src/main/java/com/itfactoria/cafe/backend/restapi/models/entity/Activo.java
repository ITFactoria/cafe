/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itfactoria.cafe.backend.restapi.models.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author jaironino
 */
@Entity
@Table(name="activos")
public class Activo implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull(message = "Fabricante no puede estar vacio")
    private int idfabricante;
    
    @NotNull(message = "Fabricante no puede estar vacio")
    private String codigo;
    
    @NotNull(message = "Nombre no puede estar vacio")
    private String nombre;
    
    private String imagenprincipal;
    private String imagendetallada;
    
    @NotNull(message = "Propietario no puede estar vacio")
    private int idpropietario;
    
    @NotNull(message = "Tecnico no puede estar vacio")
    private int idtecnico;
    
    @NotNull(message = "Fecha creación no puede estar vacio")
    @Temporal(TemporalType.DATE)
    private Date fechafingarantia;
    
    @NotNull(message = "Latitud no puede estar vacio")
    private String latitud;
    
    @NotNull(message = "Longitud no puede estar vacio")
    private String longitud;
    
    @NotNull(message = "Fecha creación no puede estar vacio")
    @Temporal(TemporalType.DATE)
    private Date fechacreacion;
    
    @NotNull(message = "Fecha modificación no puede estar vacio")
    @Temporal(TemporalType.DATE)
    private Date fechamodificacion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getIdfabricante() {
        return idfabricante;
    }

    public void setIdfabricante(int idfabricante) {
        this.idfabricante = idfabricante;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagenprincipal() {
        return imagenprincipal;
    }

    public void setImagenprincipal(String imagenprincipal) {
        this.imagenprincipal = imagenprincipal;
    }

    public String getImagendetallada() {
        return imagendetallada;
    }

    public void setImagendetallada(String imagendetallada) {
        this.imagendetallada = imagendetallada;
    }

    public int getIdpropietario() {
        return idpropietario;
    }

    public void setIdpropietario(int idpropietario) {
        this.idpropietario = idpropietario;
    }

    public int getIdtecnico() {
        return idtecnico;
    }

    public void setIdtecnico(int idtecnico) {
        this.idtecnico = idtecnico;
    }

    public Date getFechafingarantia() {
        return fechafingarantia;
    }

    public void setFechafingarantia(Date fechafingarantia) {
        this.fechafingarantia = fechafingarantia;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public Date getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public Date getFechamodificacion() {
        return fechamodificacion;
    }

    public void setFechamodificacion(Date fechamodificacion) {
        this.fechamodificacion = fechamodificacion;
    }
    
    
    
    
    
    
    
    
}
