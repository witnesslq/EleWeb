package com.web.dlxt.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.web.dlxt.entities.Recommend;
import com.web.dlxt.util.HibernateUtil;

public class RecommendDAO implements IRecommendDAO {
	private Session session = null;
	private Transaction transaction = null;
	@Override
	public void save(Recommend recommend) {

	}

	@Override
	public void delete(Recommend recommend) {

	}
	
	

	@Override
	public Recommend findByid(Integer id) {
		Recommend recommend = null;
		try {
			session = HibernateUtil.getSession();
			String hql = "from Recommend where id='" + id + "'";
			Query query = session.createQuery(hql);
			recommend = (Recommend) query.uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
		}
		return recommend;
	}

	@Override
	public void update(Recommend recommend) {

	}
	
	@Override
	public List<Recommend> findByUid(String uid) {
		List<Recommend> recommends = new ArrayList<Recommend>();
		try {
			session = HibernateUtil.getSession();
			String hql = "from Recommend where uid='" + uid + "'";
			Query query = session.createQuery(hql);
			recommends = query.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
		}
		
		return recommends;
	}

}
