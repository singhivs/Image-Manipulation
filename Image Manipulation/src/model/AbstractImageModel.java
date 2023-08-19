package model;

import java.util.HashMap;
import java.util.Map;

import model.image.Color;
import model.image.GeneralImage;
import model.image.Image;
import model.image.Mosaic;

/**
 * A class that represent an Abstract Image Model that
 * has all the methods needed to create new versions of an image.
 */
public abstract class AbstractImageModel implements ImageProcessingModel {
  protected Map<String, Image> images;

  protected AbstractImageModel() {
    this.images = new HashMap<>();
  }

  /**
   * A constructor that takes in a Map of images for the purpose of testing.
   *
   * @param images the given Map of images
   */
  public AbstractImageModel(Map<String, Image> images) {
    this.images = images;
  }

  /**
   * Adds an image with the given name into the Map of images.
   *
   * @param name the name of the new image
   * @param im   the image to be added
   */
  public void addImage(String name, Image im) {
    images.put(name, im);
  }

  /**
   * Creates an image that visualizes red channel.
   *
   * @param name     the name of the given image
   * @param destName the name to save as
   * @return the grayscale image created
   */
  @Override
  public Image createRed(String name, String destName) {
    Image image = this.getImage(name);
    int width = image.getWidth();
    int height = image.getHeight();
    int maxVal = image.getMaxVal();
    String path = image.getPath();
    Color[][] newImage = this.createRedHelp(image, width, height);
    return this.saveInProgram(destName, width, height, maxVal,
            newImage, path);
  }

  /**
   * Creates an image that visualizes green channel.
   *
   * @param name     the name of the given image
   * @param destName the name to save as
   * @return the grayscale image created
   */
  @Override
  public Image createGreen(String name, String destName) {
    Image image = this.getImage(name);
    int width = image.getWidth();
    int height = image.getHeight();
    int maxVal = image.getMaxVal();
    String path = image.getPath();
    Color[][] newImage = this.createGreenHelp(image, width, height);
    return this.saveInProgram(destName, width, height, maxVal,
            newImage, path);
  }

  /**
   * Creates an image that visualizes blue channel.
   *
   * @param name     the name of the given image
   * @param destName the name to save as
   * @return the grayscale image created
   */
  @Override
  public Image createBlue(String name, String destName) {
    Image image = this.getImage(name);
    int width = image.getWidth();
    int height = image.getHeight();
    int maxVal = image.getMaxVal();
    String path = image.getPath();
    Color[][] newImage = this.createBlueHelp(image, width, height);
    return this.saveInProgram(destName, width, height, maxVal,
            newImage, path);
  }

  /**
   * Creates an image that visualizes value.
   *
   * @param name     the name of the given image
   * @param destName the name to save as
   * @return the grayscale image created
   */
  @Override
  public Image createValue(String name, String destName) {
    Image image = this.getImage(name);
    int width = image.getWidth();
    int height = image.getHeight();
    int maxVal = image.getMaxVal();
    String path = image.getPath();
    Color[][] newImage = this.createValueHelp(image, width, height);
    return this.saveInProgram(destName, width, height, maxVal,
            newImage, path);
  }

  /**
   * Creates an image that visualizes intensity.
   *
   * @param name     the name of the given image
   * @param destName the name to save as
   * @return the grayscale image created
   */
  @Override
  public Image createIntensity(String name, String destName) {
    Image image = this.getImage(name);
    int width = image.getWidth();
    int height = image.getHeight();
    int maxVal = image.getMaxVal();
    String path = image.getPath();
    Color[][] newImage = this.createIntensityHelp(image, width, height);
    return this.saveInProgram(destName, width, height, maxVal,
            newImage, path);
  }

  /**
   * Creates an image that visualizes luma.
   *
   * @param name     the name of the given image
   * @param destName the name to save as
   * @return the grayscale image created
   */
  @Override
  public Image createLuma(String name, String destName) {
    Image image = this.getImage(name);
    int width = image.getWidth();
    int height = image.getHeight();
    int maxVal = image.getMaxVal();
    String path = image.getPath();
    Color[][] newImage = this.createLumaHelp(image, width, height);
    return this.saveInProgram(destName, width, height, maxVal,
            newImage, path);
  }

