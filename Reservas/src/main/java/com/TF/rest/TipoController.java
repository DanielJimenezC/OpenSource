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

import com.TF.model.Tipo;
import com.TF.service.TipoService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping(value="tipos")
public class TipoController {
	
	@Autowired
	TipoService serviceTipo;
	
	@ApiOperation(value="Método para crear un Tipo")
	@PostMapping(value="/")
	public ResponseEntity<Object> crear(@RequestBody @Valid Tipo obj) {
		try {
			boolean flag = serviceTipo.save(obj);
			if(flag) {
				return new ResponseEntity<Object>(HttpStatus.OK);
			}else {
				return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation(value="Método para actualizar un Tipo")
	@PutMapping(value="/{id}")
	public ResponseEntity<Object> actualizar(@RequestBody Tipo obj) {
		try {
			boolean flag = serviceTipo.update(obj);
			if(flag) {
				return new ResponseEntity<Object>(HttpStatus.OK);
			}else {
				return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation(value="Método para eliminar un Tipo")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable int id) {
		try {
			boolean flag = serviceTipo.delete(id);
			if(flag) {
				return new ResponseEntity<Object>(HttpStatus.OK);
			}else {
				return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation(value="Método para obtener toda la información de los Tipos")
	@GetMapping(value="/")
	public List<Tipo> listar(){
		List<Tipo> listado = serviceTipo.getAll();
		return listado;
	}
	
	@ApiOperation(value="Método para obtener toda la informacion de un Tipo")
	@GetMapping(value="/{id}")
	public Tipo buscarPorID(@PathVariable int id) {
		Optional<Tipo> obj = serviceTipo.FindById(id);
		if(obj.isPresent())
			return obj.get();
		else 
			return null;
	}
}
