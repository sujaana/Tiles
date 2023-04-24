import java.awt.*;

public abstract class Square {

    public Square(){

    }

    public abstract Color getColor();
    public void draw(Graphics g, int x, int y){
        g.fillRect(x,y,150,150);
    }
}
