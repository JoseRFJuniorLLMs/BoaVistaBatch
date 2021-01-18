package com.boavista.dao;

import com.boavista.model.Bill;

import java.util.List;

public interface BillDao {
    public void insert(List<? extends Bill> bills);
    List<Bill> loadAllBill();
}
