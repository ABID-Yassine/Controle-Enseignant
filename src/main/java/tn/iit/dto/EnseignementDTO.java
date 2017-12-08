package tn.iit.dto;

public class EnseignementDTO {

	private Integer id;
	private String nom;
	private Integer enseignant;
	private Integer matiere;

	public EnseignementDTO() {
	}

	public EnseignementDTO(Integer id, String nom, Integer enseignant, Integer matiere) {
		super();
		this.id = id;
		this.nom = nom;
		this.enseignant = enseignant;
		this.matiere = matiere;
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

}
