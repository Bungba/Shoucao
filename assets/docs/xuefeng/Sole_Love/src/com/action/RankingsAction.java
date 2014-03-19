package com.action;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.model.Rankings;
import com.service.RankingsService;

@Controller
@Scope("prototype")
public class RankingsAction {

	@Resource
	RankingsService rankingsService;

	// ��������
	private String result;
	private String error;

	/**
	 * ʹ�����а�
	 * 
	 * @return
	 */
	public String findRankingInfo() {
		List<Rankings> list = rankingsService.findRankingInfo();
		JSONArray ja = JSONArray.fromObject(list);
		result = ja.toString();
		error = "{\"message\":\"�޴���\"}";
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
