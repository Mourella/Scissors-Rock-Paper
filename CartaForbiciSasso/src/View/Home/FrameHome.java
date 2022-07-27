package View.Home;


import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.WindowConstants;


/**
 * Classe che modella il Frame della home. 
 * Contiene la label della home.
 * @author Davide Morelli
 *
 */
public class FrameHome extends JFrame{
	private static final long serialVersionUID=1L;
	public FrameHome() {
		super("SCF");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		try {
			setIconImage(ImageIO.read(new File("Images\\Icon.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		add(new LabelHome());
		pack();
		
		setSize(1100,699);
		setLocationRelativeTo(null);
		setResizable(false);
		

}
}
