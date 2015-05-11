package control;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;

import abstraction.MachineActuelle;

public class ControlJButtonEtatFinal implements Observer{
	private JButton bouton;
	private MachineActuelle machine;
	
	public ControlJButtonEtatFinal(JButton bouton, MachineActuelle machine) {
		this.bouton=bouton;
		this.machine=machine;
		
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if(!machine.getMachines().get(machine.getMachines().size()-1).hasNext()){
			bouton.setVisible(true);
			//bouton.setEnabled(false);
			if(machine.getMachines().get(machine.getMachines().size()-1).completedWell()){
				bouton.setBackground(Color.GREEN);
				bouton.setText("Mot Correct");
				bouton.setForeground(Color.BLACK);
			}
			else{
				bouton.setBackground(Color.RED);
				bouton.setText("Mot Incorrect");
				bouton.setForeground(Color.BLACK);
			}
		}
		else{
			bouton.setVisible(false);
		}
		
	}
	
	

}
