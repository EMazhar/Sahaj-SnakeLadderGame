package com.sahaj.service;

import java.util.Map;

import com.sahaj.model.Player;

/**
 * 
 * @author EHTESHAM MAZHAR
 *
 */
public interface ISnake {
	/**
	 * 
	 * @param newPosition
	 * @return
	 */
	int getNewPosition(int position, Map<Integer, Integer> snakes, Map<Integer, Integer> laders, Player player);

}
