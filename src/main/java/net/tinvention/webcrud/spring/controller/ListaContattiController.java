package net.tinvention.webcrud.spring.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.tinvention.webcrud.spring.model.contatto.Contatto;
import net.tinvention.webcrud.spring.service.contatto.ContattoManager;

@Controller
public class ListaContattiController {

	private final Logger log = Logger.getLogger(ListaContattiController.class);

	@Autowired
	private ContattoManager contattoManager;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("contatto", new Contatto());
		return "listaContatti";
	}

	@RequestMapping(value = "/contatti", produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	public ResponseEntity<List<Contatto>> mostraContatti() throws Exception {
		List<Contatto> contatti = contattoManager.getContatti();
		log.info("Viene mostrato l'elenco dei contatti");
		return new ResponseEntity<List<Contatto>>(contatti, HttpStatus.OK);
	}

	@RequestMapping(value = "/contattiordinati", produces = {
			MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	public ResponseEntity<List<Contatto>> mostraContattiOrdinati() throws Exception {
		List<Contatto> contattiOrdinati = contattoManager.ordinaContatti();
		log.info("Mostro elenco dei contatti ordinato");
		return new ResponseEntity<List<Contatto>>(contattiOrdinati, HttpStatus.OK);
	}

	@RequestMapping(value = "/elimina/{id}", method = RequestMethod.DELETE)
	public void eliminaContatto(@PathVariable Integer id) {
		String email = contattoManager.getEmailContatto(id);
		contattoManager.eliminaContatto(email);
		log.info("Eliminazione del contatto con id= " + id);
	}

	@RequestMapping(value = "/creaContatto", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public void creaContatto(@ModelAttribute Contatto contatto) {
		contattoManager.aggiungiContatto(contatto);
	}

	@RequestMapping(value="/creaContatto", method=RequestMethod.GET)
	public ResponseEntity<Contatto> creaContattoGet() {
		Contatto contatto= new Contatto();
		return new ResponseEntity<Contatto>(contatto, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<List<Contatto>> modificaContatto(Contatto contatto) throws Exception {
		log.info("Modifica del contatto con id: " + contatto.getId());
		contattoManager.saveOrUpdate(contatto);
		return mostraContatti();
	}

}