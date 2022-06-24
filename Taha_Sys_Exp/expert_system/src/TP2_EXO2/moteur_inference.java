package TP2_EXO2;

import java.util.ArrayList;

public class moteur_inference {
	public moteur_inference() {
		super();
	}

	
	public static boolean chainage_arriere_comp(ArrayList<String> BF, ArrayList<regle_compose> BR, String PropVerif) {
		        ArrayList<String[]> table2=new ArrayList<String[]>();
		        
				if(BF.contains(PropVerif)) {
					
					return true;
				}
				
				else {
					
					int k=0;
					while(k<BR.size()) {
						if(PropVerif.equals(BR.get(k).getConclusion())) {
							table2.add(BR.get(k).getPremisses());
						}
						k++;
					}
					
						
					
				    int COMPTEUR=0;
					for(int m=0;m<table2.size();m++) {
						
						int compteur=0;
						for(int n=0;n<table2.get(m).length;n++) {
							if(moteur_inference.chainage_arriere_comp(BF,BR,table2.get(m)[n])==true) {
								compteur++;
							}
						}
						if(compteur==table2.get(m).length) {
							return true;
						}
						else {
							COMPTEUR++;
						}
					}
					if(COMPTEUR==table2.size()) {
						return false;
					}
					
				}
				return false;

            }
}
