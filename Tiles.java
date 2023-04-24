import java.util.ArrayList;
public class Tiles {

    boolean[][] table = new boolean[4][4];
    private ArrayList<Integer> trueP = new ArrayList<Integer>(4);
    ArrayList<Integer> hit = new ArrayList<Integer>(4);

    public Tiles() {
        for (int i = 0; i < 4; i++) {
            int chosen = (int) (Math.random() * 4);
            hit.add(i, chosen);
            table[i][chosen] = true;
            trueP.add(i);
            //System.out.println(i + " " + chosen);
        }


        for(int i = 0; i < 4; i++){
            trueP.add(i);
        }

    }

    public int getY() {
        return trueP.get(0);
    }

    public int getX(){
        return hit.get(0);
    }

    public boolean right(int x){
        if(x == hit.get(0)){ //someone is getting it right
            int chosen = (int) (Math.random()*4);
            hit.add(chosen);
            trueP.add(trueP.get(0));
            hit.remove(0);
            trueP.remove(0);
            //move all the rows up
            for (int i = 1; i < 4; i++) {
                table[i-1] = table[i];
            }
            //add a new row
            table[3] = new boolean[]{false, false, false, false};
            table[3][chosen] = true;


            return true;
        }else{
            return false;
        }
    }

    public boolean getTable(int x,int y){

        return table[x][y];
    }

}
