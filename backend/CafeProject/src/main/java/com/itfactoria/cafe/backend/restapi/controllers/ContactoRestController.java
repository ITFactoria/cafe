/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itfactoria.cafe.backend.restapi.controllers;

import com.itfactoria.cafe.backend.restapi.models.entity.Contacto;
import com.itfactoria.cafe.backend.restapi.models.entity.Empresa;
import com.itfactoria.cafe.backend.restapi.models.services.ContactoServiceImpl;
import com.itfactoria.cafe.backend.restapi.models.services.IContactoService;
import com.itfactoria.cafe.backend.restapi.models.services.IEmpresaService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jaironino
 */
@RestController
@RequestMapping("/api")
public class ContactoRestController {

    @Autowired
    private IContactoService contactoService;

    @GetMapping("/contactos")
    public List<Contacto> listarContactos() {
        return contactoService.listarContactos();

    }

    @GetMapping("/contactos/{id}")
    public ResponseEntity<?> show(@PathVariable Long id) {

        Contacto contacto = null;
        Map<String, Object> response = new HashMap<>();

        try {
            contacto = contactoService.consultarContacto(id);
            if (contacto == null) {
                response.put("mensaje", "El contacto con ID ".concat(id.toString().concat(" no existe en la base de datos")));
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<Contacto>(contacto, HttpStatus.OK);
            }

        } catch (DataAccessException dae) {
            response.put("mensaje", "Error al acceder a la base de datos");
            response.put("error", dae.getMessage().concat(": ").concat(dae.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/contactos")
    public ResponseEntity<?> create(@RequestBody Contacto contacto) {

        Contacto contactoNuevo = null;
        Map<String, Object> response = new HashMap<>();

        try {
            contactoNuevo = contactoService.crearContacto(contacto);
            if (contactoNuevo == null) {
                response.put("mensaje", "El contacto con ID ".concat(contacto.getId().toString().concat(" no fue creado en la base de datos")));
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            } else {
                response.put("mensaje", "El contacto fue creado de forma exitosa");
                response.put("empresa", contactoNuevo);
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

            }

        } catch (DataAccessException dae) {
            response.put("mensaje", "Error al acceder a la base de datos");
            response.put("error", dae.getMessage().concat(": ").concat(dae.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/contactos/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> update(@RequestBody Contacto contacto, @PathVariable Long id) {

        Map<String, Object> response = new HashMap<>();

        Contacto contactoActual = contactoService.consultarContacto(id);
        Contacto contactoActualizado = null;

        if (contactoActual == null) {
            response.put("mensaje", "El contacto con ID ".concat(id.toString().concat(" no existe en la base de datos")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);

        } else {
            try {
                contactoActual.setCelular(contacto.getCelular());
                contactoActual.setDireccion(contacto.getDireccion());
                contactoActual.setEstado(contacto.getEstado());
                contactoActual.setFechacreacion(contacto.getFechacreacion());
                contactoActual.setFechamodificacion(contacto.getFechamodificacion());
                contactoActual.setLatitud(contacto.getLatitud());
                contactoActual.setLongitud(contacto.getLongitud());
                contactoActual.setNombre(contacto.getNombre());
                contactoActual.setTelefono(contacto.getTelefono());
                contactoActualizado = contactoService.crearContacto(contactoActual);
                response.put("mensaje", "El contacto fue actualizado de forma exitosa");
                response.put("empresa", contactoActualizado);
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

            } catch (DataAccessException dae) {
                response.put("mensaje", "Error al acceder a la base de datos");
                response.put("error", dae.getMessage().concat(": ").concat(dae.getMostSpecificCause().getMessage()));
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }

    }
    
    @DeleteMapping("/contactos/{id}")
    public ResponseEntity delete(@PathVariable Long id) {

        Map<String, Object> response = new HashMap<>();

        try {
            contactoService.eliminarContacto(id);
            
        } catch (DataAccessException dae) {
            response.put("mensaje", "Error al eliminar el contacto");
            response.put("error", dae.getMessage().concat(": ").concat(dae.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El contacto fue eliminada de forma exitosa");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

    }
    

}
