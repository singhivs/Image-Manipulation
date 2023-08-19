package model.image;

/**
 * A class that represents a PPM Image.
 */
public class PPMImage extends AbstractImage {

  /**
   * A constructor that takes in the width, height, maxVal, pixels and image file of the image.
   *
   * @param width  the given width
   * @param height the given height
   * @param max    the given max
   * @param image  the given pixels
   * @param path   the path of the image file
   */
  public PPMImage(int width, int height, int max, Color[][] image, String path) {
    super(width, height, max, image, path);
  }
}
