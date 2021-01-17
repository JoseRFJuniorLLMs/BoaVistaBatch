package com.boavista.step;

import com.boavista.model.PriceQuote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import java.time.LocalDate;
import java.util.Random;

public class ProcessorPrice implements ItemProcessor<PriceQuote, PriceQuote> {

    private static final Logger log = LoggerFactory.getLogger(ProcessorPrice.class);

    @Override
    public PriceQuote process(PriceQuote priceQuote) throws Exception {
        Random r = new Random();

        final String tubeassemblyid = priceQuote.getTubeassemblyid();
        final String supplier = priceQuote.getSupplier();
        final LocalDate quotedate = priceQuote.getQuotedate();
        final String annualusage = priceQuote.getAnnualusage();
        final String minorderquantity = priceQuote.getMinorderquantity();
        final String bracketpricing = priceQuote.getBracketpricing();
        final String quantity = priceQuote.getQuantity();
        final String cost = priceQuote.getCost();

        final PriceQuote fixedPriceQuote = new PriceQuote(tubeassemblyid, supplier, quotedate, annualusage, minorderquantity, bracketpricing, quantity, cost );

        log.info("Converting (" + priceQuote + ") into (" + fixedPriceQuote + ")");

        return fixedPriceQuote;
    }

}
