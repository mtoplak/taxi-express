package com.taxiexpress.ris.models;

import java.time.LocalDate;

public class KreditnaKartica extends Placilo {
	private int stevilkaKartice;
	private LocalDate datumPoteka;
	private int CVV;
	private String imetnik;
}