package abstraction;


public class Case {
	
	
	private boolean sens;
	private int attribution;
	private int nouvelEtat;
	public boolean isSens() {
		return sens;
	}
	public void setSens(boolean sens) {
		this.sens = sens;
	}
	public int getAttribution() {
		return attribution;
	}
	public void setAttribution(int attribution) {
		this.attribution = attribution;
	}
	
	public int getNouvelEtat() {
		return nouvelEtat;
	}
	public void setNouvelEtat(int nouvelEtat) {
		this.nouvelEtat = nouvelEtat;
	}
	public Case(boolean sens,int attribution, int nouvelEtat){
		this.sens=sens;
		this.attribution=attribution;
		this.nouvelEtat=nouvelEtat;
		
	}
	@Override
	public String toString() {
		String direction;
		if(isSens()){
			direction="droite";
		}
		else{
			direction="gauche";
		}
		return nouvelEtat+","+attribution+","+direction;
	}
	
	
}
