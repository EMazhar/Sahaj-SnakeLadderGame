package com.sahaj.service;

import java.util.List;

import org.springframework.stereotype.Component;

/**
 * 
 * @author EHTESHAM MAZHAR
 *
 */
@Component
public class IGameTurnsStatsServiceImpl implements IGameTurnsStatsService{

	@Override
	public List<Integer> getLongestTurn() {
		return GameStats.turns;
	}
}
