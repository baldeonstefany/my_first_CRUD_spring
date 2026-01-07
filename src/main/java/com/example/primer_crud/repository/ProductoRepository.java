package com.example.primer_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.primer_crud.entity.Producto;

// JpaRepository <Entidad,(clase que representa la tabla) Tipo de dato del ID(@id)>
public interface ProductoRepository extends JpaRepository<Producto,Long> {
    // Spring genera automaticamente el CRUD

    //CRUD ya viene incluido: 
    // - save(): guardar o actualizar una entidad
    // - findById(): buscar por  ID
    // - findAll(): listar todas las entidades
    // - deleteById(): eliminar por ID
    // - existsById(): verificar si existe una entidad por su ID
    // - count(): contar el número de entidades


}
