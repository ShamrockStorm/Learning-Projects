import java.awt.*;

public class OutlinedOval implements GraphicsShape {
    int x1;
    int y1;
    int x2;
    int y2;
    Color c1;
    public OutlinedOval(int ox1, int oy1, int ox2, int oy2, Color oc1){
        x1 = ox1;
        y1 = oy1;
        x2 = ox2;
        y2 = oy2;
        c1 = oc1;
    }

    @Override
    public void drawIt(Graphics g) {
        int rWidth = x2 - x1;
        int rHeight = y2 - y1;
        g.setColor(c1);
        g.drawOval(x1,y1,rWidth,rHeight);
    }

    @Override
    public String toString(){
        String s ="OutlinedOval(x1: "+x1+ ",y1: "+y1+",x2: "+x2+",y2: "+y2+", Color: "+c1+")";
        return s;
    }
}
