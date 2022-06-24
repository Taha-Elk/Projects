package TP1_EXO1;

import java.util.ArrayList;

public class MoteurInference {

	public MoteurInference() {
		super();
	}
	
	public static boolean chainage_avant(ArrayList<String> BF, ArrayList<RegleSimple> BR, String PropVerif) {
		int flag=1;
		while(!BF.contains(PropVerif) && flag==1) {
			flag=0;
			int i=0;
			while (i < BR.size() ) {
				if (BF.contains(BR.get(i).getPremisse())) {
					BF.add(BR.get(i).getConclusion());
					BR.remove(i);
					flag=1;
				}
				else {
					i+=1;
				}
			}
		}
		
		if (BF.contains(PropVerif)) {
			return true;
		}
		else {
			return false;
		}
		}
		
}
