
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Iterator;
import java.util.LinkedList;

public class GUI extends JFrame implements MouseListener, ActionListener, MouseMotionListener {
    JPanel pnl1 = new JPanel();
    JPanel toolbar = new JPanel();
    JPanel top = new JPanel();
    JColorChooser ColorPicker = new JColorChooser();
    JButton bLineColour = new JButton();
    JButton bFillColour = new JButton();
    String[] shapes = {"Line","Filled Rectangle","Outlined Oval"};
    JComboBox cbShapeChooser = new JComboBox(shapes);
    JButton bDump = new JButton("Dump to Console");
    JPanel canvas = new JPanel();
    int x1,y1,x2,y2;
    Color c1 = Color.black;
    Color c2 = Color.black;
    LinkedList<GraphicsShape> CanvasDump = new LinkedList();
    boolean CanvasDumpIsEmpty = true;
    public GUI (){

        toolbar.setLayout(new GridLayout(5,1));
        toolbar.add(bLineColour);
        toolbar.add(bFillColour);
        toolbar.add(cbShapeChooser);
        toolbar.add(bDump);

        top.setLayout(new FlowLayout());
        top.add(ColorPicker);
        top.add(toolbar);

        canvas.setBackground(Color.white);
        canvas.setBorder(BorderFactory.createMatteBorder(8,8,8,8,Color.lightGray));
        pnl1.setLayout(new GridLayout(2,1));
        pnl1.add(top);
        pnl1.add(canvas);
        add(pnl1);

        //anonymous inner method
        bDump.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //System.out.println(CanvasDump.toString());
                System.out.println("The contents of the canvas are: ");
                System.out.println("{");
                for (Iterator i = CanvasDump.iterator(); i.hasNext();) {
                    System.out.println(i.next().toString());
                }
                System.out.println("}");
            }
        });

        bLineColour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                c2 = ColorPicker.getColor();
                System.out.println("Color "+ c2 + "was chosen for outline");
                bLineColour.setBackground(c2);
            }
        });

        bFillColour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                c1 = ColorPicker.getColor();
                System.out.println("Color "+ c1 + "was chosen for fill");
                bFillColour.setBackground(c1);
            }
        });
        this.setPreferredSize(new Dimension(800,800));
        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);
        System.out.print("finished window drawing");
        canvas.addMouseListener(this);
        canvas.addMouseMotionListener(this);
    }
    @Override
    public void paint(Graphics g){
        super.paint(g);
        int i = 0;
        if(!CanvasDumpIsEmpty) {
            GraphicsShape s = CanvasDump.get(i);
            s.drawIt(g);
            while (s != CanvasDump.getLast()) {
                i++;
                s = CanvasDump.get(i);
                s.drawIt(g);
            }
        }
    }
    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        x1 = (int) getMousePosition().getX();
        y1 = (int) getMousePosition().getY();
        //System.out.println("Mouse clicked at "+x1+" and "+y1);
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        x1 = (int) getMousePosition().getX();
        y1 = (int) getMousePosition().getY();
        //System.out.println("Mouse pressed at "+x1+" and "+y1);
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        x2 = (int) getMousePosition().getX();
        y2 = (int) getMousePosition().getY();
        //System.out.println("Mouse released at "+x2+" and "+y2);
        GraphicsShape s;
        switch(cbShapeChooser.getSelectedIndex()){
            case 0:  s = new Line(x1,y1,x2,y2,c2);
            break;
            case 1:
                if(x1>x2) {
                    int aux = x1;
                    x1 = x2;
                    x2 = aux;
                }
                if(y1>y2){
                    int aux = y1;
                    y1 = y2;
                    y2 = aux;
                }
                s = new FilledRectangle(x1,y1,x2,y2,c2,c1);
            break;
            case 2:
                if(x1>x2) {
                    int aux = x1;
                    x1 = x2;
                    x2 = aux;
                }
                if(y1>y2){
                    int aux = y1;
                    y1 = y2;
                    y2 = aux;
                }
                s = new OutlinedOval(x1,y1,x2,y2,c2);
            break;
            default: s = new Line(x1,y1,x2,y2,c2);
        }
        //s.drawIt(getGraphics());
        //s.drawIt(canvas.getGraphics());
        CanvasDump.add(s);
        if(CanvasDumpIsEmpty == true)CanvasDumpIsEmpty = false;
        this.repaint();
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) { }
    @Override
    public void mouseExited(MouseEvent mouseEvent) { }
    @Override
    public void actionPerformed(ActionEvent actionEvent) { }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        int x3 =x1;
        int y3 = y1;
        x2 = (int) getMousePosition().getX();
        y2 = (int) getMousePosition().getY();
        //System.out.println("Mouse dragged at "+x2+" and "+y2);
        GraphicsShape s;
        switch(cbShapeChooser.getSelectedIndex()){
            case 0:  s = new Line(x3,y3,x2,y2,c2);
                break;
            case 1:
                if(x3>x2) {
                    int aux = x3;
                    x3 = x2;
                    x2 = aux;
                }
                if(y3>y2){
                    int aux = y3;
                    y3 = y2;
                    y2 = aux;
                }
                s = new FilledRectangle(x3,y3,x2,y2,c2,c1);
                break;
            case 2:
                if(x3>x2) {
                    int aux = x1;
                    x3 = x2;
                    x2 = aux;
                }
                if(y3>y2){
                    int aux = y3;
                    y3 = y2;
                    y2 = aux;
                }
                s = new OutlinedOval(x3,y3,x2,y2,c2);
                break;
            default: s = new Line(x3,y3,x2,y2,c2);
        }
        this.repaint();

        //canvas.update(canvas.getGraphics());
        s.drawIt(this.getGraphics());

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) { }
}
