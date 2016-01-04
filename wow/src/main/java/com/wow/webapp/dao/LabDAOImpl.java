package com.wow.webapp.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wow.webapp.entitymodel.Doctor;
import com.wow.webapp.entitymodel.LabType;

public class LabDAOImpl implements LabDAO{

	private SessionFactory sessionFactory;
	private static final Logger logger = LoggerFactory.getLogger(LabDAOImpl.class);

	public LabDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	@Transactional
	public void save(LabType labType) {
		Session session = this.getSession();
		session.saveOrUpdate(labType);
		
		
	}
}