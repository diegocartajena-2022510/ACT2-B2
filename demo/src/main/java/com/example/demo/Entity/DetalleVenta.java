package com.example.demo.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "detalleVenta")
public class DetalleVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "codigo_detalle_venta")
    private Integer codigo_detalle_venta;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name="precio_unitario")
    private double precio_unitario;

    @Column(name="subtotal")
    private double subtotal;

    @Column(name="productos_codigo_producto")
    private Integer productos_codigo_producto;

    @Column(name="ventas_codigo_venta")
    private Integer ventas_codigo_venta;

    public Integer getCodigo_detalle_venta() {
        return codigo_detalle_venta;
    }

    public void setCodigo_detalle_venta(Integer codigo_detalle_venta) {
        this.codigo_detalle_venta = codigo_detalle_venta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public Integer getProductos_codigo_producto() {
        return productos_codigo_producto;
    }

    public void setProductos_codigo_producto(Integer productos_codigo_producto) {
        this.productos_codigo_producto = productos_codigo_producto;
    }

    public Integer getVentas_codigo_venta() {
        return ventas_codigo_venta;
    }

    public void setVentas_codigo_venta(Integer ventas_codigo_venta) {
        this.ventas_codigo_venta = ventas_codigo_venta;
    }
}
