package org.mimba.bao.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Rolle implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Size(min = 3, max = 50)
	private String nom;
	@ElementCollection
	private Collection<String> droit;
	@NotNull
	@Size(min = 5, max = 50)
	private String description;
	@OneToMany(mappedBy="rolle")
	private Collection<Utilisateur> utilisateur;
	public Rolle() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Rolle(String nom, Collection<String> droit, String description) {
		super();
		this.nom = nom;
		this.droit = droit;
		this.description = description;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Collection<String> getDroit() {
		return droit;
	}
	public void setDroit(Collection<String> droit) {
		this.droit = droit;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Collection<Utilisateur> getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Collection<Utilisateur> utilisateur) {
		this.utilisateur = utilisateur;
	}

	
}
