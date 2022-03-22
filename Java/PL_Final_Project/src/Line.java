import java.awt.*;
import javax.swing.*;

public class Line implements GraphicsShape{
    int x1;
    int y1;
    int x2;
    int y2;
    Color c;
    public Line(int ox1, int oy1, int ox2, int oy2, Color oc){
        x1 = ox1;
        y1 = oy1;
        x2 = ox2;
        y2 = oy2;
        c = oc;
    }
    @Override
    public void drawIt(Graphics g) {
        g.setColor(c);
        g.drawLine(x1,y1,x2,y2);
    }

    @Override
    public String toString(){
        String s ="Line:(x1: "+x1+ ",y1: "+y1+",x2: "+x2+",y2: "+y2+", Color: "+c+")";
        return s;
    }
}
