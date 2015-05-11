package abstraction;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import control.ControlJButtonSaveCase;



public class CaseDialog extends JDialog{
	private static final long serialVersionUID = 1L;

	private JTextField nouvelleAttribution;
	private JTextField nouvelEtat;
	private ButtonGroup sens;
	private JRadioButton gauche;
	private JRadioButton droite;

	public boolean getSens(){


		return droite.isSelected();
	}
	public String getNouvelEtat(){
		return nouvelEtat.getText();
	}
	public String getNouvelleAttribution(){
		return nouvelleAttribution.getText();
	}

	public CaseDialog(Frame parent,MachineActuelle machine, int etatActuel, int caractereLu){
		super(parent,"Lecture de "+caractereLu+" dans l'état "+etatActuel,true);
		this.getContentPane().setLayout(new GridLayout(1, 3));
		this.setMinimumSize(new Dimension(200, 100));
		Case caseActuelle=machine.getMachines().get(0).getCases()[etatActuel][caractereLu];
		JPanel form = new JPanel(new GridLayout(8, 1));
		form.setBorder(BorderFactory.createEmptyBorder(6, 6, 6, 3));
		form.add(new JLabel("Ecriture"));
		nouvelleAttribution=new JTextField();
		form.add(nouvelleAttribution);
		form.add(new JLabel("Nouvel Etat"));
		nouvelEtat=new JTextField();
		form.add(nouvelEtat);
		form.add(new JLabel("Sens"));
		sens=new ButtonGroup();
		gauche=new JRadioButton("Gauche");
		sens.add(gauche);
		droite=new JRadioButton("Droite");
		sens.add(droite);
		form.add(gauche);
		form.add(droite);
		if(caseActuelle!=null){
			nouvelleAttribution.setText(caseActuelle.getAttribution()+"");
			nouvelEtat.setText(caseActuelle.getNouvelEtat()+"");
			if(caseActuelle.isSens()){
				droite.setSelected(true);
			}
			else{
				gauche.setSelected(true);
			}
		}
		JPanel buttons = new JPanel();
		JButton save = new JButton("OK");
		save.addActionListener(new ControlJButtonSaveCase(this, machine,etatActuel,caractereLu));
		buttons.add(save);
		form.add(buttons);

		this.getContentPane().add(form);

	}

}
