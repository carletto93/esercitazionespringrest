package net.tinvention.webcrud.spring.service.contatto;

import java.util.List;

import net.tinvention.webcrud.spring.model.contatto.Contatto;

public interface ContattoManager {

	List<Contatto> getContatti();

	int aggiungiContatto(Contatto contatto);

	int editContatto(Contatto contatto);

	int eliminaContatto(String email);

	Contatto getContatto(int id);

	List<Contatto> ordinaContatti();

	int saveOrUpdate(Contatto contatto);

	String getEmailContatto(int id);
}
