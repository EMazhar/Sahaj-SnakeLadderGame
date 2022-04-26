package com.sahaj.service;

/**
 * 
 * @author EHTESHAM MAZHAR
 *
 */
public class Edge {
	private int startPos;
	private int destPos;
	 
    public Edge(int startPos, int destPos)
    {
        this.startPos = startPos;
        this.destPos = destPos;
    }

	public int getStartPos() {
		return startPos;
	}

	public int getDestPos() {
		return destPos;
	}
    

}
