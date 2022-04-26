package com.sahaj.service;

import java.util.ArrayList;
import java.util.List;

import com.sahaj.model.Dice;

/**
 * 
 * @author EHTESHAM MAZHAR
 *
 */
public class DiceServiceImpl implements DiceService{

	@Override
	public int rollDice(Dice dice) {
		int val=0;
		List<Integer> tempTurns=new ArrayList<>();
		while(true) {
    		int roll=dice.roll();
    		tempTurns.add(roll);
    		val=val+roll;
    		if (roll!=6) {
    			break;
    		}
    	}
        
        if(tempTurns.size()>GameStats.turns.size()) {
        	GameStats.turns=tempTurns;
        }else if(tempTurns.size()==GameStats.turns.size()) {
        	if(tempTurns.get(tempTurns.size()-1)>GameStats.turns.get(GameStats.turns.size()-1)) {
        		GameStats.turns=tempTurns;
        	}
        }
        return val;
	}

}
