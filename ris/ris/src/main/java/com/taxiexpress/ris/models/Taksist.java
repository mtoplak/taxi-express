package com.taxiexpress.ris.models;

import java.util.ArrayList;

public class Taksist {
	private String email;
	private double zasluzek;
	private int prevoziSkupaj;
	public TaksiSluzba taksiSluzba;
	public ArrayList<Taksi> taksi = new ArrayList<Taksi>();
	public ArrayList<Prevoz> prevoz = new ArrayList<Prevoz>();

	public Taksist() {
		throw new UnsupportedOperationException();
	}

	private Prevoz zacniPrevoz(Prevoz prevoz) {
		throw new UnsupportedOperationException();
	}

	private Prevoz koncajPrevoz(Prevoz prevoz) {
		throw new UnsupportedOperationException();
	}

	private Prevoz potrdiPrevoz(Prevoz prevoz) {
		throw new UnsupportedOperationException();
	}

	private Prevoz zavrniPrevoz(Prevoz prevoz) {
		throw new UnsupportedOperationException();
	}
}