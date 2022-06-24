package TP3_EXO2;

public class Principal {
	
	
	public static void main(String[] args) {
		char[][] TicTacToe= new char[3][3];
		for (int i=0; i<TicTacToe.length ; i++) {
			for(int j=0; j< TicTacToe[i].length ;j++) {
				TicTacToe[i][j]='-';
			}
		}
		Agent_Arbitre.Affichage(TicTacToe);
		Agent_Joueur J1=new Agent_Joueur('X');
		Agent_Joueur J2=new Agent_Joueur('O');
		int n_tour=0;
		do {
			Agent_Arbitre.Partie(n_tour, TicTacToe, J1, J2);
			n_tour++;
		}while(Agent_Arbitre.Resultat(TicTacToe, J1, J2)==false);
		
		

	}
	

}
