package com.fouter.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static final Configuration CONFIGURATION;
	private static final SessionFactory SESSION_FACTORY;
	
	static {
		CONFIGURATION=new Configuration().configure();
		SESSION_FACTORY=CONFIGURATION.buildSessionFactory();
	}

	public static Session openSession() {
		// TODO Auto-generated method stub
		return SESSION_FACTORY.openSession();
	}
	
	public static Session getCurrentSession() {
		return SESSION_FACTORY.getCurrentSession();
	}
}
