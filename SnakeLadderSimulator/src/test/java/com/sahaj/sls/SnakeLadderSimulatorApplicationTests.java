package com.sahaj.sls;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.sahaj.model.Player;
import com.sahaj.service.GameMinimumRollStatsService;
import com.sahaj.service.GameStats;
import com.sahaj.service.IGameClimbStatsServiceImpl;
import com.sahaj.service.IGameImpl;
import com.sahaj.service.IGameLuckyRollsStatsServiceImpl;
import com.sahaj.service.IGameSlideStatsService;
import com.sahaj.service.IGameSlideStatsServiceImpl;
import com.sahaj.service.IPlayGameImpl;



@SpringBootTest
class SnakeLadderSimulatorApplicationTests {
	
	@Test
	public void snakeLadderStatsComparisionTest() {
		Map<Integer, Integer> ladder = new HashMap<>();
		Map<Integer, Integer> snake = new HashMap<>();
		IGameSlideStatsService igameSlideStatsService=new IGameSlideStatsServiceImpl();
		IGameClimbStatsServiceImpl igameClimbStatsService=new IGameClimbStatsServiceImpl();
		IGameLuckyRollsStatsServiceImpl igameLuckyRollsStatsService=new IGameLuckyRollsStatsServiceImpl();
		ladder.put(1, 38);
		ladder.put(4, 14);
		ladder.put(9, 31);
		ladder.put(21, 42);
		ladder.put(28, 84);
		ladder.put(51, 67);
		ladder.put(72, 91);
		ladder.put(80, 99);

		snake.put(17, 7);
		snake.put(54, 34);
		snake.put(62, 19);
		snake.put(64, 60);
		snake.put(87, 36);
		snake.put(93, 73);
		snake.put(95, 75);
		snake.put(98, 79);
		
		int boardSize = 200;
		IGameImpl game = new IGameImpl(snake, ladder, boardSize);
		Player p1 = new Player("p1");
		game.addPlayer(p1);
		Player p2 = new Player("p2");
		game.addPlayer(p2);
		new IPlayGameImpl().playGame(game);
		assertEquals(24,new GameMinimumRollStatsService().getMinimumRollsToWin(snake, ladder, boardSize));
		assertEquals(true,igameSlideStatsService.getMinSlide()<=igameSlideStatsService.getMaxSlide());
		assertEquals(true,igameSlideStatsService.getMinSlide()<=igameSlideStatsService.getMaxSlide());
		assertEquals(true,igameClimbStatsService.getMinClimb()<=igameClimbStatsService.getMaxClimb());
		assertEquals(true,compareSlidAndUnluckyRoll(igameSlideStatsService.getMinSlide(),igameLuckyRollsStatsService.getunLuckyRolls()));
		assertEquals(true,compareClimbAndLuckyRoll(igameClimbStatsService.getMinClimb(),igameLuckyRollsStatsService.getLuckyRolls()));
		
	}
	
	private boolean compareSlidAndUnluckyRoll(int slidNumber,int unluckyRolls ) {
		if (slidNumber==0 && unluckyRolls==0) {
			return true;
		}else if(slidNumber !=0 && unluckyRolls !=0)
			return true;
		return false;
		
	}
	private boolean compareClimbAndLuckyRoll(int climbNumber, int luckyRolls) {
		if (climbNumber==0 && luckyRolls==0) {
			return true;
		}else if(climbNumber !=0 && luckyRolls !=0)
			return true;
		return false;
	}
	
	}
