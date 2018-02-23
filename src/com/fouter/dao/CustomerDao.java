package com.fouter.dao;

import java.util.List;

import com.fouter.domain.Customer;

public interface CustomerDao {

	void save(Customer c);

	List<Customer> getAll();

}
