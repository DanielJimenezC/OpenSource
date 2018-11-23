package com.TF.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TF.model.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer>{

}
