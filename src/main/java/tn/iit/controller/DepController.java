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

import tn.iit.dao.DepDAO;
import tn.iit.entity.Dep;

@Controller
@RequestMapping("api/dep")
@CrossOrigin(origins = "*", maxAge=0)
public class DepController {
	
	@Autowired
	private DepDAO depdao;

	@GetMapping
	@ResponseBody
	public List<Dep> list() {
		return depdao.findAll();

	}

	@PostMapping
	public String add(@RequestBody Dep dep) {
		String result;
		if (dep.getId() == null) {
			result = " insere";
		} else {
			result = " modifie";
		}
		depdao.saveAndFlush(dep);
		return dep + result;
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable Integer id) {
		Dep d = depdao.findOne(id);
		depdao.delete(id);
		return d + "supprime";

	}


}
