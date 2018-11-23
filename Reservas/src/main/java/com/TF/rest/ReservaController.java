package com.TF.rest;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TF.model.Reserva;
import com.TF.service.ReservaService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping(value="reservas")
public class ReservaController {
	
	@Autowired
	ReservaService serviceReserva;
	
	@ApiOperation(value="Método para crear un Reserva")
	@PostMapping(value="/")
	public ResponseEntity<Object> crear(@RequestBody @Valid Reserva obj) {
		try {
			boolean flag = serviceReserva.save(obj);
			if(flag) {
				return new ResponseEntity<Object>(HttpStatus.OK);
			}else {
				return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation(value="Método para actualizar un Reserva")
	@PutMapping(value="/{id}")
	public ResponseEntity<Object> actualizar(@RequestBody Reserva obj) {
		try {
			boolean flag = serviceReserva.update(obj);
			if(flag) {
				return new ResponseEntity<Object>(HttpStatus.OK);
			}else {
				return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation(value="Método para eliminar un Reserva")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable int id) {
		try {
			boolean flag = serviceReserva.delete(id);
			if(flag) {
				return new ResponseEntity<Object>(HttpStatus.OK);
			}else {
				return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation(value="Método para obtener toda la información de los Reservas")
	@GetMapping(value="/")
	public List<Reserva> listar(){
		List<Reserva> listado = serviceReserva.getAll();
		return listado;
	}
	
	@ApiOperation(value="Método para obtener toda la informacion de un Reserva")
	@GetMapping(value="/{id}")
	public Reserva buscarPorID(@PathVariable int id) {
		Optional<Reserva> obj = serviceReserva.FindById(id);
		if(obj.isPresent())
			return obj.get();
		else 
			return null;
	}
}
