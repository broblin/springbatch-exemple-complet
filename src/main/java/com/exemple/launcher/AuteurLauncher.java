package com.exemple.launcher;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AuteurLauncher {
	public static void main (String [] args) throws Exception {
		ClassPathXmlApplicationContext cpt = new ClassPathXmlApplicationContext("conf/batch-context.xml");
		cpt.start();
		JobLauncher jobLauncher = (JobLauncher) cpt.getBean("jobLauncher");
		Job job = (Job) cpt.getBean("importAuteurs");
		JobParameters parameter = new JobParametersBuilder()
			.addString("input.file", "input/auteurs.txt")
			.addString("input.file.livre", "input/livres.txt").toJobParameters();
		jobLauncher.run(job, parameter);
		cpt.close();
	}
}
