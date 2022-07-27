package View.GameStage;

import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * Classe che modella il Frame della fase di gioco. 
 * Contiene la label della fase di gioco.
 * @author Davide Morelli
 *
 */
public class FrameGameStage extends JFrame {

	
	private static final long serialVersionUID = 1L;
	
	public FrameGameStage(String nickPlayer1, String nickPlayer2, int nGames,boolean flagPlayer,boolean flagMode) {
		super("Game");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); //chiude solo questa finestra
		setLayout(new BorderLayout());
		try {
			setIconImage(ImageIO.read(new File("Images\\Icon.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Background. In base al flag viene aggiunta la barra della modalita' classica piuttosto che lizard-spock
		add(new LabelGameStage(nickPlayer1,nickPlayer2,nGames,flagMode),BorderLayout.CENTER);
		if (flagMode==true) add(new LabelClassicActions(flagPlayer),BorderLayout.PAGE_END);
		else add(new LabelLsActions(flagPlayer),BorderLayout.PAGE_END);
		
	
		setSize(1295,753);
		setLocationRelativeTo(null);
		setResizable(false);
		pack(); 
		setVisible(true);
		
	}

}
