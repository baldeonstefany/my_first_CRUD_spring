package com.example.primer_crud.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.primer_crud.entity.Producto;
import com.example.primer_crud.repository.ProductoRepository;

@Service // Indica que esta clase es un servicio de Spring
public class ProductoService {

    private final ProductoRepository productoRepository; // Repositorio para acceder a los datos

    
    // Inyección de dependencia del repositorio
    public ProductoService(ProductoRepository productoRepository) {// Constructor con inyección de dependencia
        this.productoRepository = productoRepository; // Asigna el repositorio al atributo de la clase
    }

    public Producto guardarProducto(Producto producto) { // Método para guardar un producto
        return productoRepository.save(producto);//   Guarda el producto en la base de datos y lo retorna
    }

    public List<Producto>listar(){ // Método para listar todos los productos
        return productoRepository.findAll();// Retorna la lista de todos los productos
    }

    public Producto buscarPorId(Long id){// Método para buscar un producto por su ID
        return productoRepository.findById(id).orElse(null);// Retorna el producto si existe, sino retorna null
    }

    public void eliminar(Long id){ // Método para eliminar un producto por su ID
    productoRepository.deleteById(id);// Elimina el producto de la base de datos
    }
}