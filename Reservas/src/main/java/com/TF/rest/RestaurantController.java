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

import com.TF.model.Restaurant;
import com.TF.service.RestaurantService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping(value="restaurantes")
public class RestaurantController {
	
	@Autowired
	RestaurantService serviceRestaurant;
	
	@ApiOperation(value="Método para crear un Restaurant")
	@PostMapping(value="/")
	public ResponseEntity<Object> crear(@RequestBody @Valid Restaurant obj) {
		try {
			boolean flag = serviceRestaurant.save(obj);
			if(flag) {
				return new ResponseEntity<Object>(HttpStatus.OK);
			}else {
				return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation(value="Método para actualizar un Restaurant")
	@PutMapping(value="/{id}")
	public ResponseEntity<Object> actualizar(@RequestBody Restaurant obj) {
		try {
			boolean flag = serviceRestaurant.update(obj);
			if(flag) {
				return new ResponseEntity<Object>(HttpStatus.OK);
			}else {
				return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation(value="Método para eliminar un Restaurant")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable int id) {
		try {
			boolean flag = serviceRestaurant.delete(id);
			if(flag) {
				return new ResponseEntity<Object>(HttpStatus.OK);
			}else {
				return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation(value="Método para obtener toda la información de los Restaurants")
	@GetMapping(value="/")
	public List<Restaurant> listar(){
		List<Restaurant> listado = serviceRestaurant.getAll();
		return listado;
	}
	
	@ApiOperation(value="Método para obtener toda la informacion de un Restaurant")
	@GetMapping(value="/{id}")
	public Restaurant buscarPorID(@PathVariable int id) {
		Optional<Restaurant> obj = serviceRestaurant.FindById(id);
		if(obj.isPresent())
			return obj.get();
		else 
			return null;
	}
}
