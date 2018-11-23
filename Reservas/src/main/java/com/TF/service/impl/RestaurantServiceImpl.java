package com.TF.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TF.model.Restaurant;
import com.TF.repository.RestaurantRepository;
import com.TF.service.RestaurantService;

@Service
public class RestaurantServiceImpl implements RestaurantService{

	@Autowired
	private RestaurantRepository repoRestaurant;
	
	@Override
	public boolean save(Restaurant obj) {
		boolean flag = false;
		try {
			Restaurant objSave = repoRestaurant.save(obj);
			if(objSave != null)
				flag = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return flag;
	}

	@Override
	public boolean update(Restaurant obj) {
		boolean flag = false;
		try {
			Restaurant objSave = repoRestaurant.save(obj);
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
			Optional<Restaurant> obj = FindById(id);
			if(obj.isPresent()) {
				repoRestaurant.delete(obj.get());
				flag = true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
		return flag;
	}

	@Override
	public List<Restaurant> getAll() {
		List<Restaurant> listado = repoRestaurant.findAll();
		return listado;
	}

	@Override
	public Optional<Restaurant> FindById(int id) {
		Optional<Restaurant> obj = repoRestaurant.findById(id);
		return obj;
	}

}
