import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Triangels {

  public static void mainDraw(Graphics graphics) {
    int x = 0;
    int y = 320;
    int w = 320;
    int z = 320;
    graphics.setColor(Color.BLACK);
    for (int i = 0; i < 23; i++) {
      graphics.drawLine(x, y, w, z);
      x += 7;
      w -= 7;
      y -= 10;
      z -= 10;
    }
    x = 0;
    y = 320;
    w = 160;
    z = 90;
    for (int i = 0; i < 23; i++) {
      graphics.drawLine(x, y, w, z);
      x += 14;
      w += 7;
      z += 10;
    }
    x = 320;
    y = 320;
    w = 160;
    z = 90;
    for (int i = 0; i < 23; i++) {
      graphics.drawLine(x, y, w, z);
      x -= 14;
      w -= 7;
      z += 10;
    }
}
  static int WIDTH = 320;
  static int HEIGHT = 320;

  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Drawing");
    jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    Triangels.ImagePanel panel = new Triangels.ImagePanel();
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

