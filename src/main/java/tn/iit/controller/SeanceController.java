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

import tn.iit.dao.SeanceDAO;
import tn.iit.entity.Seances;

@Controller
@RequestMapping("api/seance")
@CrossOrigin(origins = "*", maxAge=0)
public class SeanceController {

	@Autowired
	private SeanceDAO seancedao;

	@GetMapping
	@ResponseBody
	public List<Seances> list() {
		return seancedao.findAll();

	}

	@PostMapping
	public String add(@RequestBody Seances seance) {
		String result;
		if (seance.getId() == null) {
			result = " insere";
		} else {
			result = " modifie";
		}
		seancedao.saveAndFlush(seance);
		return seance + result;
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable Integer id) {
		Seances s = seancedao.findOne(id);
		seancedao.delete(id);
		return s + "supprime";

	}

}
