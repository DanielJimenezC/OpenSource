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

import com.TF.model.MedioPago;
import com.TF.service.MedioPagoService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping(value="medios")
public class MedioPagoController {

	@Autowired
	MedioPagoService serviceMedioPago;
	
	@ApiOperation(value="Método para crear un Medio de Pago")
	@PostMapping(value="/")
	public ResponseEntity<Object> crear(@RequestBody @Valid MedioPago obj) {
		try {
			boolean flag = serviceMedioPago.save(obj);
			if(flag) {
				return new ResponseEntity<Object>(HttpStatus.OK);
			}else {
				return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation(value="Método para actualizar un Medio de Pago")
	@PutMapping(value="/{id}")
	public ResponseEntity<Object> actualizar(@RequestBody MedioPago obj) {
		try {
			boolean flag = serviceMedioPago.update(obj);
			if(flag) {
				return new ResponseEntity<Object>(HttpStatus.OK);
			}else {
				return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation(value="Método para eliminar un Medio de Pago")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable int id) {
		try {
			boolean flag = serviceMedioPago.delete(id);
			if(flag) {
				return new ResponseEntity<Object>(HttpStatus.OK);
			}else {
				return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation(value="Método para obtener toda la información de los Medios de Pago")
	@GetMapping(value="/")
	public List<MedioPago> listar(){
		List<MedioPago> listado = serviceMedioPago.getAll();
		return listado;
	}
	
	@ApiOperation(value="Método para obtener toda la informacion de un Medio de Pago")
	@GetMapping(value="/{id}")
	public MedioPago buscarPorID(@PathVariable int id) {
		Optional<MedioPago> obj = serviceMedioPago.FindById(id);
		if(obj.isPresent())
			return obj.get();
		else 
			return null;
	}
}
