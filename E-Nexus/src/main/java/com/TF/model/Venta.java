package com.TF.model;

import java.util.Date;
import java.util.List;

public class Venta {
	private int id;
	private String username;
	private double telefono;
	private String email;
	private Date fecha;
	private String observacion;
	
	private List<Linea> lineas;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public double getTelefono() {
		return telefono;
	}
	public void setTelefono(double telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public List<Linea> getLineas() {
		return lineas;
	}
	public void setLineas(List<Linea> lineas) {
		this.lineas = lineas;
	}
}
