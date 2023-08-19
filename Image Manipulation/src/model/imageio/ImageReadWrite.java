package model.imageio;

import java.io.IOException;

import model.image.Color;

/**
 * An interface that contains methods for reading and writing an image.
 */
public interface ImageReadWrite {
  void exportImage(String path, Color[][] rgb) throws IOException;

  Color[][] readRGB() throws IOException;
}
