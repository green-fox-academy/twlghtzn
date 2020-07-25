import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class LinePlay {

  public static void mainDraw(Graphics graphics) {

    int x = 60;
    int y = 5;
    int w = 315;
    int z = 25;
    for (int i = 0; i < 13; i++) {
      graphics.setColor(Color.MAGENTA);
      graphics.drawLine(x, y, w, z);
      x += 20;
      z += 20;
    }

    x = 5;
    y = 60;
    w = 25;
    z = 315;
    for (int i = 0; i < 13; i++) {
      graphics.setColor(Color.GREEN);
      graphics.drawLine(x, y, w, z);
      y += 20;
      w += 20;
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


