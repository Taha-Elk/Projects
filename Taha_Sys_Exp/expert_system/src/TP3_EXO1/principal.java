package TP3_EXO1;

public class principal {
	public static void Affichage(char[][] TicTacToe){
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
	
	public static boolean Gagner(char[][] TicTacToe,char symb){
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

	public static void main(String[] args) {
		char[][] TicTacToe= new char[3][3];
		for (int i=0; i<TicTacToe.length ; i++) {
			for(int j=0; j< TicTacToe[i].length ;j++) {
				TicTacToe[i][j]='-';
			}
		}
		Affichage(TicTacToe);
		
		
		AgentJoueur J1=new AgentJoueur('X');
		AgentJoueur J2=new AgentJoueur('O');
		AgentJoueur[] list_joueur=new AgentJoueur[2];
		list_joueur[0]=J1;
		list_joueur[1]=J2;
		
		
		int nbr_tour=0;
		boolean fin=false;
		do {
			for(AgentJoueur aj:list_joueur) {
				aj.jouer(TicTacToe);
				Affichage(TicTacToe);
				nbr_tour++;
				if(Gagner(TicTacToe,aj.getSymbol())==true) {
					System.out.print("le gagnant est le joueur "+aj.getSymbol());
					fin=true;
					break;
				}
				if(nbr_tour==9) {
					break;
				}
			}
		}while(GameOver(TicTacToe)==false && fin==false);
		
		if (GameOver(TicTacToe)==true && fin==false) {
			System.out.println("Match nulle");
		}
		

	}

}