  /**
   * Flips an image horizontally.
   *
   * @param name     the name of the given image
   * @param destName the name to save as
   * @return the flipped image
   */
  @Override
  public Image flipHoriz(String name, String destName) {
    Image image = this.getImage(name);
    int width = image.getWidth();
    int height = image.getHeight();
    int maxVal = image.getMaxVal();
    String path = image.getPath();
    Color[][] newImage = this.createFlipHorizHelp(image, width, height);
    return this.saveInProgram(destName, width, height, maxVal,
            newImage, path);
  }

  /**
   * Flips an image vertically.
   *
   * @param name     the name of the given image
   * @param destName the name to save as
   * @return the flipped image
   */
  @Override
  public Image flipVert(String name, String destName) {
    Image image = this.getImage(name);
    int width = image.getWidth();
    int height = image.getHeight();
    int maxVal = image.getMaxVal();
    String path = image.getPath();
    Color[][] newImage = this.createFlipVertHelp(image, width, height);
    return this.saveInProgram(destName, width, height, maxVal,
            newImage, path);
  }

  /**
   * Brightens the image by the given integer.
   *
   * @param brightness the brightness added
   * @param name       the name of the image
   * @param destName   the name to save as
   * @return the brightened image
   */
  @Override
  public Image brighten(int brightness, String name, String destName) {
    Image image = this.getImage(name);
    int width = image.getWidth();
    int height = image.getHeight();
    int maxVal = image.getMaxVal();
    String path = image.getPath();
    Color[][] newImage = this.createBrightenHelp(brightness, image, width, height);
    return this.saveInProgram(destName, width, height, maxVal,
            newImage, path);
  }

  /**
   * Darkens the image by the given integer.
   *
   * @param darkness the brightness added
   * @param name     the name of the image
   * @param destName the name to save as
   * @return the darkened image
   */
  @Override
  public Image darken(int darkness, String name, String destName) {
    Image image = this.getImage(name);
    int width = image.getWidth();
    int height = image.getHeight();
    int maxVal = image.getMaxVal();
    String path = image.getPath();
    Color[][] newImage = this.createDarkenHelp(darkness, image, width, height);
    return this.saveInProgram(destName, width, height, maxVal,
            newImage, path);
  }

  /**
   * applies a mosaic effect to the given image using the Mosaic class
   * and saves it under the destName.
   *
   * @param name     the image to be processed.
   * @param destName the name it will be added under
   * @param seeds    the number of seeds for the mosaic
   * @return the mosaic image
   */
  @Override
  public Image mosaic(String name, String destName, int seeds) {
    Image image = this.getImage(name);
    Mosaic mosaic = new Mosaic(seeds);
    int width = image.getWidth();
    int height = image.getHeight();
    int maxVal = image.getMaxVal();
    String path = image.getPath();
    Image newImage = mosaic.applyMosaic(image);
    return this.saveInProgram(destName, width, height, maxVal,
            newImage.getColors(), path);
  }

  protected Image saveInProgram(String destName, int width, int height, int maxVal,
                                Color[][] colors, String path) {
    Image newImage = new GeneralImage(width, height, colors, path);
    images.put(destName, newImage);
    return newImage;
  }


