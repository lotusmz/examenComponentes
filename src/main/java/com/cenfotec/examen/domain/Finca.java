package com.cenfotec.examen.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Finca {
	private Long id;
	private String nombre;
	private Productor productor;
	private Set<Cafe> cafes;
	
	public Finca() {}
	
	public Finca(Long id) {
		this.id=id;
	}
	
	public Finca(String nombre) {
		this.nombre=nombre;
	}
	
	public Finca(String nombre, Productor productor) {
		this.nombre=nombre;
		this.productor=productor;
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
	@JoinColumn(name="prod_id")
	public Productor getProductor() {
		return productor;
	}

	public void setProductor(Productor productor) {
		this.productor = productor;
	}
	
	@OneToMany(mappedBy="finca", cascade=CascadeType.ALL)
	public Set<Cafe> getCafes() {
		return cafes;
	}
	
	public void setCafes(Set<Cafe> cafes) {
		this.cafes = cafes;
	}
}

