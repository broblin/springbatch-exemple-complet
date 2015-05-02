package com.exemple.batch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.exemple.beans.Livre;

/**
 * 
 * @author benoit
 *
 */
@Transactional (propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
public class LivreProcessor  implements ItemProcessor<Livre, Livre> {
	
	private JdbcTemplate jdbcTemplate;

	@Override
	public Livre process(Livre livre) throws Exception {
		String sql = "SELECT ID FROM AUTEUR WHERE PRENOM like ? AND NOM like ?";

		int auteurId = jdbcTemplate.queryForInt(sql, new Object[]{livre.getPrenomAuteur(),livre.getNomAuteur()});
		livre.setAuteurId(auteurId);
		return livre;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	

}
