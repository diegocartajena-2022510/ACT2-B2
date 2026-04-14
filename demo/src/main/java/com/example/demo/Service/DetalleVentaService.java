package com.example.demo.Service;


import com.example.demo.Entity.DetalleVenta;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DetalleVentaService {
    List<DetalleVenta> getAlldetalleVenta();
    DetalleVenta getdetalleVentaById(Integer id);
    DetalleVenta savedetalleVenta(DetalleVenta detalleVenta)throws RuntimeException;
    DetalleVenta updatedetalleVenta(Integer id, DetalleVenta detalleVenta);
    void deletedetalleVenta(Integer id);
}
