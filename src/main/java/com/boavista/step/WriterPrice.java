package com.boavista.step;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import com.boavista.dao.PriceQuoteDao;
import com.boavista.model.PriceQuote;

public class WriterPrice implements ItemWriter<PriceQuote> {

    private final PriceQuoteDao priceQuoteDao;

    public WriterPrice(PriceQuoteDao priceQuoteDao) {
        this.priceQuoteDao = priceQuoteDao;
    }

    @Override
    public void write(List<? extends PriceQuote> priceQuotes) throws Exception {
        priceQuoteDao.insert(priceQuotes);
    }

}
