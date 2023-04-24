// Represents current Game Stats

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class GameStats extends JPanel
{
  private JTextField gameNameText, currentHighScorer, currentHighScore;
  private int yourScore = 0;
  private JLabel yourScoreText, hScore, hsName;
  private JLabel timeLeft;
  private JavaArcade game;

  private JavaArcade ja;

  // Constructor
  public GameStats(JavaArcade t)
  {
    super(new GridLayout(2, 4, 10, 0));

    ja = t;

    setBorder(new EmptyBorder(0, 0, 5, 0));
    Font gameNameFont = new Font("Monospaced", Font.BOLD, 24);
    Font displayFont = new Font("Monospaced", Font.BOLD, 16);

    JLabel gName = new JLabel(" " + t.getGameName());
    
    gName.setForeground(Color.red);
    gName.setFont(gameNameFont);
 	  add(gName);

      hScore = new JLabel(" Current High Score:   " + t.getHighScore());

    add(hScore); //new JLabel(" Current High Score:   " + t.getHighScore()));

    hsName = new JLabel("High Score Holder: ");
    hsName.setForeground(Color.black);
    hsName.setFont(displayFont);
    add(hsName);
   
    add(new JLabel(" "));
    yourScoreText = new JLabel(" Your Final Score: " + 0);
   
    add(yourScoreText);
    game = t;

    timeLeft = new JLabel("Time Remaining: ");
    timeLeft.setForeground(Color.black);
    timeLeft.setFont(displayFont);
    add(timeLeft);

     }

  
  public void update(int points)
  {
  	yourScore= points;
  	yourScoreText.setText(" Your Score: " + points);
   
 
  }
  
  public void updateHighScore(int points){
    hScore.setText(" Current High Score:   " + points);
    
  }

  public void updateTimer(int seconds){
    timeLeft.setText(" Seconds left  " + seconds);

  }

  public int getScore(){
    return yourScore;
  }
  public void gameOver(int points)
  {


  	if(this.game.getInitialScore() < Integer.parseInt(game.getHighScore())){
  		yourScoreText.setForeground(Color.BLUE);
  		String s = (String)JOptionPane.showInputDialog(this, "You are the new high scorer. Congratulations!\n Enter your name: ", "High Score", JOptionPane.PLAIN_MESSAGE, null, null,"name");
        hScore.setText(" Current High Score:   " + points);
        hsName.setText("High Score Holder: " + s);

  	}
  	
  }
}
