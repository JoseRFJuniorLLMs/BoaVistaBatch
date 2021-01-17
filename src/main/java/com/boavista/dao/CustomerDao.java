package com.boavista.dao;

import java.util.List;

import com.boavista.model.Customer;

public interface CustomerDao {
	public void insert(List<? extends Customer> customers);
	List<Customer> loadAllCustomers();
}
