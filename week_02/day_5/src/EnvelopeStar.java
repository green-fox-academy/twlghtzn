import javax.swing.*;

import java.awt.*;


import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class EnvelopeStar {

  public static void mainDraw(Graphics graphics) {

    graphics.setColor(Color.GREEN);
    int x1 = 160;
    int y1 = 0;
    int w1 = 160;
    int z1 = 160;

    int x2 = 160;
    int y2 = 320;
    int w2 = 160;
    int z2 = 160;


    int a = x1;
    int b = y1;
    int c = w1;
    int d = z1;
    for (int i = 0; i < 16; i++) {
      graphics.drawLine(a, b, c, d);
      b += 10;
      c -= 10;
    }
    a = x1;
    b = y1;
    c = w1;
    d = z1;
    for (int i = 0; i < 16; i++) {
      graphics.drawLine(a, b, c, d);
      b += 10;
      c += 10;
    }
    a = x2;
    b = y2;
    c = w2;
    d = z2;
    for (int i = 0; i < 16; i++) {
      graphics.drawLine(a, b, c, d);
      b -= 10;
      c -= 10;
    }
    a = x2;
    b = y2;
    c = w2;
    d = z2;
    for (int i = 0; i < 16; i++) {
      graphics.drawLine(a, b, c, d);
      b -= 10;
      c += 10;
    }
  }


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

