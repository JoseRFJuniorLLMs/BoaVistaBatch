package com.boavista.step;

import com.boavista.dao.BillDao;
import com.boavista.model.Bill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;

import java.util.List;

public class ListenerBill extends JobExecutionListenerSupport {
    private static final Logger log = LoggerFactory.getLogger(ListenerBill.class);
    
    private final BillDao billDao;

    public ListenerBill(BillDao billDao) {
        this.billDao = billDao;
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            log.info("Acabou o Job! Verifique Resultado");

            List<Bill> bill = billDao.loadAllBill();

            for (Bill priceQuote : bill) {
                log.info("FEITO <" + priceQuote + "> INSERIDO NO BANCO.");
            }
        }
    }
    
}
