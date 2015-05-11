package abstraction;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import control.ControlJButtonCase;
import control.ControlJButtonEtatFinal;
import control.ControlJButtonFinir;
import control.ControlJButtonPrecedant;
import control.ControlJButtonSuivant;
import control.ControlJListEtapes;
import control.ControlJMenuItemChangerMot;
import control.ControlJMenuItemEnregistrer;
import control.ControlJMenuItemNouveau;
import control.ControlJTextFieldMot;
import abstraction.MachineActuelle;


public class MainWindow extends JFrame{
	private static final long serialVersionUID = 1L;
	private MachineActuelle machines;
	
	public MachineActuelle getMachines(){
		return this.machines;
	}
	
	
	public MainWindow(Turing machine){
		super("Turing");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		machines=new MachineActuelle(machine);
		this.getContentPane().setLayout(new BorderLayout());
		//this.setPreferredSize(new Dimension(500, 300));
		this.creerCentre();
		this.creerWest();
		this.creerNorth();
		this.creerSouth();
		this.creerMenu();
		machines.init();
		
	}

	private void creerNorth() {
		JPanel north=new JPanel(new GridLayout(1, 2));	
		
		JButton precedant=new JButton("<-precedant");
		north.add(precedant);
		ControlJButtonPrecedant controlJButtonPrecedant=new ControlJButtonPrecedant(this, machines, precedant);
		precedant.addActionListener(controlJButtonPrecedant);
		this.machines.addObserver(controlJButtonPrecedant);
		precedant.setEnabled(false);
		JButton suivant=new JButton("suivant->");
		north.add(suivant);
		if(!this.machines.getMachines().get(0).hasNext())suivant.setEnabled(false);
		ControlJButtonSuivant controlButtonSuivant=new ControlJButtonSuivant(this,machines, suivant);
		suivant.addActionListener(controlButtonSuivant);
		this.machines.addObserver(controlButtonSuivant);
		
		this.getContentPane().add(north,BorderLayout.NORTH);
		
		
		
		
		
		
		
	}

	private void creerWest() {
		JPanel panelWest=new JPanel();
		
		JList<String> etapes=new JList<>();
		JScrollPane scrollPane=new JScrollPane(etapes);
		ControlJListEtapes controlJListEtapes= new ControlJListEtapes(scrollPane,machines, etapes);
		System.out.println(controlJListEtapes);
		this.machines.addObserver(controlJListEtapes);
		
		
		panelWest.add(scrollPane);
		this.getContentPane().add(panelWest,BorderLayout.WEST);
		
		
		
	}

	private void creerCentre() {
		
		int nbLignes=machines.getMachines().get(0).getCases().length;
		int nbCol=machines.getMachines().get(0).getCases()[0].length;
		
		JPanel centre2=new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
				c.fill=GridBagConstraints.NONE;
				c.gridx = 0;
				c.gridy = 0;
				
		centre2.add(new JLabel("etat\\caractere lu"),c);
//		JPanel haut=new JPanel(new GridLayout(1, nbCol));
		for(int i=0;i<nbCol;i++){
			c.gridx=i+1;
			c.gridy=0;
			c.weightx=1.0;
			//c.gridwidth=nbCol;
			centre2.add(new JLabel(i+""),c);
		}
//		c.gridx=1;
//		c.gridy=0;
//		c.gridwidth=nbCol;
//		centre2.add(haut,c);
		
//		JPanel gauche=new JPanel(new GridLayout(nbLignes, 1));
		for(int i=0;i<nbLignes;i++){
			c.gridx=0;
			c.gridy=i+1;
			c.weighty=1.0;
			centre2.add(new JLabel(i+""),c);
		}
		
//		centre2.add(gauche,c);
		
		JPanel centre=new JPanel(new GridLayout(nbLignes, nbCol));
		c.gridx=1;
		c.gridy=1;
		c.gridwidth=nbCol;
		c.gridheight=nbLignes;
		
		centre2.add(centre,c);
		
		JButton[][] boutons=new JButton[nbLignes][nbCol];
		
		for(int i=0;i<nbLignes;i++){
			for(int j=0;j<nbCol;j++){
				boutons[i][j]=new JButton();
				ControlJButtonCase controlJButtonCase=new ControlJButtonCase(this,machines, i, j, boutons[i][j]);
				boutons[i][j].addActionListener(controlJButtonCase);
				this.machines.addObserver(controlJButtonCase);
				boutons[i][j].setBackground( Color.GRAY);
				centre.add(boutons[i][j]);
				
			}
		}
		
		
		
		
		
		this.getContentPane().add(centre2,BorderLayout.CENTER);
	}
	private void creerSouth(){
		JPanel frame=new JPanel(new GridLayout(3,1));
		this.getContentPane().add(frame,BorderLayout.SOUTH);
		frame.add(new JLabel("Avancement du mot :"));
		JTextField mot=new JTextField();
		
		frame.add(mot);
		mot.setEditable(false);
		ControlJTextFieldMot controlJTextFieldMot=new ControlJTextFieldMot(machines,mot);
		this.machines.addObserver(controlJTextFieldMot);
		JPanel frameBasse=new JPanel();
		JButton finir=new JButton("Finir");
		frameBasse.add(finir);
		ControlJButtonFinir controlJButtonFinir=new ControlJButtonFinir(this, machines, finir);
		finir.addActionListener(controlJButtonFinir);
		this.machines.addObserver(controlJButtonFinir);
		JButton etatFinal=new JButton();
		frameBasse.add(etatFinal);
		etatFinal.setVisible(false);
		this.machines.addObserver(new ControlJButtonEtatFinal(etatFinal, machines));
		frame.add(frameBasse);
		
		
	}
	private void creerMenu(){
		JMenuBar barreMenu = new JMenuBar();
		this.setJMenuBar(barreMenu);
		JMenu fichier = new JMenu("Fichier");
		barreMenu.add(fichier);
		JMenuItem nouveau = new JMenuItem("Nouveau");
		nouveau.setMnemonic('n');
		fichier.add(nouveau);
		ControlJMenuItemNouveau controlJMenuItemNouveau=new ControlJMenuItemNouveau(this);
		nouveau.addActionListener(controlJMenuItemNouveau);
		JMenuItem enregistrer = new JMenuItem("Enregistrer");
		fichier.add(enregistrer);
		ControlJMenuItemEnregistrer controlJMenuItemEnregistrer=new ControlJMenuItemEnregistrer(machines, this);
		enregistrer.addActionListener(controlJMenuItemEnregistrer);
		JMenuItem changerMot=new JMenuItem("Changer le mot");
		fichier.add(changerMot);
		ControlJMenuItemChangerMot controlJMenuItemChangerMot=new ControlJMenuItemChangerMot(machines);
		changerMot.addActionListener(controlJMenuItemChangerMot);
	}
	
//	public static void main(String[] args) {
//		Turing test=new Turing("x2.txt");
//		MainWindow fen=new MainWindow(test);
//		fen.pack();
//		fen.setVisible(true);
//	}

}
