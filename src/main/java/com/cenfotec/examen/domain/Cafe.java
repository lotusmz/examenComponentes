package com.cenfotec.examen.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TCournal")
public class Cafe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

}
