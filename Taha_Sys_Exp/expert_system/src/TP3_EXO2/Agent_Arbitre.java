package TP3_EXO2;
import java.util.Random;

public class Agent_Arbitre {
	
	public static Agent_Joueur[] list_joueur=new Agent_Joueur[2];

	public static void Affichage(char[][] TicTacToe) {
		System.out.println();
		for (int i=0; i< TicTacToe.length ; i++) {
			for(int j=0; j<TicTacToe[i].length ;j++){
				System.out.print(TicTacToe[i][j]+"\t");
			}
			System.out.println();
			System.out.println();
		}
	}
	
	public static boolean GameOver(char[][] TicTacToe) {
		int a= 0;
		for (int i=0; i< TicTacToe.length ; i++) {
			for(int j=0; j<TicTacToe[i].length ;j++){
				if (TicTacToe[i][j]!='-') {
					a+=1;
				}
			}
		}
		if (a==9) {
			return true;
		}
		else{
			return false;
		}	
	}
	
	public static boolean Gagner(char[][] TicTacToe ,char symb) {
		for (int i=0; i< TicTacToe.length ; i++) {
			if (TicTacToe[i][0]==symb && TicTacToe[i][1]==symb && TicTacToe[i][2]==symb) {
				return true;
			}
			if (TicTacToe[0][i]==symb && TicTacToe[1][i]==symb && TicTacToe[2][i]==symb) {
				return true;
			}
		}
		if (TicTacToe[0][0]==symb && TicTacToe[1][1]==symb && TicTacToe[2][2]==symb) {
			return true;
		}
		if (TicTacToe[0][2]==symb && TicTacToe[1][1]==symb && TicTacToe[2][0]==symb) {
			return true;
		}
		else {
		return false;
		}
	}
	public static void Partie(int n_tour,char[][] TicTacToe,Agent_Joueur J1,Agent_Joueur J2) {
		
		if(n_tour==0) {
			Random rand = new Random();
			int a = rand.nextInt(2);
			list_joueur[(a+1)%2]=J2;
			list_joueur[a]=J1;
		}
		if(n_tour%2==0) {
			list_joueur[0].jouer(TicTacToe);
		}
		else {
			list_joueur[1].jouer(TicTacToe);
		}
		Agent_Arbitre.Affichage(TicTacToe);
	}
	
	public static boolean Resultat(char[][] TicTacToe,Agent_Joueur J1,Agent_Joueur J2) {
		
		if(Gagner(TicTacToe,J1.getSymbol())==true){
			System.out.println(J1.getSymbol()+" est le gagnant");
			return true;
		}
		if(Gagner(TicTacToe,J2.getSymbol())==true){
			System.out.println(J2.getSymbol()+" est le gagnant");
			return true;
		}	
		if(GameOver(TicTacToe)==true) {
			System.out.println("match nulle");
			return true;
		}
		return false;
	}

}
