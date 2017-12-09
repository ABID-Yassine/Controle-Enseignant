package tn.iit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.iit.dao.EnseignantDAO;
import tn.iit.dao.EnseignementDAO;
import tn.iit.dao.MatiereDAO;
import tn.iit.dto.EnseignementDTO;
import tn.iit.entity.Enseignement;

@RestController
@RequestMapping("api/enseignement")
public class EnseignementController {

	@Autowired
	private EnseignementDAO enseignementdao;
	@Autowired
	private EnseignantDAO enseignantdao;
	@Autowired
	private MatiereDAO matieredao;

	@GetMapping
	public List<Enseignement> list() {
		return enseignementdao.findAll();
	}

	@PostMapping
	public String add(@RequestBody EnseignementDTO enseignementDTO) {
		String result;
		if (enseignementDTO.getId() == null) {
			result = " insere";
		} else {
			result = " modifie";
		}
		Enseignement ens = new Enseignement();
		ens.setMatiere(matieredao.findOne(enseignementDTO.getMatiere()));;
		ens.setEnseignant(enseignantdao.findOne(enseignementDTO.getEnseignant()));
		ens.setNom(enseignementDTO.getNom());
		ens.setId(enseignementDTO.getId());
		enseignementdao.saveAndFlush(ens);
		return ens + result;
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable Integer id) {
		Enseignement p = enseignementdao.findOne(id);
		enseignementdao.delete(id);
		return p + "supprime";
	}

	@GetMapping("/{id}")
	public Enseignement showdetail(@PathVariable Integer id) {
		return enseignementdao.findOne(id);
	}
}
