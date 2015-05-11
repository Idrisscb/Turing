package control;


import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.JScrollPane;

import abstraction.MachineActuelle;
import abstraction.Turing;

public class ControlJListEtapes implements Observer {
	private MachineActuelle machine;
	private JList<String> liste;
	private JScrollPane scrollPane;
	
	public ControlJListEtapes(JScrollPane scrollPane, MachineActuelle machine,JList<String> liste){
		this.scrollPane=scrollPane;
		this.machine=machine;
		this.liste=liste;
		Vector<String> vect=new Vector<>();
		for(Turing e:machine.getMachines()) vect.add(e.toString());
		liste.setListData(vect);
		liste.repaint();
		
	}
	

	@Override
	public void update(Observable o, Object message) {
		Integer iMessage = (Integer) message;
		if(iMessage==MachineActuelle.CHANGEMENT_ETAPES){
			Vector<String> vect=new Vector<>();
			for(Turing e:machine.getMachines()) vect.add(e.toString());
			liste.setListData(vect);

			System.out.println(scrollPane.getVerticalScrollBar().getMaximum()+"   "+scrollPane.getVerticalScrollBar().getModel().getExtent());
			
			
		}

	}

}
