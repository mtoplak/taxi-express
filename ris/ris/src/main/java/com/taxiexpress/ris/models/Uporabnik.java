package com.taxiexpress.ris.models;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
public class Uporabnik {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String ime;
	private String priimek;
	private String email;
	private boolean jeAdmin;

	@OneToMany (mappedBy = "uporabnik", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public ArrayList<Prevoz> prevoz = new ArrayList<Prevoz>();

	public Uporabnik() {
		//throw new UnsupportedOperationException();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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