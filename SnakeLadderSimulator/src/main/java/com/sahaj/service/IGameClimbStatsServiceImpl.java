package com.sahaj.service;

import org.springframework.stereotype.Component;

@Component
public class IGameClimbStatsServiceImpl implements IGameClimbStatsService {

	@Override
	public int getMaxClimb() {
		return GameStats.maxNumberClimb;
	}

	@Override
	public int getMinClimb() {
		return GameStats.minNumberClimb;
	}

}
