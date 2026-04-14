package com.example.demo.Service;

import com.example.demo.Entity.DetalleVenta;
import com.example.demo.Repository.DetalleVentaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleVentaServiceImplements implements DetalleVentaService {
    private final DetalleVentaRepository detalleVentaRepository;

    public DetalleVentaServiceImplements(DetalleVentaRepository detalleVentaRepository) {
        this.detalleVentaRepository = detalleVentaRepository;
    }


    @Override
    public List<DetalleVenta> getAlldetalleVenta() {
        return detalleVentaRepository.findAll();
    }

    @Override
    public DetalleVenta getdetalleVentaById(Integer id) {
        return detalleVentaRepository.findById(id).orElse(null);
    }

    @Override
    public DetalleVenta savedetalleVenta(DetalleVenta detalleVenta) throws RuntimeException {
        return detalleVentaRepository.save(detalleVenta);
    }

    @Override
    public DetalleVenta updatedetalleVenta(Integer id, DetalleVenta detalleVenta) {
        return detalleVentaRepository.save(detalleVenta);
    }

    @Override
    public void deletedetalleVenta(Integer id) {
        detalleVentaRepository.deleteById(id);
    }

}
