package com.fouter.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fouter.dao.CustomerDao;
import com.fouter.domain.Customer;
import com.fouter.utils.HibernateUtils;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public void save(Customer c) {
		// TODO Auto-generated method stub
		Session session=HibernateUtils.getCurrentSession();
		
		session.save(c);
	}

	@Override
	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		Session session=HibernateUtils.getCurrentSession();
		
		Criteria criteria=session.createCriteria(Customer.class);
		
		return criteria.list();
	}

}
