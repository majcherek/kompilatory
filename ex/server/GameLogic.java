package server;
public class GameLogic {

	public static char checkWin(GameBoardImpl board) {
		// check all possibilities of winning

		// columns
		for (int i = 0; i < 3; i++) {

			if (board.gameBoard[i].getSymbol() != ' '
					&& board.gameBoard[i].getSymbol() == board.gameBoard[i + 3]
							.getSymbol()
					&& board.gameBoard[i + 3].getSymbol() == board.gameBoard[i + 6]
							.getSymbol())
				return board.gameBoard[i].getSymbol();
		}

		// rows

		for (int i = 0; i < 7; i += 3) {
			if (board.gameBoard[i].getSymbol() != ' '
					&& board.gameBoard[i].getSymbol() == board.gameBoard[i + 1]
							.getSymbol()
					&& board.gameBoard[i + 1].getSymbol() == board.gameBoard[i + 2]
							.getSymbol())
				return board.gameBoard[i].getSymbol();
		}

		// diagonals

		if (board.gameBoard[0].getSymbol() != ' '
				&& board.gameBoard[0].getSymbol() == board.gameBoard[4]
						.getSymbol()
				&& board.gameBoard[4].getSymbol() == board.gameBoard[8]
						.getSymbol())
			return board.gameBoard[0].getSymbol();

		else if (board.gameBoard[2].getSymbol() != ' '
				&& board.gameBoard[2].getSymbol() == board.gameBoard[4]
						.getSymbol()
				&& board.gameBoard[4].getSymbol() == board.gameBoard[6]
						.getSymbol())
			return board.gameBoard[2].getSymbol();
		// else

		for (Field f : board.gameBoard) {
			if (f.isEmpty())
				return ' '; // empty char for game in progress
		}
		
		return 'D'; //for draw

	}
}
