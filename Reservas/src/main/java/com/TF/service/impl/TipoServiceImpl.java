package com.TF.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TF.model.Tipo;
import com.TF.repository.TipoRepository;
import com.TF.service.TipoService;

@Service
public class TipoServiceImpl implements TipoService{

	@Autowired
	private TipoRepository repoTipo;
	
	@Override
	public boolean save(Tipo obj) {
		boolean flag = false;
		try {
			Tipo objSave = repoTipo.save(obj);
			if(objSave != null)
				flag = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return flag;
	}

	@Override
	public boolean update(Tipo obj) {
		boolean flag = false;
		try {
			Tipo objSave = repoTipo.save(obj);
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
			Optional<Tipo> obj = FindById(id);
			if(obj.isPresent()) {
				repoTipo.delete(obj.get());
				flag = true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
		return flag;
	}

	@Override
	public List<Tipo> getAll() {
		List<Tipo> listado = repoTipo.findAll();
		return listado;
	}

	@Override
	public Optional<Tipo> FindById(int id) {
		Optional<Tipo> obj = repoTipo.findById(id);
		return obj;
	}

}
