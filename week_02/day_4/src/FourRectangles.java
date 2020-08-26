import javax.swing.*;

import java.awt.*;


import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class FourRectangles {

  public static void mainDraw(Graphics graphics) {
    // draw four different size and color rectangles.
    // avoid code duplication.

    Color[] rectColors = {Color.GREEN, Color.BLUE, Color.RED, Color.ORANGE};
    int[] xes = {15, 30, 45, 60};
    int[] yes = {15, 20, 50, 10};
    int[] rectWidths = {10, 15, 20, 25};
    int[] rectHeights = {25, 20, 15, 10};

    for (int i = 0; i < 4; i++) {
      graphics.setColor(rectColors[i]);
      graphics.fillRect(xes[i], yes[i], rectWidths[i], rectHeights[i]);
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