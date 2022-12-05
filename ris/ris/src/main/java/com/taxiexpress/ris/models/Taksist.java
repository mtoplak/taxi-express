package com.taxiexpress.ris.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;

@Entity
public class Taksist {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String email;
	private double zasluzek;
	private int prevoziSkupaj;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sluzba_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	public TaksiSluzba taksiSluzba;

	@OneToMany (mappedBy = "taksist", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public ArrayList<Taksi> taksi = new ArrayList<Taksi>();

	@OneToMany (mappedBy = "taksist", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public ArrayList<Prevoz> prevoz = new ArrayList<Prevoz>();

	public Taksist() {
		//throw new UnsupportedOperationException();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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