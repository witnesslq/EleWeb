package com.web.dlxt.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.web.dlxt.entities.Elect;
import com.web.dlxt.service.ElectDAO;

public class ElectAction extends ActionSupport {
	private Elect elect;
	private String message;

	public String electLogin() {
		HttpServletRequest request = init();

		String uid = request.getParameter("uid");
		String pwd = request.getParameter("pwd");

		if (null != uid)
			elect = new ElectDAO().findByUid(uid);
		if (null != elect && elect.getPwd().equals(pwd))
			return SUCCESS;
		else
			return ERROR;
	}

	public String electAdd() throws IOException {
		HttpServletRequest request = init();
		String uid = request.getParameter("uid");
		Elect theElect = null;
		if (null != uid)
			theElect = new ElectDAO().findByUid(uid);
		if (theElect != null && !theElect.equals("")) {
			this.message = "unavailable uid!";
			return ERROR;
		} else {
			String pwd = request.getParameter("pwd");
			String cname = request.getParameter("cname");
			if (null != pwd && null != cname && !pwd.equals("") && !cname.equals("")) {
				theElect = new Elect();
				theElect.setCname(cname);
				theElect.setUid(uid);
				theElect.setPwd(pwd);

				new ElectDAO().save(theElect);
				System.out.println("电厂用户插入成功");
				this.message = "add success!";
				return SUCCESS;
			} else {
				this.message = "pwd or cname is null!";
				return ERROR;
			}
		}
	}

	public String getElectByEid() {
		HttpServletRequest request = init();
		String eid = request.getParameter("eid");
		if (null != eid) 
			elect = new ElectDAO().findByUid(eid);
		return SUCCESS;
	}
	
	private HttpServletRequest init() {
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		return request;
	}

	public Elect getElect() {
		return elect;
	}
	public void setElect(Elect elect) {
		this.elect = elect;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
