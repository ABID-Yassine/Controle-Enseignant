package tn.iit.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "mat")
public class Matiere implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COD_matiere")
	private Integer id;

	@Column(name = "abv")
	private String abv;
	
	@Column(name = "Nom_matiere")
	private String Nom_matiere;

	@Column(name = "nom_salle")
	private String nom_salle; 

	@OneToMany(fetch = FetchType.EAGER,  mappedBy="enseignant")
	private List<Enseignement> enseignement;
	
	public Matiere() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAbv() {
		return abv;
	}

	public void setAbv(String abv) {
		this.abv = abv;
	}

	public String getNom_matiere() {
		return Nom_matiere;
	}

	public void setNom_matiere(String nom_matiere) {
		Nom_matiere = nom_matiere;
	}

	public String getNom_salle() {
		return nom_salle;
	}

	public void setNom_salle(String nom_salle) {
		this.nom_salle = nom_salle;
	}

	@Override
	public String toString() {
		return "Mat [id=" + id + ", abv=" + abv + ", Nom_matiere=" + Nom_matiere + ", nom_salle=" + nom_salle + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Matiere other = (Matiere) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
 
	
	
	 

}
