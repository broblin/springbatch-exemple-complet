package com.exemple.batch;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.annotation.AfterJob;

/**
 * de même un BeforeJob existe
 * on peut parametrer le meme genre de listener entre chque etape (step)
 * @author benoit
 *
 */
public class JobExecutionStatusListener {
	
	@AfterJob
	public void executeAfterJob(JobExecution jobExecution){
		//on logue le resultat
		//TODO on pourrait sauver l'echec en base voir envoyer un mail à l'administrateur
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            System.out.println("Job completed: " + jobExecution.getJobInstance().getJobName());
        } else if (jobExecution.getStatus() == BatchStatus.FAILED) {
            System.out.println("Job failed: " + jobExecution.getJobInstance().getJobName() + " "
                    + jobExecution.getFailureExceptions());
        }
	}
}
