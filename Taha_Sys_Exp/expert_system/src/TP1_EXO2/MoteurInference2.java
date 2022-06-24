package TP1_EXO2;

import java.util.ArrayList;


public class MoteurInference2 {

	public MoteurInference2() {
		super();
	}
	public static boolean ChainageAvantComp(ArrayList<String> BF, ArrayList<RegleComposee> BR, String PropVerif) {
		int flag=1;
		while(flag==1) {
			flag=0;
			int i=0;
			while (i < BR.size() && !BF.contains(PropVerif)) {
				int a=BR.get(i).getPremisses().length;
				int b=0;
				
				
				for(int j=0;j<BR.get(i).getPremisses().length;j++) {
					if (BF.contains(BR.get(i).getPremisses()[j])) {
						b+=1;
					}
				}
				
				if(b==a) {
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
