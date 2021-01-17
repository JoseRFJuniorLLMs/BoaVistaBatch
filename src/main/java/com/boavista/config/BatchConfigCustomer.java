package com.boavista.config;

import com.boavista.dao.PriceQuoteDao;
import com.boavista.step.Listener;
import com.boavista.step.Processor;
import com.boavista.step.Writer;
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
import com.boavista.step.Reader;

@Configuration
@EnableBatchProcessing
public class BatchConfigCustomer {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Autowired
	public CustomerDao customerDao;

	@Autowired
	public PriceQuoteDao priceQuoteDao;

	@Bean
	public Job jobCustomer() {
		return jobBuilderFactory.get("jobCustomer").incrementer(new RunIdIncrementer()).listener(new Listener(customerDao))
				.flow(step1()).end().build();
	}

/*	@Bean
	public Job jobPrice() {
		return jobBuilderFactory.get("jobPrice").incrementer(new RunIdIncrementer()).listener(new Listener(priceQuoteDao))
				.flow(step2()).end().build();
	}*/

	@Bean
	public Step step1() {
		return stepBuilderFactory.get("step1").<Customer, Customer>chunk(2)
				.reader(Reader.reader("customer-data.csv"))
				.processor(new Processor()).writer(new Writer(customerDao)).build();
	}

/*	@Bean
	public Step step2() {
		return stepBuilderFactory.get("step2").<Customer, Customer>chunk(2)
				.reader(Reader.reader("price_quote.csv"))
				.processor(new Processor()).writer(new Writer(priceQuoteDao)).build();
	}*/
}
