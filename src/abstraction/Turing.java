package abstraction;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Turing {
	private Case[][] cases;
	private ArrayList<Integer> mot;
	private int etatCourant;
	private int indexRuban;
	private ArrayList<Integer> etatsFinaux;
	static BufferedReader input =new BufferedReader (new InputStreamReader(System.in));

	public static String lireString() {
		System.out.flush();
		try {
			return input.readLine();
		} catch (Exception e) {
			return "";
		}
	}

	public Turing(Turing t){
		
		//Cr�er un clone de la machine d�j� existante
		cases=t.cases;
		//		mot=new ArrayList<>();
		//		mot.addAll(mot);
		mot=(ArrayList<Integer>) t.mot.clone();
		etatCourant=t.etatCourant;
		etatsFinaux=t.etatsFinaux;
		indexRuban=t.indexRuban;
	}

	public Case[][] getCases(){
		return cases;
	}
	public boolean hasNext() {
		try{
		if(etatsFinaux.contains(etatCourant)||cases[etatCourant][mot.get(indexRuban)]==null){
			//On v�rifie si l'etat dans lequel on se trouve est un �tat final,
			//ou si la case est vide (etat/caract�re lu non r�f�renc�), 
			//Dans ce cas, on renvoit false pour annoncer que l'execution est compl�te.
			if(etatsFinaux.contains(etatCourant)){
				System.out.println("Execution sans incidents");
			}
			else{
				System.out.println("Mot non conforme");
			}
			return false;
		}
		return true;
		}catch(Exception e){
			return false;
			
		}
		
	}
	
	public boolean completedWell(){
		//indique si 
		return etatsFinaux.contains(etatCourant);
	}
	public void next(){
		//Lecture de la case correspondante � l'�tat actuel, et au caract�re lu		
		Case caseCourante=cases[etatCourant][mot.get(indexRuban)];
		//modification du caract�re
		this.mot.set(indexRuban, caseCourante.getAttribution());
		//modification de l'etat
		this.etatCourant=caseCourante.getNouvelEtat();
		//d�placement vers la gauche(false) ou la droite(true)
		if(caseCourante.isSens()){
			this.indexRuban=Math.min(indexRuban+1, mot.size());
			if(this.indexRuban==mot.size()){
				//le 2 correspond au caract�re vide.
				mot.add(2);
			}
		}
		else{
			this.indexRuban=Math.max(indexRuban-1, 0);
		}
	}
	public ArrayList<Integer> getEtatsFinaux(){
		return this.etatsFinaux;
	}
	
	public Turing(String fichierALire, String mot1) {
		//cr�ation d'une machine en connaissant le mot
		
		

		try {
			//ouverture d'un fichier
			BufferedReader aLire=new BufferedReader( new FileReader(fichierALire));
			//cr�ation d'un tableau de case
			cases=new Case[Integer.parseInt(aLire.readLine())][Integer.parseInt(aLire.readLine())];
			//			String mot1=aLire.readLine();
			//			System.out.println("Quel mot?");
			//			mot1=lireString();
			aLire.readLine();
			//"conversion" du mot en ArrayList
			mot=new ArrayList<>();
			try{
			for(int i=0;i<mot1.length();i++){
				
				mot.add(Integer.parseInt(mot1.charAt(i)+""));
				
				
			}
			}catch(Exception e){
					JOptionPane.showMessageDialog(new JFrame(), "Le mot a mal �t� d�fini, r�aliser la modification en utilisant que des entiers compris entre 0 et 9 \n en fesant Fichier-> Changer le mot",
							"Erreur!", JOptionPane.ERROR_MESSAGE);
				}
			if(mot.size()==0){
				mot.add(2);
			}
			this.etatCourant=0;
			String ligne=aLire.readLine();
			String sens;
			int etatPresent;
			int caractereLu;

			//Cr�ation des cases
			do{
				etatPresent=Integer.parseInt(ligne);
				System.out.println(ligne);
				caractereLu=Integer.parseInt(aLire.readLine());
				System.out.println(caractereLu);
				sens=aLire.readLine();
				System.out.println(sens);

				cases[etatPresent][caractereLu]=new Case(Boolean.parseBoolean(sens),Integer.parseInt(aLire.readLine()),Integer.parseInt(aLire.readLine()));


				ligne=aLire.readLine();
			}while(!ligne.equals("fin"));
			ligne=aLire.readLine();
			etatsFinaux=new ArrayList<>();
			//r�f�rencement des �tats finaux
			do{
				
				etatsFinaux.add(Integer.parseInt(ligne));
				ligne=aLire.readLine();
			}while(!ligne.equals("fin"));
			aLire.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Turing(String mot1, int nbEtats, int nbCaract,
			ArrayList<Integer> etatsFinaux) {
		//permet de cr�er une machine sans r�f�rencer les cases au pr�alable.
		mot=new ArrayList<>();
		for(int i=0;i<mot1.length();i++){

			mot.add(Integer.parseInt(mot1.charAt(i)+""));
		}
		cases=new Case[nbEtats][nbCaract];
		this.etatsFinaux=etatsFinaux;
	}

	public void parcours(){
 
		while(this.hasNext()){
			this.next();
		}
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getMot()+"-----Etat actuel:"+etatCourant+"------Index Ruban"+indexRuban+"------caract�re lu:"+mot.get(indexRuban);
	}

	public String getMot() {
		String s="";
		for(int i=0;i<mot.size();i++){
			s+=mot.get(i);
		}
		return s;
	}
	public void setMot(ArrayList<Integer> mot){
		this.mot=mot;
	}
	public int getEtatCourant(){
		return this.etatCourant;
	}
	public int getCaractereLu(){
		return mot.get(indexRuban);
	}

//	public static void main(String[] args) {
//		Turing test=new Turing("Turing.txt");
//		test.parcours();
//		System.out.println(test.cases[2][4]);
//
//	}
}
