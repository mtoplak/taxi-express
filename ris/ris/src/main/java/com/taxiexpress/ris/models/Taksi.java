package com.taxiexpress.ris.models;

public class Taksi {
	private String model;
	private String registrskaStevilka;
	private int maxSteviloPotnikov;
	public Taksist taksist;
	public TaksiSluzba taksiSluzba;
	public Znamka znamka;

	public Taksi() {
		throw new UnsupportedOperationException();
	}

	public boolean trenutniStatus() {
		throw new UnsupportedOperationException();
	}
}