package com.TF.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="restaurantes")
public class Restaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value="Primary key de restaurant")
	private int id;
	@NotBlank(message="El campo no puede estar en blanco")
	@Size(min=3, max=50, message="El campo no cumple con longitud")
	private String nombre;
	@NotNull(message="No puede ser Nulo")
	@DecimalMin(value="0.01", message="Precio tiene que tener un valor")
	private double precio;
	@NotBlank(message="El campo no puede estar en blanco")
	@Size(min=3, max=100, message="El campo no cumple con longitud")
	private String descripcion;
	
	@OneToMany(mappedBy="restaurant")
	@JsonIgnoreProperties("restaurant")
	private List<Reserva> reservas;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public List<Reserva> getReservas() {
		return reservas;
	}
	public void setReserva(List<Reserva> reservas) {
		this.reservas = reservas;
	}
}
