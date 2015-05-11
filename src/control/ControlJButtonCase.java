package control;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

import abstraction.CaseDialog;
import abstraction.MachineActuelle;

public class ControlJButtonCase implements ActionListener, Observer {
	private MachineActuelle machine;
	public int etat;
	public int caractere;
	public JButton bouton;
	private Frame parent;
	
	public ControlJButtonCase(Frame parent,MachineActuelle machine, int etat,int caractere,JButton bouton){
		this.parent=parent;
		this.etat=etat;
		this.machine=machine;
		this.caractere=caractere;
		this.bouton=bouton;
		if(machine.getMachines().get(0).getCases()[etat][caractere]==null){
			bouton.setText("VIDE");
			
		}
		else{
			bouton.setText(machine.getMachines().get(0).getCases()[etat][caractere].toString());
		}
		
	}
	

	@Override
	public void update(Observable o, Object message) {
		Integer iMessage = (Integer) message;
		if(iMessage==MachineActuelle.CHANGEMENT_CASES||iMessage==MachineActuelle.CHANGEMENT_ETAPES){
			if(machine.getMachines().get(0).getCases()[etat][caractere]==null){
				bouton.setText("VIDE");
				
			}
			else{
				bouton.setText(machine.getMachines().get(0).getCases()[etat][caractere].toString());
				if(machine.getMachines().get(machine.getMachines().size()-1).hasNext()&&machine.getMachines().get(machine.getMachines().size()-1).getCaractereLu()==caractere&&machine.getMachines().get(machine.getMachines().size()-1).getEtatCourant()==etat){
					bouton.setBackground(Color.GREEN);
				}else{
					bouton.setBackground( Color.GRAY);
				}
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		CaseDialog caseD=new CaseDialog(parent, machine, etat, caractere);
		caseD.pack();
		caseD.setVisible(true);
		

	}

}
