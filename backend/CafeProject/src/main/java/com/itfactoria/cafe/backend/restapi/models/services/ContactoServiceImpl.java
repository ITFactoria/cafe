/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itfactoria.cafe.backend.restapi.models.services;

import com.itfactoria.cafe.backend.restapi.models.dao.IContactoDao;
import com.itfactoria.cafe.backend.restapi.models.entity.Contacto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jaironino
 */
@Service
public class ContactoServiceImpl implements IContactoService{
    
    @Autowired
    IContactoDao contactoDao;

    @Override
    @Transactional 
    public Contacto crearContacto(Contacto contacto) {
        return contactoDao.save(contacto);
    }

    @Override
    @Transactional(readOnly = true) 
    public List<Contacto> listarContactos() {
        return contactoDao.findAll();
    }

    @Override
    @Transactional(readOnly = true) 
    public Contacto consultarContacto(Long id) {
        return contactoDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void eliminarContacto(Long id) {
        contactoDao.deleteById(id);
    }
    
}
