package Model.Game;

import java.util.Random;

import Model.Players.Players;

/**
 * Sottoclasse di ModeGame, rappresenta la modalita' lizard-spock
 * @author Davide Morelli
 *
 */

public class LSMode extends ModeGame<LSAction> {
	
	
	public LSMode(Players p1, Players p2) {
		super(p1, p2);		
	}
	/**
	 * Getter e setter che verranno implementati nelle sottoclassi in base alla enum
	 *  la caratterizza. In questo caso LSAction
	 */
	@Override
	public LSAction getActionP2() {
		return this.actionP2;
	}
	@Override
	public void setActionP2(Enum<?> actionP2) {
		this.actionP2=(LSAction) actionP2;
		
	}
	@Override
	public LSAction getActionP1() {
	
		return this.actionP1;
	}
	@Override
	public void setActionP1(Enum<?> actionP1) {
		this.actionP1=(LSAction) actionP1;
		
	}
	
	/**
	 * Metodo che chiama il compareAction della modalita' in questione, usato per decretare chi dei
	 * due players ha scelto la mossa vincente.
	 * Inoltre il metodo aggiorna gli scores personali dei due players, in caso di vittoria del round
	 */
	@Override 
	public int updateScores() {
			int result=(this.getActionP1()).compareAction(this.getActionP2()); 
			if (result==1) {this.setScoreP1(this.getScoreP1()+1);}
			else if (result==-1) {this.setScoreP2(this.getScoreP2()+1);}	
			return result;
	}
	
	/**
	 * Questo metodo
	 * fa giocare il player non umano P1, facendolo scegliere random tra le costanti delle enum.
	 */
	@Override
	public void playBotP1() {
		setArrayAction(LSAction.values());
		setActionP1(this.getArrayAction()[new Random().nextInt(0,this.getArrayAction().length)]);
		
	}
	/**
	 * Questo metodo
	 * fa giocare il player non umano P2, facendolo scegliere random tra le costanti delle enum.
	 */
	@Override
	public void playBotP2() {
		setArrayAction(LSAction.values());
		
		setActionP2(this.getArrayAction()[new Random().nextInt(0,this.getArrayAction().length)]);
	}
	/**
	 * Setta l'azione del player il quel round in base al bottone premuto in fase del gioco dall'utente
	 * @param input
	 */
	@Override
	public void setInputAction(String input) {
		switch(input) {
		case "Scissors" ->  setActionP1(LSAction.SCISSORS);
		case "Rock" -> 		setActionP1(LSAction.ROCK);
		case "Paper" ->  	setActionP1(LSAction.PAPER);
		case "Lizard" ->	setActionP1(LSAction.LIZARD);
		case "Spock" ->		setActionP1(LSAction.SPOCK);
		}	
		
	}


	
	
}
