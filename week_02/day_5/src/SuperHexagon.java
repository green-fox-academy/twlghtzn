import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class SuperHexagon {

  public static void mainDraw(Graphics graphics) {

    int a = 155;
    int b = 30;
    for (int i = 0; i < 8; i++) {
      graphics.drawLine(a, b, (a + 10), b);
      b += 20;
    }

    a = 140;
    b = 40;
    for (int i = 0; i < 7; i++) {
      graphics.drawLine(a, b, (a + 10), b);
      b += 20;
    }

    a = 170;
    b = 40;
    for (int i = 0; i < 7; i++) {
      graphics.drawLine(a, b, (a + 10), b);
      b += 20;
    }

    a = 125;
    b = 50;
    for (int i = 0; i < 6; i++) {
      graphics.drawLine(a, b, (a + 10), b);
      b += 20;
    }

    a = 185;
    b = 50;
    for (int i = 0; i < 6; i++) {
      graphics.drawLine(a, b, (a + 10), b);
      b += 20;
    }

    a = 110;
    b = 60;
    for (int i = 0; i < 5; i++) {
      graphics.drawLine(a, b, (a + 10), b);
      b += 20;
    }

    a = 200;
    b = 60;
    for (int i = 0; i < 5; i++) {
      graphics.drawLine(a, b, (a + 10), b);
      b += 20;
    }

    //-60 fok
    a = 105;
    b = 70;
    for (int i = 0; i < 8; i++) {
      graphics.drawLine(a, b, (a + 5), (b - 10));
      a += 15;
      b += 10;
    }

    a = 105;
    b = 90;
    for (int i = 0; i < 7; i++) {
      graphics.drawLine(a, b, (a + 5), (b - 10));
      a += 15;
      b += 10;
    }

    a = 120;
    b = 60;
    for (int i = 0; i < 7; i++) {
      graphics.drawLine(a, b, (a + 5), (b - 10));
      a += 15;
      b += 10;
    }

    a = 105;
    b = 110;
    for (int i = 0; i < 6; i++) {
      graphics.drawLine(a, b, (a + 5), (b - 10));
      a += 15;
      b += 10;
    }

    a = 135;
    b = 50;
    for (int i = 0; i < 6; i++) {
      graphics.drawLine(a, b, (a + 5), (b - 10));
      a += 15;
      b += 10;
    }

    a = 105;
    b = 130;
    for (int i = 0; i < 5; i++) {
      graphics.drawLine(a, b, (a + 5), (b - 10));
      a += 15;
      b += 10;
    }

    a = 150;
    b = 40;
    for (int i = 0; i < 5; i++) {
      graphics.drawLine(a, b, (a + 5), (b - 10));
      a += 15;
      b += 10;
    }
    //+60 fok
    a = 210;
    b = 60;
    for (int i = 0; i < 8; i++) {
      graphics.drawLine(a, b, (a + 5), (b + 10));
      a -= 15;
      b += 10;
    }
    a = 195;
    b = 50;
    for (int i = 0; i < 7; i++) {
      graphics.drawLine(a, b, (a + 5), (b + 10));
      a -= 15;
      b += 10;
    }
    a = 210;
    b = 80;
    for (int i = 0; i < 7; i++) {
      graphics.drawLine(a, b, (a + 5), (b + 10));
      a -= 15;
      b += 10;
    }
    a = 180;
    b = 40;
    for (int i = 0; i < 6; i++) {
      graphics.drawLine(a, b, (a + 5), (b + 10));
      a -= 15;
      b += 10;
    }
    a = 210;
    b = 100;
    for (int i = 0; i < 6; i++) {
      graphics.drawLine(a, b, (a + 5), (b + 10));
      a -= 15;
      b += 10;
    }
    a = 165;
    b = 30;
    for (int i = 0; i < 5; i++) {
      graphics.drawLine(a, b, (a + 5), (b + 10));
      a -= 15;
      b += 10;
    }
    a = 210;
    b = 120;
    for (int i = 0; i < 5; i++) {
      graphics.drawLine(a, b, (a + 5), (b + 10));
      a -= 15;
      b += 10;
    }
  }

  static int WIDTH = 320;
  static int HEIGHT = 320;

  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Drawing");
    jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    SuperHexagon.ImagePanel panel = new SuperHexagon.ImagePanel();
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
