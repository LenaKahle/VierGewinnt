public class Game {
	int board[][];
	int height;
	int width;
	int current_player;
	int moves_played;
	int token_count;
	int winner;
	int current_x;
	int current_y;

	public Game() {
		current_player = 1;
		moves_played = 0;
	}

	public void createBoard(int board_width, int board_height) {
		if (board_width < 4 || board_height < 4) {
			System.out.println("Please enter a valid board height/weight");
			return;
		}
		width = board_width;
		height = board_height;
		board = new int[width][height];
		this.resetBoard();
	}

	public void resetBoard() {
		token_count = 0;
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				board[i][j] = 0;
			}
		}
	}

	public void changePlayer() {
		if (current_player == 1) {
			current_player = 2;
		} else {
			current_player = 1;
		}
	}

	public void addToken(int board_column) {
		int column = board_column - 1;
		if (!(0 <= column && column <= width))
			return;
		boolean token_set = false;
		if (getTokenCountColumn(column) != height) {
			for (int i = 0; i < height; i++) {
				if (board[column][i] == 0 && token_set == false) {
					board[column][i] = current_player;
					this.current_y = i;
					this.current_x = column;
					token_count++;
					token_set = true;
				}
			}

		} else {
			System.out.println("This column is already full");
		}

	}

	public int getTokenCount() {
		return token_count;
	}

	public int getTokenCountColumn(int column) {
		int token_count_column = 0;
		for (int i = 0; i < height; i++) {
			if (board[column][i] != 0) {
				token_count_column++;
			}
		}
		return token_count_column;
	}

	public boolean checkForWin(int column, int row) {
		if (checkVertical(column, row) == true || checkHorizontal(column, row) == true || checkDiagonal(column, row) == true) {
			winner = current_player;
			System.out.println("Player " + winner + " has won the game");
			return true;
		} else {
			return false;
		}
	}

	public boolean checkVertical(int x, int y) {
		int token_count_column_ = 0;
		for (int i = 0; i <= y; i++) {
			if (this.board[x][i] == current_player) {
				token_count_column_++;
				if (token_count_column_ >= 4) {
					return true;
				}
			} else
				token_count_column_ = 0;
		}
		return false;
	}

	public boolean checkHorizontal(int x, int y) {
		int token_count_row_ = 0;
		for (int i = 0; i < width; i++) {
			if (this.board[i][y] == current_player) {
				token_count_row_++;
				if (token_count_row_ >= 4) {
					return true;
				}
			} else
				token_count_row_ = 0;
		}
		return false;
	}

	public boolean checkDiagonal(int column, int row) {
		if (this.checkDirection("down-left", column, row) + this.checkDirection("up-right", column, row) >= 4) {
			return true;
		} else if (this.checkDirection("up-left", column, row) + this.checkDirection("down-right", column, row) >= 4) {
			return true;
		}
		return false;
	}

	public int checkDirection(String direction, int column, int row) {
		int modifier_x = 0;
		int modifier_y = 0;
		int token_count_diagonal_direction = 0;
		if (direction.equals("down-left")) {
			modifier_x = -1;
			modifier_y = -1;
		} else if (direction.equals("up-left")) {
			modifier_x = -1;
			modifier_y = 1;
		} else if (direction.equals("down-right")) {
			modifier_x = 1;
			modifier_y = -1;
		} else if (direction.equals("up-right")) {
			modifier_x = 1;
			modifier_y = 1;
		}		
		boolean move_on = true;
		for (int i = 0; i < width; i++) {
			if (column + modifier_x < width || row + modifier_y < height)
				move_on = false;
			if (move_on == true) {
				if (this.board[column + modifier_x][row + modifier_y] == current_player) {
					token_count_diagonal_direction++;
				} else {
					move_on = false;
				}
			}
		}
		return token_count_diagonal_direction;
	}

	public void drawBoard() {
		for (int i = height - 1; i >= 0; i--) {
			System.out.println();
			for (int j = 0; j < width; j++) {
				System.out.print(board[j][i]);
				System.out.print(" | ");
			}
		}
	}
}
