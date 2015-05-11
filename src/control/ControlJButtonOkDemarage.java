package control;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import abstraction.MainWindow;
import abstraction.NouvelleMachine;
import abstraction.Turing;

public class ControlJButtonOkDemarage implements ActionListener {
	private JTextField mot;
	private JComboBox<String> choixMachine;
	private Frame parent;
	
	public ControlJButtonOkDemarage(Frame parent, JTextField mot, JComboBox<String> choixMachine){
		this.mot=mot;
		this.choixMachine=choixMachine;
		this.parent=parent;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(!((String)choixMachine.getSelectedItem()).equals("Nouveau")){
			Turing t=new Turing((String)choixMachine.getSelectedItem()+".txt",mot.getText());
			parent.setVisible(false);
			MainWindow fen=new MainWindow(t);
			fen.pack();
			fen.setVisible(true);
			
		}
		else{
			NouvelleMachine n=new NouvelleMachine(mot.getText());
			n.pack();
			n.setVisible(true);
			parent.setVisible(false);
		}

	}

}
