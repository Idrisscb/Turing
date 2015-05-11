package control;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSpinner;
import abstraction.SelectionEtatsFinaux;

public class ControlJButtonOkNouvelleMachine implements ActionListener {
	private String mot;
	private JSpinner nbEtats;
	private JSpinner nbCaract;
	private Frame parent;
	
	public ControlJButtonOkNouvelleMachine(Frame parent, String mot, JSpinner nbEtats, JSpinner nbCaract){
		this.mot=mot;
		this.parent=parent;
		this.nbCaract=nbCaract;
		this.nbEtats=nbEtats;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		SelectionEtatsFinaux s=new SelectionEtatsFinaux(mot, (Integer)nbEtats.getValue(), (Integer)nbCaract.getValue());
		s.setVisible(true);
		s.pack();
		parent.setVisible(false);

	}

}
