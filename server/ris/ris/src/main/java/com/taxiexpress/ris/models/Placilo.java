package com.taxiexpress.ris.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Placilo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private float znesek;
	private String opomba;
	private String cas;
	private boolean status; //true, če je že plačano; false če še ni
	//status, vrsta

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

	public String getOpomba() {
		return opomba;
	}

	public void setOpomba(String opomba) {
		this.opomba = opomba;
	}

	public String getCas() {
		return cas;
	}

	public void setCas(String cas) {
		this.cas = cas;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}