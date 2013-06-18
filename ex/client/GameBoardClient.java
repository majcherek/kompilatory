package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import remotes.GameBoard;
import remotes.Server;
import remotes.UserRejectedException;

public class GameBoardClient {
	
	Server serv;
	GameBoard game;
	GameBoardListenerImpl listener;

	public static void main(String[] args) {

		if (args.length != 3) {
			System.out.println("Args: <host> <nick> <port>");
			System.exit(-1);
		}
		try {

			serv = (Server) Naming.lookup("rmi://" + args[0] + "/serv"); // "rmi://127.0.0.1/serv"
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					System.in));

			System.out
					.println("Type X for PvP game, anything else for game vs. AI");
			boolean isAI;

			String choice = reader.readLine();
			if (choice.equals("X"))
				isAI = false;
			else
				isAI = true;

			game = serv.connect(isAI);

			UserImpl user = new UserImpl(args[1]);
			listener = new GameBoardListenerImpl();

			try {
				UnicastRemoteObject.exportObject(user, Integer.parseInt(args[2]));
				UnicastRemoteObject.exportObject(listener, Integer.parseInt(args[2]));
			} catch (RemoteException re) {
				re.printStackTrace();
			}
			try {

				game.register(user, listener);
			} catch (UserRejectedException e) {
				System.out.println("Error while registering, user rejected.");
				System.exit(1);
			}

			while (true) {
				try {

					String move = reader.readLine();
					try {
						if (move != null)
							game.makeMove(user, Integer.parseInt(move));
					} catch (RemoteException e) {
						System.out.println("Error while accessing remote object!");
					} catch (UserRejectedException e) {
						System.out
								.println("User not registered - please reconnect");
					}

					catch (Exception e) {
						System.out.println("Make a valid move!");
					}

				} catch (IOException e) {
					return;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}