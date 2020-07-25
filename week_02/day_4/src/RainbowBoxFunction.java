import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class RainbowBoxFunction {
  public static void mainDraw(Graphics graphics) {
    // Create a square drawing function that takes 3 parameters:
    // The square size, the fill color, graphics
    // and draws a square of that size and color to the center of the canvas.
    // Create a loop that fills the canvas with rainbow colored squares (red, orange, yellow, green, blue, indigo, violet).

    Color INDIGO = new Color(75, 0, 130);
    Color VIOLET = new Color(93, 51, 93);
    int[] sizes = {320, 270, 220, 170, 120, 70, 20};
    Color[] rectColors = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, INDIGO, VIOLET};

    for (int i = 0; i < 7; i++) {
      graphics.setColor(rectColors[i]);
      graphics.fillRect((160 - (sizes[i] / 2)), (160 - (sizes[i] / 2)), sizes[i], sizes[i]);
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