package com.TF.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TF.model.MedioPago;

@Repository
public interface MedioPagoRepository extends JpaRepository<MedioPago, Integer>{

}
