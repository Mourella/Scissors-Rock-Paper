package Model.Game;

/**
 * Enum che rappresenta le costanti della modalita' classica.
 * @author Davide Morelli
 *
 */
public enum ClassicAction implements compareAction{
	SCISSORS,PAPER,ROCK; //costanti

	/**
	 * Metodo dell'interfaccia compareAction da implementare in base alle costanti dell'enum in questione.
	 * Questo metodo verra' utilizzato in fase di gioco per stabilire chi dei due giocatori ha scelto la mossa vincente.
	 */
	public int compareAction(Enum<?> a1) {
		
		if (this.equals(a1)) return 0;
		
		switch(this) {
		case SCISSORS -> {return (a1.equals(PAPER)?1:-1);}
		case PAPER -> {return (a1.equals(ROCK)?1:-1);}
		case ROCK -> {return (a1.equals(SCISSORS)?1:-1);}	
		}
	return 0;
	
}

	
	}
