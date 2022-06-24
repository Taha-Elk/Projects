package TP4;

public class Regle_composee {
	public Regle_composee() {
		super();
	}
	public Regle_composee(int[][] premisses, boolean conclusion) {
		this.premisses = premisses;
		this.conclusion = conclusion;
		}
	private int[][] premisses;
	private boolean conclusion;
	
	
	public int[][] getPremisses() {
		return premisses;
	}
	public void setPremisses(int[][] premisse) {
		this.premisses = premisse;
	}
	public boolean getConclusion() {
		return conclusion;
	}
	public void setConclusion(boolean conclusion) {
		this.conclusion = conclusion;
	}
  
}
