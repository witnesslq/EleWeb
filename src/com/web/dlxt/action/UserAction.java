package com.web.dlxt.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.web.dlxt.entities.User;
import com.web.dlxt.service.ElectDAO;
import com.web.dlxt.service.UserDAO;

public class UserAction extends ActionSupport {
	
	private User user;
	private String message;
	
	public String userLogin() {
		HttpServletRequest request = init();

		String uid = request.getParameter("uid");
		String pwd = request.getParameter("pwd");
		
		if (null != uid) 
			user = new UserDAO().findByUid(uid);
		if (null != user && user.getPwd().equals(pwd))
			return SUCCESS;
		else
			return ERROR;
	}
	
	public String userAdd() { // 注册用户
		HttpServletRequest request = init();
		String uid = request.getParameter("uid");
		User theUser = null;
		if (null != uid)
			theUser = new UserDAO().findByUid(uid);
		if (theUser != null) {
			this.message = "unavailable uid!";
			return ERROR;
		} else {
			String pwd = request.getParameter("pwd");
			if (null != pwd && !pwd.equals("")) {
				theUser = new User();
				theUser.setPwd(pwd);
				theUser.setUid(uid);
				new UserDAO().save(theUser);
				System.out.println("用户插入成功");
				this.message = "add success!";
				return SUCCESS;
			} else {
				this.message = "pwd is null!";
				return ERROR;
			}
		}
	}
	
	/**
	 * 用户发布需求信息
	 * @return
	 */
	public String releaseRequire() {
		HttpServletRequest request = init();
		String uid = request.getParameter("uid");
		String requireQuan = request.getParameter("requirequan");
		float thisrequirequan = Float.parseFloat(requireQuan);
		User theUser = null;
		if (null != uid )
			theUser = new UserDAO().findByUid(uid);
		if (theUser != null) {
			theUser.setThisrequirequan(thisrequirequan);
			new UserDAO().update(theUser);
			System.out.println("需求信息发布成功");
			this.message = "release success!";
			return SUCCESS;
		} else {
			this.message = "no this user!";
			return ERROR;
		}
	}
	
	
	private HttpServletRequest init() {
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		return request;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
