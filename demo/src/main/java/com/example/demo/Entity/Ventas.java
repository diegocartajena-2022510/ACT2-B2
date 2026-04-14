package com.example.demo.Entity;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "ventas")
public class Ventas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "codigo_venta")
    private Integer codigo_venta;

    @Column(name = "fecha_venta")
    private LocalDate fecha_venta;

    @Column(name = "total")
    private double total;

    @Column(name = "estado")
    private int estado;

    @Column(name = "Usuarios_codigo_usuario")
    private Integer Usuarios_codigo_usuario;

    @Column(name = "Clientes_dpi_cliente")
    private Integer Clientes_dpi_cliente;

    public Integer getCodigo_venta() {
        return codigo_venta;
    }

    public void setCodigo_venta(Integer codigo_venta) {
        this.codigo_venta = codigo_venta;
    }

    public LocalDate getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(LocalDate fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Integer getUsuarios_codigo_usuario() {
        return Usuarios_codigo_usuario;
    }

    public void setUsuarios_codigo_usuario(Integer usuarios_codigo_usuario) {
        Usuarios_codigo_usuario = usuarios_codigo_usuario;
    }

    public Integer getClientes_dpi_cliente() {
        return Clientes_dpi_cliente;
    }

    public void setClientes_dpi_cliente(Integer clientes_dpi_cliente) {
        Clientes_dpi_cliente = clientes_dpi_cliente;
    }
}
