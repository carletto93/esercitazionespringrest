package net.tinvention.webcrud.spring.service.contatto;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.tinvention.webcrud.spring.dao.contattodao.ContattoDao;
import net.tinvention.webcrud.spring.dao.contattodao.ContattoDaoImpl;
import net.tinvention.webcrud.spring.model.contatto.Contatto;

@Service
public class ContattoManagerImpl implements ContattoManager {

	private ContattoDao contattoDao;

	@Autowired
	public void setContattoDao(ContattoDaoImpl contattoDao) {
		this.contattoDao = contattoDao;
	}

	public ContattoDao getContattoDao() {
		return this.contattoDao;
	}

	public List<Contatto> getContatti() {
		return contattoDao.getContatti();
	}

	public int eliminaContatto(String email) {
		return contattoDao.eliminaContatto(email);
	}

	public String getEmailContatto(int id) {
		Contatto contatto = getContatto(id);
		return contatto.getEmail();
	}

	public Contatto getContatto(int id) {
		Contatto contatto;
		List<Contatto> listaContatti = getContatti();
		Iterator<Contatto> i = listaContatti.iterator();
		while (i.hasNext()) {
			contatto = i.next();
			if (contatto.getId() == id) {
				return contatto;
			}
		}
		return null;
	}

	public List<Contatto> ordinaContatti() {
		return contattoDao.ordinaContatti();
	}

	public int aggiungiContatto(Contatto contatto) {
		return contattoDao.aggiungiContatto(contatto);
	}

	public int editContatto(Contatto contatto) {
		return contattoDao.editContatto(contatto);
	}

	public int saveOrUpdate(Contatto contatto) {
		if (contatto.getId() != 0) {
			return editContatto(contatto);
		} else {
			return aggiungiContatto(contatto);
		}

	}
}
