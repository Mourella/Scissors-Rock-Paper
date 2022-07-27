package Controller.ActionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Controller.ModePlayers.BotVsBot;
import Controller.ModePlayers.RealPlayerVsBot;
import View.GameStage.FrameGameStage;
import Model.Players.*;
import Model.Game.*;

/**
 * Classe che implementa il listener della Home,dal quale l'utente sceglie se 
 * giocare contro il computer o meno e quale modalita': Classica o Lizard-Spock
 * Resa singleton per evitare di creare 
 * nuove istanze di questa classe ed usare sempre lo stesso Listener
 * @author Davide Morelli
 *
 */
public class ActionListenerHome implements ActionListener {
	//singleton
	private static ActionListenerHome instance;  
	private static RealPlayerVsBot rb; //rifermento alla modalita' Umano vs Computer
	private static BotVsBot bb;//rifermento alla modalita' Computer vs Computer
	private String mode;//Stringa che viene settata a Classic o Lizard-Spock in base alla scelta dell'utente effettuata sulla home

	public static ActionListenerHome getInstance() {
		if (instance==null) instance=new ActionListenerHome();
		return instance;
	}
	
	/**
	 * Override del metodo ActionPerformed
	 * Grazie a questo metodo, in base alle scelte effettuate dall'utente nella schermata di home, vengono avviate la modalita'
	 * Umano vs Computer(classic o Lizard-spock) oppure Computer vs Computer (classic o Lizard-Spock)
	 * 
	 * Nel caso in cui l'utente avvia la partita senza selezionare una delle due modalita' (Classic o Lizard-Spock) verra' mostrato un messaggio
	 * in cui si chiede esplicitamente di farlo.
	 *
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand()=="Classic") this.mode="Classic"; 
		else if (e.getActionCommand()=="Spock-Lizard") this.mode="Spock-Lizard";
		
		if (this.mode!=null) {
			switch(e.getActionCommand()) {
			case "Umano vs Computer" -> 
			{
				new JOptionPane();
				String nick=JOptionPane.showInputDialog("INSERISCI NICKNAME: ");
				RealPlayer real=new RealPlayer(nick.isEmpty()?"No name":nick); 
				BotPlayer bot=new BotPlayer();
				
				if (mode=="Classic") {
					mode=null;
					rb=new RealPlayerVsBot(new ClassicMode(real,bot)); 
					ActionListenerRealVsBot.getInstance().setMod(rb);
					new FrameGameStage(rb.getModeGame().getPlayers(1).getNickName(),rb.getModeGame().getPlayers(2).getNickName(),rb.getModeGame().getNumberGames(),true,true); // E' LA PRIMA PARTITA QUINDI METTO 0 sicuramente	
				}
				else {
					mode=null;
					rb=new RealPlayerVsBot(new LSMode(real,bot));
					ActionListenerRealVsBot.getInstance().setMod(rb);
					new FrameGameStage(rb.getModeGame().getPlayers(1).getNickName(),rb.getModeGame().getPlayers(2).getNickName(),rb.getModeGame().getNumberGames(),true,false);
				}
			}
			
			case "Computer vs Computer" -> {
				
				if (mode=="Classic") {
				mode=null;
				bb=new BotVsBot(new ClassicMode(new BotPlayer(),new BotPlayer()));
				ActionListenerBotVsBot.getInstance().setMod(bb);
				new FrameGameStage(bb.getModeGame().getPlayers(1).getNickName(),bb.getModeGame().getPlayers(2).getNickName(),bb.getModeGame().getNumberGames(),false,true);
				}
				
				else {
					bb=new BotVsBot(new LSMode(new BotPlayer(),new BotPlayer()));
					ActionListenerBotVsBot.getInstance().setMod(bb);
					new FrameGameStage(bb.getModeGame().getPlayers(1).getNickName(),bb.getModeGame().getPlayers(2).getNickName(),bb.getModeGame().getNumberGames(),false,false);
				}	
			}
			}
		}
		else {
			new JOptionPane();
			JOptionPane.showMessageDialog(null, "Devi selezionare una delle due modalità:\nClassic o Spock-Lizard");
			}
		}
}
