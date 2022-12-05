package com.taxiexpress.ris.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.time.LocalDate;

@Entity
public class TaksiSluzba {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	public String naziv;
	private LocalDate zacetekIzvajanja;

	@OneToMany (mappedBy = "taksiSluzba", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public ArrayList<Taksist> taksist = new ArrayList<Taksist>();

	@OneToMany (mappedBy = "taksiSluzba", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public ArrayList<Taksi> taksi = new ArrayList<Taksi>();

	public TaksiSluzba() {
		//throw new UnsupportedOperationException();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


}