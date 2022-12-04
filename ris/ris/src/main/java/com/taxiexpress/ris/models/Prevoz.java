package com.taxiexpress.ris.models;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Prevoz {
	private LocalDateTime casNarocila;
	private String mestoVstopa;
	private String mestoIzstopa;
	private int kolicinaPrtljage;
	private int steviloPotnikov;
	private LocalDateTime casZacetka;
	private LocalDateTime casZakljucka;
	private float stKilometrov;
	public Uporabnik uporabnik;
	public Taksist taksist;
}