import java.awt.*;

public class ColorSquare extends Square{
    Color color;
    int special;
    public ColorSquare(){
        special = (int) (Math.random()*4);

        if(special == 0)
            color = Color.green;
        else if(special == 1)
            color = Color.red;
        else if(special == 2)
            color = Color.pink;
        else
            color = Color.orange;
    }

    public Color getColor(){

        return color;
    }
    public void draw(Graphics g, int x, int y){

        g.setColor(color);
        super.draw(g,x,y);
    }
}
