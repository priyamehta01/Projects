package Threading;

import java.awt.FlowLayout;
import javax.swing.*;

public class DialogBox extends JFrame{
      JPanel p;
      JLabel l;
      public DialogBox(){

          setLayout(new FlowLayout(FlowLayout.CENTER));
          setSize(200,200);
          p = new JPanel();
          l = new JLabel("You have entered Academic Records!");
          p.add(l);
          add(p);
          setVisible(true);
      }
}
