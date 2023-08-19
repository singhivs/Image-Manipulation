package view;

import java.io.IOException;
import java.util.Scanner;

/**
 * A class representing the text view for an image ending in .ppm.
 */
public class PPMTextView implements ImageProcessingView {

  private Appendable out;

  /**
   * Constructs the default PPMTextView where out is System.out.
   */
  public PPMTextView() {
    this.out = System.out;
  }

  /**
   * Constructs a PPMTextView with the given Appendable.
   * @param out anything that can be appended to
   */
  public PPMTextView(Appendable out) {
    this.out = out;
  }

  /**
   * Shows an arbitrary message, allowing this view to
   * show messages determined by whoever uses it.
   *
   * @param message the message to be transmitted
   * @throws IllegalStateException if transmission to view failed
   */
  public void renderMessage(String message) throws IllegalStateException {
    try {
      out.append(message);
    }
    catch (IOException e) {
      e.printStackTrace();
      throw new IllegalStateException("Transmission to view failed");
    }
  }

  /**
   * Prints the pixels in the given Scanner.
   * @param sc the given Scanner
   * @param width the width of the image
   * @param height the height of the image
   * @throws IllegalStateException if transmission to view failed
   */
  public void printColors(Scanner sc, int width, int height) throws IllegalStateException {
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        int r = sc.nextInt();
        int g = sc.nextInt();
        int b = sc.nextInt();
        try {
          out.append("Color of pixel (" + i + "," + j + "): "
                  + r + "," + g + "," + b + "\n");
        }
        catch (IOException e) {
          e.printStackTrace();
          throw new IllegalStateException("Transmission to view failed");
        }
      }
    }
  }

}
