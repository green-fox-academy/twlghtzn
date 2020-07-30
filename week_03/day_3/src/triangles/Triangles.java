package triangles;

import static javax.swing.JFrame.EXIT_ON_CLOSE;


import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Triangles {

  public static int actualRecursions = 0;
  public static int maxRecursions = 8;

    public static void fractalDrawer1(Graphics g, int actualRecursions, int xA, int yA, int xB, int yB, int xC, int yC) {
      actualRecursions++;
      if (actualRecursions < maxRecursions) {
        g.drawLine(xA, yA, xB, yB);
        g.drawLine(xB, yB, xC, yC);
        g.drawLine(xC, yC, xA, yA);
        int xD = (xA + xB) / 2;
        int yD = (yA + yB) / 2;
        int xE = (xB + xC) / 2;
        int yE = (yB + yC) / 2;
        int xF = (xA + xC) / 2;
        int yF = (yA + yC) / 2;
        fractalDrawer1(g, actualRecursions, xA, yA, xD, yD, xF, yF);
      } else {
        return;
      }
    }
  public static void fractalDrawer2(Graphics g, int actualRecursions, int xA, int yA, int xB, int yB, int xC, int yC) {
    actualRecursions++;
    if (actualRecursions < maxRecursions) {
      g.drawLine(xA, yA, xB, yB);
      g.drawLine(xB, yB, xC, yC);
      g.drawLine(xC, yC, xA, yA);
      int xD = (xA + xB) / 2;
      int yD = (yA + yB) / 2;
      int xE = (xB + xC) / 2;
      int yE = (yB + yC) / 2;
      int xF = (xA + xC) / 2;
      int yF = (yA + yC) / 2;
      fractalDrawer2(g, actualRecursions, xD, yD, xB, yB, xE, yE);
    } else {
      return;
    }
  }
  public static void fractalDrawer3(Graphics g, int actualRecursions, int xA, int yA, int xB, int yB, int xC, int yC) {
    actualRecursions++;
    if (actualRecursions < maxRecursions) {
      g.drawLine(xA, yA, xB, yB);
      g.drawLine(xB, yB, xC, yC);
      g.drawLine(xC, yC, xA, yA);
      int xD = (xA + xB) / 2;
      int yD = (yA + yB) / 2;
      int xE = (xB + xC) / 2;
      int yE = (yB + yC) / 2;
      int xF = (xA + xC) / 2;
      int yF = (yA + yC) / 2;
      fractalDrawer3(g, actualRecursions, xF, yF, xE, yE, xC, yC);
    } else {
      return;
    }
  }
    public static void mainDraw(Graphics graphics) {
      fractalDrawer1(graphics, 0,0,0,320,0,160,320);
      fractalDrawer2(graphics, 0,0,0,320,0,160,320);
      fractalDrawer3(graphics, 0,0,0,320,0,160,320);

    }


    // Don't touch the code below
    static int WIDTH = 320;
    static int HEIGHT = 320;

    public static void main(String[] args) {
      JFrame jFrame = new JFrame("Drawing");
      jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
      ImagePanel panel = new ImagePanel();
      panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
      jFrame.add(panel);
      jFrame.setLocationRelativeTo(null);
      jFrame.setVisible(true);
      jFrame.pack();

    }

    static class ImagePanel extends JPanel {
      @Override
      protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        mainDraw(graphics);
      }


    }
  }
