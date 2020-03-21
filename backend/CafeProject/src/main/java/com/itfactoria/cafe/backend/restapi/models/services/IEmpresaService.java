/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itfactoria.cafe.backend.restapi.models.services;

import com.itfactoria.cafe.backend.restapi.models.entity.Empresa;
import java.util.List;

/**
 *
 * @author jaironino
 */
public interface IEmpresaService {
    
    public List<Empresa> findAll();
    public Empresa findById(Long Id);
    public Empresa save(Empresa empresa);
    public void delete(Long id);
   
    
}
