package com.web.dlxt.service;

import com.web.dlxt.entities.Elect;

public interface IElectDAO {
	public void save(Elect elect);
	
	public void delete(Elect elect);
	
	public Elect findByUid(String uid);
	
	public void update(Elect elect);
}