  protected Color[][] createRedHelp(Image im, int width, int height) {
    Color[][] image = im.getColors();
    Color[][] red = new Color[height][width];

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        int r = image[i][j].getRed();
        red[i][j] = new Color(r, r, r);
      }
    }
    return red;
  }

  protected Color[][] createGreenHelp(Image im, int width, int height) {
    Color[][] image = im.getColors();
    Color[][] green = new Color[height][width];

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        int g = image[i][j].getGreen();
        green[i][j] = new Color(g, g, g);
      }
    }
    return green;
  }

  protected Color[][] createBlueHelp(Image im, int width, int height) {
    Color[][] image = im.getColors();
    Color[][] blue = new Color[height][width];

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        int b = image[i][j].getBlue();
        blue[i][j] = new Color(b, b, b);
      }
    }
    return blue;
  }

  protected Color[][] createValueHelp(Image im, int width, int height) {
    Color[][] image = im.getColors();
    Color[][] value = new Color[height][width];

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        value[i][j] = image[i][j].valueColor();
      }
    }
    return value;
  }

  protected Color[][] createIntensityHelp(Image im, int width, int height) {
    Color[][] image = im.getColors();
    Color[][] intensity = new Color[height][width];

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        intensity[i][j] = image[i][j].intensityColor();
      }
    }
    return intensity;
  }

  protected Color[][] createLumaHelp(Image im, int width, int height) {
    Color[][] image = im.getColors();
    Color[][] luma = new Color[height][width];

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        luma[i][j] = image[i][j].lumaColor();
      }
    }
    return luma;
  }

  protected Color[][] createBrightenHelp(int brightness, Image im, int width, int height) {
    Color[][] image = im.getColors();
    Color[][] brighten = new Color[height][width];

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        brighten[i][j] = image[i][j].brightenColor(brightness, im.getMaxVal());
      }
    }
    return brighten;
  }

  protected Color[][] createDarkenHelp(int darkness, Image im, int width, int height) {
    Color[][] image = im.getColors();
    Color[][] darken = new Color[height][width];

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        darken[i][j] = image[i][j].darkenColor(darkness);
      }
    }
    return darken;
  }

  protected Color[][] createFlipHorizHelp(Image im, int width, int height) {
    Color[][] image = im.getColors();
    Color[][] flip = new Color[height][width];

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        flip[(height - 1) - i][j] = image[i][j];
      }
    }
    return flip;
  }

  protected Color[][] createFlipVertHelp(Image im, int width, int height) {
    Color[][] image = im.getColors();
    Color[][] flip = new Color[height][width];

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        flip[i][(width - 1) - j] = image[i][j];
      }
    }
    return flip;
  }


  /**
   * gets the image with the given String name in images.
   *
   * @param name the name of the image in the images Map
   * @return the image at the given name
   * @throws IllegalStateException if the image name is null
   */
  public Image getImage(String name) throws IllegalStateException {
    if (images.get(name) == null) {
      throw new IllegalStateException("Image not found");
    } else {
      return images.get(name);
    }
  }

  private final Double[][] greyScale = new Double[][]{{0.2126, 0.7152, 0.0722},
      {0.2126, 0.7152, 0.0722}, {0.2126, 0.7152, 0.0722}};

  private final Double[][] sepia = new Double[][]{{0.393, 0.769, 0.189},
      {0.349, 0.686, 0.168}, {0.272, 0.534, 0.131}};

  @Override
  public Image greyScale(String name, String destName) {
    Image image = this.getImage(name);
    int width = image.getWidth();
    int height = image.getHeight();
    int maxVal = image.getMaxVal();
    String path = image.getPath();
    Color[][] newImage = this.colorTransform(image, width, height, this.greyScale);
    return saveInProgram(destName, width, height, maxVal, newImage, path);
  }

  @Override
  public Image sepia(String name, String destName) {
    Image image = this.getImage(name);
    int width = image.getWidth();
    int height = image.getHeight();
    int maxVal = image.getMaxVal();
    String path = image.getPath();
    Color[][] newImage = this.colorTransform(image, width, height, this.sepia);
    return saveInProgram(destName, width, height, maxVal, newImage, path);
  }


  private Color[][] colorTransform(Image im, int width, int height, Double[][] matrix) {
    Color[][] image = im.getColors();
    Color[][] transformed = new Color[height][width];
    int maxValue = im.getMaxVal();

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        int r = image[i][j].getRed();
        int g = image[i][j].getGreen();
        int b = image[i][j].getBlue();
        int rT = (int) Math.round(r * matrix[0][0] + g * matrix[0][1] + b * matrix[0][2]);
        int newR = checkUpperBounds(rT, maxValue);
        int gT = (int) Math.round(r * matrix[1][0] + g * matrix[1][1] + b * matrix[1][2]);
        int newG = checkUpperBounds(gT, maxValue);
        int bT = (int) Math.round(r * matrix[2][0] + g * matrix[2][1] + b * matrix[2][2]);
        int newB = checkUpperBounds(bT, maxValue);
        transformed[i][j] = new Color(newR, newG, newB);
      }
    }
    return transformed;
  }

  private int checkUpperBounds(int value, int maxValue) {
    int newValue;
    if (maxValue < value) {
      newValue = maxValue;
    } else {
      newValue = value;
    }
    return newValue;
  }

  private int checkLowerBounds(int value) {
    int newValue;
    if (0 > value) {
      newValue = 0;
    } else {
      newValue = value;
    }
    return newValue;
  }

  /**
   * The built-in blur filter, set as final private static to avoid modification and outer change.
   */
  private final static Double[][] blurFilter = new Double[][]{{0.0625, 0.125, 0.0625},
      {0.125, 0.25, 0.125}, {0.0625, 0.125, 0.0625}};

  /**
   * The built-in sharp filter, set as final private static to avoid modification and outer change.
   */
  private final static Double[][] sharpenFilter = new Double[][]{
          {-0.125, -0.125, -0.125, -0.125, -0.125},
          {-0.125, 0.25, 0.25, 0.25, -0.125}, {-0.125, 0.25, 1.0, 0.25, -0.125},
          {-0.125, 0.25, 0.25, 0.25, -0.125}, {-0.125, -0.125, -0.125, -0.125, -0.125}};

  /**
   * blurs the given image using the blur filter
   * and saves it under the destName.
   *
   * @param name     the image to be blurred.
   * @param destName the name it will be added under
   * @return the blurred image
   */
  public Image blur(String name, String destName) {
    Image image = this.getImage(name);
    int width = image.getWidth();
    int height = image.getHeight();
    int maxVal = image.getMaxVal();
    String path = image.getPath();
    Color[][] newImage = this.filterHelp(image, this.blurFilter, width, height);
    return saveInProgram(destName, width, height, maxVal,
            newImage, path);
  }

  /**
   * sharpens the given image using the sharpen filter
   * and saves it under the destName.
   *
   * @param name     the image to be sharpened.
   * @param destName the name it will be added under
   * @return the sharpened image
   */
  public Image sharpen(String name, String destName) {
    Image image = this.getImage(name);
    int width = image.getWidth();
    int height = image.getHeight();
    int maxVal = image.getMaxVal();
    String path = image.getPath();
    Color[][] newImage = this.filterHelp(image, this.sharpenFilter, width, height);
    return saveInProgram(destName, width, height, maxVal,
            newImage, path);
  }

  private Color[][] filterHelp(Image im, Double[][] filter, int width, int height) {
    Color[][] image = im.getColors();
    Color[][] filtered = new Color[height][width];
    int maxValue = im.getMaxVal();

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        int rF = (int) Math.round(filtering(filter, image, 0,
                width, height, i, j));
        int zeroRF = checkLowerBounds(rF);
        int limRF = checkUpperBounds(zeroRF, maxValue);
        int gF = (int) Math.round(filtering(filter, image, 1,
                width, height, i, j));
        int zeroGF = checkLowerBounds(gF);
        int limGF = checkUpperBounds(zeroGF, maxValue);
        int bF = (int) Math.round(filtering(filter, image, 2,
                width, height, i, j));
        int zeroBF = checkLowerBounds(bF);
        int limBF = checkUpperBounds(zeroBF, maxValue);
        filtered[i][j] = new Color(limRF, limGF, limBF);
      }
    }
    return filtered;
  }

  private Double filtering(Double[][] matrix, Color[][] im, int channel,
                           int width, int height, int i, int j) {
    int w = matrix.length;
    int h = matrix.length;
    int half = matrix.length / 2;
    int iS = i - half;
    int jS;
    double result = 0.0;
    for (int k = 0; k < h; k++) {
      jS = j - half;
      iS = iS + 1;
      for (int l = 0; l < w; l++) {
        if (channel == 0) {
          if (isWithin(height, width, iS, jS)) {
            int r = im[iS][jS].getRed();
            result = result + matrix[k][l] * r;
          }
        } else if (channel == 1) {
          if (isWithin(height, width, iS, jS)) {
            int g = im[iS][jS].getGreen();
            result = result + matrix[k][l] * g;
          }
        } else {
          if (isWithin(height, width, iS, jS)) {
            int b = im[iS][jS].getBlue();
            result = result + matrix[k][l] * b;
          }
        }
        jS = jS + 1;
      }
    }
    return result;
  }

  private static boolean isWithin(int height, int width, int iS, int jS) {
    return iS >= 0 && iS < height && jS >= 0 && jS < width;
  }


}
