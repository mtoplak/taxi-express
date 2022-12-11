package com.taxiexpress.ris.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class TaksiSluzba {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	public String naziv;
	private LocalDate zacetekIzvajanja;

	@OneToMany (mappedBy = "taksiSluzba", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	//public List<Taksist> taksist = new List<Taksist>();
	public List<Taksist> taksist;


	@OneToMany (mappedBy = "taksiSluzba", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	//public ArrayList<Taksi> taksi = new ArrayList<Taksi>();
	public List<Taksi> taksi;


	public TaksiSluzba() {
		//throw new UnsupportedOperationException();
	}

	public TaksiSluzba(String naziv, LocalDate zacetekIzvajanja){
		this.naziv = naziv;
		this.zacetekIzvajanja = zacetekIzvajanja;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public LocalDate getZacetekIzvajanja() {
		return zacetekIzvajanja;
	}

	public void setZacetekIzvajanja(LocalDate zacetekIzvajanja) {
		this.zacetekIzvajanja = zacetekIzvajanja;
	}

	public List<Taksist> getTaksist() {
		return taksist;
	}

	public void setTaksist(List<Taksist> taksist) {
		this.taksist = taksist;
	}

	public List<Taksi> getTaksi() {
		return taksi;
	}

	public void setTaksi(List<Taksi> taksi) {
		this.taksi = taksi;
	}
}