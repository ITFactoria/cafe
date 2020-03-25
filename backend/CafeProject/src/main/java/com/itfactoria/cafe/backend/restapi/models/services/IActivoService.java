/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itfactoria.cafe.backend.restapi.models.services;

import com.itfactoria.cafe.backend.restapi.models.entity.Activo;
import java.util.List;

/**
 *
 * @author jaironino
 */
public interface IActivoService {
    public Activo crearActivo(Activo activo);
    public List<Activo> listarActivos();
    public Activo consultarActivo(Long id);
    public void eliminarActivo(Long id);
    
    
}
