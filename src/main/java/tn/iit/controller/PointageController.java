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

import tn.iit.dao.PointageDAO;
import tn.iit.entity.Pointage;

@Controller
@RequestMapping("api/pointage")
@CrossOrigin(origins = "*", maxAge=0)
public class PointageController {

	@Autowired
	private PointageDAO pointagedao;

	@GetMapping
	public List<Pointage> list() {
		return pointagedao.findAll();
	}

	@PostMapping
	public String add(@RequestBody Pointage pointage) {
		String result;
		if (pointage.getId() == null) {
			result = " insere";
		} else {
			result = " modifie";
		}
		pointagedao.saveAndFlush(pointage);
		return pointage + result;
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable Integer id) {
		Pointage p = pointagedao.findOne(id);
		pointagedao.delete(id);
		return p + "supprime";
	}
	
	@GetMapping("/{id}")
	public Pointage showdetail(@PathVariable Integer id) {
		return pointagedao.findOne(id);
	}

}
