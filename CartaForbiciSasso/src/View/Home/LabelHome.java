package View.Home;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.border.Border;

import Controller.ActionListener.ActionListenerHome;

/**
 * Label che decora il frame della home.
 * Questa classe contiene:
 * - titolo del gioco
 * - bottoni per scegliere tra le modalita' Computer vs Computer, Umano vs Computer
 * - checkBox per scegliere la modalita' lizard-spock o classic
 * @author Davide Morelli
 *
 */
public class LabelHome extends JLabel {
	
	
	private static final long serialVersionUID = -2788958473708974327L;
	private JButton cvsc,cvsp;
	private JCheckBox classic,ls;
	private Border bordo=BorderFactory.createLineBorder(Color.WHITE, 5);
	public LabelHome() {
		super("Sasso carta forbici",new ImageIcon("Images\\Table_1.png"),CENTER);
		setLayout(null);
		
		//setTitle 
		setForeground(Color.WHITE);
		setFont(new Font("Sans-serif",Font.BOLD,100));
		setHorizontalTextPosition(CENTER);
		setVerticalTextPosition(TOP);
		setIconTextGap(-200);
		
		//buttons
		cvsp=new JButton("Umano vs Computer");
		cvsp.setBounds(445,300, 200, 100);     //200 250 375 500
		cvsp.setContentAreaFilled(false);
		cvsp.setFont(new Font("Sans-serif",Font.BOLD,15));
		cvsp.setForeground(Color.WHITE);
		cvsp.setBorder(bordo);
		cvsp.setFocusable(false);
		cvsp.addActionListener(ActionListenerHome.getInstance());
		add(cvsp);
		
		cvsc=new JButton("Computer vs Computer");
		cvsc.setBounds(445, 425, 200, 100);
		cvsc.setContentAreaFilled(false);
		cvsc.setFont(new Font("Sans-serif",Font.BOLD,15));
		cvsc.setForeground(Color.WHITE);
		cvsc.setBorder(bordo);
		cvsc.setFocusable(false);
		cvsc.addActionListener(ActionListenerHome.getInstance());
		add(cvsc);
		
		//checkbox
		
		classic=new JCheckBox("Classic");
		classic.setBounds(450, 200, 100, 20);
		classic.setFont(new Font("Sans-serif",Font.BOLD,20));
		classic.setForeground(Color.WHITE);
		classic.setOpaque(false);
		classic.setFocusable(false);
		classic.addActionListener(ActionListenerHome.getInstance());
		
		ls=new JCheckBox("Spock-Lizard");
		ls.setBounds(450, 250, 200, 23);
		ls.setOpaque(false);
		ls.setFont(new Font("Sans-serif",Font.BOLD,20));
		ls.setForeground(Color.WHITE);
		ls.setFocusable(false);
		ls.addActionListener(ActionListenerHome.getInstance());
		
		add(classic);
		add(ls);
		
		
	}

}
