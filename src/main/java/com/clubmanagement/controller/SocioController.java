package com.clubmanagement.controller;

import com.clubmanagement.model.Socio;
import com.clubmanagement.repository.SocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/socios")
public class SocioController {

    @Autowired
    private SocioRepository socioRepository;

    @GetMapping
    public List<Socio> getAllSocios() {
        return socioRepository.findAll();
    }

    @PostMapping
    public Socio createSocio(@RequestBody Socio socio) {
        return socioRepository.save(socio);
    }

    @GetMapping("/{id}")
    public Socio getSocioById(@PathVariable Long id) {
        return socioRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Socio updateSocio(@PathVariable Long id, @RequestBody Socio socioDetails) {
        Socio socio = socioRepository.findById(id).orElse(null);
        if (socio != null) {
            socio.setNombre(socioDetails.getNombre());
            socio.setEmail(socioDetails.getEmail());
            return socioRepository.save(socio);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteSocio(@PathVariable Long id) {
        socioRepository.deleteById(id);
    }
}