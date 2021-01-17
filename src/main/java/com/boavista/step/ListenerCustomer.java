package com.boavista.step;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;

import com.boavista.dao.CustomerDao;
import com.boavista.model.Customer;

public class ListenerCustomer extends JobExecutionListenerSupport {
	private static final Logger log = LoggerFactory.getLogger(ListenerCustomer.class);

	private final CustomerDao customerDao;

	public ListenerCustomer(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
			log.info("Acabou o Job! Verifique Resultado");

			List<Customer> customers = customerDao.loadAllCustomers();

			for (Customer customer : customers) {
				log.info("FEITO <" + customer + "> INSERIDO NO BANCO.");
			}
		}
	}
}
