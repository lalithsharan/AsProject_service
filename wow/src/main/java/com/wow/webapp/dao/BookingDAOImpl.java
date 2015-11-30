package com.wow.webapp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wow.webapp.entitymodel.Booking;
import com.wow.webapp.entitymodel.Clinic;
import com.wow.webapp.entitymodel.Doctor;
import com.wow.webapp.entitymodel.Slots;
import com.wow.webapp.entitymodel.User;

public class BookingDAOImpl implements BookingDAO {

	private SessionFactory sessionFactory;
	private static final Logger logger = LoggerFactory.getLogger(BookingDAOImpl.class);

	public BookingDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Transactional
	public Slots findSlot(Integer slot_id) {
		// TODO Auto-generated method stub
		System.out.println("enter into getSlots");
		Session session = this.getSession();
		
		System.out.println("before executing:::");
		List<Slots> slots = session.createQuery("from Slots s where s.id=?").setParameter(0, slot_id).list();
		return slots.get(0);
		
	}

	@Transactional
	public List<Booking> findBookings(Clinic clinic,Doctor doctor) {
		// TODO Auto-generated method stub
		System.out.println("enter into findBookings");
		Session session = this.getSession();
		
		List<Booking> bookings=session.createQuery("from Booking b where b.clinic=? and b.doctor=?").setParameter(0, clinic)
				.setParameter(1, doctor).list();
		
		return bookings;
	}

	@Transactional
	public void save(Booking b) {
		// TODO Auto-generated method stub
		System.out.println("enter into save bookings");
		Session session = this.getSession();
		session.persist(b);
		
		
	}
	@Transactional
	public List<Booking> findBookingsOnUserId(Integer userId) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		User user=new User(userId);
		List<Booking> bookings=session.createQuery("from User b where b.user=?").setParameter(0,user).list();
		
		return bookings;
	}
	

}
