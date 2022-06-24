package TP4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;




public class Agent_intelligent {
	
	public Agent_intelligent(char symbol) {
		Symbol = symbol;
		BF=new ArrayList<int[]>();
		checker_a= new ArrayList<Integer>(Collections.nCopies(8, 0));
		content_a=new ArrayList<ArrayList<int[]>>(Collections.nCopies(8, null));
		checker_b= new ArrayList<Integer>(Collections.nCopies(8, 0));
		content_b=new ArrayList<ArrayList<int[]>>(Collections.nCopies(8, null));
		
	}

	private char Symbol;
	private ArrayList<int[]> BF;
	private ArrayList<Integer> checker_a;
	private ArrayList<ArrayList<int[]>> content_a;
	private ArrayList<Integer> checker_b;
	private ArrayList<ArrayList<int[]>> content_b;
	
	public char getSymbol() {
		return Symbol;
	}

	public void setSymbol(char symbol) {
		Symbol = symbol;
	}
	public ArrayList<int[]> getBF() {
		return BF;
	}

	public void setBF(ArrayList<int[]> bF) {
		BF = bF;
	}
	
	public void jouer(ArrayList<Regle_composee> BR,char[][] TicTacToe,ArrayList<int[]> BF_adv) {
		int A;
		int B;
		int[] ma_case=new int[2];
		if(BF.isEmpty()) {
			Random rand = new Random();
			int flag=0;
			do {
			A = rand.nextInt(3);
			B = rand.nextInt(3);
			if(BF_adv.size()==0) {
				break;
			}
			for(int p=0;p<BF_adv.size();p++){
				if(BF_adv.get(p)[0]!=A || BF_adv.get(p)[1]!=B) {
					flag++;
				}
			}
			}while(flag!=BF_adv.size());
			ma_case= new int[] {A,B};
			TicTacToe[A][B]=this.getSymbol();
			BF.add(ma_case);
		}
		
		
		else{
			for(int i=0;i<BR.size();i++) {
				if(checker_a.get(i)==-1) {
					continue;
				}
				int a=0;
				ArrayList<int[]> a_con=new ArrayList<int[]>();
				loop1:for(int[] case_r: BR.get(i).getPremisses()) {
					for(int m=0; m<BF_adv.size();m++) {
						if(BF_adv.get(m)[0]==case_r[0] && BF_adv.get(m)[1]==case_r[1]) {
							a=-1;
							a_con=null;
							break loop1;
						}
					}
					
					
					boolean indice=false;
					for(int m=0; m<BF.size();m++) {
						if(BF.get(m)[0]==case_r[0] && BF.get(m)[1]==case_r[1]) {
							indice=true;
							break;
						}
					}
					if(indice==true) {
						a++;
					}else {
						a_con.add(case_r);
					}
				}
				
				
				content_a.set(i,a_con);
				checker_a.set(i, a);
			}
			
			for(int i=0;i<BR.size();i++) {
				if(checker_b.get(i)==-1) {
					continue;
				}
				int b=0;
				ArrayList<int[]> b_con=new ArrayList<int[]>();
				loop2:for(int[] case_r: BR.get(i).getPremisses()) {
					for(int n=0; n<BF.size();n++) {
						if(BF.get(n)[0]==case_r[0] && BF.get(n)[1]==case_r[1]) {
							b=-1;
							b_con=null;
							break loop2;
						}
					}
					
					
					boolean indice=false;
					for(int n=0; n<BF_adv.size();n++) {
						if(BF_adv.get(n)[0]==case_r[0] && BF_adv.get(n)[1]==case_r[1]) {
							indice=true;
							break;
						}
					}
					if(indice==true) {
						b++;
					}else {
						b_con.add(case_r);
					}
				}
				
				
				content_b.set(i,b_con);
				checker_b.set(i,b);
			}
			
			
			
			int max_a=Collections.max(checker_a);
			int max_b=Collections.max(checker_b);
			ArrayList<int[]> possibilities=new ArrayList<int[]>();
			
			if(max_a!=-1 || max_b!=-1) {
				if(max_a>=max_b) {
				for(int j=0;j<content_a.size();j++) {
					if(checker_a.get(j)==max_a) {
						possibilities.addAll(content_a.get(j));
					}
				}
			}
			else {
				for(int j=0;j<content_b.size();j++) {
					if(checker_b.get(j)==max_b) {
						possibilities.addAll(content_b.get(j));
					}
				}
				
			}
				Collections.shuffle(possibilities);
				A=possibilities.get(0)[0];
				B=possibilities.get(0)[1];
				ma_case= new int[] {A,B};
				TicTacToe[A][B]=this.getSymbol();
				BF.add(ma_case);
			}
			else {
				ArrayList<int[]> liste_aleatoire= new ArrayList<int[]>();
				for (int i=0; i<TicTacToe.length ; i++) {
					for(int j=0; j< TicTacToe[i].length ;j++) {
						if(TicTacToe[i][j]=='-') {
							liste_aleatoire.add(new int[] {i,j});
						}
					}
				}
				Collections.shuffle(liste_aleatoire);
				A=liste_aleatoire.get(0)[0];
				B=liste_aleatoire.get(0)[1];
				ma_case= new int[] {A,B};
				TicTacToe[A][B]=this.getSymbol();
				BF.add(ma_case);
			}
			
			
			
		}
		
		
	}

}
