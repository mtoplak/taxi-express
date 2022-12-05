package com.taxiexpress.ris.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Prevoz {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	private LocalDateTime casNarocila;
	private String mestoVstopa;
	private String mestoIzstopa;
	private int kolicinaPrtljage;
	private int steviloPotnikov;
	private LocalDateTime casZacetka;
	private LocalDateTime casZakljucka;
	private float stKilometrov;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "uporabnik_id")
	public Uporabnik uporabnik;

	@OneToOne
	@JoinColumn(name = "taksist_id")
	public Taksist taksist;

	public Taksist getTaksist() {
		return taksist;
	}

	public void setTaksist(Taksist taksist) {
		this.taksist = taksist;
	}

	public Uporabnik getUporabnik() {
		return uporabnik;
	}

	public void setUporabnik(Uporabnik uporabnik) {
		this.uporabnik = uporabnik;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}
}