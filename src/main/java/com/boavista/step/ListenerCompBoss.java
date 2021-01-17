package com.boavista.step;

import com.boavista.dao.CompBossDao;
import com.boavista.model.CompBoss;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;

import java.util.List;

public class ListenerCompBoss extends JobExecutionListenerSupport {
    private static final Logger log = LoggerFactory.getLogger(ListenerCompBoss.class);

    private final CompBossDao compBossDao;
    public ListenerCompBoss(CompBossDao compBossDao){
        this.compBossDao = compBossDao;
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            log.info("Acabou o Job! Verifique Resultado");

            List<CompBoss> compBosses = compBossDao.loadAllCompBosses();

            for (CompBoss compBosse : compBosses) {
                log.info("FEITO <" + compBosse + "> INSERIDO NO BANCO.");
            }
        }
    }

}
