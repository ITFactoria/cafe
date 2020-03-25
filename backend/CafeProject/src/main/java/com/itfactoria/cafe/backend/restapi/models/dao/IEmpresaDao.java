/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itfactoria.cafe.backend.restapi.models.dao;

import com.itfactoria.cafe.backend.restapi.models.entity.Empresa;
import com.itfactoria.cafe.backend.restapi.models.entity.Estado;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author jaironino
 */
public interface IEmpresaDao extends JpaRepository<Empresa, Long>{
    
    @Query("from Estado")
    public List<Estado> listarEstados();
    
}
