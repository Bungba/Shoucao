package com.action;

import java.util.List;

import javax.annotation.Resource;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.model.Rankings;
import com.model.Users;
import com.service.RankingsService;

@Controller
@Scope("prototype")
public class RankingsAction {

	@Resource
	RankingsService rankingsService;

	// 返回数据
	private String result;
	private String error;

	/**
	 * 使者排行榜
	 * 
	 * @return
	 */
	public String findRankingInfo() {
		List<Rankings> list = rankingsService.findRankingInfo();
		Users u = (Users) ServletActionContext.getRequest().getSession()
				.getAttribute("User");
		JSONArray ja = JSONArray.fromObject(list);
		StringBuffer sb=new StringBuffer();
		sb.append(ja.toString());
		result=sb.toString();
		
		return "success";
	}
	
	public String findUserRank() {
		List<Rankings> list = rankingsService.findRankingInfo();
		Users u = (Users) ServletActionContext.getRequest().getSession()
				.getAttribute("User");
		
		
		if(u!=null){
			for (int i = 0; i < list.size(); i++) {
				if (u.getNickname().equals(list.get(i).getName())) {
					result = "[{\"name\":\""+u.getNickname()+"\"},{\"message\":\""+(i+1)+"\"}]";
				}
			}
		}
		
		
		return "success";
	}
	
	public RankingsService getRankingsService() {
		return rankingsService;
	}

	public void setRankingsService(RankingsService rankingsService) {
		this.rankingsService = rankingsService;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
}
