package net.tinvention.webcrud.spring.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import net.tinvention.webcrud.spring.model.contatto.Contatto;

public class ContattoMapper implements RowMapper {

	public Contatto mapRow(ResultSet rs, int rowNum) throws SQLException {
		Contatto contatto = new Contatto();
		contatto.setId(rs.getInt("id"));
		contatto.setNome(rs.getString("nome"));
		contatto.setCognome(rs.getString("cognome"));
		contatto.setEmail(rs.getString("email"));
		contatto.setDataDiNascita(rs.getDate("datadinascita"));
		return contatto;
	}

}