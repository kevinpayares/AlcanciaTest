package com.AlcanciaTest.demo.modelo;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name="alcancia")
public class Alcancia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	private int Moneda;
	
	public Alcancia() {
	
	}

	public Alcancia(int id, int moneda) {
		super();
		Id = id;
		Moneda = moneda;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getMoneda() {
		return Moneda;
	}

	public void setMoneda(int moneda) {
		Moneda = moneda;
	}	
	
}
