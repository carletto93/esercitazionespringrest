package dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import configtest.WebAppConfigTest;
import net.tinvention.webcrud.spring.dao.contattodao.ContattoDao;
import net.tinvention.webcrud.spring.model.contatto.Contatto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { WebAppConfigTest.class }, loader = AnnotationConfigContextLoader.class)
public class TestContattoDao {

	@Autowired
	private ContattoDao contattoDao;
	
	@Test
	public void testAggiungiContatto() throws ParseException {
		Contatto contattoTest = new Contatto();
		contattoTest.setNome("nomeTest");
		contattoTest.setCognome("cognomeTest");
		contattoTest.setEmail("emailTest");
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
		contattoTest.setDataDiNascita(dateFormatter.parse("1990-09-09"));
		assertEquals(1, contattoDao.aggiungiContatto(contattoTest));
	}
	
	@Test
	public void testEditContatto() throws ParseException {
		Contatto contattoTest = new Contatto();
		contattoTest.setNome("carlo");
		contattoTest.setCognome("cassano");
		contattoTest.setEmail("ciao@pippo.com");
		contattoTest.setId(1);
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
		contattoTest.setDataDiNascita(dateFormatter.parse("1993-05-02"));
		assertEquals(1, contattoDao.editContatto(contattoTest));
	}
	
	@Test
	public void testEliminaContatto() {
		assertEquals(1, contattoDao.eliminaContatto("emailTest"));

	}
	
	@Test
	public void testGetContatti() {
		assertNotNull(contattoDao.getContatti());
	}

}
