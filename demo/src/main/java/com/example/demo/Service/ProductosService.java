package com.example.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.Productos;

@Service
public interface ProductosService {
    List<Productos> getAllProductos();
    Productos getProductosById(Integer id);
    Productos saveProductos(Productos productos)throws RuntimeException;
    Productos updateProductos(Integer id, Productos productos);
    void deleteProductos(Integer id);
}
