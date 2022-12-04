package com.taxiexpress.ris.models;

import java.util.ArrayList;
import java.time.LocalDate;

public class TaksiSluzba {
	public String naziv;
	private LocalDate zacetekIzvajanja;
	public ArrayList<Taksist> taksist = new ArrayList<Taksist>();
	public ArrayList<Taksi> taksi = new ArrayList<Taksi>();

	public TaksiSluzba() {
		throw new UnsupportedOperationException();
	}
}