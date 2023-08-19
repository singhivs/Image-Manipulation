package model;

import java.util.Map;

import model.image.Color;
import model.image.Image;
import model.image.PPMImage;

/**
 * A class that represents the model a list of any ppm image,
 * and can create and save new versions of its images.
 */
public class PPMImageModel extends AbstractImageModel {
  /**
   * The default constructor.
   */
  public PPMImageModel() {
    super();
  }

  /**
   * A constructor that takes in a Map of images.
   *
   * @param images the given Map of images
   */
  public PPMImageModel(Map<String, Image> images) {
    super(images);
  }

  @Override
  protected Image saveInProgram(String destName, int width, int height, int maxVal,
                                Color[][] colors, String path) {
    PPMImage newImage = new PPMImage(width, height, maxVal, colors, path);
    images.put(destName, newImage);
    return newImage;
  }
}
