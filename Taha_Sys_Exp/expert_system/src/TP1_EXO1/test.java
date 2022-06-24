package TP1_EXO1;
import java.util.ArrayList;

public class test {

	public static void main(String[] args) {
		RegleSimple R1= new RegleSimple("D","G");
		RegleSimple R2= new RegleSimple("F","A");
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
		BF.add("C");
	
		
		System.out.print(MoteurInference.chainage_avant(BF,BR,"J"));
	}

}
