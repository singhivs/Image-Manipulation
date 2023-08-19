package model;

import model.image.Image;

/**
 * An interface that represents the methods needed for processing an image.
 */
public interface ImageProcessingModel {

  /**
   * Adds an image with the given name into the Map of images.
   *
   * @param name the name of the new image
   * @param im   the image to be added
   */
  void addImage(String name, Image im);

  /**
   * Returns the image with the given name from the model.
   *
   * @param name the key of the image
   * @return returns the image from the model
   */
  Image getImage(String name);

  /**
   * Adds a new image to the HashMap made up of the value of the
   * red component of the given image for all the rgb values.
   *
   * @param name     the name of the given image
   * @param destName the name of the new image
   * @return the image added
   */
  Image createRed(String name, String destName);

  /**
   * Adds a new image to the HashMap made up of the value of the
   * green component of the given image for all the rgb values.
   *
   * @param name     the name of the given image
   * @param destName the name of the new image
   * @return the image added
   */
  Image createGreen(String name, String destName);

  /**
   * Adds a new image to the HashMap made up of the value of the
   * blue component of the given image for all the rgb values.
   *
   * @param name     the name of the given image
   * @param destName the name of the new image
   * @return the image added
   */
  Image createBlue(String name, String destName);

  /**
   * Adds a new image to the HashMap made up of the value of the
   * max value of the rgb values of the given image for all the rgb values.
   *
   * @param name     the name of the given image
   * @param destName the name of the new image
   * @return the image added
   */
  Image createValue(String name, String destName);

  /**
   * Adds a new image to the HashMap made up of the value of the
   * average of the rgb values of the given image for all the rgb values.
   *
   * @param name     the name of the given image
   * @param destName the name of the new image
   * @return the image added
   */
  Image createIntensity(String name, String destName);

  /**
   * Adds a new image to the HashMap made up of the value of the
   * max value of the rgb values of the given image for all the rgb values.
   *
   * @param name     the name of the given image
   * @param destName the name of the new image
   * @return the image added
   */
  Image createLuma(String name, String destName);

  /**
   * Adds a new image to the HashMap where the image is the given image
   * flipped horizontally.
   *
   * @param name     the name of the given image
   * @param destName the name of the new image
   * @return the image added
   */
  Image flipHoriz(String name, String destName);

  /**
   * Adds a new image to the HashMap made up of the value of the
   * max value of the rgb values of the given image for all the rgb values.
   *
   * @param name     the name of the given image
   * @param destName the name of the new image
   * @return the image added
   */
  Image flipVert(String name, String destName);

  /**
   * Adds a new image to the HashMap where the image is
   * the given image with the interval added to each component
   * for all the rgb values.
   * If the component goes above the max value, it is set to the max value.
   *
   * @param brightness the number by which each component increases
   * @param name       the name of the given image
   * @param destName   the name of the new image
   * @return the image added
   */
  Image brighten(int brightness, String name, String destName);

  /**
   * Adds a new image to the HashMap where the image is
   * the given image with the interval subtracted from each component
   * for all the rgb values.
   * If the component goes below zero, it is set to zero.
   *
   * @param darkness the number by which each component decreases
   * @param name     the name of the given image
   * @param destName the name of the new image
   * @return the image added
   */
  Image darken(int darkness, String name, String destName);

  /**
   * applies greyscale tone to the given image using the greyscale color transformation
   * and saves it under the destName.
   *
   * @param name     the image to be processed.
   * @param destName the name it will be added under
   * @return the greyscale image
   */
  Image greyScale(String name, String destName);

  /**
   * applies sepia tone to the given image using the sepia color transformation
   * and saves it under the destName.
   *
   * @param name     the image to be processed.
   * @param destName the name it will be added under
   * @return the sepia image
   */
  Image sepia(String name, String destName);

  /**
   * blurs the given image using the blur filter
   * and saves it under the destName.
   *
   * @param name     the image to be blurred.
   * @param destName the name it will be added under
   * @return the blurred image
   */
  Image blur(String name, String destName);

  /**
   * sharpens the given image using the sharpen filter
   * and saves it under the destName.
   *
   * @param name     the image to be sharpened.
   * @param destName the name it will be added under
   * @return the sharpened image
   */
  Image sharpen(String name, String destName);

  /**
   * applies a mosaic effect to the given image using the Mosaic class
   * and saves it under the destName.
   *
   * @param name     the image to be processed.
   * @param destName the name it will be added under
   * @param seeds    the number of seeds for the mosaic
   * @return the mosaic image
   */
  Image mosaic(String name, String destName, int seeds);
}

