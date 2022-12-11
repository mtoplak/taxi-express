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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean trenutniStatus() {
		throw new UnsupportedOperationException();
	}
}