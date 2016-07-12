package net.tinvention.webcrud.spring.dao.contattodao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import net.tinvention.webcrud.spring.model.contatto.Contatto;
import net.tinvention.webcrud.spring.util.ContattoMapper;

@Repository
public class ContattoDaoImpl implements ContattoDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void init(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}

	public int aggiungiContatto(Contatto contatto) {
		return jdbcTemplate.update("insert into contatti (nome, cognome, email, datadinascita) values (?,?,?,?)",
				contatto.getNome(), contatto.getCognome(), contatto.getEmail(), contatto.getDataDiNascita());
	}

	public List<Contatto> ordinaContatti() {
		return this.jdbcTemplate.query("select * from contatti order by datadinascita DESC, id ASC",
				new ContattoMapper());

	}

	public List<Contatto> getContatti() {
		return this.jdbcTemplate.query("select * from contatti", new ContattoMapper());
	}

	public int editContatto(Contatto contatto) {
		return jdbcTemplate.update("update contatti set nome=?, cognome=?, email=?, datadinascita=? where id=?",
				contatto.getNome(), contatto.getCognome(), contatto.getEmail(), contatto.getDataDiNascita(),
				contatto.getId());
	}

	public int eliminaContatto(String email) {
		return jdbcTemplate.update("delete from contatti where email=?", email);

	}

}