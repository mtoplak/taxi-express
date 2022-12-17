package com.taxiexpress.ris.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Taksi {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	private String model;
	private String registrskaStevilka;
	private int maxSteviloPotnikov;

	@ManyToOne
	@JoinColumn(name = "taksist_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	public Taksist taksist;

	@ManyToOne
	@JoinColumn(name = "sluzba_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	public TaksiSluzba taksiSluzba;
	public Znamka znamka;

	public Taksi() {
		//throw new UnsupportedOperationException();
	}

	public Taksi(Long id, String model, String registrskaStevilka, int maxSteviloPotnikov, Taksist taksist, TaksiSluzba taksiSluzba, Znamka znamka){
		this.id=id;
		this.model = model;
		this.registrskaStevilka = registrskaStevilka;
		this.maxSteviloPotnikov = maxSteviloPotnikov;
		this.taksist=taksist;
		this.taksiSluzba=taksiSluzba;
		this.znamka=znamka;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean trenutniStatus() {
		throw new UnsupportedOperationException();
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getRegistrskaStevilka() {
		return registrskaStevilka;
	}

	public void setRegistrskaStevilka(String registrskaStevilka) {
		this.registrskaStevilka = registrskaStevilka;
	}

	public int getMaxSteviloPotnikov() {
		return maxSteviloPotnikov;
	}

	public void setMaxSteviloPotnikov(int maxSteviloPotnikov) {
		this.maxSteviloPotnikov = maxSteviloPotnikov;
	}

	public Taksist getTaksist() {
		return taksist;
	}

	public void setTaksist(Taksist taksist) {
		this.taksist = taksist;
	}

	public TaksiSluzba getTaksiSluzba() {
		return taksiSluzba;
	}

	public void setTaksiSluzba(TaksiSluzba taksiSluzba) {
		this.taksiSluzba = taksiSluzba;
	}

	public Znamka getZnamka() {
		return znamka;
	}

	public void setZnamka(Znamka znamka) {
		this.znamka = znamka;
	}
}