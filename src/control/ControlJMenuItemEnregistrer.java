package control;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

import abstraction.Case;
import abstraction.MachineActuelle;
import abstraction.Turing;

public class ControlJMenuItemEnregistrer implements ActionListener {
	private MachineActuelle machine;
	private Frame parent;

	public ControlJMenuItemEnregistrer(MachineActuelle machine,Frame parent){
		this.machine=machine;
		this.parent=parent;



	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JFileChooser choixNom = new JFileChooser();
		choixNom.addChoosableFileFilter(new FiltreTexte());
		choixNom.setAcceptAllFileFilterUsed(false);
		choixNom.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int bouton = choixNom.showSaveDialog(parent);
		if (bouton == JFileChooser.APPROVE_OPTION) {
			Turing t=machine.getMachines().get(0);
			Case[][] c=t.getCases();
			try {
				BufferedWriter out = new BufferedWriter(new FileWriter(choixNom.getSelectedFile()));
				out.write(c.length+"");
				out.newLine();
				out.write(c[0].length+"");out.newLine();
				out.write("0"+"");out.newLine();
				for(int i=0;i<c.length;i++){
					for(int j=0;j<c[0].length;j++){
						if(c[i][j]!=null){
							out.write(i+"");out.newLine();
							out.write(j+"");out.newLine();
							out.write(c[i][j].isSens()+""+"");out.newLine();
							out.write(c[i][j].getAttribution()+"");out.newLine();
							out.write(c[i][j].getNouvelEtat()+"");out.newLine();
						}
					}
				}
				out.write("fin"+"");out.newLine();
				ArrayList<Integer> f=t.getEtatsFinaux();
				for(int i=0;i<f.size();i++){
					out.write(f.get(i)+"");out.newLine();
				}
				out.write("fin"+"");
				
				out.close();
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 

		}

	}
}

class FiltreTexte extends FileFilter {
	public boolean accept(File f) {
		return f.getName().toLowerCase().endsWith("txt");
	}
	public String getDescription() {
		return "Fichiers texte";
	}
}