package Controller.ActionListener;

import java.awt.event.ActionEvent;
import View.GameStage.LabelGameStage;

/**
 * Classe che implementa il Listener della modalita' Umano vs Computer. Resa singleton per evitare di creare 
 * nuove istanze di questa classe ed usare sempre lo stesso Listener
 * @author Davide Morelli
 *
 */
public class ActionListenerRealVsBot extends ActionListenerModePlayers {

	//singleton
	private static ActionListenerRealVsBot instance; 

	
	public static ActionListenerRealVsBot  getInstance() {
		if (instance==null) instance=new ActionListenerRealVsBot ();
		return instance;
	}
	
	private ActionListenerRealVsBot() {}
		

	/**
	 * Override del metodo actionPerfomed dell'interfaccia ActionListener
	 * In base al bottone premuto dall'utente, aggiorna il model riguardo la mossa scelta
	 * ed aggiorna la gui
	 * Questo actionPerformed è utile ad entrambe le modalita' Lizard-Spock e classica. Nel caso in
	 * cui si volesse estendere il gioco ad una nuova modalita' basta aggiungere altri case.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch(e.getActionCommand()) {
		case "Scissors" ->  {
			typeController.getModeGame().setInputAction("Scissors");
			LabelGameStage.setActionSx("SCISSORS","ScissorsSx");	
							}
		case "Rock" -> {
			typeController.getModeGame().setInputAction("Rock");
			LabelGameStage.setActionSx("ROCK","RockSx");
						}
		case "Paper" ->  {
			typeController.getModeGame().setInputAction("Paper");
			LabelGameStage.setActionSx("PAPER","PaperSx");
						}
		case "Lizard" ->	{
			typeController.getModeGame().setInputAction("Lizard");
			LabelGameStage.setActionSx("LIZARD","LizardSx");	
		}
		case "Spock" ->	{
			typeController.getModeGame().setInputAction("Spock");
			LabelGameStage.setActionSx("SPOCK","SpockSx");	
		}
		}
		
		updateActionBotGui("Dx"); //Fa giocare il bot nella posizione destra della schermata e aggiorna la gui
		updateScoresGui(); // aggiorna gli scores
		checkWin();	 //Controlla se uno dei due giocatori ha vinto il game, ed in caso affermativo chiede se vuole giocare nuovamente. Aggiorna la gui
	}
	
	}


