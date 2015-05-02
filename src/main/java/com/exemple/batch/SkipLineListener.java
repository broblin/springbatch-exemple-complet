package com.exemple.batch;

import java.util.Calendar;

import org.springframework.batch.core.annotation.OnSkipInProcess;
import org.springframework.batch.core.annotation.OnSkipInRead;
import org.springframework.batch.core.annotation.OnSkipInWrite;
import org.springframework.batch.item.file.FlatFileParseException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.exemple.beans.FunctionalException;
import com.exemple.beans.Livre;

/**
 * appelé en cas d'échec de lecture ou de transformation d'une ligne
 * @author benoit
 *
 */
public class SkipLineListener {
	private JdbcTemplate jdbcTemplate;
	
	private String origin;
    
    @OnSkipInRead
    public void logInRead(Throwable t) {
            if(t instanceof FlatFileParseException) {
                    FlatFileParseException ffpe = (FlatFileParseException) t;
                    jdbcTemplate.update(
                            "insert into lignes_en_erreur (ligne,numero_de_ligne,fichier,erreur_date) values (?,?,?,?)",
                            ffpe.getInput(),ffpe.getLineNumber(),origin,new java.sql.Date(Calendar.getInstance().getTime().getTime())
                    );
            }
    }
    
    @OnSkipInProcess
    public void logInProcess(Livre livre,Throwable t) {
    	if(t instanceof FunctionalException) {
    		FunctionalException f = (FunctionalException) t;
    		jdbcTemplate.update(
                    "insert into lignes_en_erreur (ligne,numero_de_ligne,fichier,erreur_date) values (?,?,?,?)",
                    t.getMessage(),f.getRowNumber(),origin,new java.sql.Date(Calendar.getInstance().getTime().getTime())
            );
    	}
    	//TODO DataAccessException
    }
    
    @OnSkipInWrite
    public void logInWrite(Livre livre,Throwable t){
    	//TODO erreur lors de l'écriture en base d'un nouveau livre
    }

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}
    
}
