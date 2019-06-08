package com.ecodeup.model;

import java.sql.Timestamp;
import java.util.Date;

public class Producto {

	private int id;
	private String nombre;
	private int cantidad;
	private double precio;
	private String fechaCrear;
	private String fechaActualizar;
	
	public Producto(int id, String nombre, int cantidad, double precio, String fechaCrear, String fechaActualizar) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio;
		this.fechaCrear = fechaCrear;
		this.fechaActualizar = fechaActualizar;
	}

	
	
	public Producto() {

	}



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



	public int getCantidad() {
		return cantidad;
	}



	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}



	public double getPrecio() {
		return precio;
	}



	public void setPrecio(double precio) {
		this.precio = precio;
	}



	public String getFechaCrear() {
		return fechaCrear;
	}



	public void setFechaCrear(String fechaCrear) {
		this.fechaCrear = fechaCrear;
	}



	public String getFechaActualizar() {
		return fechaActualizar;
	}



	public void setFechaActualizar(String fechaActualizar) {
		this.fechaActualizar = fechaActualizar;
	}



	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", cantidad=" + cantidad + ", precio=" + precio
				+ ", fechaCrear=" + fechaCrear + ", fechaActualizar=" + fechaActualizar + "]";
	}
	

	
	
}
