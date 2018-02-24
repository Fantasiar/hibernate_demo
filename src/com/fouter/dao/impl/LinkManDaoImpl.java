package com.fouter.dao.impl;

import org.hibernate.Session;

import com.fouter.dao.LinkManDao;
import com.fouter.domain.LinkMan;
import com.fouter.utils.HibernateUtils;

public class LinkManDaoImpl implements LinkManDao {

	@Override
	public void save(LinkMan lm) {
		// TODO Auto-generated method stub
		Session session=HibernateUtils.getCurrentSession();
		session.save(lm);
	}

}
