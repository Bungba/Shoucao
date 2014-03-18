package com.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.service.RankingsService;

@Controller
@Scope("prototype")
public class RankingsAction {

	@Resource
	RankingsService rankingsService;

	/**
	 *  π’ﬂ≈≈––∞Ò
	 * 
	 * @return
	 */
	public String findRankingInfo() {
		 rankingsService.findRankingInfo();
		return "success";
	}



	public RankingsService getRankingsService() {
		return rankingsService;
	}

	public void setRankingsService(RankingsService rankingsService) {
		this.rankingsService = rankingsService;
	}
}
