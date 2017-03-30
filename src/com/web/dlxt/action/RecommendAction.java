package com.web.dlxt.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.web.dlxt.entities.Elect;
import com.web.dlxt.entities.Recommend;
import com.web.dlxt.service.ElectDAO;
import com.web.dlxt.service.RecommendDAO;

public class RecommendAction extends ActionSupport {

	private List<Elect> elects = new ArrayList<Elect>();
	private Elect elect;
	private Recommend recommend;

	public String recommendElect() {
		List<Recommend> recommends = null;
		HttpServletRequest request = init();
		String uid = request.getParameter("uid");
		if (!uid.equals("") && uid != null) {
			recommends = new RecommendDAO().findByUid(uid);
		}
		if (recommends == null || recommends.size() == 0)
			return ERROR;
		for (Recommend tempRec : recommends) {
			Elect ele = (Elect) new ElectDAO().findByUid(tempRec.getEid());
			elects.add(ele);
		}
		
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

	public Recommend getRecommend() {
		return recommend;
	}

	public void setRecommend(Recommend recommend) {
		this.recommend = recommend;
	}

	public List<Elect> getElects() {
		return elects;
	}

	public void setElects(List<Elect> elects) {
		this.elects = elects;
	}

}
