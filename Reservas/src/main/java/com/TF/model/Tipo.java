package com.TF.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="tipos")
public class Tipo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value="Primary key de tipo")
	private int id;
	@NotBlank(message="El campo no puede estar en blanco")
	@Size(min=3, max=50, message="El campo no cumple con longitud")
	private String nombre;
	@NotBlank(message="El campo no puede estar en blanco")
	@Size(min=3, max=100, message="El campo no cumple con longitud")
	private String descripcion;
	
	@OneToMany(mappedBy="tipo")
	@JsonIgnoreProperties("tipo")
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public List<Reserva> getReservas() {
		return reservas;
	}
	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}
}
