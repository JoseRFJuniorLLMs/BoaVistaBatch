package com.boavista.config;

import com.boavista.dao.CompBossDao;
import com.boavista.model.CompBoss;
import com.boavista.step.ListenerCompBoss;
import com.boavista.step.ProcessorCompBoss;
import com.boavista.step.ReaderCompBoss;
import com.boavista.step.WriterCompBoss;
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
public class BatchConfigCompBoss {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    public CompBossDao compBossDao;

    @Bean
    public Job jobCompBoss() {
        return jobBuilderFactory.get("jobComBoss")
                .incrementer(new RunIdIncrementer())
                .listener(new ListenerCompBoss(compBossDao))
                .flow(step3()).end().build();
    }

    @Bean
    public Step step3() {
        return stepBuilderFactory.get("step3").<CompBoss, CompBoss>chunk(2)
                .reader(ReaderCompBoss.reader("comp_boss.csv"))
                .processor(new ProcessorCompBoss())
                .writer(new WriterCompBoss(compBossDao))
                .build();
    }

}
