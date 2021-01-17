package com.boavista.config;

import com.boavista.dao.PriceQuoteDao;
import com.boavista.model.PriceQuote;
import com.boavista.step.*;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchConfigPriceQuote {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    public PriceQuoteDao priceQuoteDao;


  	@Bean
	public Job jobPrice() {
		return jobBuilderFactory.get("jobPrice")
				.incrementer(new RunIdIncrementer())
				.listener(new ListenerPrice(priceQuoteDao))
				.flow(step2()).end().build();
	}

	@Bean
	public Step step2() {
		return stepBuilderFactory.get("step2").<PriceQuote, PriceQuote>chunk(2)
				.reader(ReaderPrice.reader("price_quote.csv"))
				.processor(new ProcessorPrice())
				.writer(new WriterPrice(priceQuoteDao))
				.build();
	}

}
