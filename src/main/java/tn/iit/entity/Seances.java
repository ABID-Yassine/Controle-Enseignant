package tn.iit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "seances")
public class Seances {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_seance")
	private Integer id;

	@Column(name = "nom_seance")
	private String nom;
	
	@Override
	public String toString() {
		return "Seances [id=" + id + ", nom=" + nom + ", duree=" + duree + "]";
	}

	@Column(name = "duree")
	private String duree;

	public Seances() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDuree() {
		return duree;
	}

	public void setDuree(String duree) {
		this.duree = duree;
	}


}
