package tn.iit.dto;

public class EnseignementDTO {

	private Integer id;
	private String nom;
	private Integer enseignant;
	private Integer matiere;
	private Integer salle;
	private Integer seance;
	private Integer jours;
	private Integer departement;
	private Integer niveaux;
	
	
	public EnseignementDTO() {
	 
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
	public Integer getEnseignant() {
		return enseignant;
	}
	public void setEnseignant(Integer enseignant) {
		this.enseignant = enseignant;
	}
	public Integer getMatiere() {
		return matiere;
	}
	public void setMatiere(Integer matiere) {
		this.matiere = matiere;
	}
	public Integer getSalle() {
		return salle;
	}
	public void setSalle(Integer salle) {
		this.salle = salle;
	}
	public Integer getSeance() {
		return seance;
	}
	public void setSeance(Integer seance) {
		this.seance = seance;
	}
	public Integer getJours() {
		return jours;
	}
	public void setJours(Integer jours) {
		this.jours = jours;
	}
	public Integer getDepartement() {
		return departement;
	}
	public void setDepartement(Integer departement) {
		this.departement = departement;
	}
	public Integer getNiveaux() {
		return niveaux;
	}
	public void setNiveaux(Integer niveaux) {
		this.niveaux = niveaux;
	}

	 

}
