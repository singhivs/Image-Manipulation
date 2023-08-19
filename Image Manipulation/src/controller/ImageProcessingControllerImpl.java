package controller;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import model.ImageProcessingModel;
import model.ImageUtil;
import model.image.Color;
import model.image.GeneralImage;
import model.image.Image;
import model.image.PPMImage;
import model.imageio.GeneralReadWrite;
import view.ImageProcessingView;
import view.PPMTextView;

/**
 * A class that represents a PPM Controller,
 * with methods to run a program, including loading and saving an Image.
 */
public class ImageProcessingControllerImpl implements ImageProcessingController {
  private Readable input;
  private ImageProcessingModel model;
  // private IView view;
  private ImageProcessingView view;

  /**
   * A constructor that takes in an input, model, and view
   * and constructs the ImageProcessingControllerImpl.
   *
   * @param input the given input
   * @param model the given Image Processing Model
   * @param view  the given Image Processing View
   * @throws IllegalArgumentException if any of the parameters is null
   */
  public ImageProcessingControllerImpl(
          Readable input, ImageProcessingModel model, ImageProcessingView view) {
    if (input == null || model == null || view == null) {
      throw new IllegalArgumentException("Fields of controller cannot be null");
    }
    this.input = input;
    this.model = model;
    this.view = view;

  }

  /**
   * Runs the Image Processing Program.
   */
  @Override
  public void runProgram() {
    Scanner sc = new Scanner(this.input);

    while (sc.hasNext()) {
      String cmd = sc.next();
      switch (cmd) {
        case "load":
          String path = sc.next();
          String name = sc.next();
          this.load(path, name);
          //System.out.println("Successful load");
          break;
        case "save":
          String destPath = sc.next();
          String imageName = sc.next();
          this.save(destPath, imageName);
          //System.out.println("Successful save");
          break;
        case "red-component":
          String rImName = sc.next();
          String rDestName = sc.next();
          this.model.createRed(rImName, rDestName);
          break;
        case "green-component":
          String gImName = sc.next();
          String gDestName = sc.next();
          this.model.createGreen(gImName, gDestName);
          break;
        case "blue-component":
          String bImName = sc.next();
          String bDestName = sc.next();
          this.model.createBlue(bImName, bDestName);
          break;
        case "value-component":
          String vImName = sc.next();
          String vDestName = sc.next();
          this.model.createValue(vImName, vDestName);
          break;
        case "intensity-component":
          String iImName = sc.next();
          String iDestName = sc.next();
          this.model.createIntensity(iImName, iDestName);
          break;
        case "luma-component":
          String lImName = sc.next();
          String lDestName = sc.next();
          this.model.createLuma(lImName, lDestName);
          break;
        case "horizontal-flip":
          String hfImName = sc.next();
          String hfDestName = sc.next();
          this.model.flipHoriz(hfImName, hfDestName);
          break;
        case "vertical-flip":
          String vfImName = sc.next();
          String vfDestName = sc.next();
          this.model.flipVert(vfImName, vfDestName);
          break;
        case "brighten":
          int brightness = sc.nextInt();
          String btImName = sc.next();
          String btDestName = sc.next();
          this.model.brighten(brightness, btImName, btDestName);
          break;
        case "darken":
          int darkness = sc.nextInt();
          String dkImName = sc.next();
          String dkDestName = sc.next();
          this.model.darken(darkness, dkImName, dkDestName);
          break;
        case "sepia":
          String sImName = sc.next();
          String sDestName = sc.next();
          this.model.sepia(sImName, sDestName);
          break;
        case "greyscale":
          String gsImName = sc.next();
          String gsDestName = sc.next();
          this.model.greyScale(gsImName, gsDestName);
          break;
        case "blur":
          String blurImName = sc.next();
          String blurDestName = sc.next();
          this.model.blur(blurImName, blurDestName);
          break;
        case "sharpen":
          String sharpImName = sc.next();
          String sharpDestName = sc.next();
          this.model.sharpen(sharpImName, sharpDestName);
          break;
        case "mosaic":
          int seeds = sc.nextInt();
          String mosaicImName = sc.next();
          String mosaicDestName = sc.next();
          this.model.mosaic(mosaicImName, mosaicDestName, seeds);
          //System.out.println("Successful mosaic");
          break;
        case "quit":
          return;
        default:
          try {
            view.renderMessage("\nThis method could not be understood");
          } catch (IllegalStateException e) {
            e.printStackTrace();
          }
      }
    }
  }

