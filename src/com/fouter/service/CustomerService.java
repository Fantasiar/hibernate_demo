package com.fouter.service;

import java.util.List;

import com.fouter.domain.Customer;

public interface CustomerService {

	void save(Customer c);

	List<Customer> getAll();

}
