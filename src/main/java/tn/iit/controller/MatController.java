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

import tn.iit.dao.MatDAO;
import tn.iit.entity.Mat;
import tn.iit.entity.Pointage;

@Controller
@RequestMapping("api/mat")
public class MatController {

	@Autowired
	private MatDAO matdao;

	@GetMapping
	@ResponseBody
	public List<Mat> list() {
		return matdao.findAll();

	}

	@PostMapping
	public String add(@RequestBody Mat mat) {
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
		Mat m = matdao.findOne(id);
		matdao.delete(id);
		return m + "supprime";

	}

	@GetMapping("/{id}")
	@ResponseBody
	public Mat showdetail(@PathVariable Integer id) {
		return matdao.findOne(id);
	}
	
}
