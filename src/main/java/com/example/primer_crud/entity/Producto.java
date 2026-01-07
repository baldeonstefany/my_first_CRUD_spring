package com.example.primer_crud.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@Entity // Indica que esta clase es una entidad JPA
@Table(name = "productos") // Mapea la entidad a la tabla "personas" en la base de datos
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Indica que el ID se genera automáticamente
    // Atributos
    private Long id;
    private String nombre;
    private Integer precio;
    private String descripcion;
   

    // Constructor vacio (obligatorio para JPA)
    public Producto() {
    }

    // Constructor con parámetros (opcional) 
    public Producto(String nombre, Integer precio, String descripcion) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
    }

}
