package tn.iit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tn.iit.dao.NiveauxDAO;
import tn.iit.entity.Niveaux;

@Controller
@RequestMapping("api/pointage")
@CrossOrigin(origins = "*", maxAge=0)
public class NiveauxController {

	
	@Autowired
	private NiveauxDAO niveauxdao;

	@GetMapping
	@ResponseBody
	public List<Niveaux> list() {
		return niveauxdao.findAll();

	}

	@PostMapping
	public String add(@RequestBody Niveaux niveaux) {
		String result;
		if (niveaux.getId() == null) {
			result = " insere";
		} else {
			result = " modifie";
		}
		niveauxdao.saveAndFlush(niveaux);
		return niveaux + result;
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable Integer id) {
		Niveaux n = niveauxdao.findOne(id);
		niveauxdao.delete(id);
		return n + "supprime";

	}

}
