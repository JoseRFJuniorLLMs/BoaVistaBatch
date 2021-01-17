package com.boavista.config;

import com.boavista.step.ListenerCustomer;
import com.boavista.step.ProcessorCustomer;
import com.boavista.step.WriterCustomer;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.boavista.dao.CustomerDao;
import com.boavista.model.Customer;
import com.boavista.step.ReaderCustomer;

@Configuration
@EnableBatchProcessing
public class BatchConfigCustomer {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Autowired
	public CustomerDao customerDao;

	@Bean
	public Job jobCustomer() {
		return jobBuilderFactory.get("jobCustomer")
				.incrementer(new RunIdIncrementer())
				.listener(new ListenerCustomer(customerDao))
				.flow(step1()).end().build();
	}

	@Bean
	public Step step1() {
		return stepBuilderFactory.get("step1").<Customer, Customer>chunk(2)
				.reader(ReaderCustomer.reader("customer-data.csv"))
				.processor(new ProcessorCustomer())
				.writer(new WriterCustomer(customerDao))
				.build();
	}

}
