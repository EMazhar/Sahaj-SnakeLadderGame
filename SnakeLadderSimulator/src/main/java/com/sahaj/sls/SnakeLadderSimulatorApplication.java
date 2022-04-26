package com.sahaj.sls;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sahaj.model.Player;
import com.sahaj.service.GameMinimumRollStatsService;
import com.sahaj.service.IGameClimbStatsServiceImpl;
import com.sahaj.service.IGameImpl;
import com.sahaj.service.IGameLuckyRollsStatsServiceImpl;
import com.sahaj.service.IGameSlideStatsService;
import com.sahaj.service.IGameSlideStatsServiceImpl;
import com.sahaj.service.IGameTurnsStatsServiceImpl;
import com.sahaj.service.IPlayGameImpl;

@SpringBootApplication

public class SnakeLadderSimulatorApplication {
	

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		SpringApplication.run(SnakeLadderSimulatorApplication.class, args);
		String ch = "s";
		Map<Integer, Integer> ladder = new HashMap<>();
		ladder.put(1, 38);
		ladder.put(4, 14);
		ladder.put(9, 31);
		ladder.put(21, 42);
		ladder.put(28, 84);
		ladder.put(51, 67);
		ladder.put(72, 91);
		ladder.put(80, 99);

		Map<Integer, Integer> snake = new HashMap<>();
		snake.put(17, 7);
		snake.put(54, 34);
		snake.put(62, 19);
		snake.put(64, 60);
		snake.put(87, 36);
		snake.put(93, 73);
		snake.put(95, 75);
		snake.put(98, 79);
		IGameSlideStatsService igameSlideStatsService=new IGameSlideStatsServiceImpl();
		IGameClimbStatsServiceImpl igameClimbStatsService=new IGameClimbStatsServiceImpl();
		IGameLuckyRollsStatsServiceImpl igameLuckyRollsStatsService=new IGameLuckyRollsStatsServiceImpl();
		
		
		while (!ch.equalsIgnoreCase("E")) {

			System.out.println("Start Game : ");
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter board Size");
			int boardSize = scanner.nextInt();
			System.out.println("Enter number of players");
			int numberOfPlayers = scanner.nextInt();
			IGameImpl game = new IGameImpl(snake, ladder, boardSize);
			for (int i = 0; i < numberOfPlayers; i++) {
				System.out.println("Enter player name");
				String pName = scanner.next();
				Player player = new Player(pName);
				game.addPlayer(player);
			}
			new IPlayGameImpl().playGame(game);
			System.out.println("min slide: " + igameSlideStatsService.getMinSlide());
			System.out.println("max slide: " + igameSlideStatsService.getMaxSlide());
			System.out.println("Minimum Climb :" + igameClimbStatsService.getMinClimb());
			System.out.println("Max Climb :" + igameClimbStatsService.getMaxClimb());
			System.out.println("Longest turn : " + new IGameTurnsStatsServiceImpl().getLongestTurn());
			System.out.println("minimum roll to win the game : "
					+ new GameMinimumRollStatsService().getMinimumRollsToWin(snake, ladder, boardSize));
			System.out.println("Lucky rolls : "+igameLuckyRollsStatsService.getLuckyRolls());
			System.out.println("Unlucky rolls : "+igameLuckyRollsStatsService.getunLuckyRolls());
			
			Scanner sc = new Scanner(System.in);
			System.out.println("To Re Start Game press any Key except E");
			ch = sc.next();

		}

	}

}
