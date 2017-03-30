package com.web.dlxt.service;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.web.dlxt.entities.User;
import com.web.dlxt.util.HibernateUtil;

public class UserDAO implements IUserDAO {
	private Session session = null;
	private Transaction transaction = null;
	@Override
	public void save(User user) {
		session = HibernateUtil.getSession();
		try {
			transaction = session.beginTransaction();
			session.save(user);
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
	public void delete(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public User findByUid(String uid) {
		User user = null;
		try {
			session = HibernateUtil.getSession();
			String hql = "from User where uid='" + uid + "'";
			Query query = session.createQuery(hql);
			user = (User) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
		}
		return user;
	}

	@Override
	public void update(User user) {
		session = HibernateUtil.getSession();
		try {
			transaction = session.beginTransaction();
			session.merge(user);
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

}
