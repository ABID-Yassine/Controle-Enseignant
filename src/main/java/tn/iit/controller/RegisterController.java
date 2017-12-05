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
import tn.iit.dao.RegisterDAO;
import tn.iit.entity.Register;

@Controller
@RequestMapping("api/register")
public class RegisterController {

	@Autowired
	private RegisterDAO Registerdao;

	@GetMapping
	@ResponseBody
	public List<Register> list() {
		return Registerdao.findAll();
	}

	@PostMapping
	public String add(@RequestBody Register register) {
		String result;
		if (register.getEmail() == null) {
			result = " insere";
		} else {
			result = " modifie";
		}
		Registerdao.saveAndFlush(register);
		return register + result;
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable String email) {
		Register p = Registerdao.findOne(email);
		Registerdao.delete(email);
		return p + "supprime";
	}

}
