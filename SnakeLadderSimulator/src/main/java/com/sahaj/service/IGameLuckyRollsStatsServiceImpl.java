package com.sahaj.service;

/**
 * 
 * @author EHTESHAM MAZHAR
 *
 */
public class IGameLuckyRollsStatsServiceImpl implements IGameLuckyRollsStatsService {

	@Override
	public int getLuckyRolls() {
		return GameStats.luckyRoll;
	}

	@Override
	public int getunLuckyRolls() {
		return GameStats.unluckyRoll;
	}

}
