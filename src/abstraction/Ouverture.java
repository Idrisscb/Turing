package abstraction;

import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.ControlJButtonOkDemarage;
import control.ControlJComboBoxChoix;

public class Ouverture extends JFrame{

	private static final long serialVersionUID = 1L;
	public Ouverture(){
		super("Démarage");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel frame=new JPanel(new GridLayout(5, 1));
		frame.add(new JLabel("Quel operation?"));
		
		Vector<String> data=new Vector<>();
		data.add("divise2");
		data.add("x2");
		data.add("+1");
		data.add("Nouveau");
		data.add("Autre...");
		JComboBox<String> choixMachine=new JComboBox<>(data);
		ControlJComboBoxChoix controlJComboBoxChoix=new ControlJComboBoxChoix(choixMachine,this);
		choixMachine.addActionListener(controlJComboBoxChoix);
		frame.add(choixMachine);
		frame.add(new JLabel("Quel mot? (ajoutez 0 au début du mot en cas de multiplication ou d'addition)"));
		JTextField mot=new JTextField();
		frame.add(mot);
		JButton ok=new JButton("Ok");
		ControlJButtonOkDemarage controlJButtonOkDemarage=new ControlJButtonOkDemarage(this, mot, choixMachine);
		ok.addActionListener(controlJButtonOkDemarage);
		frame.add(ok);
		this.getContentPane().add(frame);
		this.pack();
		
	}
	public static void main(String[] args) {
		Ouverture o=new Ouverture();
		o.setVisible(true);
	}

}
