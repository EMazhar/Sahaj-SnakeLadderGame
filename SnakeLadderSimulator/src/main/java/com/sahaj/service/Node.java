package com.sahaj.service;

public class Node {

	 private int head;
	 private int minDist;
	 
	 public Node(int head, int minDist){
	        this.head = head;
	        this.minDist = minDist;
	    }

	public int getHead() {
		return head;
	}

	public void setHead(int head) {
		this.head = head;
	}

	public int getMinDist() {
		return minDist;
	}

	public void setMinDist(int minDist) {
		this.minDist = minDist;
	}
	 
}
