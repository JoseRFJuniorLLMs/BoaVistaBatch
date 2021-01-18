package com.boavista.step;

import com.boavista.dao.BillDao;
import com.boavista.model.Bill;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class WriterBill implements ItemWriter<Bill> {

    private final BillDao billDao;

    public WriterBill(BillDao billDao) {
        this.billDao = billDao;
    }

    @Override
    public void write(List<? extends Bill> bills) throws Exception {
        billDao.insert(bills);
    }
}
