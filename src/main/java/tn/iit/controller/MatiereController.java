package tn.iit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.iit.dao.MatiereDAO;
import tn.iit.entity.Matiere;

@RestController
@RequestMapping("api/matiere")
@CrossOrigin(origins = "*", maxAge=0)
public class MatiereController {

	@Autowired
	private MatiereDAO matdao;

	@GetMapping
	public List<Matiere> list() {
		return matdao.findAll();

	}

	@PostMapping
	public String add(@RequestBody Matiere mat) {
		String result;
		if (mat.getId() == null) {
			result = " insere";
		} else {
			result = " modifie";
		}
		matdao.saveAndFlush(mat);
		return mat + result;
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable Integer id) {
		Matiere m = matdao.findOne(id);
		matdao.delete(id);
		return m + "supprime";

	}

	@GetMapping("/{id}")
	public Matiere showdetail(@PathVariable Integer id) {
		return matdao.findOne(id);
	}
	
}
