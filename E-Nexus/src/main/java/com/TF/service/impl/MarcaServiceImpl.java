package com.TF.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TF.model.Marca;
import com.TF.repository.MarcaRepository;
import com.TF.service.MarcaService;

@Service
public class MarcaServiceImpl implements MarcaService{

	@Autowired
	MarcaRepository repoMarca;
	
	@Override
	public boolean save(Marca obj) {
		boolean flag = false;
		try {
			Marca objSave = repoMarca.save(obj);
			if(objSave != null)
				flag = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return flag;
	}

	@Override
	public boolean update(Marca obj) {
		boolean flag = false;
		try {
			Marca objSave = repoMarca.save(obj);
			if(objSave != null)
				flag = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return flag;
	}

	@Override
	public boolean delete(int id) {
		boolean flag = false;
		try {
			Optional<Marca> obj = findById(id);
			if(obj.isPresent()) {
				repoMarca.delete(obj.get());
				flag = true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return flag;
	}

	@Override
	public List<Marca> getAll() {
		List<Marca> listado = repoMarca.findAll();
		return listado;
	}

	@Override
	public Optional<Marca> findById(int id) {
		Optional<Marca> obj = repoMarca.findById(id);
		return obj;
	}

}
