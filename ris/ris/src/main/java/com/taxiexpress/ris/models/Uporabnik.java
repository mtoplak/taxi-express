package com.taxiexpress.ris.models;

import java.util.ArrayList;

public class Uporabnik {
	private String ime;
	private String priimek;
	private String email;
	private boolean jeAdmin;
	public ArrayList<Prevoz> prevoz = new ArrayList<Prevoz>();

	public Uporabnik() {
		throw new UnsupportedOperationException();
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