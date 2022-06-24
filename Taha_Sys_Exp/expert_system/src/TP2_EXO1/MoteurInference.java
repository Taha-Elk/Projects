package TP2_EXO1;

import java.util.ArrayList;

public class MoteurInference {
	public MoteurInference() {
		super();
	}
	
	public static boolean chainage_arriere(ArrayList<String> BF, ArrayList<RegleSimple> BR, String PropVerif) {
		ArrayList<String> table=new ArrayList<String>();
		ArrayList<String> table2=new ArrayList<String>();
		table.add(PropVerif);
		int a=0;
		while(table.size()!=0) {
			
			if (BF.contains(table.get(0))) {
				a=1;
				break;
			}
			
			else{
				for (int j=0;j < BR.size();j++) {
					if (BR.get(j).getConclusion()==table.get(0)) {
						table2.add(BR.get(j).getPremisse());
					}
				}
				table.remove(0);
			}
			
			if (table.size()==0) {
				for (int k=0; k<table2.size();k++) {
					table.add(table2.get(k));
					table2.clear();
				}
			}
		}
			
		
		if (a==1) {
			return true;
		}
		else {
			return false;
		}
		}
	}




		

