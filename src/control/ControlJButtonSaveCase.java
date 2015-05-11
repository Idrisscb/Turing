package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import abstraction.Case;
import abstraction.CaseDialog;
import abstraction.MachineActuelle;

public class ControlJButtonSaveCase implements ActionListener {
	private MachineActuelle machine;
	private CaseDialog parent;
	private int etat;
	private int caractere;
	
	public ControlJButtonSaveCase(CaseDialog parent,MachineActuelle machine,int etat,int caractere ){
		this.machine=machine;
		this.parent=parent;
		this.etat=etat;
		this.caractere=caractere;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Case c=new Case(parent.getSens(),Integer.parseInt(parent.getNouvelleAttribution()),Integer.parseInt(parent.getNouvelEtat()));
		parent.setVisible(false);
		machine.changementCase(etat, caractere,c);

	}

}