  @Override
  public void load(String path, String name) {
    File temp = new File(path);
    if ((temp.exists()) && ((path.endsWith("png")) || (path.endsWith("jpg"))
            || (path.endsWith("jpeg")) || (path.endsWith("bmp")))) {
      loadGeneral(path, name);
      tryCatchMessage("File " + name + " successfully loaded!");
    } else if (temp.exists() && path.endsWith("ppm")) {
      loadPPM(path, name);
    } else if (!temp.exists()) {
      tryCatchMessage("File " + name + " cannot be loaded because file-path "
              + path + " does not exist.");
    }
  }

  @Override
  public void save(String path, String name) {
    if (path.contains(name) && ((path.endsWith("png") || path.endsWith("jpg"))
            || (path.endsWith("jpeg")) || (path.endsWith("bmp")))) {
      Image img = model.getImage(name);
      String orgPath = img.getPath();
      if (orgPath.endsWith("png") || orgPath.endsWith("jpg")
              || orgPath.endsWith("jpeg") || orgPath.endsWith("bmp")) {
        saveGeneral(path, name);
      } else if (orgPath.endsWith("ppm")) {
        savePPM(path, name);
      } else {
        tryCatchMessage("Invalid file format");
      }
    } else if (path.contains(name) && (path.endsWith("ppm"))) {
      savePPM(path, name);
      tryCatchMessage("Image " + name + " successfully saved to file "
              + path);
    } else {
      tryCatchMessage("FilePath must include filename and end in PPM. Try again");
    }
  }

  private void loadGeneral(String path, String name) {
    GeneralReadWrite irw = new GeneralReadWrite(path);

    try {
      Color[][] colors = irw.readRGB();
      Image img = new GeneralImage(irw.width, irw.height, colors, path);
      model.addImage(name, img);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void saveGeneral(String path, String name) {
    Image img = model.getImage(name);
    Color[][] colors = img.getColors();
    String orgPath = img.getPath();
    GeneralReadWrite irw = new GeneralReadWrite(orgPath);
    try {
      irw.exportImage(path, colors);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void loadPPM(String path, String name) throws IllegalStateException {
    ImageProcessingView view = new PPMTextView();

    String file = new ImageUtil().readPPMFile(path, view);

    Scanner sc = new Scanner(file);

    String token;

    token = sc.next();
    if (!token.equals("P3")) {
      try {
        view.renderMessage("Invalid PPM file: plain RAW file should begin with P3\n");
      } catch (IllegalStateException e) {
        e.printStackTrace();
      }
    }
    int width = sc.nextInt();
    int height = sc.nextInt();
    int maxValue = sc.nextInt();

    model.addImage(name, new PPMImage(width, height, maxValue,
            new ImageUtil().createImage(file, width, height), file));
  }

  private void savePPM(String path, String name) {
    Image im = model.getImage(name);
    new ImageUtil().writePPMFile(path, im);
  }

  /**
   * Used to avoid nested try catch blocks. Attempts to render message, and handles transmission
   * failure accordingly.
   *
   * @param message is error message to be transmitted to view.
   */
  private void tryCatchMessage(String message) {
    try {
      this.view.renderMessage(message);
    } catch (IllegalStateException e) {
      e.printStackTrace();
      throw new IllegalStateException("View Transmission failed.");
    }
  }
}
