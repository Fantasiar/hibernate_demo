package com.fouter.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;

import com.fouter.dao.CustomerDao;
import com.fouter.dao.impl.CustomerDaoImpl;
import com.fouter.domain.Customer;
import com.fouter.service.CustomerService;
import com.fouter.utils.HibernateUtils;

public class CustomerServiceImpl implements CustomerService {

	private CustomerDao customerDao = new CustomerDaoImpl();

	@Override
	public void save(Customer c) {
		Session session=HibernateUtils.getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		
		try {
			customerDao.save(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();
		}
		
		tx.commit();
	}

	@Override
	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		Session session=HibernateUtils.getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		
		List<Customer> list=customerDao.getAll();
		
		tx.commit();
		
		return list;
	}

	@Override
	public List<Customer> getAll(DetachedCriteria dc) {
		// TODO Auto-generated method stub
		Session session=HibernateUtils.getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		
		List<Customer> list=customerDao.getAll(dc);
		
		tx.commit();
		
		return list;
	}

}
