package com.sahaj.service;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import org.springframework.stereotype.Component;

/**
 * 
 * @author EHTESHAM MAZHAR
 *
 *
 */
@Component
public class GameMinimumRollStatsService {

	public int getMinimumRollsToWin(Map<Integer, Integer> laders, Map<Integer, Integer> snakes, int boardSize) {
		List<Edge> edges = new ArrayList<>();
		for (int i = 0; i < boardSize; i++) {
			for (int j = 1; j <= 6 && i + j <= boardSize; j++) {
				int src = i;
				int dest;
				int lader = (laders.get(i + j) != null) ? laders.get(i + j) : 0;
				int snake = (snakes.get(i + j) != null) ? snakes.get(i + j) : 0;
				if (lader != 0 || snake != 0) {
					dest = lader + snake;
				} else {
					dest = i + j;
				}
				edges.add(new Edge(src, dest));
			}
		}

		NodePath nodePath = new NodePath(edges, boardSize);
		return findMinimumRoll(nodePath, 0, boardSize);

	}

	public int findMinimumRoll(NodePath g, int source, int n) {

		Queue<Node> q = new ArrayDeque<>();
		boolean[] discovered = new boolean[n + 1];
		discovered[source] = true;
		int minRoll=-1;
		Node node = new Node(source, 0);
		q.add(node);
		while (!q.isEmpty()) {
			node = q.poll();
			if (node.getHead() == n) {
				minRoll=node.getMinDist();
				break;
			}
			for (int u : g.adjList.get(node.getHead())) {
				if (!discovered[u]) {
					discovered[u] = true;
					q.add(new Node(u, node.getMinDist() + 1));
				}
			}
		}

		return minRoll;

	}
}
