package com.example.primer_crud.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.primer_crud.entity.Producto;
import com.example.primer_crud.service.ProductoService;

@RestController // Indica que esta clase es un controlador REST
@RequestMapping("/productos") // Ruta base para los endpoints de productos
public class ProductoController {

    private final ProductoService productoService; // Servicio para manejar la lógica de negocio
    
    public ProductoController(ProductoService productoService) { // Constructor con inyección de dependencia
        this.productoService = productoService; // Asigna el servicio al atributo de la clase
    }

    // Endpoint para CREAR un nuevo producto
    // POST /productos http://localhost:8080/productos
    @PostMapping // Indica que este método maneja solicitudes POST
    public Producto crear(@RequestBody Producto producto){ // Método para crear un nuevo producto
        return productoService.guardarProducto(producto);

    }

    // Endpoint para LISTAR todos los productos
    // GET /productos http://localhost:8080/productos
    @GetMapping
    public List<Producto> listar(){ // Método para listar todos los productos
        return productoService.listar();// Retorna la lista de todos los productos
    }

    // Endpoint para OBTENER un producto por su ID
    // GET /productos/{id} http://localhost:8080/productos/1
    @GetMapping("/{id}")
    public Producto obtenerPorId(@PathVariable Long id){ // Método para obtener un producto por su ID
        return productoService.buscarPorId(id);// Retorna el producto si existe, sino retorna null
    }
    
    // Endpoint para ACTUALIZAR un producto por su ID
    // PUT /productos/{id} http://localhost:8080/productos/1
    @PutMapping("/{id}")
    public Producto actualizaProducto(@PathVariable Long id, @RequestBody Producto producto){
        producto.setId(id); 
        return productoService.guardarProducto(producto);
    }

    // Endpoint para ELIMINAR un producto por su ID
    // DELETE /productos/{id} http://localhost:8080/productos/1
    public void eliminarProducto(@PathVariable Long id){
        productoService.eliminar(id);
    }
}
