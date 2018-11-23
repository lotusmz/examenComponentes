package com.cenfotec.examen.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class Cafe {
	private Long id;
	private String nombre;
	private Finca finca;
	
	public Cafe() {}
	
	public Cafe(String nombre) {
		this.nombre=nombre;
	}
	
	public Cafe(String nombre, Finca finca) {
		this.nombre=nombre;
		this.finca=finca;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@ManyToOne
	@JoinColumn(name="finca_id")
	public Finca getFinca() {
		return finca;
	}
	
	public void setFinca(Finca finca) {
		this.finca=finca;
	}
}
