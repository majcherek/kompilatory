package client;

import java.rmi.RemoteException;

import remotes.User;

public class UserImpl implements User {

	private String nick;

	private char symbol;

	public UserImpl(String nick) throws RemoteException {
		this.nick = nick;
		this.symbol = 'g';
	}

	public String getNick() throws RemoteException {
		return nick;
	}

	public char getSymbol() throws RemoteException {
		return symbol;
	}

	@Override
	public void setSymbol(char s) {
		symbol = s;

	}

}