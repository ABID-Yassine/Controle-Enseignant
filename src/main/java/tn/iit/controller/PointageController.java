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

import tn.iit.dao.PointageDAO;
import tn.iit.entity.Pointage;
import tn.iit.entity.Salle;

@Controller
@RequestMapping("api/pointage")
public class PointageController {

	@Autowired
	private PointageDAO pointagedao;

	@GetMapping
	@ResponseBody
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
	@ResponseBody
	public Pointage showdetail(@PathVariable Integer id) {
		return pointagedao.findOne(id);
	}

}
