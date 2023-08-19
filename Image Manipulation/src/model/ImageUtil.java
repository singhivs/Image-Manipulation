package model;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileInputStream;

import controller.ActionListenerController;
import controller.ImageProcessingController;
import controller.ImageProcessingControllerImpl;
import model.image.Color;
import model.image.Image;
import view.IView;
import view.ImageProcessingView;
import view.JFrameView;
import view.PPMTextView;


/**
 * This class contains utility methods to read a PPM image from file
 * and simply print its contents. Feel free to change this method
 * as required.
 */
public class ImageUtil {

  /**
   * Read an image file in the PPM format and print the colors.
   *
   * @param filename the path of the file.
   */
  public static void readPPM(String filename) throws IllegalStateException {
    ImageProcessingView view = new PPMTextView();

    String file = readPPMFile(filename, view);
    Scanner sc = new Scanner(file);

    String token;

    token = sc.next();
    if (!token.equals("P3")) {
      try {
        view.renderMessage("Invalid PPM file: plain RAW file should begin with P3\n");
      } catch (IllegalStateException e) {
        throw new IllegalStateException("Invalid file message error");
      }
    }
    int width = sc.nextInt();
    try {
      view.renderMessage("Width of image: " + width + "\n");
    } catch (IllegalStateException e) {
      throw new IllegalStateException("Print width error");
    }
    int height = sc.nextInt();
    try {
      view.renderMessage("Height of image: " + height + "\n");
    } catch (IllegalStateException e) {
      throw new IllegalStateException("Print height error");
    }
    int maxValue = sc.nextInt();
    try {
      view.renderMessage("Maximum value of a color in this file (usually 255): " + maxValue + "\n");
    } catch (IllegalStateException e) {
      throw new IllegalStateException("Print maximum value error");
    }

    try {
      view.printColors(sc, width, height);
    } catch (IllegalStateException e) {
      throw new IllegalStateException("Print colors error");
    }
  }

  /**
   * Runs an PPM Image Processing Program interactively on the console.
   *
   * @param args the user input
   */
  public static void ppmProgram(String[] args) {
    ImageProcessingModel model = new PPMImageModel();
    IView view = new JFrameView("Image Processing Program");
    ActionListenerController controller = new ActionListenerController(model, view);
  }

  /**
   * Runs an General Image Processing Program interactively on the console.
   *
   * @param args the user input
   */
  public static void main(String[] args) {
    /*
    ImageProcessingModel model = new PPMImageModel();
    IView view = new JFrameView("Image Processing Program");
    ActionListenerController controller = new ActionListenerController(model, view);
     */

    if (args.length == 0) {
      ImageProcessingModel model = new PPMImageModel();
      IView view = new JFrameView("Image Processing Program");
      ActionListenerController controller = new ActionListenerController(model, view);
    } else if (args[0].equalsIgnoreCase("-file")) {
      if (args.length < 2) {
        throw new IllegalArgumentException("Please enter txt file name after '-file' "
                + "for file-based scripting");
      }
      try {
        Readable rd = new FileReader(args[1]);
        Appendable ap = System.out;
        ImageProcessingModel model = new PPMImageModel();
        ImageProcessingView view = new PPMTextView();
        ImageProcessingController controller = new ImageProcessingControllerImpl(rd, model, view);
        controller.runProgram();
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }
    } else if (args[0].equalsIgnoreCase("-text")) {
      Readable rd = new InputStreamReader(System.in);
      Appendable ap = System.out;
      ImageProcessingModel model = new PPMImageModel();
      ImageProcessingView view = new PPMTextView();
      ImageProcessingController controller = new ImageProcessingControllerImpl(rd, model, view);
      controller.runProgram();
    } else {
      throw new IllegalArgumentException("not accepted command");

    }
  }

  /**
   * Reads the file from the given path and returns a String that represents the text in the file.
   *
   * @param filename the given path
   * @param view     the given ImageProcessingView
   * @return a String that represents the text in a file
   * @throws IllegalArgumentException if transmission to view failed
   */
  public static String readPPMFile(String filename, ImageProcessingView view)
          throws IllegalArgumentException {
    Scanner sc;

    try {
      sc = new Scanner(new FileInputStream(filename));
    } catch (FileNotFoundException e) {
      try {
        view.renderMessage("File " + filename + " not found!");
      } catch (IllegalStateException se) {
        throw new IllegalStateException("File not found message error");
      }
      return "";
    }
    StringBuilder builder = new StringBuilder();
    //read the file line by line, and populate a string. This will throw away any comment lines
    while (sc.hasNextLine()) {
      String s = sc.nextLine();
      if (s.charAt(0) != '#') {
        builder.append(s + System.lineSeparator());
      }
    }

    return builder.toString();
  }

  /**
   * Creates the pixels of the given file.
   *
   * @param file   text in the ppm file
   * @param width  the width of the image
   * @param height the height of the image
   * @return a Color[][] that represents the pixels of the given file
   */
  public Color[][] createImage(String file, int width, int height) {
    Scanner sc = new Scanner(file);
    sc.next();
    sc.next();
    sc.next();

    Color[][] image = new Color[height][width];
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        int r = sc.nextInt();
        int g = sc.nextInt();
        int b = sc.nextInt();
        image[i][j] = new Color(r, g, b);
      }
    }
    return image;
  }

  /**
   * Transforms the given pixels to the corresponding image file.
   *
   * @param image  the given pixels
   * @param width  the width of the image
   * @param height the height of the image
   * @param maxVal the given maxVal
   * @return String that represents the image file
   */
  public static String toImageFile(Color[][] image, int width, int height, int maxVal) {
    String file = "P3" + " " + width + " " + height + " " + maxVal + "\n";
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        file = file + image[i][j].colorToString() + "\n";
      }
    }
    return file;
  }

  /**
   * adds the given image to the ppm filePath.
   *
   * @param filePath where the image should be added
   * @param img      the image to be written
   * @throws IllegalArgumentException if the filePath doesn't end in .ppm
   */
  public void writePPMFile(String filePath, Image img)
          throws IllegalArgumentException {
    Color[][] colors = img.getColors();
    if (filePath.endsWith("ppm")) {
      try {
        FileWriter file = new FileWriter(filePath);
        String imgFile = toImageFile(colors, img.getWidth(), img.getHeight(), img.getMaxVal());
        file.append(imgFile);
      } catch (IOException e) {
        e.printStackTrace();
      }
    } else {
      throw new IllegalArgumentException("FilePath must end in .ppm");
    }
  }
}


