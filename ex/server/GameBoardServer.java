package server;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import remotes.GameBoard;
import remotes.Server;
import remotes.UserRejectedException;


public class GameBoardServer implements Server {
	static Server serv;
	static Integer gameNr;

	ArrayList<GameBoard> game;

	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Args: <port>");
			System.exit(-1);
		}
		try {

			serv = new GameBoardServer();
			UnicastRemoteObject.exportObject(serv, Integer.parseInt(args[0]));

			Naming.rebind("serv", serv);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Finds available game for connecting user or creates new one
	 */
	@Override
	public GameBoard connect(boolean isAI) throws RemoteException {

		if (!isAI) {
			for (GameBoard g : games) {
				if (g.isSlotFree())
					return g;
			}
		}
		// if there is no game available, create new game
		GameBoard newGame = new GameBoardImpl(++gameNr);
		System.out.println("Board " + gameNr + " created");
		games.add(newGame);
		UnicastRemoteObject.exportObject(newGame, 0);

		// if AI, register computer player on the board
		if (isAI) {
			try {
				AIUser computer = new AIUser("Janusz", newGame);
				newGame.register(computer, computer);
			} catch (UserRejectedException e) {
				e.printStackTrace();
			}
		}
		return newGame;
	}

}
