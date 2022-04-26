package com.sahaj.service;

import java.util.Map;

import com.sahaj.model.Player;

/**
 * 
 * @author EHTESHAM MAZHAR
 *
 */
public class ISnakeImpl implements ISnake {

	@Override
	public int getNewPosition(int position, Map<Integer, Integer> snakes, Map<Integer, Integer> laders, Player player) {
		int slide = 0;
		int climb = 0;
		while (true) {
			if (snakes.keySet().contains(position)) {
				slide = slide + position - snakes.get(position);
				if (GameStats.minSlide == 0)
					GameStats.minSlide = slide;
				else
					GameStats.minSlide = GameStats.minSlide > slide ? slide : GameStats.minSlide;
				GameStats.maxSlide = GameStats.maxSlide < slide ? slide : GameStats.maxSlide;
				GameStats.unluckyRoll+=1;
				position = snakes.get(position);
			} else if (laders.keySet().contains(position)) {
				climb = climb + laders.get(position) - position;
				if (GameStats.minNumberClimb == 0)
					GameStats.minNumberClimb = climb;
				else
					GameStats.minNumberClimb = GameStats.minNumberClimb > climb ? climb : GameStats.minNumberClimb;
				GameStats.maxNumberClimb = GameStats.maxNumberClimb < climb ? climb : GameStats.maxNumberClimb;
				if(snakes.keySet().contains(position+1) || snakes.keySet().contains(position+2) 
						||snakes.keySet().contains(position-1) || snakes.keySet().contains(position-2))
					GameStats.luckyRoll+=1;
					
				GameStats.luckyRoll+=1;
				position = laders.get(position);
			} else {
				return position;
			}
		}

	}
}
