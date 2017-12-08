package tn.iit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.iit.dao.RegisterDAO;
import tn.iit.entity.Register;

@RestController
@RequestMapping("api/register")
public class RegisterController {

	@Autowired
	private RegisterDAO registerdao;

	@GetMapping
	@ResponseBody
	public List<Register> list() {
		return registerdao.findAll();
	}

	@PostMapping
	public String add(@RequestBody Register register) {
		String result;
		if (register.getEmail() == null) {
			result = " insere";
		} else {
			result = " modifie";
		}
		registerdao.saveAndFlush(register);
		return register + result;
	}
	
	@GetMapping("/{email:.*}")
	public Register showdetail(@PathVariable String email) {
		return registerdao.findOne(email);
	}
	 
	@DeleteMapping("/{email:.*}")
	public String delete(@PathVariable String email) {
		Register p = registerdao.findOne(email);
		registerdao.delete(email);
		return p + "supprime";
	}

}
