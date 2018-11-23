package com.TF.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TF.model.MedioPago;
import com.TF.repository.MedioPagoRepository;
import com.TF.service.MedioPagoService;

@Service
public class MedioPagoServiceImpl implements MedioPagoService{

	@Autowired
	private MedioPagoRepository repoMedioPago;
	
	@Override
	public boolean save(MedioPago obj) {
		boolean flag = false;
		try {
			MedioPago objSave = repoMedioPago.save(obj);
			if(objSave != null)
				flag = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return flag;
	}

	@Override
	public boolean update(MedioPago obj) {
		boolean flag = false;
		try {
			MedioPago objSave = repoMedioPago.save(obj);
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
			Optional<MedioPago> obj = FindById(id);
			if(obj.isPresent()) {
				repoMedioPago.delete(obj.get());
				flag = true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
		return flag;
	}

	@Override
	public List<MedioPago> getAll() {
		List<MedioPago> listado = repoMedioPago.findAll();
		return listado;
	}

	@Override
	public Optional<MedioPago> FindById(int id) {
		Optional<MedioPago> obj = repoMedioPago.findById(id);
		return obj;
	}

}
