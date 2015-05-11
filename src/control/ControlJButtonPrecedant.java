package control;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import abstraction.MachineActuelle;

public class ControlJButtonPrecedant implements ActionListener, Observer {



	private MachineActuelle machine;
	private JButton bouton;
	private Frame parent;

	public ControlJButtonPrecedant(Frame parent,MachineActuelle machine,JButton bouton){
		this.parent=parent;
		this.machine=machine;
		this.bouton=bouton;
	}
	@Override
	public void update(Observable o, Object message) {
		Integer iMessage = (Integer) message;
		try{
			if(iMessage==MachineActuelle.CHANGEMENT_ETAPES||iMessage==MachineActuelle.CHANGEMENT_CASES){
				bouton.setEnabled(machine.getMachines().size()>1);
			}
			//parent.pack();
		}catch (Exception e1) {
			System.out.println(e1.getMessage());
			JOptionPane.showMessageDialog(parent, "La table a mal été définie, réaliser la modification et faites précédant pour recommencer",
					"Erreur!", JOptionPane.ERROR_MESSAGE);
		}

		}

		@Override
		public void actionPerformed(ActionEvent e) {
			machine.EtapePrecedante();


		}

	}
