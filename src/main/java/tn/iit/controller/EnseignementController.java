package tn.iit.controller;

import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.iit.config.EmailUtility;
import tn.iit.dao.DepDAO;
import tn.iit.dao.EnseignantDAO;
import tn.iit.dao.EnseignementDAO;
import tn.iit.dao.JoursDAO;
import tn.iit.dao.MatiereDAO;
import tn.iit.dao.NiveauxDAO;
import tn.iit.dao.SalleDAO;
import tn.iit.dao.SeanceDAO;
import tn.iit.dto.EnseignementDTO;
import tn.iit.entity.Enseignement;

@RestController
@RequestMapping("api/enseignement")
@CrossOrigin(origins = "*", maxAge=0)
public class EnseignementController {

	@Autowired
	private EnseignementDAO enseignementdao;
	@Autowired
	private EnseignantDAO enseignantdao;
	@Autowired
	private MatiereDAO matieredao;
	@Autowired
	private SalleDAO salledao;
	@Autowired
	private SeanceDAO seancedao;
	@Autowired
	private JoursDAO joursdao;
	@Autowired
	private DepDAO depdao;
	@Autowired
	private NiveauxDAO niveauxdao;
	
	@GetMapping
	public List<Enseignement> list() {
		return enseignementdao.findAll();
	}

	@PostMapping
	public String add(@RequestBody EnseignementDTO enseignementDTO) {
		String result;
		if (enseignementDTO.getId() == null) {
			result = " insere";
		} else {
			result = " modifie";
		}
		Enseignement ens = new Enseignement();
		ens.setMatiere(matieredao.findOne(enseignementDTO.getMatiere()));
		ens.setEnseignant(enseignantdao.findOne(enseignementDTO.getEnseignant()));
		ens.setSalle(salledao.findOne(enseignementDTO.getSalle()));
		ens.setSeances(seancedao.findOne(enseignementDTO.getSeance()));
		ens.setJours(joursdao.findOne(enseignementDTO.getJours()));
		ens.setDep(depdao.findOne(enseignementDTO.getDepartement()));
		ens.setNiveaux(niveauxdao.findOne(enseignementDTO.getNiveaux()));
		ens.setNom(enseignementDTO.getNom());
		ens.setId(enseignementDTO.getId());
		enseignementdao.saveAndFlush(ens);
		return ens + result;
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable Integer id) {
		Enseignement p = enseignementdao.findOne(id);
		enseignementdao.delete(id);
		return p + "supprime";
	}

	@GetMapping("/{id}")
	public Enseignement showdetail(@PathVariable Integer id) {
		return enseignementdao.findOne(id);
	}
	
	@GetMapping("/datetoday")
	public List<Enseignement> showdetail() {
		Date d = new Date(); 
		return enseignementdao.findByDate(d);
	}
	
	
	@GetMapping("/mail/{id}")
	public void sendMail(@PathVariable Integer id) {

		Enseignement ens = showdetail(id);
		String subject = "Avis de seance non effectuée";
		String userName = "rh.iit.sfax";
		String password = "rhiitsfax";
		String host = "smtp.gmail.com";
		String port = "587";

		String mailEns = ens.getEnseignant().getEmail();
		String nomEns = ens.getEnseignant().getNom();
		String nomGroupe = ens.getNiveaux().getNom();
		String message = "Bonjour Mr " + nomEns + " , la seance de " + ens.getSeances().getNom() + " le " + ens.getJours().getDate()
				+ " avec le groupe " + nomGroupe + " a été raté , veuillez planifier une seance de rattrappage ";

		try { 
			EmailUtility.sendEmail(host, port, userName, password, mailEns, subject, message);
			ens.setMailsend(true);
			enseignementdao.saveAndFlush(ens);
			} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
	
}
