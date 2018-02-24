package com.fouter.service.impl;

import java.lang.invoke.LambdaConversionException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fouter.dao.CustomerDao;
import com.fouter.dao.LinkManDao;
import com.fouter.dao.impl.CustomerDaoImpl;
import com.fouter.dao.impl.LinkManDaoImpl;
import com.fouter.domain.Customer;
import com.fouter.domain.LinkMan;
import com.fouter.service.LinkManService;
import com.fouter.utils.HibernateUtils;
import com.sun.xml.internal.ws.util.xml.CDATA;

public class LinkManServiceImpl implements LinkManService {

	private CustomerDao cd=new CustomerDaoImpl();
	private LinkManDao lmd=new LinkManDaoImpl();
	
	
	@Override
	public void save(LinkMan lm) {
		// TODO Auto-generated method stub
		HibernateUtils.getCurrentSession().beginTransaction();
		
		try {
			Long cust_id=lm.getCust_id();
			Customer c=cd.getById(cust_id);
			lm.setCustomer(c);
			lmd.save(lm);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			HibernateUtils.getCurrentSession().getTransaction().rollback();
		}
		
		HibernateUtils.getCurrentSession().getTransaction().commit();
	}

}
