package model;

import java.util.Map;

import model.image.Image;

/**
 * A class that represents a general
 * image model or a model for all image types.
 * Contains methods for creating new altered images, loading them,
 * and saving them.
 */
public class GeneralImageModel extends AbstractImageModel {
  public GeneralImageModel() {
    super();
  }

  public GeneralImageModel(Map<String, Image> images) {
    super(images);
  }
}
