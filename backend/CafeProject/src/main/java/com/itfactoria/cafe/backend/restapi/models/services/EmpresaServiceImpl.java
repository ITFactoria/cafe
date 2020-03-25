/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itfactoria.cafe.backend.restapi.models.services;

import com.itfactoria.cafe.backend.restapi.models.dao.IEmpresaDao;
import com.itfactoria.cafe.backend.restapi.models.entity.Empresa;
import com.itfactoria.cafe.backend.restapi.models.entity.Estado;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jaironino
 */
@Service
public class EmpresaServiceImpl implements IEmpresaService{
    
    @Autowired
    IEmpresaDao empresaDao;

    @Override
    @Transactional(readOnly = true) 
    public List<Empresa> findAll() {
        return (List<Empresa>) empresaDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Empresa findById(Long Id) {
        return empresaDao.findById(Id).orElse(null);
    }

    @Override
    @Transactional
    public Empresa save(Empresa empresa) {
        return empresaDao.save(empresa);
        
    }

    @Override
    @Transactional
    public void delete(Long id) {
        empresaDao.deleteById(id);
        
    }

    @Override
    @Transactional(readOnly = true)
    public List<Estado> listarEstados() {
        return (List<Estado>)empresaDao.listarEstados();
        
    }
    
}
