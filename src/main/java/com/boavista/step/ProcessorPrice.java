package com.boavista.step;

import com.boavista.model.PriceQuote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class ProcessorPrice implements ItemProcessor<PriceQuote, PriceQuote> {

    private static final Logger log = LoggerFactory.getLogger(ProcessorPrice.class);

    @Override
    public PriceQuote process(PriceQuote priceQuote) throws Exception {

        final Long id = priceQuote.getId();
        final String tubeassemblyid = priceQuote.getTubeassemblyid();
        final String supplier = priceQuote.getSupplier();
        final String quotedate = priceQuote.getQuotedate();
        final String annualusage = priceQuote.getAnnualusage();
        final String minorderquantity = priceQuote.getMinorderquantity();
        final String bracketpricing = priceQuote.getBracketpricing();
        final String quantity = priceQuote.getQuantity();
        final String cost = priceQuote.getCost();

        final PriceQuote fixedPriceQuote = new PriceQuote(id, tubeassemblyid, supplier, quotedate, annualusage, minorderquantity, bracketpricing, quantity, cost );

        log.info("Converting (" + priceQuote + ") into (" + fixedPriceQuote + ")");

        return fixedPriceQuote;
    }

}
