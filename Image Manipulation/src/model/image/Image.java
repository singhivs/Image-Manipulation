package model.image;

import java.awt.image.BufferedImage;

/**
 * An interface that represents an Image.
 */
public interface Image {
  int getWidth();

  int getHeight();

  int getMaxVal();

  Color[][] getColors();

  String getPath();

  Integer[] createRedHistogram();

  Integer[] createGreenHistogram();

  Integer[] createBlueHistogram();

  Integer[] createIntensityHistogram();

  BufferedImage createBufferedImage();

  BufferedImage getBImage();

  BufferedImage createHistogram();

  BufferedImage getHist();
}
