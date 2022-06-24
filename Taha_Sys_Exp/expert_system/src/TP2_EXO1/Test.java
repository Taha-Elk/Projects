package TP2_EXO1;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RegleSimple R1= new RegleSimple("P","Q");
		RegleSimple R2= new RegleSimple("Q","R");
		RegleSimple R3= new RegleSimple("A","B");
		RegleSimple R4= new RegleSimple("C","D");
		RegleSimple R5= new RegleSimple("G","C");
		RegleSimple R6= new RegleSimple("I","J");
		RegleSimple R7= new RegleSimple("B","I");
		ArrayList<String> BF= new ArrayList<String>();
		ArrayList<RegleSimple> BR= new ArrayList<RegleSimple>();
		
		BR.add(R1);
		BR.add(R2);
		BR.add(R3);
		BR.add(R4);
		BR.add(R5);
		BR.add(R6);
		BR.add(R7);
		
		BF.add("F");
		BF.add("P");
	
		
		System.out.print(MoteurInference.chainage_arriere(BF,BR,"R"));

	}

}
