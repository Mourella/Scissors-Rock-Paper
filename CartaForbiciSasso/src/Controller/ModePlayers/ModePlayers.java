package Controller.ModePlayers;

import Model.Game.ModeGame;

/**
 *Classe astratta che modella i controller delle varie modalita'
 * @author Davide Morelli
 *
 */
public abstract class ModePlayers {
	
	/**
	 * Questo campo contiene la modalita' scelta dall'utente
	 * Classica oppure  Rock, paper, scissors, lizard and Spock
	 */
	private final ModeGame<?> modeGame;

	/**
	 * Costruttore
	 * @param modeGame prende in input la modalita' di gioco scelta dall'utente
	 */
	public ModePlayers(ModeGame<?> modeGame) {
		this.modeGame=modeGame;
		
	}
	/**
	 * 
	 * @return la modalita' scelta
	 */
	public ModeGame<?> getModeGame() {
		return modeGame;
	}	

}
