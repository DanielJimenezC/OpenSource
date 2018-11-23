package com.TF.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TF.model.Linea;

@Repository
public interface LineaRepository extends JpaRepository<Linea, Integer>{
}
