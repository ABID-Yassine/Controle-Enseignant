package tn.iit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tn.iit.dao.EnseignantDAO;
import tn.iit.entity.Enseignant;
import tn.iit.entity.Register;

@Controller
@RequestMapping("api/enseignant")
public class EnseignantController {

	@Autowired
	private EnseignantDAO enseignantdao;

	@GetMapping
	@ResponseBody
	public List<Enseignant> list() {
		return enseignantdao.findAll();
	}

	@PostMapping
	public String add(@RequestBody Enseignant enseignant) {
		String result;
		if (enseignant.getId() == null) {
			result = " insere";
		} else {
			result = " modifie";
		}
		enseignantdao.saveAndFlush(enseignant);
		return enseignant + result;
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public Enseignant showdetail(@PathVariable Integer id) {
		return enseignantdao.findOne(id);
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable Integer id) {
		Enseignant p = enseignantdao.findOne(id);
		enseignantdao.delete(id);
		return p + "supprime";
	}

}
