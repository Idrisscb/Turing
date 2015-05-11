package control;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

public class ControlJComboBoxChoix implements ActionListener{
	private JComboBox<String> choix;
	private Frame parent;

	public ControlJComboBoxChoix(JComboBox<String> choix,Frame parent){
		this.choix=choix;
		this.parent=parent;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(((String)choix.getSelectedItem()).equals("Autre...")){
			JFileChooser choixNom = new JFileChooser();
			choixNom.addChoosableFileFilter(new FiltreTexte());
			choixNom.setAcceptAllFileFilterUsed(false);
			choixNom.setFileSelectionMode(JFileChooser.FILES_ONLY);
			int bouton = choixNom.showOpenDialog(parent);
			if (bouton == JFileChooser.APPROVE_OPTION) {
				String fichier=choixNom.getSelectedFile().toString().substring(0, choixNom.getSelectedFile().toString().length()-4);
				choix.addItem(fichier);
				choix.setSelectedIndex(choix.getItemCount()-1);
			}
		}

	}

}

