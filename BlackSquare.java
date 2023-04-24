import java.awt.*;

public class BlackSquare extends Square{
     Color color;
    public BlackSquare(){

        color = Color.black;
    }

    public Color getColor(){

        return Color.black;
    }
    public void draw(Graphics g, int x, int y){

        g.setColor(color);
        super.draw(g,x,y);
    }
}



