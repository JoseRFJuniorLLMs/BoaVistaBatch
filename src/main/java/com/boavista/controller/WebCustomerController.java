package com.boavista.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebCustomerController {

	@Autowired
	JobLauncher jobLauncherCustomer;

	@Autowired
	JobLauncher jobLauncherPrice;

	@Qualifier("jobCustomer")
	@Autowired
	Job jobCustomer;

	@Qualifier("jobPrice")
	@Autowired
	Job jobPrice;

	@RequestMapping("/JobCustomer")
	public String handle() throws Exception {
		Logger logger = LoggerFactory.getLogger(this.getClass());
		try {
			//Executa Costumer
			JobParameters jobParametersCostumer = new JobParametersBuilder()
					.addLong("time", System.currentTimeMillis())
					.toJobParameters();
			jobLauncherCustomer.run(jobCustomer, jobParametersCostumer);

			//Executa Price
			JobParameters jobParametersPrice = new JobParametersBuilder()
					.addLong("time", System.currentTimeMillis())
					.toJobParameters();
			jobLauncherPrice.run(jobPrice, jobParametersPrice);

		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "Feito verifique o Console";
	}
}
