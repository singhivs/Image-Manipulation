package model.image;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * A class that represents an AbstractImage that constructs
 * an Image as well as contains methods for getting its fields.
 */
public abstract class AbstractImage implements Image {
  protected int width;
  protected int height;
  protected int maxVal;
  protected Color[][] image;
  protected String path;
  protected BufferedImage bImage;
  protected BufferedImage hist;

  protected AbstractImage(int width, int height, int maxVal, Color[][] image, String path) {
    this.width = width;
    this.height = height;
    this.maxVal = maxVal;
    this.image = image;
    this.path = path;
    this.bImage = createBufferedImage();
    //this.hist = createHistogram();
  }

  protected AbstractImage(int width, int height, Color[][] image, String path) {
    this.width = width;
    this.height = height;
    this.maxVal = 255;
    this.image = image;
    this.path = path;
  }

  /**
   * Returns the width.
   *
   * @return the width
   */
  @Override
  public int getWidth() {
    return this.width;
  }

  /**
   * Returns the height.
   *
   * @return the height
   */
  @Override
  public int getHeight() {
    return this.height;
  }

  /**
   * Returns the maxVal.
   *
   * @return the maxVal
   */
  @Override
  public int getMaxVal() {
    return this.maxVal;
  }

  /**
   * Returns the pixels.
   *
   * @return the pixels
   */
  @Override
  public Color[][] getColors() {
    return this.image;
  }

  public String getPath() {
    return this.path;
  }


  @Override
  public Integer[] createRedHistogram() {
    Integer[] hist = new Integer[maxVal];
    for (int i = 0; i < this.height; i++) {
      for (int j = 0; j < this.width; j++) {
        hist[this.image[i][j].getRed()] += 1;
      }
    }
    return hist;
  }


  @Override
  public Integer[] createGreenHistogram() {
    Integer[] hist = new Integer[maxVal];
    for (int i = 0; i < this.height; i++) {
      for (int j = 0; j < this.width; j++) {
        hist[this.image[i][j].getGreen()] += 1;
      }
    }
    return hist;
  }

  @Override
  public Integer[] createBlueHistogram() {
    Integer[] hist = new Integer[maxVal];
    for (int i = 0; i < this.height; i++) {
      for (int j = 0; j < this.width; j++) {
        hist[this.image[i][j].getBlue()] += 1;
      }
    }
    return hist;
  }

  @Override
  public Integer[] createIntensityHistogram() {
    Integer[] hist = new Integer[maxVal];
    for (int i = 0; i < this.height; i++) {
      for (int j = 0; j < this.width; j++) {
        hist[this.image[i][j].getIntensity()] += 1;
      }
    }
    return hist;
  }

  @Override
  public BufferedImage createHistogram() {
    Integer[] redHist = this.createRedHistogram();
    Integer[] blueHist = this.createBlueHistogram();
    Integer[] greenHist = this.createGreenHistogram();
    Integer[] intensityHist = this.createIntensityHistogram();
    BufferedImage im = new BufferedImage(this.height, redHist.length, BufferedImage.TYPE_INT_RGB);
    Graphics g = im.getGraphics();
    int redy1;
    int redy2;
    int greeny1;
    int greeny2;
    int bluey1;
    int bluey2;
    int intensityy1;
    int intensityy2;

    for (int i = 0; i < redHist.length; i++) {
      redy1 = redHist[i];
      redy2 = redHist[i + 1];
      g.setColor(java.awt.Color.red);
      g.drawLine(i, redy1, i + 1, redy2);

      greeny1 = greenHist[i];
      greeny2 = greenHist[i + 1];
      g.setColor(java.awt.Color.green);
      g.drawLine(i, greeny1, i + 1, greeny2);

      bluey1 = blueHist[i];
      bluey2 = blueHist[i + 1];
      g.setColor(java.awt.Color.blue);
      g.drawLine(i, bluey1, i + 1, bluey2);

      intensityy1 = intensityHist[i];
      intensityy2 = intensityHist[i + 1];
      g.setColor(java.awt.Color.black);
      g.drawLine(i, intensityy1, i + 1, intensityy2);
    }
    return im;
  }

  @Override
  public BufferedImage getHist() {
    return this.hist;
  }

  @Override
  public BufferedImage createBufferedImage() {
    BufferedImage im = new BufferedImage(width,
            height, BufferedImage.TYPE_INT_RGB);

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        Color rgbValues = this.image[i][j];
        java.awt.Color color = new java.awt.Color(rgbValues.getRed(),
                rgbValues.getGreen(), rgbValues.getBlue());
        im.setRGB(j, i, color.getRGB());
      }
    }
    return im;
  }

  @Override
  public BufferedImage getBImage() {
    return this.bImage;
  }
}
