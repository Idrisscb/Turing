package control;


import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;

import abstraction.MachineActuelle;

public class ControlJTextFieldMot implements Observer{
	private MachineActuelle machines;
	private JTextField mot;
	public ControlJTextFieldMot(MachineActuelle machines, JTextField mot) {
		this.mot=mot;
		this.machines=machines;
	}
	
	
	@Override
	public void update(Observable o, Object message) {
		Integer iMessage=(Integer)message;
		if(iMessage==MachineActuelle.CHANGEMENT_ETAPES){
			mot.setText(machines.getMachines().get(machines.getMachines().size()-1).getMot());
		}
		
	}

}
