package abstraction;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import control.ControlJButtonOkNouvelleMachine;

public class NouvelleMachine extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	public NouvelleMachine(String mot){
		super("Nouvelle Machine");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel frame=new JPanel(new GridLayout(5, 1));
		JPanel panneau1=new JPanel(new GridLayout(1,2));
		frame.add(panneau1);
		panneau1.add(new JLabel("Mot"));
		JTextField fieldMot=new JTextField(mot);
		fieldMot.setEditable(false);
		panneau1.add(fieldMot);
		JPanel panneau2=new JPanel(new GridLayout(1, 4));
		panneau2.add(new JLabel("Nombre d'etats possible"));
		SpinnerNumberModel nbEtats = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
		JSpinner spinnerEtats=new JSpinner(nbEtats);
		panneau2.add(spinnerEtats);
		panneau2.add(new JLabel("Nombre de caractères"));
		SpinnerNumberModel nbCaracteres = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
		JSpinner spinnerCaracteres=new JSpinner(nbCaracteres);
		panneau2.add(spinnerCaracteres);
		frame.add(panneau2);
//		frame.add(new JLabel("Etats Finaux"));
//		JTextArea etatsFinaux=new JTextArea();
//		frame.add(etatsFinaux);
//		etatsFinaux.get
		JButton ok=new JButton("Ok");
		ControlJButtonOkNouvelleMachine controlJButtonOkNouvelleMachine=new ControlJButtonOkNouvelleMachine(this, mot,spinnerEtats, spinnerCaracteres);
		ok.addActionListener(controlJButtonOkNouvelleMachine);
		frame.add(ok);
		this.getContentPane().add(frame);
	}
}
