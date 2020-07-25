import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Checkerboard {
  public static void mainDraw(Graphics graphics) {
    // Fill the canvas with a checkerboard pattern.

    int x = 0;
    int y = 0;
    int size = 40;
    for (int i = 0; i < 8; i++) {
      if (i % 2 == 0) {
        x = 0;
        for (int j = 0; j < 4; j++) {
          graphics.setColor(Color.BLACK);
          graphics.fillRect(x, y, size, size);
          x += 80;
        }
      } else {
        x = 40;
        for (int j = 0; j < 4; j++) {
          graphics.setColor(Color.BLACK);
          graphics.fillRect(x, y, size, size);
          x += 80;
        }

      }
      y += 40;
    }
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