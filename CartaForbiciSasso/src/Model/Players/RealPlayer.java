package Model.Players;

/**
 * Classe che modella il giocatore umano
 * @author Davide Morelli
 *
 */
public class RealPlayer extends Players {
	
	/**
	 * Costruttore della classe. La costruzione dell'oggetto richiede 
	 * l'inserimento di un nickname per identificarlo
	 * @param nickname
	 */
	public RealPlayer(String nickname) {
		this.setNickName(nickname);
	}

}
