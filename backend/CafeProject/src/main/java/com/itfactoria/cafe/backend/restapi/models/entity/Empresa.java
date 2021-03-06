/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itfactoria.cafe.backend.restapi.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author jaironino
 */
@Entity
@Table(name = "empresas")
public class Empresa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Tipo identficacion no puede estar vacio")
    private String tipoid;
    
    @NotNull(message = "Numero identificacion no puede estar vacio")
    @Column(nullable=false, unique =true)
    private Long numeroid;
    
    @NotNull(message = "Nombre no puede estar vacio")
    @Column(nullable=false)
    private String nombre;
    
    @NotNull(message = "Correo no puede estar vacio")
    @Column(nullable=false, unique =true)
    private String correo;
    
    @NotNull(message = "Telefono no puede estar vacio")
    @Column(nullable=false)
    private String telefono;
    
    @NotNull(message = "Direccion no puede estar vacia")
    private String direccion;
    
    @NotNull(message = "Contacto no puede estar vacio")
    private int idcontacto;
    
    private int idlogo;
    
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
    
    @NotNull(message = "Estado no puede estar vacio")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="estado_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Estado estado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoid() {
        return tipoid;
    }

    public void setTipoid(String tipoid) {
        this.tipoid = tipoid;
    }

    public Long getNumeroid() {
        return numeroid;
    }

    public void setNumeroid(Long numeroid) {
        this.numeroid = numeroid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getIdcontacto() {
        return idcontacto;
    }

    public void setIdcontacto(int idcontacto) {
        this.idcontacto = idcontacto;
    }

    public int getIdLogo() {
        return idlogo;
    }

    public void setIdLogo(int logo) {
        this.idlogo = logo;
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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
    
    

    
}
