package View.GameStage;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Function;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
/**
 * Questa classe rappresenta il background della fase di gioco.
 * Contiente:
 * - label che mostrano quale mossa e' stata fatta
 * - Textfield che descrivono sottoforma di parola quale mossa e' stata scelta
 * - bottone "?", che contiene le regole della modalita' scelta, classica o spock-lizard
 * - metodi con cui aggiornare la gui riguardo, scores, immagini e Textfields
 * @author Davide Morelli
 *
 */
public class LabelGameStage extends JLabel {
	
	private static final long serialVersionUID = -7518177291421275748L;
	private static JTextField areaActionSx,areaActionDx,scoreSx,scoreDx,numberGames;
	private static JLabel labelSx,labelDx;
	private Border bordo=BorderFactory.createLineBorder(Color.WHITE, 3);
	public static Function<Integer,String> funzione=String::valueOf;
	
	
	public LabelGameStage(String nickPlayer1, String nickPlayer2, int nGames,boolean flagMode) {
		super(new ImageIcon("Images\\Table_1.png"));

		JButton info=new JButton("?");
		info.setBounds(1150,40,60,60);
		info.setFont(new Font("Sans-serif",Font.BOLD,30));
		info.setForeground(Color.WHITE);
		info.setContentAreaFilled(false);
		info.setBorder(bordo);
		info.setFocusable(false);
		info.setHorizontalAlignment(CENTER);
		info.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new JOptionPane();
				if (flagMode) JOptionPane.showMessageDialog(null, null, "Rules", 0, new ImageIcon("Images\\RulesClassic.png"));
				else JOptionPane.showMessageDialog(null,null, "Rules", 0, new ImageIcon("Images\\RulesLS.png"));
			}
		});
		
		add(info);
		//partite giocate
		numberGames=new JTextField();
		numberGames.setBounds(360, 40, 500, 60);
		numberGames.setText("Game: "+funzione.apply(nGames));
		numberGames.setFont(new Font("Sans-serif",Font.BOLD,50));
		numberGames.setForeground(Color.WHITE);
		numberGames.setBorder(bordo);
		numberGames.setHorizontalAlignment(JTextField.CENTER);
		numberGames.setFocusable(false);
		numberGames.setOpaque(false);
		add(numberGames);
		
		//area name player
		JTextField fieldNickPlayer1= new JTextField(nickPlayer1);
		fieldNickPlayer1.setBounds(320, 200, 200, 60);
		fieldNickPlayer1.setFont(new Font("Sans-serif",Font.BOLD,30));
		fieldNickPlayer1.setFocusable(false);
		fieldNickPlayer1.setForeground(Color.WHITE);
		fieldNickPlayer1.setBorder(null);
		fieldNickPlayer1.setOpaque(false);
		fieldNickPlayer1.setHorizontalAlignment(JTextField.CENTER);
		
		JTextField fieldNickPlayer2= new JTextField(nickPlayer2);
		fieldNickPlayer2.setBounds(700, 200, 200, 60);
		fieldNickPlayer2.setFont(new Font("Sans-serif",Font.BOLD,30));
		fieldNickPlayer2.setFocusable(false);
		fieldNickPlayer2.setForeground(Color.WHITE);
		fieldNickPlayer2.setBorder(null);
		fieldNickPlayer2.setOpaque(false);
		fieldNickPlayer2.setHorizontalAlignment(JTextField.CENTER);
		
		add(fieldNickPlayer1);
		add(fieldNickPlayer2);
		
		
		//area azioni
		areaActionSx=new JTextField();
		areaActionSx.setBounds(320, 500, 200, 60);
		areaActionSx.setFont(new Font("Sans-serif",Font.BOLD,30));
		areaActionSx.setHorizontalAlignment(JTextField.CENTER);
		areaActionSx.setFocusable(false);
		areaActionSx.setOpaque(true);
		areaActionSx.setForeground(Color.WHITE);
		areaActionSx.setBorder(null);
		areaActionSx.setOpaque(false);
		labelSx=new JLabel();
		labelSx.setBounds(320, 300, 200, 200);
		labelSx.setHorizontalAlignment(JLabel.CENTER);
		add(labelSx);
		add(areaActionSx);
		
		areaActionDx=new JTextField();
		areaActionDx.setBounds(700, 500, 200, 60);
		areaActionDx.setFont(new Font("Sans-serif",Font.BOLD,30));
		areaActionDx.setHorizontalAlignment(JTextField.CENTER);
		areaActionDx.setFocusable(false);
		areaActionDx.setForeground(Color.WHITE);
		areaActionDx.setBorder(null);
		areaActionDx.setOpaque(false);
		labelDx=new JLabel();
		labelDx.setBounds(700, 300, 200, 200);
		labelDx.setHorizontalAlignment(JLabel.CENTER);
		add(labelDx);
		add(areaActionDx);
		
		
		//score
		scoreSx=new JTextField("0");
		
		scoreSx.setBounds(100, 350, 100, 60);
		scoreSx.setFocusable(false);
		scoreSx.setFont(new Font("Sans-serif",Font.BOLD,50));
		scoreSx.setForeground(Color.WHITE);
		scoreSx.setBorder(null);
		scoreSx.setOpaque(false);
		scoreSx.setHorizontalAlignment(JTextField.CENTER);
		
		scoreDx=new JTextField("0");
		scoreDx.setBounds(1000, 350, 100, 60);
		scoreDx.setFocusable(false);
		scoreDx.setFont(new Font("Sans-serif",Font.BOLD,50));
		scoreDx.setForeground(Color.WHITE);
		scoreDx.setBorder(null);
		scoreDx.setOpaque(false);
		scoreDx.setHorizontalAlignment(JTextField.CENTER);
		
		add(scoreSx);
		add(scoreDx);
		
		
	}
	
	public static void setActionSx(String stringa,String img) {
		labelSx.setIcon(new ImageIcon("Images\\"+img+".png"));
		areaActionSx.setText(stringa);}
	public static void setActionDx(String stringa,String img) {
		labelDx.setIcon(new ImageIcon("Images\\"+img+".png"));
		areaActionDx.setText(stringa);}
	
	public static void setScore(int score, int player) {
		if (player==1) scoreSx.setText(funzione.apply(score));
		else scoreDx.setText(funzione.apply(score));}	
	
	
	public static void setNumberGames(int games) {
		numberGames.setText("Game: "+funzione.apply(games));}	

}
	

