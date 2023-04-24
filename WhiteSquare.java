import java.awt.*;

public class WhiteSquare extends Square{
    Color color;
    public WhiteSquare(){
        color = Color.white;
    }


    public Color getColor() {
        return Color.white;
    }
    public void draw(Graphics g, int x, int y){
        g.setColor(color);
        super.draw(g,x,y);
    }
}


