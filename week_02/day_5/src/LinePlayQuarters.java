import javax.swing.*;

import java.awt.*;


import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class LinePlayQuarters {
  public static void mainDraw(Graphics graphics) {

    int x = 2;
    int y = 0;
    int w = 20;
    int z = 1;

    int xx = 0;
    int yy = 2;
    int ww = 1;
    int zz = 20;


    for (int k = 0; k < 16; k++) {
      for (int j = 0; j < 16; j++) {
        int a = x;
        int b = y;
        int c = w;
        int d = z;
        for (int i = 0; i < 13; i++) {
          graphics.setColor(Color.MAGENTA);
          graphics.drawLine(a, b, c, d);
          a += 1;
          d += 1;
        }
        int e = xx;
        int f = yy;
        int g = ww;
        int h = zz;
        for (int i = 0; i < 13; i++) {
          graphics.setColor(Color.GREEN);
          graphics.drawLine(e, f, g, h);
          f += 1;
          g += 1;
        }
        x += 20;
        w += 20;
        xx += 20;
        ww += 20;
      }
      x = 0;
      y += 20;
      w = 20;
      z += 20;
      xx = 0;
      yy += 20;
      ww = 1;
      zz += 20;
    }


  }

  static int WIDTH = 320;
  static int HEIGHT = 320;

  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Drawing");
    jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    LinePlayQuarters.ImagePanel panel = new LinePlayQuarters.ImagePanel();
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

