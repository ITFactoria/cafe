/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itfactoria.cafe.backend.restapi.models.services;

import com.itfactoria.cafe.backend.restapi.models.entity.Contacto;
import java.util.List;

/**
 *
 * @author jaironino
 */
public interface IContactoService {
    public Contacto crearContacto(Contacto contacto);
    public List<Contacto> listarContactos();
    public Contacto consultarContacto(Long id);
    public void eliminarContacto(Long id);
    
    
}
