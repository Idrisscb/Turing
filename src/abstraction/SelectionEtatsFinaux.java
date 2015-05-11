package abstraction;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


import control.ControlJButtonOkSelectionEtatsFinaux;

public class SelectionEtatsFinaux extends JFrame{

	private static final long serialVersionUID = 1L;

	public SelectionEtatsFinaux(String mot, int nbEtats,int nbCaract){
		super("Etats Finaux");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel panel=new JPanel(new GridLayout(3, 1));
		panel.add(new JLabel(nbEtats+" etats possible, indiquez les états finaux"));
		JPanel selection=new JPanel(new GridLayout(nbEtats, nbEtats/3+2));
		panel.add(selection);
		JCheckBox[] select=new JCheckBox[nbEtats+3];
		for(int i=0;i<nbEtats+3;i++){
			select[i]=new JCheckBox(i+"");
			selection.add(select[i]);
		}
		JButton ok=new JButton("Ok");
		panel.add(ok);
		ControlJButtonOkSelectionEtatsFinaux controlJButtonOkSelectionEtatsFinaux=new ControlJButtonOkSelectionEtatsFinaux(this, mot, nbEtats, nbCaract, select);
		ok.addActionListener(controlJButtonOkSelectionEtatsFinaux);
		this.getContentPane().add(panel);
	}

}
