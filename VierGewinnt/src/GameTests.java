
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GameTests {

	@Test
	void WhenBoardInitialisedThenTokenCountZero() {
		Game game; 
		game = new Game();
		int expected_token_count = 0;
		int token_count = game.getTokenCount();
		assertEquals(expected_token_count, token_count);
	}
	
	@Test
	void WhenOneTokenPlacedThenTokenCountOne() {
		Game game; 
		game = new Game();
		game.createBoard(6, 7);
		game.addToken(1);
		int expected_token_count = 1;
		int token_count = game.getTokenCount();
		assertEquals(expected_token_count, token_count);
	}
	
	@Test
	void WhenBoardResetThenTokenCountZero() {
		Game game; 
		game = new Game();
		game.createBoard(6, 7);
		game.addToken(1);
		game.resetBoard();
		int expected_token_count = 0;
		int token_count = game.getTokenCount();
		assertEquals(expected_token_count, token_count);		
	}
	
	@Test 
	void WhenDiagonalWinThenVictoryCurrentPlayer() {
		Game game; 
		game = new Game();
		game.createBoard(6, 7);
		game.addToken(1); // Player 1
		game.addToken(2); //2
		game.addToken(2); //1
		game.addToken(3); //2
		game.addToken(3); //1
		game.addToken(4); //2
		game.addToken(3); //1
		game.addToken(4); //2
		game.addToken(4); //1
		game.addToken(1); //2
		game.addToken(4); //1
		game.checkForWin(game.current_x, game.current_y);
		int expected_winner = 1;
		int winner = game.winner;
		assertEquals(expected_winner, winner);
	}
	
	
	@Test 
	void WhenHorizontalWinThenVictoryCurrentPlayer() {
		Game game; 
		game = new Game();
		game.createBoard(6, 7);
		game.addToken(1); //1
		game.addToken(1); //2
		game.addToken(2); //1
		game.addToken(2); //2
		game.addToken(3); //1
		game.addToken(3); //2
		game.addToken(4); //1
		game.checkForWin(game.current_x, game.current_y);
		int expected_winner = 1;
		int winner = game.winner;
		assertEquals(expected_winner, winner);
	}
	
	@Test
	void WhenVerticalWinThenVictoryCurrentPlayer() {
		Game game;
		boolean expected_victory = true;
		game = new Game();
		game.createBoard(6, 7);
		game.addToken(1);
		game.addToken(2);
		game.addToken(1);
		game.addToken(2);
		game.addToken(1);
		game.addToken(2);
		game.addToken(1);
		game.checkForWin(game.current_x, game.current_y);
		int expected_winner = 1;
		int winner = game.winner;
		assertEquals(expected_winner, winner);
	}
	
	
	@Test
	void TokenCountColumnWithTwoTokens() {
		int expected_token_count_column_three = 2;
		Game game;
		game = new Game();
		game.createBoard(7, 6);
		
		game.addToken(3);
		game.addToken(3);
		
		int token_count_column_three = game.getTokenCountColumn(2);
		
		assertEquals(expected_token_count_column_three, token_count_column_three);
	}
	
	@Test
	void WhenOneTokenPlacedInColumnTwoThenColumnOneTokenCountZero() {
		Game game;
		game = new Game();
		game.createBoard(7, 6);
		
		int expected_token_count = 0;		
		int token_count = game.getTokenCountColumn(2);
		assertEquals(expected_token_count, token_count);
	}
}
