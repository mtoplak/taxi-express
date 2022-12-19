package com.taxiexpress.ris.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Uporabnik {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String ime;
	private String priimek;
	private String email;
	private boolean jeAdmin;
	private String geslo;


	@OneToMany (mappedBy = "uporabnik", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public List<Prevoz> prevoz;

	public Uporabnik() {
		//throw new UnsupportedOperationException();
	}
	public Uporabnik(String ime, String priimek, String email, boolean jeAdmin, Prevoz prevoz) {
		//throw new UnsupportedOperationException();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPriimek() {
		return priimek;
	}

	public void setPriimek(String priimek) {
		this.priimek = priimek;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isJeAdmin() {
		return jeAdmin;
	}

	public void setJeAdmin(boolean jeAdmin) {
		this.jeAdmin = jeAdmin;
	}

	public List<Prevoz> getPrevoz() {
		return prevoz;
	}

	public void setPrevoz(List<Prevoz> prevoz) {
		this.prevoz = prevoz;
	}

	private void naroci() {
		throw new UnsupportedOperationException();
	}

	private float placaj(Prevoz prevoz) {
		throw new UnsupportedOperationException();
	}

	private void oceniPrevoz(int ocena, String komentar, Prevoz prevoz) {
		throw new UnsupportedOperationException();
	}

	private void slediTaksiju(Prevoz prevoz) {
		throw new UnsupportedOperationException();
	}

	public String getGeslo() {
		return geslo;
	}

	public void setGeslo(String geslo) {
		this.geslo = geslo;
	}

	private boolean prijava(String email, String geslo) {
		throw new UnsupportedOperationException();
	}

	private boolean registracija(String email, String geslo, String gesloPotrdi) {
		throw new UnsupportedOperationException();
	}

	private void urediProfil(Object atributZaSpremembo, String novaVrednost) {
		throw new UnsupportedOperationException();
	}
}