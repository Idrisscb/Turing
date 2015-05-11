package control;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import abstraction.Ouverture;

public class ControlJMenuItemNouveau implements ActionListener {
	private Frame parent;
	public ControlJMenuItemNouveau(Frame parent){
		this.parent=parent;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		parent.setVisible(false);
		Ouverture o=new Ouverture();
		o.setVisible(true);
		o.pack();

	}

}
