package abstraction;


import java.util.ArrayList;
import java.util.Observable;
import java.util.Vector;

import abstraction.Turing;

public class MachineActuelle extends Observable{
	private Vector<Turing> vect;
	
	public static final Integer CHANGEMENT_ETAPES = new Integer(1);
	public static final Integer CHANGEMENT_CASES = new Integer(2);
	
	
	public MachineActuelle(Turing turing){
		vect=new Vector<>();
		vect.add(turing);
//		this.setChanged();
//		this.notifyObservers(CHANGEMENT_ETAPES);
	}
	public Vector<Turing> getMachines(){
		return vect;
	}
	public void init(){
		this.setChanged();
		this.notifyObservers(CHANGEMENT_ETAPES);
	}
	public void changerMot(String mot1){
		ArrayList<Integer> mot=new ArrayList<>();
		for(int i=0;i<mot1.length();i++){

			mot.add(Integer.parseInt(mot1.charAt(i)+""));
		}

		if(mot.size()==0){
			mot.add(2);
		}
		this.vect.get(0).setMot(mot);
		while(this.vect.size()>1){
			vect.remove(1);
		}
		this.setChanged();
		this.notifyObservers(CHANGEMENT_ETAPES);
	}
	
	public void EtapeSuivante(){
		Turing ajout=new Turing(vect.get(vect.size()-1));
		ajout.next();
		vect.add(ajout);
		System.out.println(vect);
		this.setChanged();
		this.notifyObservers(CHANGEMENT_ETAPES);
		
	}
	
	public void EtapePrecedante(){
		vect.remove(vect.size()-1);
		this.setChanged();
		this.notifyObservers(CHANGEMENT_ETAPES);
	}
	
	public void changementCase(int etat,int caractere,Case nouvelleCase){
		for(Turing e:vect){
			e.getCases()[etat][caractere]=nouvelleCase;
			this.setChanged();
			this.notifyObservers(CHANGEMENT_CASES);
			this.notifyObservers(CHANGEMENT_ETAPES);
		}
	}
	
	

}
