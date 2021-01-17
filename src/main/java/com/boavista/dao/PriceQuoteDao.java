package com.boavista.dao;

import com.boavista.model.PriceQuote;

import java.util.List;

public interface PriceQuoteDao {
    public void insert(List<? extends PriceQuote> priceQuotes);
    List<PriceQuote> loadAllPricesQuotes();
}
