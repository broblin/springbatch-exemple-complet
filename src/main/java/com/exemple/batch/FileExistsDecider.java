package com.exemple.batch;

import java.io.File;
import java.net.URL;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.job.flow.FlowExecutionStatus;
import org.springframework.batch.core.job.flow.JobExecutionDecider;

public class FileExistsDecider implements JobExecutionDecider {
	
	String filePath;

	@Override
	public FlowExecutionStatus decide(JobExecution jobExecution, StepExecution stepExecution) {
		//possibilité de récupérer les paramètres :
		//on aurait pu tester en plus si le fichier est de type texte ...
		String targetFile = jobExecution.getJobParameters().getString(filePath);
		URL fileUrl = this.getClass().getClassLoader().getResource(targetFile);
		File inputFile = new File(fileUrl.getPath());
		if(inputFile.exists()){
			return new FlowExecutionStatus("FILE EXISTS");
		}else{
			return new FlowExecutionStatus("NO FILE");
		}
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	

}
