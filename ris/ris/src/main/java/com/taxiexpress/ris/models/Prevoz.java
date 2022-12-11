package com.taxiexpress.ris.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Prevoz {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	@JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss a")
	private LocalDateTime casNarocila;
	private String mestoVstopa;
	private String mestoIzstopa;
	private int kolicinaPrtljage;
	private int steviloPotnikov;
	@JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss a")
	private LocalDateTime casZacetka;
	@JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss a")
	private LocalDateTime casZakljucka;
	private float stKilometrov;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "uporabnik_id")
	public Uporabnik uporabnik;

	@OneToOne
	@JoinColumn(name = "taksist_id")
	public Taksist taksist;

	public Prevoz() {
		//throw new UnsupportedOperationException();
	}
	public Prevoz(LocalDateTime casNarocila, String mestoVstopa, String mestoIzstopa, int kolicinaPrtljage, int steviloPotnikov, LocalDateTime casZacetka, LocalDateTime casZakljucka, float stKilometrov) {
		//throw new UnsupportedOperationException();
	}

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

	public LocalDateTime getCasNarocila() {
		return casNarocila;
	}

	public void setCasNarocila(LocalDateTime casNarocila) {
		this.casNarocila = casNarocila;
	}

	public String getMestoVstopa() {
		return mestoVstopa;
	}

	public void setMestoVstopa(String mestoVstopa) {
		this.mestoVstopa = mestoVstopa;
	}

	public String getMestoIzstopa() {
		return mestoIzstopa;
	}

	public void setMestoIzstopa(String mestoIzstopa) {
		this.mestoIzstopa = mestoIzstopa;
	}

	public int getKolicinaPrtljage() {
		return kolicinaPrtljage;
	}

	public void setKolicinaPrtljage(int kolicinaPrtljage) {
		this.kolicinaPrtljage = kolicinaPrtljage;
	}

	public int getSteviloPotnikov() {
		return steviloPotnikov;
	}

	public void setSteviloPotnikov(int steviloPotnikov) {
		this.steviloPotnikov = steviloPotnikov;
	}

	public LocalDateTime getCasZacetka() {
		return casZacetka;
	}

	public void setCasZacetka(LocalDateTime casZacetka) {
		this.casZacetka = casZacetka;
	}

	public LocalDateTime getCasZakljucka() {
		return casZakljucka;
	}

	public void setCasZakljucka(LocalDateTime casZakljucka) {
		this.casZakljucka = casZakljucka;
	}

	public float getStKilometrov() {
		return stKilometrov;
	}

	public void setStKilometrov(float stKilometrov) {
		this.stKilometrov = stKilometrov;
	}
}