/**
 * @author Marcel Koppensteiner
 * @version 2015 - 09 - 15
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Schülerdaten extends JFrame implements ActionListener {
	
	JPanel main;
	JPanel p;
	JPanel jp;
	JPanel op;
	
	JLabel schülerdaten;
	JLabel famname;
	JLabel vorname;
	JLabel geschlecht;
	JLabel gebdatum;
	
	JTextField fn;
	JTextField vn;
	JTextField gebdat;
	
	JRadioButton m;
	JRadioButton w;
	
	JButton reset;
	JButton ok;
	JButton exit;
	
	public Schülerdaten () {
	
		setTitle ("Schülerdaten");
		pack();
//		setLocationRelativeTo(null);
		setSize (500,300);
		
		main = new JPanel ();
		main.setLayout(new BorderLayout());
		add (main);
		
		
		op = new JPanel ();
		schülerdaten = new JLabel ("Schülerdaten");
		schülerdaten.setFont(new Font("Arial", Font.PLAIN, 28));
		op.add(schülerdaten);
		main.add(op,BorderLayout.NORTH);
		
		jp = new JPanel ();
		jp.setLayout(new BoxLayout(jp,BoxLayout.X_AXIS));
		main.add(jp,BorderLayout.SOUTH);
		
		
		p = new JPanel ();
		p.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		main.add(p);
		
		// JLABELS WERDEN DEKLARIERT
		JLabel famname = new JLabel ("Familienname: ");
		JLabel vorname = new JLabel ("Vorname: ");
		JLabel geschlecht = new JLabel ("Geschlecht: ");
		JLabel gebdatum = new JLabel ("Geburtsdatum: ");
		
		gbc.gridx=0;
		gbc.gridy=0;
		p.add(famname,gbc);
		
		gbc.gridx=0;
		gbc.gridy=1;
		p.add(vorname, gbc);
		
		gbc.gridx=0;
		gbc.gridy=2;
		gbc.anchor = GridBagConstraints.LINE_START;
		p.add(geschlecht, gbc);
		
		gbc.gridx=0;
		gbc.gridy=4;
		p.add(gebdatum, gbc);
		
		
		// TEXTFIELD´S WERDEN DEKLARIERT
		fn = new JTextField (30);
		vn = new JTextField (15);
		gebdat = new JTextField (15);
		
		gbc.gridx=1;
		gbc.gridy=0;
		p.add(fn, gbc);
		
		gbc.gridx=1;
		gbc.gridy=1;
		p.add(vn, gbc);
		
		gbc.gridx=1;
		gbc.gridy=4;
		p.add(gebdat, gbc);
		
		
		
		m = new JRadioButton("männlich");
		w = new JRadioButton ("weiblich");
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(m);
		bg.add(w);
		
		gbc.gridx=1;
		gbc.gridy=2;
		p.add(m, gbc);
		
		gbc.gridx=1;
		gbc.gridy=3;
		p.add(w, gbc);
			
		
		// BUTTONS DEKLARIEREN 
		reset = new JButton ("reset");
		ok = new JButton ("ok");
		exit = new JButton ("exit");
		
		// BUTTONS HINZUFÜGEN
//		jp.add(Box.createRigidArea(new Dimension(20,0)));
		jp.add(Box.createHorizontalGlue());
		jp.add(reset);
		jp.add(Box.createRigidArea(new Dimension(20,0)));
		jp.add(Box.createHorizontalGlue());
		jp.add(ok);
		jp.add(Box.createRigidArea(new Dimension(20,0)));
		jp.add(Box.createHorizontalGlue());
		jp.add(exit);
		jp.add(Box.createHorizontalGlue());
		
		//	FABE VOM PANEL SETZEN
		jp.setBackground(Color.BLUE);
		
		
		// ACTIONLISTENER HINZUFÜGEN
		
		reset.addActionListener(this);
		exit.addActionListener(this);
		ok.addActionListener(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	public static void main (String[]args) {
		Schülerdaten sd = new Schülerdaten();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==reset) {
			fn.setText(null);
			vn.setText(null);
			m.setSelected(false);
			w.setSelected(false);
			gebdat.setText(null);
		}
			if (e.getSource()==ok) {
				String s = fn.getText();
				System.out.println("Familienname: " + s);
				String s1 = vn.getText();
				System.out.println ("Vorname: " + s1);
				
				
				// GESCHLECHT
				if (m.isSelected()) {
					System.out.println ("Geschlecht: männlich");
				}else {
					if (w.isSelected()) {
						System.out.println ("Geschlecht: weiblich");
					}
				}
			
				
				// GEBURTSDATUM
				SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
				try {
					Date date = sdf.parse(gebdat.getText());
					GregorianCalendar g = new GregorianCalendar();
					g.setTime(date);
					int i = g.get(GregorianCalendar.DAY_OF_MONTH);
					int x = g.get (GregorianCalendar.YEAR);
					int z = g.get (GregorianCalendar.MONTH);
					
					String s4 = String.valueOf(i);
					String r = String.valueOf(x);
					String u = String.valueOf(z);
					
					String m = "";
					
					if(z==0) {
						m = "Jänner";
					}if (z==1) {
						m = "Februar";
					}if (z==2) {
						m = "März";
					}if (z==3){
						m = "April";
					}if (z==4) {
						m = "Mai";
					}if (z==5){
						m = "Juni";						
					}if (z==6){
						m = "Juli";
					}if (z==7){
						m = "August";
					}if (z==8){
						m = "September";
					}if (z==9){
						m = "Oktober";
					}if (z==10){
						m = "November";
					}if (z==11){
						m = "Dezember";
					}System.out.println ("Geburtsdatum: " + s4+"."+m+" "+r);
					System.out.println (" ");
									
				} catch (ParseException pe) {
					// TODO Auto-generated catch block
					pe.printStackTrace();
				}	

			}
		
		if (e.getSource()==exit) {
			System.exit(0);
		}
		repaint();	
		}
		
	}


