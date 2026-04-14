package com.example.demo.Service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.Ventas;

@Service
public interface VentasService {
    List<Ventas> getAllVentas();
    Ventas getVentasById(Integer id);
    Ventas saveVentas(Ventas ventas)throws RuntimeException;
    Ventas updateVentas(Integer id, Ventas ventas);
    void deleteVentas(Integer id);
}
