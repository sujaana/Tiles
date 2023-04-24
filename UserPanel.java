import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class UserPanel extends JPanel implements JavaArcade, ActionListener, KeyListener {
    private boolean game = false;
    private static int highScore = 0;
    private static int initialHighScore;
    private int score = 0;
    private javax.swing.Timer timer;
    private int pressed;

    private GameStats gs;
    private Tiles tiles;

    private Square[][] table = new Square[4][4]; // make square class
    private int xP = 0;
    private int yP = 0;

    private int count = 30000;

    ActionListener timerPrinter = new ActionListener() {
        //int count = 30000;
        public void actionPerformed(ActionEvent e) {
            count-=1000;
            if(count>=0)
                gs.updateTimer(count/1000);
            else
                gs.updateTimer(0);
        }
    };

    public UserPanel(int a, int b) {
        int special = (int) (Math.random()*7);
        addKeyListener(this);//used for key controls
        tiles = new Tiles();

        timer = new Timer(1000, timerPrinter);

        for(int x = 0; x < 4; x++){
            for(int y = 0; y<4;y++){
                if(tiles.getTable(x,y)==false){
                    if(special == 0)
                        table[x][y] = new ColorSquare();
                    else
                        table[x][y] = new WhiteSquare();
                } else{
                    table[x][y] = new BlackSquare();
                }

            }
        }

    }

    //added because UserPanel implements KeyListener
    public void keyTyped(KeyEvent e){

    }

    //added because UserPanel implements KeyListener
    public void keyReleased(KeyEvent e) {

    }


    public void keyPressed(KeyEvent e) {
        if (count >= 0) {
            switch ((int) e.getKeyChar()) {
                case KeyEvent.VK_1:
                    pressed = 0;
                    if (tiles.right(pressed)) {
                        score++;
                        redraw();
                        gs.update(score);
                        if (score > highScore) {
                            highScore = score;
                            gs.updateHighScore(highScore);
                        }


                    } else {
                        stopGame();
                        gs.gameOver(highScore);
                        initialHighScore = highScore;
                        JOptionPane.showMessageDialog(this, "Incorrect Tile Pressed. Game Over!");

                    }
                    break;
                case KeyEvent.VK_2:
                    pressed = 1;
                    if (tiles.right(pressed)) {
                        score++;
                        redraw();
                        gs.update(score);
                        if (score > highScore) {
                            highScore = score;
                            gs.updateHighScore(highScore);
                        }

                    } else {
                        stopGame();
                        gs.gameOver(highScore);
                        initialHighScore = highScore;
                        JOptionPane.showMessageDialog(this, "Incorrect Tile Pressed. Game Over!");
                    }
                    break;
                case KeyEvent.VK_3:
                    pressed = 2;
                    if (tiles.right(pressed)) {
                        score++;
                        redraw();
                        gs.update(score);
                        if (score > highScore) {
                            highScore = score;
                            gs.updateHighScore(highScore);
                        }

                    } else {
                        stopGame();
                        gs.gameOver(highScore);
                        initialHighScore = highScore;
                        JOptionPane.showMessageDialog(this, "Incorrect Tile Pressed. Game Over!");
                    }
                    break;
                case KeyEvent.VK_4:
                    pressed = 3;
                    if (tiles.right(pressed)) {
                        score++;
                        redraw();
                        gs.update(score);
                        if (score > highScore) {
                            highScore = score;
                            gs.updateHighScore(highScore);
                        }


                    } else {
                        stopGame();
                        JOptionPane.showMessageDialog(this, "Incorrect Tile Pressed. Game Over!");
                        gs.gameOver(highScore);
                        initialHighScore = highScore;
                    }
                    break;

            }
        } else{
            stopGame();
            JOptionPane.showMessageDialog(this, "You ran out of time! Start a new game");
            gs.gameOver(highScore);
            initialHighScore = highScore;
        }
    }



    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g); //a call to JPanel's paintComponent



        g.drawString("Hit Start to Play!", 600, 10);


        //Draw tiles
	    for(int x = 0;x<4;x++) {
            for (int y = 0; y < 4; y++) {
                table[y][x].draw(g, xP, yP);
                yP +=150;
            }
            yP= 0;
            xP += 150;
        }

        yP= 0;
        xP = 0;
    }
    public void redraw(){
        for(int x = 0; x < 4; x++){
            for(int y = 0; y<4;y++){
                int special = (int) (Math.random()*7);
                if(tiles.getTable(x,y)==false){
                    if(special ==0)
                        table[x][y] = new ColorSquare();
                    else
                        table[x][y] = new WhiteSquare();
                } else{
                    table[x][y] = new BlackSquare();
                }

            }
        }
        repaint();
    }



    /* This method should return true if your game is in a "start" state, it should return false if
     * your game is in a "paused" state or "stopped" or "unstarted" */
    public boolean running() {
        return game;
    }

    /* This method should start your game, it should also set a global boolean value so that your running method
     * can return the appropriate value */
    public void startGame() {
        game = true;
        initialHighScore = highScore;
        if(this.tiles.right(pressed)){
            this.score++;
        }else{
            this.stopGame();
        }

        timer.start();
    }

    /*This method should return the name of your game */
    public String getGameName() {

        return "Tiles";
    }

    /* This method should stop your timers but save your score, it should set a boolean value to indicate
     *the game is not running, this value will be returned by running method */
    public void pauseGame() {
        game = false;
        timer.stop();

    }

    /* This method should return your instructions */
    public String getInstructions() {

        return "Hit Start to Play\nPress the number that corresponds with the black rectangle in the top row\n1 = left, 2 = middle left, 3 = middle right, 4 = right\nPress only the black tiles, not the colored or white ones";
    }

    /* This method should return the author(s) of the game */

    public String getCredits() {

        return "Sujaana A. and Rishika A.";
    }


    public String getHighScore() {
        return "" + highScore;

    }

    public int getInitialScore() {
        return initialHighScore;
    }


    /* This method should stop the timers, reset the score, and set a running boolean value to false */

    public void stopGame() {
        game = false;
        score = 0;
        timer.stop();
        count = 30000;
    }

    /* This method should return the current players number of points */
    public int getPoints() { //add to spec
        return score;
    }

    /* This method provides access to GameStats display for UserPanel to pass information to update score
    GameStats is created in Arcade, a reference should be passed to UserPanel (main panel) to update points */
    public void setDisplay(GameStats d) {
        gs = d;
        d.update(score);
        repaint();
    }


}




