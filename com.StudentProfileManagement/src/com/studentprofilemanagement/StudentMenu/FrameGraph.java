/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.studentprofilemanagement.StudentMenu;


 
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FrameGraph extends JPanel
{
    
    
  private double[] values;

  private String[] names;

  private String title;
  JFrame f ;
  JLabel b = new JLabel("Bansi");
  public FrameGraph() 
  {
      
     // System.out.println("Constructor ma");
      this.setSize(200, 200);
      this.setForeground(Color.red);
     f = new JFrame();
     
    //f.setSize(400, 300);
    double[] values = new double[8];
    String[] names = new String[8];
    values[0] = 3;
    names[0] = "SEM 1";

    values[1] = 2;
    names[1] = "SEM 2";

    values[2] = 4;
    names[2] = "SEM 3";
    
    values[3] = 3;
    names[3] = "SEM 4";

    values[4] = 2;
    names[4] = "SEM 5";

    values[5] = 4;
    names[5] = "SEM 6";
    
    values[6] = 3;
    names[6] = "SEM 7";

    values[7] = 2;
    names[7] = "SEM 8";
   
    f.getContentPane().add(new FrameGraph());
  }

  public void paintComponent(Graphics g) {
   //super.paintComponent(g);
    if (values == null || values.length == 0)
      return;
    double minValue = 0;
    double maxValue = 0;
    for (int i = 0; i < values.length; i++) {
      if (minValue > values[i])
        minValue = values[i];
      if (maxValue < values[i])
        maxValue = values[i];
    }

    Dimension d = getSize();
    int clientWidth = d.width;
    int clientHeight = d.height;
    int barWidth = clientWidth / values.length-300;

    Font titleFont = new Font("SansSerif", Font.BOLD, 20);
    FontMetrics titleFontMetrics = g.getFontMetrics(titleFont);
    Font labelFont = new Font("SansSerif", Font.PLAIN, 10);
    FontMetrics labelFontMetrics = g.getFontMetrics(labelFont);

    int titleWidth = titleFontMetrics.stringWidth(title);
    int y = titleFontMetrics.getAscent();
    int x = (clientWidth - titleWidth) / 2;
    g.setFont(titleFont);
    g.drawString(title, x, y);

    int top = titleFontMetrics.getHeight();
    int bottom = labelFontMetrics.getHeight();
    if (maxValue == minValue)
      return;
    double scale = (clientHeight - top - bottom) / (maxValue - minValue);
    y = clientHeight - labelFontMetrics.getDescent();
    g.setFont(labelFont);

    for (int i = 0; i < values.length; i++) {
      int valueX = i * barWidth + 1;
      int valueY = top;
      int height = (int) (values[i] * scale);
      if (values[i] >= 0)
        valueY += (int) ((maxValue - values[i]) * scale);
      else {
        valueY += (int) (maxValue * scale);
        height = -height;
      }

      g.setColor(Color.red);
      g.fillRect(valueX, valueY, barWidth - 2, height);
      g.setColor(Color.black);
      g.drawRect(valueX, valueY, barWidth - 2, height);
      int labelWidth = labelFontMetrics.stringWidth(names[i]);
      x = i * barWidth + (barWidth - labelWidth) / 2;
      g.drawString(names[i], x, y);
       
    //  g.drawString(Integer.toString((int) values[i]), x, y);
    
    

   WindowListener wndCloser = new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    };
    f.addWindowListener(wndCloser);
   
    f.setVisible(true);
    
    }
  }

}
/*public class frame
{
    public static void main(String[] args) 
    {
        
    }
}
*/



