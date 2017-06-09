package org.mimba.bao.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.mimba.bao.entities.autres.Personne;

@Entity
public class Utilisateur implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Size(min = 5, max = 50)
	private String motDePasse;
	@NotNull
	private boolean activer;
	@NotNull
	private boolean presence;
	@NotNull
	@OneToOne(mappedBy="utilisateur")
	private Personne personne;
	@NotNull
	@ManyToOne
	@JoinColumn(name="idRolle")
//	@JoinTable(name="UTIL_ROLLE",
//	joinColumns= @JoinColumn(name="NUM_UTIL",unique=true),
//	inverseJoinColumns=@JoinColumn(name="NUM_ROLLE"))
	private Rolle rolle;
	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Utilisateur(String motDePasse, boolean activer, boolean presence, Personne personne) {
		super();
		this.motDePasse = motDePasse;
		this.activer = activer;
		this.presence = presence;
		this.personne = personne;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	public boolean isActiver() {
		return activer;
	}
	public void setActiver(boolean activer) {
		this.activer = activer;
	}
	public boolean isPresence() {
		return presence;
	}
	public void setPresence(boolean presence) {
		this.presence = presence;
	}
	public Personne getPersonne() {
		return personne;
	}
	public void setPersonne(Personne personne) {
		this.personne = personne;
	}
	public Rolle getRolle() {
		return rolle;
	}
	public void setRolle(Rolle rolle) {
		this.rolle = rolle;
	}

	
	
}


