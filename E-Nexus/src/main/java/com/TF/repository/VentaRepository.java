package com.TF.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TF.model.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Integer>{
}
