import java.util.Scanner;

public class Main {
	
	public static void main(String args[]) {	
		Game game;
		game = new Game();
		game.createBoard(7, 6);
		game.drawBoard();
		
		while (true) {
		Scanner scanner = new Scanner(System.in);
		int board_column = scanner.nextInt();
		game.addToken(board_column);
		game.drawBoard();
		if (game.checkForWin(game.current_x, game.current_y) == true) System.exit(0);
		game.changePlayer();
		}
		}
}
