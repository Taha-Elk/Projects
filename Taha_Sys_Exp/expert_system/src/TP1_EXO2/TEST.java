package TP1_EXO2;

import java.util.ArrayList;


public class TEST {

	public static void main(String[] args) {
		RegleComposee R1= new RegleComposee("A&B","C");
		RegleComposee R2= new RegleComposee("C&D","F");
		RegleComposee R3= new RegleComposee("F&B","E");
		RegleComposee R4= new RegleComposee("F&A","G");
		RegleComposee R5= new RegleComposee("G&F","B");
		
		
		ArrayList<String> BF= new ArrayList<String>();
		ArrayList<RegleComposee> BR= new ArrayList<RegleComposee>();
		
		
		BR.add(R1);
		BR.add(R2);
		BR.add(R3);
		BR.add(R4);
		BR.add(R5);
		
		
		BF.add("A");
		BF.add("C");
		BF.add("D");
		
		System.out.print(MoteurInference2.ChainageAvantComp(BF, BR, "E"));

	}

}
