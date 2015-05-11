package control;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import abstraction.MainWindow;
import abstraction.Turing;

public class ControlJButtonOkSelectionEtatsFinaux implements ActionListener {
	private String mot;
	private int nbEtats;
	private int nbCaract;
	private Frame parent;
	private JCheckBox[] select;
	
	public ControlJButtonOkSelectionEtatsFinaux(Frame parent, String mot, int nbEtats, int nbCaract, JCheckBox[] select){
		this.mot=mot;
		this.parent=parent;
		this.nbCaract=nbCaract;
		this.nbEtats=nbEtats;
		this.select=select;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ArrayList<Integer> etatsFinaux=new ArrayList<>();
		for(int i=0;i<nbEtats+3;i++){
			if(select[i].isSelected())etatsFinaux.add(i);
		}
		Turing t=new Turing(mot,nbEtats,nbCaract,etatsFinaux);
		parent.setVisible(false);
		MainWindow fen=new MainWindow(t);
		fen.pack();
		fen.setVisible(true);
		

	}

}
