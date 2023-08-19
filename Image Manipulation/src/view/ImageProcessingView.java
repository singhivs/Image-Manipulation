package view;

import java.util.Scanner;

/**
 * An interface with methods required to view an image.
 */
public interface ImageProcessingView {

  /**
   * renders the given message.
   * @param message a String message
   * @throws IllegalStateException if it could not render the given message
   */
  void renderMessage(String message) throws IllegalStateException;

  /**
   * Prints the Colors in the given Scanner.
   * @param sc the given Scanner, with each int representing an rgb value
   * @param width the width of the image
   * @param height the height of the image
   * @throws IllegalStateException if out could not be appended to
   */
  void printColors(Scanner sc, int width, int height) throws IllegalStateException;
}
