package Model.Game;

/**
 * Enum che rappresenta le costanti della modalita' Lizard-Spock
 * @author Davide Morelli
 *
 */
public enum LSAction implements compareAction {
	SCISSORS,PAPER,ROCK,SPOCK,LIZARD;

	/**
	 * Metodo dell'interfaccia compareAction da implementare in base alle costanti dell'enum in questione.
	 * Questo metodo verra' utilizzato in fase di gioco per stabilire chi dei due giocatori ha scelto la mossa vincente.
	 */
	public int compareAction(Enum<?> a1) {
		
		if (this.equals(a1)) return 0;
		
		switch(this) {
		case SCISSORS -> {return ((a1.equals(LIZARD))||a1.equals(PAPER)?1:-1);}
		case PAPER -> {return ((a1.equals(ROCK))||a1.equals(SPOCK)?1:-1);}
		case ROCK -> {return ((a1.equals(SCISSORS))||a1.equals(LIZARD)?1:-1);}	
		case SPOCK -> {return ((a1.equals(SCISSORS)||a1.equals(ROCK))?1:-1);}
		case LIZARD -> {return ((a1.equals(SPOCK))||a1.equals(PAPER)?1:-1);}
		}
	return 0;

}



	}
