package TP3_EXO1;
import java.util.Random;

public class AgentJoueur {
	private char Symbol;
	
	public AgentJoueur(char symbol) {
		Symbol = symbol;
	}

	

	public char getSymbol() {
		return Symbol;
	}

	public void setSymbol(char symbol) {
		Symbol = symbol;
	}
	public void jouer(char[][] TicTacToe) {
		Random rand = new Random();
		
		boolean flag=true;
		do {
		int a = rand.nextInt(3);
		int b = rand.nextInt(3);
		if (TicTacToe[a][b]=='-') {
			TicTacToe[a][b]=Symbol;
			flag=false;
		}
		}while(flag==true);
		
	}
	
}
