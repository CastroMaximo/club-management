package com.clubmanagement.controller;

import com.clubmanagement.model.Reserva;
import com.clubmanagement.repository.ReservaRepository;
import com.clubmanagement.repository.SocioRepository;
import com.clubmanagement.repository.InstalacionRepository;
import com.clubmanagement.repository.ArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private SocioRepository socioRepository;

    @Autowired
    private InstalacionRepository instalacionRepository;

    @Autowired
    private ArticuloRepository articuloRepository;

    @GetMapping
    public List<Reserva> getAllReservas() {
        return reservaRepository.findAll();
    }

    @PostMapping
    public Reserva createReserva(@RequestBody Reserva reserva) {
        // Aquí podrías validar que socio, instalacion o articulo existan si lo deseas
        return reservaRepository.save(reserva);
    }

    @GetMapping("/{id}")
    public Reserva getReservaById(@PathVariable Long id) {
        return reservaRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Reserva updateReserva(@PathVariable Long id, @RequestBody Reserva details) {
        Reserva reserva = reservaRepository.findById(id).orElse(null);
        if (reserva != null) {
            reserva.setSocio(details.getSocio());
            reserva.setInstalacion(details.getInstalacion());
            reserva.setArticulo(details.getArticulo());
            reserva.setFechaHoraInicio(details.getFechaHoraInicio());
            reserva.setFechaHoraFin(details.getFechaHoraFin());
            reserva.setEstado(details.getEstado());
            return reservaRepository.save(reserva);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteReserva(@PathVariable Long id) {
        reservaRepository.deleteById(id);
    }
}