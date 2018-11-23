package com.TF.service;

import java.util.List;
import java.util.Optional;

public interface CrudService<T>{
	public boolean save(T obj);
	public boolean update(T obj);
	public boolean delete(int id);
	public List<T> getAll();
	public Optional<T> FindById(int id);
}
