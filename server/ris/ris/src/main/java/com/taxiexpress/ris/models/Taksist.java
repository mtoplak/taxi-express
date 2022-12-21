package com.taxiexpress.ris.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
public class Taksist {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String ime;
	private String Priimek;
	private String email;
	private double zasluzek;
	private int prevoziSkupaj;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sluzba_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	public TaksiSluzba taksiSluzba;

	@OneToMany (mappedBy = "taksist", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public List<Taksi> taksi;

	@OneToMany (mappedBy = "taksist", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public List<Prevoz> prevoz;

	public Taksist() {
		//throw new UnsupportedOperationException();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getZasluzek() {
		return zasluzek;
	}

	public void setZasluzek(double zasluzek) {
		this.zasluzek = zasluzek;
	}

	public int getPrevoziSkupaj() {
		return prevoziSkupaj;
	}

	public void setPrevoziSkupaj(int prevoziSkupaj) {
		this.prevoziSkupaj = prevoziSkupaj;
	}

	public TaksiSluzba getTaksiSluzba() {
		return taksiSluzba;
	}

	public void setTaksiSluzba(TaksiSluzba taksiSluzba) {
		this.taksiSluzba = taksiSluzba;
	}

	public List<Taksi> getTaksi() {
		return taksi;
	}

	public void setTaksi(List<Taksi> taksi) {
		this.taksi = taksi;
	}

	public List<Prevoz> getPrevoz() {
		return prevoz;
	}

	public void setPrevoz(List<Prevoz> prevoz) {
		this.prevoz = prevoz;
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
		return Priimek;
	}

	public void setPriimek(String priimek) {
		Priimek = priimek;
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