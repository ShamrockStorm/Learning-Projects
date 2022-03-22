import javafx.scene.control.ComboBox;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class CheckboxListner implements ItemListener {
    String Text;
    public CheckboxListner (Window w, Checkbox c){
        Text = c.getLabel();
        w.SelectionRB = Text;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

    }
}
