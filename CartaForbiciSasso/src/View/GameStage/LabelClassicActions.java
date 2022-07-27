package View.GameStage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import Controller.ActionListener.ActionListenerRealVsBot;

/**
 * Questa classe estende la classe LabelActions
 * Chiama il costruttore delle superclasse cosi' da ereditare da essa le decorazioni standard che deve avere la barra delle azioni.
 * In questo caso viene costruita una barra in base alla modalita' classic con 3 bottoni (scissors-paper-rock)
 * @author Davide Morelli
 *
 */
public class LabelClassicActions extends LabelActions {
	
	private static final long serialVersionUID = 8232796119661671073L;


	//flag true mode RealBot  flag false mode BotBot
	public LabelClassicActions(boolean flagMode) {
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
			
			forbice.addActionListener(ActionListenerRealVsBot.getInstance());
			sasso.addActionListener(ActionListenerRealVsBot.getInstance());
			carta.addActionListener(ActionListenerRealVsBot.getInstance());
			
			add(carta);
			add(sasso);
			add(forbice);
			}
		else labelActionsCvsC();
	
		
		
		
	}

}
