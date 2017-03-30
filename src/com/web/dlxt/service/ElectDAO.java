package com.web.dlxt.service;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.web.dlxt.entities.Elect;
import com.web.dlxt.entities.User;
import com.web.dlxt.util.HibernateUtil;

public class ElectDAO implements IElectDAO {
	private Session session = null;
	private Transaction transaction = null;
	@Override
	public void save(Elect elect) {
		session = HibernateUtil.getSession();
		try {
			transaction = session.beginTransaction();
			session.save(elect);
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (null != transaction) {
				transaction.rollback();
				throw e;
			}
		} finally {
			if (null != session) {
				session.close();
			}
		}
	}

	@Override
	public void delete(Elect elect) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Elect findByUid(String uid) {
		Elect elect = null;
		try {
			session = HibernateUtil.getSession();
			String hql = "from Elect where uid='" + uid + "'";
			Query query = session.createQuery(hql);
			elect = (Elect) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
		}
		return elect;
	}

	@Override
	public void update(Elect elect) {
		// TODO Auto-generated method stub
		
	}
	
}
