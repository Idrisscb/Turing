package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import abstraction.MachineActuelle;

public class ControlJMenuItemChangerMot implements ActionListener {
	private MachineActuelle machine;

	public ControlJMenuItemChangerMot(MachineActuelle machine) {
		this.machine=machine;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String mot = JOptionPane.showInputDialog("Quel mot?", machine.getMachines().get(0).getMot());
		try{
		machine.changerMot(mot);
		}catch(Exception e1){
			
		}
		
	}

}
