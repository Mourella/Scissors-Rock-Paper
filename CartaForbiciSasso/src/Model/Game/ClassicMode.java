package Model.Game;

import java.util.Random;

import Model.Players.Players;


/**
 * Sottoclasse di ModeGame, rappresenta la modalita' classica
 * @author Davide Morelli
 *
 */
public class ClassicMode extends ModeGame<ClassicAction> {

	public ClassicMode(Players p1, Players p2) {
		super(p1, p2);
	}

	/**
	 * Getter e setter che verranno implementati nelle sottoclassi in base alla enum
	 *  la caratterizza. In questo caso ClassicAction
	 */
	@Override
	public void setActionP1(Enum<?> actionP1) {
		this.actionP1=(ClassicAction) actionP1;
		
	}

	@Override
	public void setActionP2(Enum<?> actionP2) {
		this.actionP2=(ClassicAction) actionP2;
		
	}

	@Override
	public ClassicAction getActionP1() {
		return this.actionP1;
	}

	@Override
	public ClassicAction getActionP2() {
		return this.actionP2;
	}

	/**
	 * Metodo che chiama il compareAction della modalita' in questione, usato per decretare chi dei
	 * due players ha scelto la mossa vincente.
	 * Inoltre il metodo aggiorna gli scores personali dei due players, in caso di vittoria del round
	 */
	@Override
	public int updateScores() {
			int result=(this.getActionP1()).compareAction(this.getActionP2()); //calcola e corregge lo score
			if (result==1) {this.setScoreP1(this.getScoreP1()+1);}
			else if (result==-1) {this.setScoreP2(this.getScoreP2()+1);}	
			return result;
	}

	/**
	 * Questo metodo che verra' implementato nelle sottoclassi che rappresentano la modalita' scelta
	 * fa giocare il player non umano P1, facendolo scegliere random tra le costanti delle enum.
	 */
	@Override
	public void playBotP1() {
		setArrayAction(ClassicAction.values());
		setActionP1(this.getArrayAction()[new Random().nextInt(0,this.getArrayAction().length)]);
		
	}
	/**
	 * Questo metodo che verra' implementato nelle sottoclassi che rappresentano la modalita' scelta
	 * fa giocare il player non umano P2, facendolo scegliere random tra le costanti delle enum.
	 */
	@Override
	public void playBotP2() {
		setArrayAction(ClassicAction.values());
		setActionP2(this.getArrayAction()[new Random().nextInt(0,this.getArrayAction().length)]);
	}
	/**
	 * Setta l'azione del player il quel round in base al bottone premuto in fase del gioco dall'utente
	 * @param input
	 */
	@Override
	public void setInputAction(String input) {
		switch(input) {
		case "Scissors" ->  setActionP1(ClassicAction.SCISSORS);
		case "Rock" -> setActionP1(ClassicAction.ROCK);
		case "Paper" ->  setActionP1(ClassicAction.PAPER);
		}	
	}

	
		
	}	
	
