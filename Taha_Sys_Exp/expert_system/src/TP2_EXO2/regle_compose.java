package TP2_EXO2;

public class regle_compose {
	public regle_compose() {
		super();
	}
	public regle_compose(String premissesComposees, String conclusion) {
		premisses = premissesComposees.split("&");
		this.conclusion = conclusion;
		}
	private String[] premisses;
	private String conclusion;
	
	
	public String[] getPremisses() {
		return premisses;
	}
	public void setPremisses(String[] premisse) {
		this.premisses = premisse;
	}
	public String getConclusion() {
		return conclusion;
	}
	public void setConclusion(String conclusion) {
		this.conclusion = conclusion;
	}

}
