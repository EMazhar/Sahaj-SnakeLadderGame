package com.sahaj.service;

import org.springframework.stereotype.Component;

import com.sahaj.model.Player;

/**
 * 
 * @author EHTESHAM MAZHAR
 *
 */
@Component
public class IPlayGameImpl implements IPlayGame {

	ISnakeImpl isnakeImpl = new ISnakeImpl();
	DiceServiceImpl diceService = new DiceServiceImpl();

	public IPlayGameImpl() {
	}

	public void playGame(IGameImpl game) {

		while (true) {

			Player player = game.getPlayers().poll();
			int newPosition = player.getPosition() + diceService.rollDice(game.getDice());

			if (newPosition > game.getBoard().getEnd()) {
				player.setPosition(player.getPosition());
				game.getPlayers().offer(player);
			} else {
				newPosition = isnakeImpl.getNewPosition(newPosition, game.getSnakes(), game.getLaders(), player);
				player.setPosition(newPosition);
				if (player.getPosition() == game.getBoard().getEnd()) {
					player.setWon(true);
					game.getPlayers().offer(player);
					System.out.println("Player " + player.getName() + " Won.");
					break;
				} else {
					System.out.println("Setting " + player.getName() + "'s new position to " + player.getPosition());
					game.getPlayers().offer(player);
				}
			}

		}
	}

}
