package com.boavista.config;

import com.boavista.dao.BillDao;
import com.boavista.model.Bill;
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
public class BatchConfigBill {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    public BillDao bill;

    @Bean
    public Job jobPrice() {
        return jobBuilderFactory.get("jobPrice")
                .incrementer(new RunIdIncrementer())
                .listener(new ListenerBill(bill))
                .flow(step1()).end().build();
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1").<Bill, Bill>chunk(2)
                .reader(ReaderBill.reader("bill_off_materials.csv"))
                .processor(new ProcessorBill())
                .writer(new WriterBill(bill))
                .build();
    }

}
