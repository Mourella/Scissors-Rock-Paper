package View.GameStage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.Border;

import Controller.ActionListener.ActionListenerBotVsBot;

/**
 * Questa classe astratta impone alcune decorazioni che le label  contenenti i bottoni
 * delle mosse devono avere.
 * La scelta' di farla astratta permette di creare piu' sottoclassi diverse che modellano la modalita' 
 * a cui fanno riferimento.
 * @author Davide Morelli
 *
 */
public abstract class LabelActions extends JLabel {
	private static final long serialVersionUID = -763606645381968097L;
	protected Border bordo=BorderFactory.createLineBorder(Color.WHITE, 3);
	
	/**
	 * Il costruttore prende in input il
	 * @param flagPlayer grazie al quale viene identificata la modalita' Computer vs computer o Umano vs Computer
	 * ed assegnata di conseguenza la barra delle azioni giusta.
	 * flag true mode RealBot  flag false mode BotBot
	 */
	public LabelActions(boolean flagPlayer) {
		super(new ImageIcon("Images\\LD.png"));
		setLayout(new FlowLayout(FlowLayout.CENTER,50,3));
		setOpaque(true);
		setPreferredSize(new Dimension(0,55));
		setBorder(bordo);
		
	}

	/**
	 * Questo metodo è unico per tutte le sottoclassi in quanto 
	 * modella la barra delle azioni nella modalita' Computer vs computer pertanto conterra' sempre
	 * e solo un bottone
	 */
	protected void labelActionsCvsC() {
		JButton nextRound=new JButton("Next round");
		nextRound.setPreferredSize(new Dimension(100,40));
		nextRound.setFont(new Font("Sans-serif",Font.BOLD,15));
		nextRound.setContentAreaFilled(false);
		nextRound.setBorder(bordo);
		nextRound.setForeground(Color.WHITE);
		nextRound.addActionListener(ActionListenerBotVsBot.getInstance());
		nextRound.setFocusable(false);
		add(nextRound);
	}
}
