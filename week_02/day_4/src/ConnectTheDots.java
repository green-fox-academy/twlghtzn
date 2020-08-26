import javax.swing.*;

import java.awt.*;


import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class ConnectTheDots {
  public static void mainDraw(Graphics graphics) {
    // Create a function that takes 2 parameters:
    // An array of {x, y} points and graphics
    // and connects them with green lines.
    // Connect these to get a box: {{10, 10}, {290,  10}, {290, 290}, {10, 290}}
    // Connect these: {{50, 100}, {70, 70}, {80, 90}, {90, 90}, {100, 70},
    // {120, 100}, {85, 130}, {50, 100}}

    int[] box = {10, 10, 290, 10, 290, 290, 10, 290, 10, 10};
    int[] shape = {50, 100, 70, 70, 80, 90, 90, 90, 100, 70, 120, 100, 85, 130, 50, 100, 50, 100};

    for (int i = 0; i < 8; i++) {
      graphics.setColor(Color.GREEN);
      if (i % 2 == 0) {
        graphics.drawLine(box[i], box[(i + 1)], box[(i + 2)], box[(i + 3)]);
      }
    }
    for (int i = 0; i < 16; i++) {
      graphics.setColor(Color.GREEN);
      if (i % 2 == 0) {
        graphics.drawLine(shape[i], shape[(i + 1)], shape[(i + 2)], shape[(i + 3)]);
      }
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