package com.taxiexpress.ris.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Placilo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private float znesek;
	//status, vrsta, datum, opomba

	public Long getId() {
		return id;
	}

	public float getZnesek() {
		return znesek;
	}

	public void setZnesek(float znesek) {
		this.znesek = znesek;
	}

	public void setId(Long id) {
		this.id = id;
	}
}