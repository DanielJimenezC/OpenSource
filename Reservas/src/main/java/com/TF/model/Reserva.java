package com.TF.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="reservas")
public class Reserva {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@NotNull(message="No puede ser Nulo")
	@Min(1)
	private int cantidad;
	@NotNull @FutureOrPresent
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fecha;	
	
	@ManyToOne
	@JsonIgnoreProperties("reservas")
	private MedioPago medio;
	
	@ManyToOne
	@JsonIgnoreProperties("reservas")
	private Restaurant restaurant;
	
	@ManyToOne
	@JsonIgnoreProperties("reservas")
	private Tipo tipo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public MedioPago getMedio() {
		return medio;
	}
	public void setMedio(MedioPago medio) {
		this.medio = medio;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
}
