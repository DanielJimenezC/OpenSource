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

import com.TF.model.Marca;
import com.TF.service.MarcaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping(value="/marcas")
@Api(value="Servicio para gestionar marcas")
public class MarcaRestController {

	@Autowired
	MarcaService marcaService;
	
	@ApiOperation(value="Método para guardar un Genero")
	@PostMapping(value="/")
	public ResponseEntity<Object> save(@RequestBody @Valid Marca obj){
		try {
			boolean flag = marcaService.save(obj);
			if(flag) {
				return new ResponseEntity<Object>(HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation(value="Método para actualiza una Marca")
	@PutMapping(value="/{id}")
	public ResponseEntity<Object> update(@RequestBody Marca obj){
		try {
			boolean flag = marcaService.update(obj);
			if(flag) {
				return new ResponseEntity<Object>(HttpStatus.OK);
			}else
				return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation(value="Método para eliminar una Marca")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> delete(@PathVariable int id){
		try {
			boolean flag = marcaService.delete(id);
			if(flag) {
				return new ResponseEntity<Object>(HttpStatus.OK);
			}else {
				return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation(value="Método para listar todas las Marcas")
	@GetMapping(value="/")
	public List<Marca> getAll(){
		List<Marca> listado = marcaService.getAll();
		return listado;
	}
	
	@ApiOperation(value="Método para buscar Marca por Id")
	@GetMapping(value="/{id}")
	public Marca findById(@PathVariable int id) {
		Optional<Marca> obj = marcaService.findById(id);
		if(obj.isPresent()) {
			return obj.get();
		}else {
			return null;
		}
	}
}
