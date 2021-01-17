package com.boavista.step;

import com.boavista.dao.PriceQuoteDao;
import com.boavista.model.PriceQuote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;

import java.util.List;

public class ListenerPrice extends JobExecutionListenerSupport {
    private static final Logger log = LoggerFactory.getLogger(ListenerCustomer.class);

    private final PriceQuoteDao priceQuoteDao;
    public ListenerPrice(PriceQuoteDao priceQuoteDao){
        this.priceQuoteDao = priceQuoteDao;
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            log.info("Acabou o Job! Verifique Resultado");

            List<PriceQuote> priceQuotes = priceQuoteDao.loadAllPricesQuotes();

            for (PriceQuote priceQuote : priceQuotes) {
                log.info("FEITO <" + priceQuote + "> INSERIDO NO BANCO.");
            }
        }
    }
}
