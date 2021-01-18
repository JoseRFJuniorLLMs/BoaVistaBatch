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
    public Job jobBill() {
        return jobBuilderFactory.get("jobBill")
                .incrementer(new RunIdIncrementer())
                .listener(new ListenerBill(bill))
                .flow(step4()).end().build();
    }

    @Bean
    public Step step4() {
        return stepBuilderFactory.get("step4").<Bill, Bill>chunk(2)
                .reader(ReaderBill.reader("bill_of_materials.csv"))
                .processor(new ProcessorBill())
                .writer(new WriterBill(bill))
                .build();
    }

}
