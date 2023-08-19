package controller;

/**
 * An interface that represents an ImageProcessing Controller,
 * with all of the methods needed to run a program,
 * including loading and saving an Image.
 */
public interface ImageProcessingController {
  /**
   * Runs the Image Processing Program.
   */
  void runProgram();

  /**
   * A method that load an image at the given path and to the given name.
   *
   * @param path the path of the image to be loaded
   * @param name the name under which the image is referred
   */
  void load(String path, String name);

  /**
   * A method that sames the image under the given name to the given path.
   *
   * @param path the path under which the image is saved
   * @param name the name that the image can be found under
   */
  void save(String path, String name);
}
