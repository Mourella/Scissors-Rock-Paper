package Model.Players;

/**
 * Classe astratta che modella i players. 
 * 
 * @author Davide Morelli
 *
 */
public abstract class Players {
	
	private String nickName;

	public String getNickName() {return this.nickName;}
	protected void setNickName(String name) {this.nickName=name;} 
	
	
}
