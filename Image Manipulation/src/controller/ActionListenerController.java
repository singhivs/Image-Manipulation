package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
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
import view.IView;
import view.ImageProcessingView;
import view.PPMTextView;

/**
 * An ActionListenerController is a controller that is used on the Action of a GUI.
 */
public class ActionListenerController implements ActionListener {
  private ImageProcessingModel model;
  private IView view;

  /**
   * Constructs the default ActionListenerController for a given model and view.
   *
   * @param model The model that the GUI works on
   * @param view  the GUI for which it controls
   */
  public ActionListenerController(ImageProcessingModel model, IView view) {
    this.model = model;
    this.view = view;
    view.setListener(this);
    view.display();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    switch (e.getActionCommand()) {
      //read from the input textfield
      case "load":
        String path = this.view.getInput1String();
        String name = this.view.getInput2String();
        this.load(path, name);
        BufferedImage image = this.model.getImage(name).getBImage();
        BufferedImage hist = this.model.getImage(name).getHist();
        view.setButton(image, hist);
        break;
      case "save":
        path = this.view.getInput1String();
        name = this.view.getInput2String();
        this.save(path, name);
        break;
      case "red-component":
        String dest = this.view.getInput1String();
        name = this.view.getInput2String();
        this.model.createRed(dest, name);
        view.setButton(this.model.getImage(name).getBImage(),
                this.model.getImage(name).getHist());
        this.model.getImage("panda-red");
        break;
      case "green-component":
        dest = this.view.getInput1String();
        name = this.view.getInput2String();
        this.model.createGreen(dest, name);
        view.setButton(this.model.getImage(name).getBImage(),
                this.model.getImage(name).getHist());
        break;
      case "blue-component":
        dest = this.view.getInput1String();
        name = this.view.getInput2String();
        this.model.createBlue(dest, name);
        view.setButton(this.model.getImage(name).getBImage(),
                this.model.getImage(name).getHist());
        break;
      case "value-component":
        dest = this.view.getInput1String();
        name = this.view.getInput2String();
        this.model.createValue(dest, name);
        view.setButton(this.model.getImage(name).getBImage(),
                this.model.getImage(name).getHist());
        break;
      case "intensity-component":
        dest = this.view.getInput1String();
        name = this.view.getInput2String();
        this.model.createIntensity(dest, name);
        view.setButton(this.model.getImage(name).getBImage(),
                this.model.getImage(name).getHist());
        break;
      case "luma-component":
        dest = this.view.getInput1String();
        name = this.view.getInput2String();
        this.model.createLuma(dest, name);
        view.setButton(this.model.getImage(name).getBImage(),
                this.model.getImage(name).getHist());
        break;
      case "horizontal-flip":
        dest = this.view.getInput1String();
        name = this.view.getInput2String();
        this.model.flipHoriz(dest, name);
        view.setButton(this.model.getImage(name).getBImage(),
                this.model.getImage(name).getHist());
        break;
      case "vertical-flip":
        dest = this.view.getInput1String();
        name = this.view.getInput2String();
        this.model.flipVert(dest, name);
        view.setButton(this.model.getImage(name).getBImage(),
                this.model.getImage(name).getHist());
        break;
      case "brighten":
        dest = this.view.getInput1String();
        name = this.view.getInput2String();
        int brightenInt = Integer.valueOf(this.view.getInput3String());
        this.model.brighten(brightenInt, dest, name);
        view.setButton(this.model.getImage(name).getBImage(),
                this.model.getImage(name).getHist());
        break;
      case "darken":
        dest = this.view.getInput1String();
        name = this.view.getInput2String();
        int darkenInt = Integer.valueOf(this.view.getInput3String());
        this.model.darken(darkenInt, dest, name);
        view.setButton(this.model.getImage(name).getBImage(),
                this.model.getImage(name).getHist());
        break;
      case "sepia":
        dest = this.view.getInput1String();
        name = this.view.getInput2String();
        this.model.sepia(dest, name);
        view.setButton(this.model.getImage(name).getBImage(),
                this.model.getImage(name).getHist());
        break;
      case "greyscale":
        dest = this.view.getInput1String();
        name = this.view.getInput2String();
        this.model.greyScale(dest, name);
        view.setButton(this.model.getImage(name).getBImage(),
                this.model.getImage(name).getHist());
        break;
      case "blur":
        dest = this.view.getInput1String();
        name = this.view.getInput2String();
        this.model.blur(dest, name);
        view.setButton(this.model.getImage(name).getBImage(),
                this.model.getImage(name).getHist());
        break;
      case "sharpen":
        dest = this.view.getInput1String();
        name = this.view.getInput2String();
        this.model.sharpen(dest, name);
        view.setButton(this.model.getImage(name).getBImage(),
                this.model.getImage(name).getHist());
        break;
      case "mosaic":
        dest = this.view.getInput1String();
        name = this.view.getInput2String();
        int seeds = Integer.valueOf(this.view.getInput3String());
        this.model.mosaic(dest, name, seeds);
        view.setButton(this.model.getImage(name).getBImage(),
                this.model.getImage(name).getHist());
        break;
      default:
        try {
          view.renderMessage("\nThis method could not be understood");
        } catch (IllegalStateException ex) {
          ex.printStackTrace();
        }

    }
  }

  /**
   * A method that load an image at the given path and to the given name.
   *
   * @param path the path of the image to be loaded
   * @param name the name under which the image is referred
   */
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

  /**
   * A method that sames the image under the given name to the given path.
   *
   * @param path the path under which the image is saved
   * @param name the name that the image can be found under
   */
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
