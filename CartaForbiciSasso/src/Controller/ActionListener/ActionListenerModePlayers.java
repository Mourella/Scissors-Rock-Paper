package Controller.ActionListener;

import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Controller.ModePlayers.ModePlayers;
import View.GameStage.LabelGameStage;

/**
 * Classe astratta, fornisce il modello iniziale dei Action Listener di ogni interfaccia. Può essere
 * estesa da sottoclassi rappresentanti Listener piu' specifici
 * 
 * @author Davide Morelli
 *
 */
public abstract class ActionListenerModePlayers implements ActionListener {
	
	/**
	 * Contiene il controller della modalita' scelta dall'utente nella home.
	 * In questo caso Umano vs computer oppure Computer vs Computer
	 */
	protected ModePlayers typeController;
	
	/**
	 * Metodo con cui settare la modalita' scelta dall'utente nella home
	 * @param prende in input una sottoclasse di ControllerPlayers
	 */
	protected void setMod(ModePlayers pb) {
		this.typeController=pb;
	
	}
	
	/**
	 * Aggiorna la gui in base alla mossa eseguita dal P1 o P2
	 * @param place , parametro con cui identificare il giocatore a sinistra dello schermo P1 o a destra P2
	 */
	protected void updateActionBotGui(String place) {
		if (place=="Sx") {
			typeController.getModeGame().playBotP1();
			LabelGameStage.setActionSx(typeController.getModeGame().getActionP1().toString(),typeController.getModeGame().getActionP1().toString()+"Sx");	}
		else {
			typeController.getModeGame().playBotP2();
			LabelGameStage.setActionDx(typeController.getModeGame().getActionP2().toString(),typeController.getModeGame().getActionP2().toString()+"Dx");}
	}
	
	/**
	 * Aggiorna la gui con i nuovi punteggi dei giocatori. 
	 */
	protected void updateScoresGui() {
		if (typeController.getModeGame().updateScores()==1) LabelGameStage.setScore(typeController.getModeGame().getScoreP1(),1);
		LabelGameStage.setScore(typeController.getModeGame().getScoreP2(),-1);
		
	}
	
	/**
	 * Controlla se uno dei due giocatori ha vinto il game, ed in caso affermativo chiede se vuole giocare nuovamente. Aggiorna la gui
	 */
	protected void checkWin() {
		
		if(typeController.getModeGame().win()!=null) {
			var paneWin=new JOptionPane();
			int c=JOptionPane.showConfirmDialog(paneWin, typeController.getModeGame().win().getNickName().toUpperCase()+" "+"HA VINTO!\nVUOI GIOCARE ANCORA?", null, JOptionPane.YES_NO_OPTION);
			if (c==0) {
				typeController.getModeGame().playAgain(); 
				LabelGameStage.setScore(typeController.getModeGame().getScoreP1(),1);
				LabelGameStage.setScore(typeController.getModeGame().getScoreP2(),-1);
				LabelGameStage.setActionDx(" ", null);
				LabelGameStage.setActionSx(" ", null);
				LabelGameStage.setNumberGames(typeController.getModeGame().getNumberGames());
				
				}
				}
			}
	

}
