package com.web.dlxt.service;

import com.web.dlxt.entities.User;

public interface IUserDAO {
	
	public void save(User user);
	
	public void delete(User user);
	
	public User findByUid(String uid);
	
	public void update(User user);
}
