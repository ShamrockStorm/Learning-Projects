import java.awt.*;
import java.awt.Frame;
import java.awt.event.*;

public class Window extends Frame implements ItemListener, ActionListener, WindowListener {
    Panel pnl1 = new Panel();
    Label l1 = new Label("Label 1");
    Label l2 = new Label("Label 2");
    Panel pnl2 = new Panel();
    TextField tf1 = new TextField(10);
    Button b1 = new Button("Click me");
    Panel pnl3 = new Panel();
    Choice ch1 = new Choice();
    CheckboxGroup grp1 = new CheckboxGroup();
    Checkbox c1 = new Checkbox("option 1",grp1,false);
    Checkbox c2 = new Checkbox("option 2",grp1,false);
    Checkbox c3 = new Checkbox("option 3",grp1,false);

    GridLayout gl1 = new GridLayout(1,2);
    GridLayout gl2 = new GridLayout(3,1);
    FlowLayout fl1 = new FlowLayout();
    String SelectionCh;
    public String SelectionRB;
    String TF;


    public Window () {
        setLayout(gl2);
        pnl1.setLayout(gl1);
        pnl1.add(l1);
        pnl1.add(l2);
        pnl2.setLayout(gl1);
        pnl2.add(tf1);
        pnl2.add(b1);
        ch1.add("element 1");
        ch1.add("element 2");
        ch1.add("element 3");
        pnl3.setLayout(fl1);
        pnl3.add(ch1);
        pnl3.add(c1);
        pnl3.add(c2);
        pnl3.add(c3);
        add(pnl1);
        add(pnl2);
        add(pnl3);

        ch1.addItemListener(this);
        InnerItemListner Il = new InnerItemListner();
        /*
        c3.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {

            }
        });
        */
        c1.addItemListener(Il);
        c2.addItemListener(Il);
        c3.addItemListener(Il);
        b1.addActionListener(this);
        /*
        tf1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                TF = tf1.getText();
            }
        });
        */

        addWindowListener(this);

        this.setPreferredSize(new Dimension(400,300));
        this.pack();
        this.setLocationRelativeTo(null);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ChSelect) {
        System.out.println(SelectionCh);
        System.out.println(SelectionRB);
        TF = tf1.getText();
        System.out.println(TF);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        SelectionCh = ch1.getSelectedItem();
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

    class InnerItemListner implements ItemListener{
        @Override
          public void itemStateChanged(ItemEvent e) {
            SelectionRB = grp1.getSelectedCheckbox().getLabel();
         }
    }

}
