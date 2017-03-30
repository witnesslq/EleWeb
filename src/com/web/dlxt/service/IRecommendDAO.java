package com.web.dlxt.service;

import java.util.List;

import com.web.dlxt.entities.Recommend;

public interface IRecommendDAO {
	public void save(Recommend recommend);

	public void delete(Recommend recommend);

	public Recommend findByid(Integer id);

	public void update(Recommend recommend);
	
	public List<Recommend> findByUid(String uid);
}
