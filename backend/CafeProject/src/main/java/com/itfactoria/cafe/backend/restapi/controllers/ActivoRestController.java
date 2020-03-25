/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itfactoria.cafe.backend.restapi.controllers;

import com.itfactoria.cafe.backend.restapi.models.entity.Activo;
import com.itfactoria.cafe.backend.restapi.models.services.IActivoService;
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
public class ActivoRestController {
    
    @Autowired
    private IActivoService activoService;

    @GetMapping("/activos")
    public List<Activo> index() {
        return activoService.listarActivos();
    }
    
    @GetMapping("/activos/{id}")
    public ResponseEntity<?> show(@PathVariable Long id) {

        Activo activo = null;
        Map<String, Object> response = new HashMap<>();

        try {
            activo = activoService.consultarActivo(id);
            if (activo == null) {
                response.put("mensaje", "El activo con ID ".concat(id.toString().concat(" no existe en la base de datos")));
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<Activo>(activo, HttpStatus.OK);
            }

        } catch (DataAccessException dae) {
            response.put("mensaje", "Error al acceder a la base de datos");
            response.put("error", dae.getMessage().concat(": ").concat(dae.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PostMapping("/activos")
    public ResponseEntity<?> create(@RequestBody Activo activo) {

        Activo activoNuevo = null;
        Map<String, Object> response = new HashMap<>();

        try {
            activoNuevo = activoService.crearActivo(activo);
            if (activoNuevo == null) {
                response.put("mensaje", "El activo con ID ".concat(activo.getId().toString().concat(" no fue creada en la base de datos")));
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            } else {
                response.put("mensaje", "El activo fue creada de forma exitosa");
                response.put("empresa", activoNuevo);
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

            }

        } catch (DataAccessException dae) {
            response.put("mensaje", "Error al acceder a la base de datos");
            response.put("error", dae.getMessage().concat(": ").concat(dae.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PutMapping("/activos/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> update(@RequestBody Activo activo, @PathVariable Long id) {

        Map<String, Object> response = new HashMap<>();

        Activo activoActual = activoService.consultarActivo(id);
        Activo activoActualizado = null;

        if (activoActual == null) {
            response.put("mensaje", "El activo con ID ".concat(id.toString().concat(" no existe en la base de datos")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);

        } else {
            try {
                activoActual.setCodigo(activo.getCodigo());
                activoActual.setFechacreacion(activo.getFechacreacion());
                activoActual.setFechafingarantia(activo.getFechafingarantia());
                activoActual.setFechamodificacion(activo.getFechamodificacion());
                activoActual.setIdfabricante(activo.getIdfabricante());
                activoActual.setIdpropietario(activo.getIdpropietario());
                activoActual.setIdtecnico(activo.getIdtecnico());
                activoActual.setImagendetallada(activo.getImagendetallada());
                activoActual.setImagenprincipal(activo.getImagendetallada());
                activoActual.setLatitud(activo.getLatitud());
                activoActual.setLongitud(activo.getLongitud());
                activoActual.setNombre(activo.getNombre());
                activoActualizado = activoService.crearActivo(activoActual);
                response.put("mensaje", "El activo fue actualizado de forma exitosa");
                response.put("activo", activoActualizado);
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

            } catch (DataAccessException dae) {
                response.put("mensaje", "Error al acceder a la base de datos");
                response.put("error", dae.getMessage().concat(": ").concat(dae.getMostSpecificCause().getMessage()));
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }

    }
    
    @DeleteMapping("/activos/{id}")
    public ResponseEntity delete(@PathVariable Long id) {

        Map<String, Object> response = new HashMap<>();

        try {
            activoService.eliminarActivo(id);

        } catch (DataAccessException dae) {
            response.put("mensaje", "Error al eliminar activo");
            response.put("error", dae.getMessage().concat(": ").concat(dae.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "La empresa fue eliminada de forma exitosa");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

    }
    
}
