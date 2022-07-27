package Model.Players;

import java.util.Random;

/**
 * Classe che modella il giocatore non umano
 * @author Davide Morelli
 *
 */
public class BotPlayer extends Players {
	
	private final String[] nick= {"Sheldon","Penny","Leonard","Howard","Raj","Amy","Bernadette"};
	
	/**
	 * Costruttore della classe. La costruzione dell'oggetto non richiede 
	 * l'inserimento di un nickname per identificarlo ma sceglie random tra quelli esplicitati nell'array nick
	 * @param nickname
	 */
	public BotPlayer() {
		this.setNickName(nick[new Random().nextInt(0, nick.length)]);	
	}


	
}
