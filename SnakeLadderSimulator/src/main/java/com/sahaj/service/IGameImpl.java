package com.sahaj.service;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.Queue;

import com.sahaj.model.Board;
import com.sahaj.model.Dice;
import com.sahaj.model.Player;

/**
 * 
 * @author EHTESHAM MAZHAR
 *
 */
public class IGameImpl implements IGame{
	private int numberOfSnakes;
    private int numberOfLadders;
    private Queue<Player> players;
    private Map<Integer,Integer> snakes;
    private Map<Integer,Integer> laders;

    private Board board;
    private Dice dice;
    public IGameImpl() {}
    
    
	public IGameImpl( Map<Integer, Integer> snakes,
			Map<Integer, Integer> laders,int boardSize) {
		
		players = new ArrayDeque<>();
		this.snakes = snakes;
		this.laders = laders;
		board = new Board(boardSize);
		dice = new Dice(1, 6, 2);
	}

	public void addPlayer(Player player) {
        players.add(player);
    }

	public int getNumberOfSnakes() {
		return numberOfSnakes;
	}
	public void setNumberOfSnakes(int numberOfSnakes) {
		this.numberOfSnakes = numberOfSnakes;
	}
	public int getNumberOfLadders() {
		return numberOfLadders;
	}
	public void setNumberOfLadders(int numberOfLadders) {
		this.numberOfLadders = numberOfLadders;
	}
	public Queue<Player> getPlayers() {
		return players;
	}
	public void setPlayers(Queue<Player> players) {
		this.players = players;
	}
	public Map<Integer, Integer> getSnakes() {
		return snakes;
	}
	public void setSnakes(Map<Integer, Integer> snakes) {
		this.snakes = snakes;
	}
	public Map<Integer, Integer> getLaders() {
		return laders;
	}
	public void setLaders(Map<Integer, Integer> laders) {
		this.laders = laders;
	}
	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
	}
	public Dice getDice() {
		return dice;
	}
	public void setDice(Dice dice) {
		this.dice = dice;
	}

    
}
