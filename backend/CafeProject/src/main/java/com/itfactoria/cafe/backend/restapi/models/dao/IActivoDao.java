/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itfactoria.cafe.backend.restapi.models.dao;

import com.itfactoria.cafe.backend.restapi.models.entity.Activo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jaironino
 */

public interface IActivoDao extends JpaRepository<Activo, Long>{
    
}
