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

import tn.iit.dao.EnseignementDAO;
import tn.iit.entity.Enseignement;
import tn.iit.entity.Mat;

@Controller
@RequestMapping("api/enseignement")
public class EnseignementController {

	@Autowired
	private EnseignementDAO enseignementdao;

	@GetMapping
	@ResponseBody
	public List<Enseignement> list() {
		return enseignementdao.findAll();
	}

	@PostMapping
	public String add(@RequestBody Enseignement enseignement) {
		String result;
		if (enseignement.getId() == null) {
			result = " insere";
		} else {
			result = " modifie";
		}
		enseignementdao.saveAndFlush(enseignement);
		return enseignement + result;
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable Integer id) {
		Enseignement p = enseignementdao.findOne(id);
		enseignementdao.delete(id);
		return p + "supprime";
	}

	@GetMapping("/{id}")
	@ResponseBody
	public Enseignement showdetail(@PathVariable Integer id) {
		return enseignementdao.findOne(id);
	}
}
