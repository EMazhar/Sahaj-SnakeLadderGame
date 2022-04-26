package com.sahaj.service;

import org.springframework.stereotype.Component;

/**
 * 
 * @author EHTESHAM MAZHAR
 *
 */
@Component
public class IGameSlideStatsServiceImpl implements IGameSlideStatsService {

	@Override
	public int getMaxSlide() {
		
		return GameStats.maxSlide;
	}

	@Override
	public int getMinSlide() {
		return GameStats.minSlide;
	}

}
