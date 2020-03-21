/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itfactoria.cafe.backend.restapi.controllers;

import com.itfactoria.cafe.backend.restapi.models.entity.Empresa;
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
public class EmpresaRestController {

    @Autowired
    private IEmpresaService empresaService;

    @GetMapping("/empresas")
    public List<Empresa> index() {
        return empresaService.findAll();

    }

    @GetMapping("/empresas/{id}")
    public ResponseEntity<?> show(@PathVariable Long id) {

        Empresa empresa = null;
        Map<String, Object> response = new HashMap<>();

        try {
            empresa = empresaService.findById(id);
            if (empresa == null) {
                response.put("mensaje", "La empresa con ID ".concat(id.toString().concat(" no existe en la base de datos")));
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<Empresa>(empresa, HttpStatus.OK);
            }

        } catch (DataAccessException dae) {
            response.put("mensaje", "Error al acceder a la base de datos");
            response.put("error", dae.getMessage().concat(": ").concat(dae.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/empresas")
    public ResponseEntity<?> create(@RequestBody Empresa empresa) {

        Empresa empresaNueva = null;
        Map<String, Object> response = new HashMap<>();

        try {
            empresaNueva = empresaService.save(empresa);
            if (empresaNueva == null) {
                response.put("mensaje", "La empresa con ID ".concat(empresa.getId().toString().concat(" no fue creada en la base de datos")));
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            } else {
                response.put("mensaje", "La empresa fue creada de forma exitosa");
                response.put("empresa", empresaNueva);
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

            }

        } catch (DataAccessException dae) {
            response.put("mensaje", "Error al acceder a la base de datos");
            response.put("error", dae.getMessage().concat(": ").concat(dae.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/empresas/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> update(@RequestBody Empresa empresa, @PathVariable Long id) {

        Map<String, Object> response = new HashMap<>();

        Empresa empresaActual = empresaService.findById(id);
        Empresa empresaActualizada = null;

        if (empresaActual == null) {
            response.put("mensaje", "La empresa con ID ".concat(id.toString().concat(" no existe en la base de datos")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);

        } else {
            try {
                empresaActual.setCorreo(empresa.getCorreo());
                empresaActual.setDireccion(empresa.getDireccion());
                empresaActual.setFechacreacion(empresa.getFechacreacion());
                empresaActual.setIdciudad(empresa.getIdciudad());
                empresaActual.setIdcontacto(empresa.getIdcontacto());
                empresaActual.setIddepartamento(empresa.getIddepartamento());
                empresaActual.setIdpais(empresa.getIdpais());
                empresaActual.setLatitud(empresa.getLatitud());
                empresaActual.setLogo(empresa.getLogo());
                empresaActual.setLongitud(empresa.getLongitud());
                empresaActual.setNombre(empresa.getNombre());
                empresaActual.setNumeroid(empresa.getNumeroid());
                empresaActual.setTelefono(empresa.getTelefono());
                empresaActual.setTipoid(empresa.getTipoid());
                empresaActualizada = empresaService.save(empresaActual);
                response.put("mensaje", "La empresa fue actualizada de forma exitosa");
                response.put("empresa", empresaActualizada);
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

            } catch (DataAccessException dae) {
                response.put("mensaje", "Error al acceder a la base de datos");
                response.put("error", dae.getMessage().concat(": ").concat(dae.getMostSpecificCause().getMessage()));
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }

    }

    @DeleteMapping("/empresas/{id}")
    public ResponseEntity delete(@PathVariable Long id) {

        Map<String, Object> response = new HashMap<>();

        try {
            empresaService.delete(id);

        } catch (DataAccessException dae) {
            response.put("mensaje", "Error al eliminar empresa");
            response.put("error", dae.getMessage().concat(": ").concat(dae.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "La empresa fue eliminada de forma exitosa");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

    }

}
