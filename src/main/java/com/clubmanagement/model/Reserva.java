package com.clubmanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import java.time.LocalDateTime;

@Entity
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relación con Socio
    @ManyToOne
    @JoinColumn(name = "socio_id")
    private Socio socio;

    // Relación con Instalacion (nullable)
    @ManyToOne
    @JoinColumn(name = "instalacion_id")
    private Instalacion instalacion;

    // Relación con Articulo (nullable)
    @ManyToOne
    @JoinColumn(name = "articulo_id")
    private Articulo articulo;

    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFin;
    private String estado; // pendiente, confirmada, cancelada, etc.

    public Reserva() {}

    public Reserva(Socio socio, Instalacion instalacion, Articulo articulo, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin, String estado) {
        this.socio = socio;
        this.instalacion = instalacion;
        this.articulo = articulo;
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFin = fechaHoraFin;
        this.estado = estado;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Socio getSocio() { return socio; }
    public void setSocio(Socio socio) { this.socio = socio; }

    public Instalacion getInstalacion() { return instalacion; }
    public void setInstalacion(Instalacion instalacion) { this.instalacion = instalacion; }

    public Articulo getArticulo() { return articulo; }
    public void setArticulo(Articulo articulo) { this.articulo = articulo; }

    public LocalDateTime getFechaHoraInicio() { return fechaHoraInicio; }
    public void setFechaHoraInicio(LocalDateTime fechaHoraInicio) { this.fechaHoraInicio = fechaHoraInicio; }

    public LocalDateTime getFechaHoraFin() { return fechaHoraFin; }
    public void setFechaHoraFin(LocalDateTime fechaHoraFin) { this.fechaHoraFin = fechaHoraFin; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}