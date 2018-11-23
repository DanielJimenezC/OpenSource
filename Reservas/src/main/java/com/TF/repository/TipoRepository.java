package com.TF.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TF.model.Tipo;

@Repository
public interface TipoRepository extends JpaRepository<Tipo, Integer>{

}
