package TP4;

import java.util.ArrayList;


public class programme_principal {
	
	
	public static ArrayList<Regle_composee> BR;

	public static void main(String[] args) {
		Regle_composee R1= new Regle_composee(new int[][] {{0,0},{1,1},{2,2}},true);
		Regle_composee R2= new Regle_composee(new int[][] {{0,2},{1,1},{2,0}},true);
		Regle_composee R3= new Regle_composee(new int[][] {{0,0},{0,1},{0,2}},true);
		Regle_composee R4= new Regle_composee(new int[][] {{0,0},{1,0},{2,0}},true);
		Regle_composee R5= new Regle_composee(new int[][] {{1,0},{1,1},{1,2}},true);
		Regle_composee R6= new Regle_composee(new int[][] {{0,1},{1,1},{2,1}},true);
		Regle_composee R7= new Regle_composee(new int[][] {{2,0},{2,1},{2,2}},true);
		Regle_composee R8= new Regle_composee(new int[][] {{0,2},{1,2},{2,2}},true);
		BR= new ArrayList<Regle_composee>();
		BR.add(R1);
		BR.add(R2);
		BR.add(R3);
		BR.add(R4);
		BR.add(R5);
		BR.add(R6);
		BR.add(R7);
		BR.add(R8);
		
		
		char[][] TicTacToe= new char[3][3];
		for (int i=0; i<TicTacToe.length ; i++) {
			for(int j=0; j< TicTacToe[i].length ;j++) {
				TicTacToe[i][j]='-';
			}
		}
		Agent_arbitre.Affichage(TicTacToe);
		Agent_intelligent J1=new Agent_intelligent('X');
		Agent_intelligent J2=new Agent_intelligent('O');
		int n_tour=0;
		do {
			Agent_arbitre.Partie(n_tour, TicTacToe, J1, J2);
			n_tour++;
		}while(Agent_arbitre.Resultat(TicTacToe, J1, J2)==false);

	}

}
