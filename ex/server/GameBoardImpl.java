package server;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Random;
import java.util.TreeMap;

import remotes.GameBoard;
import remotes.GameBoardListener;
import remotes.User;
import remotes.UserRejectedException;

public class GameBoardImpl implements GameBoard {

	private TreeMap<String, GameBoardListener> map;
	public Integer boardID;
	// private String[] playerNames = new String[2];
	protected String turn; // nick of current player

	public GameBoardImpl(Integer id) {
		boardID = id;
		map = new TreeMap<String, GameBoardListener>();
	}

	protected Field[] gameBoard;

	

	public void register(User u, GameBoardListener l) throws RemoteException,
			UserRejectedException {
		if (map.containsKey(u.getNick()) || map.size() >= 2)
			throw new UserRejectedException();
		else {
			if (map.size() == 1)
				u.setSymbol('X');
			else
				u.setSymbol('O');
			map.put(u.getNick(), l);
			System.out.println("***log: " + u.getNick() + " has registered on "
					+ boardID);
			if (map.size() > 1)
				startGame();
		}
	}

	public String getCurrentBoard() throws RemoteException {

		return boardToString();
	}

	// TODO
	private String boardToString() {

		StringBuffer boardBuf = new StringBuffer();

		boardBuf.append("    1 2 3\n");
		boardBuf.append("1   " + gameBoard[0] + "|" + gameBoard[1] + "|"
				+ gameBoard[2] + "\n");
		boardBuf.append("2   " + gameBoard[3] + "|" + gameBoard[4] + "|"
				+ gameBoard[5] + "\n");
		boardBuf.append("3   " + gameBoard[6] + "|" + gameBoard[7] + "|"
				+ gameBoard[8] + "\n");

		return boardBuf.toString();
	}

	public boolean isSlotFree() throws RemoteException {
		return (map.size() < 2);
	}

}
