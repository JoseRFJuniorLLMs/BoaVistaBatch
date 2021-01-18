package com.boavista.step;

import com.boavista.model.Bill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class ProcessorBill implements ItemProcessor<Bill, Bill> {

    private static final Logger log = LoggerFactory.getLogger(Bill.class);

    @Override
    public Bill process(Bill bill) throws Exception {

        final Long id = bill.getId();
        final String tubeassemblyid = bill.getTubeassemblyid();
        final String componentid1 = bill.getComponentid1();
        final String quantity1 = bill.getQuantity1();
        final String componentid2 = bill.getComponentid2();
        final String quantity2 = bill.getQuantity2();
        final String componentid3 = bill.getComponentid3();
        final String quantity3 = bill.getQuantity3();
        final String componentid4 = bill.getComponentid4();
        final String quantity4 = bill.getQuantity4();
        final String componentid5 = bill.getComponentid5();
        final String quantity5 = bill.getQuantity5();
        final String componentid6 = bill.getComponentid6();
        final String quantity6 = bill.getQuantity6();
        final String componentid7 = bill.getComponentid7();
        final String quantity7 = bill.getQuantity7();
        final String componentid8 = bill.getComponentid1();
        final String quantity8 = bill.getQuantity8();

        final Bill fixedBill = new Bill(id,tubeassemblyid, componentid1, quantity1, componentid2, quantity2, componentid3, quantity3, componentid4, quantity4, componentid5, quantity5, componentid6, quantity6, componentid7, quantity7, componentid8, quantity8 );

        log.info("Converting (" + bill + ") into (" + fixedBill + ")");

        return fixedBill;
    }
}
