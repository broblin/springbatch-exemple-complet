package com.exemple.batch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.exemple.beans.FunctionalException;
import com.exemple.beans.Livre;

/**
 * processor validant fonctionnellement une ligne
 * @author benoit
 *
 */
@Transactional (propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
public class LivreValidatorProcessor implements ItemProcessor<Livre, Livre> {
	
	private JdbcTemplate jdbcTemplate;
	
	//pas de concurence d'acces car il n'y a pas de parallelisation
	private static int nbRow = 0;

	@Override
	public Livre process(Livre livre) throws Exception {
		String sql = "SELECT COUNT(*) FROM AUTEUR WHERE PRENOM like ? AND NOM like ?";
		nbRow++;
		int count = jdbcTemplate.queryForInt(sql, new Object[]{livre.getPrenomAuteur(),livre.getNomAuteur()});
		if(count == 0){
			throw new FunctionalException(String.format("cet auteur %s %s n'est pas inscrit en base.",livre.getPrenomAuteur(),livre.getNomAuteur()),nbRow);
		}else if(livre.getPrix() < 0){
			throw new FunctionalException(String.format("le prix de ce livre %s ne peut être negatif", livre.getTitre()),nbRow);
		}
		return livre;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
