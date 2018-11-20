package com.cenfotec.examen.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TProductor")
public class Productor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="direccion")
	private String direccion;
	
	@Column(name="distrito")
	private String distrito;
	
	@Column(name="canton")
	private String canton;
	
	@Column(name="provincia")
	private String provincia;
	
	@Column(name="cedula")
	private String cedula;
	
	@Column(name="empresa")
	private String empresa;
}
