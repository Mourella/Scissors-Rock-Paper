package View.GameStage;

import java.awt.Color;
import java.awt.Dimension;

import java.awt.Font;


import javax.swing.JButton;



import Controller.ActionListener.ActionListenerRealVsBot;

/**
 * Questa classe estende la classe LabelActions
 * Chiama il costruttore delle superclasse cosi' da ereditare da essa le decorazioni standard che deve avere la barra delle azioni.
 * In questo caso viene costruita una barra in base alla modalita' Spock-Lizard, con 5 bottoni (scissors-paper-rock-lizard-spock)
 * 
 * @author Davide Morelli
 *
 */
public class LabelLsActions extends LabelActions {

	private static final long serialVersionUID = 1L;
	
	
	
	//flag true mode RealBot  flag false mode BotBot
	public LabelLsActions(boolean flagMode) {
		super(flagMode);
		
		
		if (flagMode) {
			
			//qua poi modifichi
			JButton carta=new JButton("Paper");
			carta.setPreferredSize(new Dimension(100,40));
			carta.setFont(new Font("Sans-serif",Font.BOLD,15));
			carta.setContentAreaFilled(false);
			carta.setBorder(bordo);
			carta.setForeground(Color.WHITE);
			carta.setFocusable(false);
			JButton sasso=new JButton("Rock");
			sasso.setPreferredSize(new Dimension(100,40));
			sasso.setFont(new Font("Sans-serif",Font.BOLD,15));
			sasso.setContentAreaFilled(false);
			sasso.setBorder(bordo);
			sasso.setForeground(Color.WHITE);
			sasso.setFocusable(false);
			JButton forbice=new JButton("Scissors");
			forbice.setPreferredSize(new Dimension(100,40));
			forbice.setFont(new Font("Sans-serif",Font.BOLD,15));
			forbice.setContentAreaFilled(false);
			forbice.setBorder(bordo);
			forbice.setForeground(Color.WHITE);
			forbice.setFocusable(false);
			JButton lizard=new JButton("Lizard");
			lizard.setPreferredSize(new Dimension(100,40));
			lizard.setFont(new Font("Sans-serif",Font.BOLD,15));
			lizard.setContentAreaFilled(false);
			lizard.setBorder(bordo);
			lizard.setForeground(Color.WHITE);
			lizard.setFocusable(false);
			JButton spock=new JButton("Spock");
			spock.setPreferredSize(new Dimension(100,40));
			spock.setFont(new Font("Sans-serif",Font.BOLD,15));
			spock.setContentAreaFilled(false);
			spock.setBorder(bordo);
			spock.setForeground(Color.WHITE);
			spock.setFocusable(false);
			
			forbice.addActionListener(ActionListenerRealVsBot.getInstance());
			sasso.addActionListener(ActionListenerRealVsBot.getInstance());
			carta.addActionListener(ActionListenerRealVsBot.getInstance());
			spock.addActionListener(ActionListenerRealVsBot.getInstance());
			lizard.addActionListener(ActionListenerRealVsBot.getInstance());
			
			add(carta);
			add(sasso);
			add(forbice);
			add(lizard);
			add(spock);
			}
		
		else labelActionsCvsC();
		
	
	}
}
