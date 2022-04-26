package com.sahaj.service;

import java.util.ArrayList;
import java.util.List;

public class NodePath {
	List<List<Integer>> adjList = null;
	 
    
	NodePath(List<Edge> edges, int n) {
		adjList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adjList.add(new ArrayList<>());
		}

		for (Edge edge : edges) {
			adjList.get(edge.getStartPos()).add(edge.getDestPos());
		}
	}

}
