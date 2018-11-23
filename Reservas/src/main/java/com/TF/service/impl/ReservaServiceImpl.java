package com.TF.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TF.model.Reserva;
import com.TF.repository.ReservaRepository;
import com.TF.service.ReservaService;

@Service
public class ReservaServiceImpl implements ReservaService{

	@Autowired
	private ReservaRepository repoReserva;
	
	@Override
	public boolean save(Reserva obj) {
		boolean flag = false;
		try {
			Reserva objSave = repoReserva.save(obj);
			if(objSave != null)
				flag = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return flag;
	}

	@Override
	public boolean update(Reserva obj) {
		boolean flag = false;
		try {
			Reserva objSave = repoReserva.save(obj);
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
			Optional<Reserva> obj = FindById(id);
			if(obj.isPresent()) {
				repoReserva.delete(obj.get());
				flag = true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
		return flag;
	}

	@Override
	public List<Reserva> getAll() {
		List<Reserva> listado = repoReserva.findAll();
		return listado;
	}

	@Override
	public Optional<Reserva> FindById(int id) {
		Optional<Reserva> obj = repoReserva.findById(id);
		return obj;
	}

}
