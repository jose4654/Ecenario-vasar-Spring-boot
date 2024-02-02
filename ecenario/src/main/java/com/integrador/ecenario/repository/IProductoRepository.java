package com.integrador.ecenario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.integrador.ecenario.model.Producto;


@Repository
public interface IProductoRepository extends JpaRepository<Producto,Long>{

}
