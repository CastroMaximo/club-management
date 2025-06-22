package com.clubmanagement.controller;

import com.clubmanagement.model.Instalacion;
import com.clubmanagement.repository.InstalacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instalaciones")
public class InstalacionController {

    @Autowired
    private InstalacionRepository instalacionRepository;

    @GetMapping
    public List<Instalacion> getAllInstalaciones() {
        return instalacionRepository.findAll();
    }

    @PostMapping
    public Instalacion createInstalacion(@RequestBody Instalacion instalacion) {
        return instalacionRepository.save(instalacion);
    }

    @GetMapping("/{id}")
    public Instalacion getInstalacionById(@PathVariable Long id) {
        return instalacionRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Instalacion updateInstalacion(@PathVariable Long id, @RequestBody Instalacion details) {
        Instalacion instalacion = instalacionRepository.findById(id).orElse(null);
        if (instalacion != null) {
            instalacion.setNombre(details.getNombre());
            instalacion.setTipo(details.getTipo());
            instalacion.setUbicacion(details.getUbicacion());
            instalacion.setCapacidad(details.getCapacidad());
            return instalacionRepository.save(instalacion);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteInstalacion(@PathVariable Long id) {
        instalacionRepository.deleteById(id);
    }
}