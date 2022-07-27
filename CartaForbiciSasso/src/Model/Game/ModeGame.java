package Model.Game;

import Model.Players.Players;

/**
 * Questa classe astratta modella alcuni metodi e costanti che verranno ereditati dalle sottoclassi
 * Questa scelta ha come obiettivo quello di rendere il codice piu' estendibile possibile, infatti oltre alle modalita'
 * gia' create si possono creare altre modalita' caratterizzate da nuove enum
 * @author Davide Morelli
 *
 * @param <T> enum contenente mosse della modalita' classica, lizard-spock o altre modalita' qualora si volesse estendere il codice
 */

public abstract class ModeGame<T extends Enum<T>> {

	
	private final Players player1,player2; // riferimenti ai giocatori 
	private int numberGames; // numero di game giocati in una partita
	private int scoreP1,scoreP2; //score dei due players
	protected T actionP1,actionP2; //campi cotenenti le mosse dei due players
	private T[] actions; //array contenente le costanti delle enum scelta' in base alla modalita'


	/**Costruttore che setta i players in input, gli scores a 0  ed il numero di game a 1
		essendo una nuova partita 
	**/
	public ModeGame(Players p1,Players p2) {
		
		this.player1=p1;
		this.player2=p2;
		this.scoreP1=0;
		this.scoreP2=0;
		this.numberGames=1;
		
	}
	
	//Vari setter e getter dei campi descritti sopra
	public int getNumberGames() { return this.numberGames;} 
	
	public void setNumberGames(int nGames) { this.numberGames=nGames;}
	
	public Players getPlayers(int player) {return player==1? player1:player2;}

	public int getScoreP2() {return scoreP2;}

	public void setScoreP2(int scoreP2) {this.scoreP2 = scoreP2;}

	public int getScoreP1() {return scoreP1;}

	public void setScoreP1(int scoreP1) {this.scoreP1 = scoreP1;}
	
	/**
	 * Getter e setter che verranno implementati nelle sottoclassi in base alla enum che
	 *  la caratterizza 
	 */
	public abstract T getActionP2();

	public abstract void setActionP2(Enum<?> actionP2);

	public abstract T getActionP1();

	public abstract void setActionP1(Enum<?> actionP1);
	

	/**
	 Questo metodo viene implementato nelle sottoclassi, per far si di chiamare 
	 il compareAction della modalita' scelta (classic o lizard-spock) e aggiornare gli scores personali
	 */
	public abstract int updateScores();
	
	public T[] getArrayAction() {return actions;}

	/**
	 * Setta l'array delle mosse. (ValueOf dell'enum che caratterizza la modalità scelta)
	 * @param arrayAction
	 */
	public void setArrayAction(T[] arrayAction) {this.actions = arrayAction;}
	
	/**
	 * Setta l'azione del player il quel round in base al bottone premuto in fase del gioco dall'utente
	 * @param input
	 */
	public abstract void setInputAction(String input);
	
	/**
	 * Questo metodo che verra' implementato nelle sottoclassi che rappresentano la modalita' scelta
	 * fa giocare il player non umano P1, facendolo scegliere random tra le costanti delle enum.
	 */
	public abstract void playBotP1 ();
	
	/**
	 * Questo metodo che verra' implementato nelle sottoclassi che rappresentano la modalita' scelta
	 * fa giocare il player non umano P2, facendolo scegliere random tra le costanti delle enum.
	 */
	public abstract void playBotP2 ();
	
	/**
	 * Questo metodo fa giocare , qualora il giocatore lo desiderasse, una nuova partita,
	 * ponendo a zero ogni score o mossa precedente ed incrementando il numero di games in quella partita
	 */
	public void playAgain() {
	
		setScoreP1(0);
		setScoreP2(0);
		setNumberGames(getNumberGames()+1);
		setActionP1(null);
		setActionP2(null);
	}
	
	/**
	 * Questo metodo controlla chi dei due players ha vinto il game. 
	 * Controlla ad ogni mossa gli scores dei due players, decretando come vincitore il primo che arriva 
	 * ad uno score pari a 10 
	 * @return player vincente
	 */
	public Players win() {
		if (this.getScoreP1()==10)   return this.getPlayers(1);
		else if (this.getScoreP2()==10)  return this.getPlayers(2);
		
		return null;
	}

	

	
	
	
}
