package com.clubmanagement.controller;

import com.clubmanagement.model.Articulo;
import com.clubmanagement.repository.ArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articulos")
public class ArticuloController {

    @Autowired
    private ArticuloRepository articuloRepository;

    @GetMapping
    public List<Articulo> getAllArticulos() {
        return articuloRepository.findAll();
    }

    @PostMapping
    public Articulo createArticulo(@RequestBody Articulo articulo) {
        return articuloRepository.save(articulo);
    }

    @GetMapping("/{id}")
    public Articulo getArticuloById(@PathVariable Long id) {
        return articuloRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Articulo updateArticulo(@PathVariable Long id, @RequestBody Articulo details) {
        Articulo articulo = articuloRepository.findById(id).orElse(null);
        if (articulo != null) {
            articulo.setNombre(details.getNombre());
            articulo.setTipo(details.getTipo());
            articulo.setEstado(details.getEstado());
            articulo.setCantidadDisponible(details.getCantidadDisponible());
            return articuloRepository.save(articulo);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteArticulo(@PathVariable Long id) {
        articuloRepository.deleteById(id);
    }
}