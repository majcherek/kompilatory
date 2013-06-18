package server;

import java.rmi.RemoteException;
import java.util.Random;

import remotes.GameBoard;
import remotes.GameBoardListener;
import remotes.User;
import remotes.UserRejectedException;

public class AIUser implements User, GameBoardListener {

	private static final long serialVersionUID = 1L;
	private String nick;// TODO add randomly generated names
	private char symbol;
	private GameBoard game;

	public AIUser(String s, GameBoard b) {
		game = b;

		Random r = new Random();
		nick = s + r.nextInt();
	}

	@Override
	public String getNick() throws RemoteException {

		return nick;
	}

	@Override
	public char getSymbol() throws RemoteException {

		return symbol;
	}

	@Override
	public void setSymbol(char s) throws RemoteException {
		symbol = s;

	}

	@Override
	public void onNewMove(GameBoard board) throws RemoteException {

	}

	// TODO - add some intelligence
	@Override
	public void onWrongMove() throws RemoteException {
		Random r = new Random();

		Integer move = r.nextInt(9);
		try {
			game.makeMove(this, move);
		} catch (UserRejectedException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void onGameWon(GameBoard board, char symbol) throws RemoteException {

	}

	@Override
	public void onWrongTurn() throws RemoteException {

	}

	@Override
	public void onNewTurn() throws RemoteException {
		Random r = new Random();

		Integer move = r.nextInt(9);
		try {
			game.makeMove(this, move);
		} catch (UserRejectedException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void onDraw() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
