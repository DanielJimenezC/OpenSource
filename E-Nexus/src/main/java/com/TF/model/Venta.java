package com.TF.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="ventas")
public class Venta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message="El campo no puede estar vacio")
	@Size(min=5, max=100, message="El campo no cumple el tamaño deseado")
	private String username;
	@NotNull(message="El campo no puede estar vacio")
	@Min(7) @Max(999999999)
	private double telefono;
	@NotBlank(message="El campo no puede estar vacio")
	@Size(min=5, max=100, message="El campo no cumple el tamaño deseado")
	private String email;
	@NotNull @FutureOrPresent
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fecha;
	@NotBlank(message="El campo no puede ser vacio")
	@Size(min=3, max=100, message="El campo no cumple la longuitud")
	private String observacion;
	
	@OneToMany
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
