package TP2_EXO2;

import java.util.ArrayList;

public abstract class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		regle_compose R1= new regle_compose("A&B","C");
		regle_compose R2= new regle_compose("C&D","F");
		regle_compose R3= new regle_compose("F&A","E");
		regle_compose R4= new regle_compose("F&A","G");
		regle_compose R5= new regle_compose("B&C&D","A");
		
		
		ArrayList<String> BF= new ArrayList<String>();
		ArrayList<regle_compose> BR= new ArrayList<regle_compose>();
		
		
		BR.add(R1);
		BR.add(R2);
		BR.add(R3);
		BR.add(R4);
		BR.add(R5);
		
		
		BF.add("B");
		BF.add("C");
		BF.add("D");
		
		System.out.println(moteur_inference.chainage_arriere_comp(BF, BR, "E"));


	}

}
