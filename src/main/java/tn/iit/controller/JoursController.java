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

import tn.iit.dao.JoursDAO;
import tn.iit.entity.Jours;

@Controller
@RequestMapping("api/jour")
@CrossOrigin(origins = "*", maxAge=0)
public class JoursController {

	@Autowired
	private JoursDAO jourdao;

	@GetMapping
	@ResponseBody
	public List<Jours> list() {
		return jourdao.findAll();

	}

	@PostMapping
	public String add(@RequestBody Jours jours) {
		String result;
		if ( jours.getId() == null) {
			result = " insere";
		} else {
			result = " modifie";
		}
		jourdao.saveAndFlush(jours);
		return jours + result;
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable Integer id) {
		Jours j = jourdao.findOne(id);
		jourdao.delete(id);
		return j  + "supprime";

	}


}
