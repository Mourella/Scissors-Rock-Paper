package Controller.ActionListener;

import java.awt.event.ActionEvent;



/**
 * Classe che implementa il Listener della modalita' Computer vs Computer. Resa singleton per evitare di creare 
 * nuove istanze di questa classe ed usare sempre lo stesso Listener
 * @author Davide Morelli
 *
 */
public class ActionListenerBotVsBot extends ActionListenerModePlayers{
	
	private static ActionListenerBotVsBot instance; 
	

	public static ActionListenerBotVsBot  getInstance() {
		if (instance==null) instance=new ActionListenerBotVsBot ();
		return instance;
	}

	/**
	 * ActionPerformed del bottone con cui l'utente fa giocare i due bot
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		updateActionBotGui("Sx"); //Fa giocare il bot nella posizione sinistra della schermata e aggiorna la gui
		updateActionBotGui("Dx"); //Fa giocare il bot nella posizione destra della schermata e aggiorna la gui
		updateScoresGui();// aggiorna gli scores
		checkWin(); //Controlla se uno dei due giocatori ha vinto il game, ed in caso affermativo chiede se vuole giocare nuovamente. Aggiorna la gui
	}
	

	
	
}
