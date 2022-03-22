import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MouseTracker extends Frame implements MouseMotionListener, WindowListener {

    int X;
    int Y;
    public MouseTracker(){

        this.addMouseMotionListener(this);

        addWindowListener(this);

        this.setPreferredSize(new Dimension(400,300));
        this.pack();
        this.setLocationRelativeTo(null);

        setVisible(true);
    }

    @Override
    public void paint(Graphics g){
        g.drawString("X:" + X+ " Y: "+ Y,X,Y);

    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

        System.out.print("X:"+ this.getMousePosition().x);
        System.out.print(" Y:"+ this.getMousePosition().y);
        System.out.println();

         X = this.getMousePosition().x;
         Y = this.getMousePosition().y;
         repaint();
    }

    @Override
    public void windowOpened(WindowEvent windowEvent) {

    }

    @Override
    public void windowClosing(WindowEvent windowEvent) {
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent windowEvent) {

    }

    @Override
    public void windowIconified(WindowEvent windowEvent) {

    }

    @Override
    public void windowDeiconified(WindowEvent windowEvent) {

    }

    @Override
    public void windowActivated(WindowEvent windowEvent) {

    }

    @Override
    public void windowDeactivated(WindowEvent windowEvent) {

    }
}
