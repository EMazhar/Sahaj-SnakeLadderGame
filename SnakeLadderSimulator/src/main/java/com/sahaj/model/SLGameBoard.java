package com.sahaj.model;

import java.util.List;

public class SLGameBoard {

	private int boarSize;
    private List<Snake> snakes; // The board also contains some snakes and ladders.
    private List<Ladder> ladders;
    
    
    public SLGameBoard() {}
    
    
	public SLGameBoard(int boarSize, List<Snake> snakes, List<Ladder> ladders) {
		
		this.boarSize = boarSize;
		this.snakes = snakes;
		this.ladders = ladders;
	}
	public int getBoarSize() {
		return boarSize;
	}
	public void setBoarSize(int boarSize) {
		this.boarSize = boarSize;
	}
	public List<Snake> getSnakes() {
		return snakes;
	}
	public void setSnakes(List<Snake> snakes) {
		this.snakes = snakes;
	}
	public List<Ladder> getLadders() {
		return ladders;
	}
	public void setLadders(List<Ladder> ladders) {
		this.ladders = ladders;
	}
    
    
}
