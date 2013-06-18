package server;
class Field {
	char symbol;

	public Field() {
		this.symbol = ' ';
	}

	public boolean isEmpty() {
		return (symbol == ' ');
	}
	
	public void clean()
	{
		symbol = ' ';
	}

	public boolean setSymbol(char s) {
		if (isEmpty()) {
			symbol = s;
			return true;
		} else
			return false;
	}

	public char getSymbol() {
		return symbol;
	}

	public String toString() {
		return Character.toString(this.getSymbol());
	}
}