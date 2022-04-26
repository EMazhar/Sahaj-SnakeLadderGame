package com.sahaj.model;


public class Player {
	private String name;
    private int position;
    private boolean won;
    public static int luckyRolls;
    public static int unluckyRolls;
    public Player(String name) {
        this.name = name;
        this.position = 0;
        this.won = false;
    }
	public String getName() {
		return name;
	}
	public int getPosition() {
		return position;
	}
	public boolean isWon() {
		return won;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public void setWon(boolean won) {
		this.won = won;
	}
    
}
