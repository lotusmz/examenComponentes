package com.cenfotec.examen.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="productor")
public class Productor {
	private Long id;
	private String nombre;
	private String direccion;
	private String distrito;
	private String canton;
	private String provincia;
	private String cedula;
	private String empresa;
	private Set<Finca> fincas;
	
	public Productor() {}

	public Productor(String nombre, String direccion, String distrito, String canton, String provincia, String cedula,
			String empresa) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.distrito = distrito;
		this.canton = canton;
		this.provincia = provincia;
		this.cedula = cedula;
		this.empresa = empresa;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getCanton() {
		return canton;
	}

	public void setCanton(String canton) {
		this.canton = canton;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	@OneToMany(mappedBy="productor", cascade=CascadeType.ALL)
	public Set<Finca> getFincas() {
		return fincas;
	}

	public void setFincas(Set<Finca> fincas) {
		this.fincas = fincas;
	}

}

