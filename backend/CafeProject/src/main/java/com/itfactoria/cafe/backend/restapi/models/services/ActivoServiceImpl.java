/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itfactoria.cafe.backend.restapi.models.services;

import com.itfactoria.cafe.backend.restapi.models.dao.IActivoDao;
import com.itfactoria.cafe.backend.restapi.models.entity.Activo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jaironino
 */
@Service
public class ActivoServiceImpl implements IActivoService{
    
    @Autowired
    IActivoDao activoDao;

    @Override
    @Transactional
    public Activo crearActivo(Activo activo) {
        return activoDao.save(activo);
        
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Activo> listarActivos() {
        return activoDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Activo consultarActivo(Long id) {
        return activoDao.findById(id).orElse(null);
    }

    

    @Override
    @Transactional
    public void eliminarActivo(Long id) {
        activoDao.deleteById(id);
        
    }
    
}
