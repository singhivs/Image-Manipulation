//package controller;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import java.io.StringReader;
//import java.util.HashMap;
//import java.util.Map;
//
//import model.GeneralImageModel;
//import model.image.Color;
//import model.image.Image;
//import model.ImageProcessingModel;
//import model.image.PPMImage;
//import model.PPMImageModel;
//import view.ImageProcessingView;
//import view.PPMTextView;
//
//import static org.junit.Assert.assertEquals;
//
///**
// * A class in which to test the methods of PPMController.
// */
//public class ImageProcessingControllerTest {
//  private ImageProcessingModel model;
//  private Readable rd;
//  private ImageProcessingView view;
//  Appendable ap = new StringBuilder();
//  ImageProcessingModel ppmImageModel1;
//  Color[][] loadColors;
//
//  Color rgb800 = new Color(8, 0, 0);
//  Color rgb555 = new Color(5, 5, 5);
//  Color rgb268 = new Color(2, 6, 8);
//  Color rgb000 = new Color(0, 0, 0);
//  Color rgb888 = new Color(8, 8, 8);
//
//  String file2 = "path";
//
//  Color[][] rgb2by3;
//  PPMImage ppm2by3;
//  Color[][] red2by3;
//  Color[][] green2by3;
//  Color[][] blue2by3;
//  Color[][] value2by3;
//  Color[][] intensity2by3;
//  Color[][] luma2by3;
//  Color[][] hFlip2by3;
//  Color[][] vFlip2by3;
//  Color[][] brighten2by3;
//  Color[][] darken2by3;
//  Color[][] sepiargb2by3;
//  Color[][] greyScalergb2by3;
//  Color[][] blurrgb2by3;
//  Color[][] sharpenrgb2by3;
//
//  Color rgb100 = new Color(1, 0, 0);
//  Color rgb010 = new Color(0, 1, 0);
//  Color rgb001 = new Color(0, 0, 1);
//  Color rgb110 = new Color(1, 1, 0);
//  Color rgb111 = new Color(1, 1, 1);
//
//  String file1 = "path";
//
//  Color[][] rgb3by3;
//  PPMImage gen3by3;
//  Color[][] redrgb3by3;
//  Color[][] greenrgb3by3;
//  Color[][] bluergb3by3;
//  Color[][] valuergb3by3;
//  Color[][] intensityrgb3by3;
//  Color[][] lumargb3by3;
//  Color[][] hfliprgb3by3;
//  Color[][] vfliprgb3by3;
//  Color[][] brightenrgb3by3;
//  Color[][] darkenrgb3by3;
//  Color[][] sepiargb3by3;
//  Color[][] greyScalergb3by3;
//  Color[][] blurrgb3by3;
//  Color[][] sharpenrgb3by3;
//
//  GeneralImageModel genImageModel1;
//
//  /**
//   * Sets up examples to be used while testing a ppm.
//   */
//  private void setUpPPM() {
//    rgb2by3 = new Color[2][3];
//    rgb2by3[0][0] = rgb000;
//    rgb2by3[0][1] = rgb268;
//    rgb2by3[0][2] = rgb555;
//    rgb2by3[1][0] = rgb800;
//    rgb2by3[1][1] = rgb888;
//    rgb2by3[1][2] = rgb000;
//
//    ppm2by3 = new PPMImage(3, 2, 8, rgb2by3, file2);
//
//    red2by3 = new Color[2][3];
//    red2by3[0][0] = rgb000;
//    red2by3[0][1] = new Color(2, 2, 2);
//    red2by3[0][2] = rgb555;
//    red2by3[1][0] = new Color(8, 8, 8);
//    red2by3[1][1] = rgb888;
//    red2by3[1][2] = rgb000;
//
//    green2by3 = new Color[2][3];
//    green2by3[0][0] = rgb000;
//    green2by3[0][1] = new Color(6, 6, 6);
//    green2by3[0][2] = rgb555;
//    green2by3[1][0] = rgb000;
//    green2by3[1][1] = rgb888;
//    green2by3[1][2] = rgb000;
//
//    blue2by3 = new Color[2][3];
//    blue2by3[0][0] = rgb000;
//    blue2by3[0][1] = rgb888;
//    blue2by3[0][2] = rgb555;
//    blue2by3[1][0] = rgb000;
//    blue2by3[1][1] = rgb888;
//    blue2by3[1][2] = rgb000;
//
//    value2by3 = new Color[2][3];
//    value2by3[0][0] = rgb000;
//    value2by3[0][1] = rgb888;
//    value2by3[0][2] = rgb555;
//    value2by3[1][0] = rgb888;
//    value2by3[1][1] = rgb888;
//    value2by3[1][2] = rgb000;
//
//    intensity2by3 = new Color[2][3];
//    intensity2by3[0][0] = rgb000;
//    intensity2by3[0][1] = rgb555;
//    intensity2by3[0][2] = rgb555;
//    intensity2by3[1][0] = new Color(2, 2,2);
//    intensity2by3[1][1] = rgb888;
//    intensity2by3[1][2] = rgb000;
//
//    luma2by3 = new Color[2][3];
//    luma2by3[0][0] = rgb000;
//    luma2by3[0][1] = rgb555;
//    luma2by3[0][2] = rgb555;
//    luma2by3[1][0] = new Color(2, 2, 2);
//    luma2by3[1][1] = rgb888;
//    luma2by3[1][2] = rgb000;
//
//    hFlip2by3 = new Color[2][3];
//    hFlip2by3[1][0] = rgb000;
//    hFlip2by3[1][1] = rgb268;
//    hFlip2by3[1][2] = rgb555;
//    hFlip2by3[0][0] = rgb800;
//    hFlip2by3[0][1] = rgb888;
//    hFlip2by3[0][2] = rgb000;
//
//    vFlip2by3 = new Color[2][3];
//    vFlip2by3[0][2] = rgb000;
//    vFlip2by3[0][1] = rgb268;
//    vFlip2by3[0][0] = rgb555;
//    vFlip2by3[1][2] = rgb800;
//    vFlip2by3[1][1] = rgb888;
//    vFlip2by3[1][0] = rgb000;
//
//    brighten2by3 = new Color[2][3];
//    brighten2by3[0][0] = new Color(4, 4, 4);
//    brighten2by3[0][1] = new Color(6, 8, 8);
//    brighten2by3[0][2] = rgb888;
//    brighten2by3[1][0] = new Color(8, 4, 4);
//    brighten2by3[1][1] = rgb888;
//    brighten2by3[1][2] = new Color(4, 4, 4);
//
//    darken2by3 = new Color[2][3];
//    darken2by3[0][0] = rgb000;
//    darken2by3[0][1] = new Color(0, 3, 5);
//    darken2by3[0][2] = new Color(2, 2,2);
//    darken2by3[1][0] = new Color(5, 0,0);
//    darken2by3[1][1] = new Color(5, 5, 5);
//    darken2by3[1][2] = rgb000;
//
//    sepiargb2by3 = new Color[2][3];
//    sepiargb2by3[0][0] = rgb000;
//    sepiargb2by3[0][1] = new Color(7, 6, 5);
//    sepiargb2by3[0][2] = new Color(7, 6, 5);
//    sepiargb2by3[1][0] = new Color(3, 3, 2);
//    sepiargb2by3[1][1] = new Color(8, 8, 7);
//    sepiargb2by3[1][2] = rgb000;
//
//    greyScalergb2by3 = new Color[2][3];
//    greyScalergb2by3[0][0] = rgb000;
//    greyScalergb2by3[0][1] = new Color(5, 5, 5);
//    greyScalergb2by3[0][2] = new Color(5, 5, 5);
//    greyScalergb2by3[1][0] = new Color(2, 2, 2);
//    greyScalergb2by3[1][1] = rgb888;
//    greyScalergb2by3[1][2] = rgb000;
//
//    blurrgb2by3 = new Color[2][3];
//    blurrgb2by3[0][0] = new Color(3, 1, 2);
//    blurrgb2by3[0][1] = new Color(4, 3, 3);
//    blurrgb2by3[0][2] = new Color(2, 2, 2);
//    blurrgb2by3[1][0] = new Color(2, 1, 1);
//    blurrgb2by3[1][1] = new Color(2, 1, 1);
//    blurrgb2by3[1][2] = new Color(1, 1, 1);
//
//    sharpenrgb2by3 = new Color[2][3];
//    sharpenrgb2by3[0][0] = new Color(8, 3, 3);
//    sharpenrgb2by3[0][1] = new Color(8, 8, 8);
//    sharpenrgb2by3[0][2] = new Color(3, 5, 5);
//    sharpenrgb2by3[1][0] = new Color(3, 1, 0);
//    sharpenrgb2by3[1][1] = new Color(3, 1, 0);
//    sharpenrgb2by3[1][2] = new Color(0, 1, 0);
//  }
//
//  /**
//   * Sets up examples to be used while testing a general image.
//   */
//  private void setUpGeneral() {
//    rgb3by3 = new Color[3][3];
//    rgb3by3[0][0] = rgb000;
//    rgb3by3[0][1] = rgb100;
//    rgb3by3[0][2] = rgb010;
//    rgb3by3[1][0] = rgb001;
//    rgb3by3[1][1] = rgb110;
//    rgb3by3[1][2] = rgb111;
//    rgb3by3[2][0] = rgb000;
//    rgb3by3[2][1] = rgb111;
//    rgb3by3[2][2] = rgb111;
//
//    gen3by3 = new PPMImage(3, 3, 1, rgb3by3, file1);
//
//    redrgb3by3 = new Color[3][3];
//    redrgb3by3[0][0] = rgb000;
//    redrgb3by3[0][1] = rgb111;
//    redrgb3by3[0][2] = rgb000;
//    redrgb3by3[1][0] = rgb000;
//    redrgb3by3[1][1] = rgb111;
//    redrgb3by3[1][2] = rgb111;
//    redrgb3by3[2][0] = rgb000;
//    redrgb3by3[2][1] = rgb111;
//    redrgb3by3[2][2] = rgb111;
//
//    greenrgb3by3 = new Color[3][3];
//    greenrgb3by3[0][0] = rgb000;
//    greenrgb3by3[0][1] = rgb000;
//    greenrgb3by3[0][2] = rgb111;
//    greenrgb3by3[1][0] = rgb000;
//    greenrgb3by3[1][1] = rgb111;
//    greenrgb3by3[1][2] = rgb111;
//    greenrgb3by3[2][0] = rgb000;
//    greenrgb3by3[2][1] = rgb111;
//    greenrgb3by3[2][2] = rgb111;
//
//    bluergb3by3 = new Color[3][3];
//    bluergb3by3[0][0] = rgb000;
//    bluergb3by3[0][1] = rgb000;
//    bluergb3by3[0][2] = rgb000;
//    bluergb3by3[1][0] = rgb111;
//    bluergb3by3[1][1] = rgb000;
//    bluergb3by3[1][2] = rgb111;
//    bluergb3by3[2][0] = rgb000;
//    bluergb3by3[2][1] = rgb111;
//    bluergb3by3[2][2] = rgb111;
//
//    valuergb3by3 = new Color[3][3];
//    valuergb3by3[0][0] = rgb000;
//    valuergb3by3[0][1] = rgb111;
//    valuergb3by3[0][2] = rgb111;
//    valuergb3by3[1][0] = rgb111;
//    valuergb3by3[1][1] = rgb111;
//    valuergb3by3[1][2] = rgb111;
//    valuergb3by3[2][0] = rgb000;
//    valuergb3by3[2][1] = rgb111;
//    valuergb3by3[2][2] = rgb111;
//
//    intensityrgb3by3 = new Color[3][3];
//    intensityrgb3by3[0][0] = rgb000;
//    intensityrgb3by3[0][1] = rgb000;
//    intensityrgb3by3[0][2] = rgb000;
//    intensityrgb3by3[1][0] = rgb000;
//    intensityrgb3by3[1][1] = rgb000;
//    intensityrgb3by3[1][2] = rgb111;
//    intensityrgb3by3[2][0] = rgb000;
//    intensityrgb3by3[2][1] = rgb111;
//    intensityrgb3by3[2][2] = rgb111;
//
//    lumargb3by3 = new Color[3][3];
//    lumargb3by3[0][0] = rgb000;
//    lumargb3by3[0][1] = rgb000;
//    lumargb3by3[0][2] = rgb111;
//    lumargb3by3[1][0] = rgb000;
//    lumargb3by3[1][1] = rgb111;
//    lumargb3by3[1][2] = rgb111;
//    lumargb3by3[2][0] = rgb000;
//    lumargb3by3[2][1] = rgb111;
//    lumargb3by3[2][2] = rgb111;
//
//    hfliprgb3by3 = new Color[3][3];
//    hfliprgb3by3[2][0] = rgb000;
//    hfliprgb3by3[2][1] = rgb100;
//    hfliprgb3by3[2][2] = rgb010;
//    hfliprgb3by3[1][0] = rgb001;
//    hfliprgb3by3[1][1] = rgb110;
//    hfliprgb3by3[1][2] = rgb111;
//    hfliprgb3by3[0][0] = rgb000;
//    hfliprgb3by3[0][1] = rgb111;
//    hfliprgb3by3[0][2] = rgb111;
//
//    vfliprgb3by3 = new Color[3][3];
//    vfliprgb3by3[0][2] = rgb000;
//    vfliprgb3by3[0][1] = rgb100;
//    vfliprgb3by3[0][0] = rgb010;
//    vfliprgb3by3[1][2] = rgb001;
//    vfliprgb3by3[1][1] = rgb110;
//    vfliprgb3by3[1][0] = rgb111;
//    vfliprgb3by3[2][2] = rgb000;
//    vfliprgb3by3[2][1] = rgb111;
//    vfliprgb3by3[2][0] = rgb111;
//
//    greyScalergb3by3 = new Color[3][3];
//    greyScalergb3by3[0][0] = rgb000;
//    greyScalergb3by3[0][1] = rgb000;
//    greyScalergb3by3[0][2] = rgb111;
//    greyScalergb3by3[1][0] = rgb000;
//    greyScalergb3by3[1][1] = rgb111;
//    greyScalergb3by3[1][2] = rgb111;
//    greyScalergb3by3[2][0] = rgb000;
//    greyScalergb3by3[2][1] = rgb111;
//    greyScalergb3by3[2][2] = rgb111;
//
//    sepiargb3by3 = new Color[3][3];
//    sepiargb3by3[0][0] = rgb000;
//    sepiargb3by3[0][1] = rgb000;
//    sepiargb3by3[0][2] = rgb111;
//    sepiargb3by3[1][0] = rgb000;
//    sepiargb3by3[1][1] = rgb111;
//    sepiargb3by3[1][2] = rgb111;
//    sepiargb3by3[2][0] = rgb000;
//    sepiargb3by3[2][1] = rgb111;
//    sepiargb3by3[2][2] = rgb111;
//
//    blurrgb3by3 = new Color[3][3];
//    blurrgb3by3[0][0] = rgb000;
//    blurrgb3by3[0][1] = rgb110;
//    blurrgb3by3[0][2] = rgb110;
//    blurrgb3by3[1][0] = rgb000;
//    blurrgb3by3[1][1] = rgb111;
//    blurrgb3by3[1][2] = rgb111;
//    blurrgb3by3[2][0] = rgb000;
//    blurrgb3by3[2][1] = rgb000;
//    blurrgb3by3[2][2] = rgb000;
//
//    sharpenrgb3by3 = new Color[3][3];
//    sharpenrgb3by3[0][0] = rgb000;
//    sharpenrgb3by3[0][1] = rgb110;
//    sharpenrgb3by3[0][2] = rgb110;
//    sharpenrgb3by3[1][0] = rgb000;
//    sharpenrgb3by3[1][1] = rgb111;
//    sharpenrgb3by3[1][2] = rgb111;
//    sharpenrgb3by3[2][0] = rgb000;
//    sharpenrgb3by3[2][1] = rgb000;
//    sharpenrgb3by3[2][2] = rgb000;
//  }
//
//
//  @Before
//  public void setUp() {
//    setUpPPM();
//    setUpGeneral();
//    savePandas();
//
//    Map<String, Image> images1 = new HashMap<>();
//    images1.put("im2", ppm2by3);
//    ppmImageModel1 = new PPMImageModel(images1);
//    Map<String, Image> images2 = new HashMap<>();
//    images2.put("im1", gen3by3);
//    genImageModel1 = new GeneralImageModel(images2);
//
//    model = new PPMImageModel();
//    rd = new StringReader("");
//    ap = new StringBuilder();
//    view = new PPMTextView(ap);
//
//    loadColors = new Color[2][2];
//    loadColors[0][0] = new Color(3, 3, 0);
//    loadColors[0][1] = new Color(1, 2, 1);
//    loadColors[1][0] = new Color(2, 1, 1);
//    loadColors[1][1] = new Color(0, 0, 1);
//  }
//
//  @Test(expected = IllegalArgumentException.class)
//  public void testNullModelController() {
//    ImageProcessingController controller = new ImageProcessingControllerImpl(rd,
//            null, view);
//  }
//
//  @Test(expected = IllegalArgumentException.class)
//  public void testNullViewController() {
//    ImageProcessingController controller = new ImageProcessingControllerImpl(rd,
//            model, null);
//  }
//
//  @Test(expected = IllegalArgumentException.class)
//  public void testNullInputController() {
//    ImageProcessingController controller = new ImageProcessingControllerImpl(null,
//            model, view);
//  }
//
//  @Test
//  public void testLoad() throws IllegalStateException {
//    Readable in = new StringReader("load" + " "
//            + "res/TestLoad.ppm"
//            + " " + "TestLoad");
//    Map<String, Image> images = new HashMap<>();
//    ImageProcessingModel loadModel = new PPMImageModel(images);
//    ImageProcessingView v = new PPMTextView();
//    ImageProcessingController controller = new ImageProcessingControllerImpl(in, loadModel, v);
//    controller.runProgram();
//
//
//    for (int i = 0; i < 2; i++) {
//      for (int j = 0; j < 2; j++) {
//        assertEquals(loadColors[i][j],
//                images.get("TestLoad").getColors()[i][j]);
//      }
//    }
//  }
//
//  @Test
//  public void testCreateRed() {
//    Readable in1 = new StringReader("red-component" + " "
//            + "im2"
//            + " " + "im2-red");
//    ImageProcessingView v = new PPMTextView();
//    ImageProcessingController controller1 =
//            new ImageProcessingControllerImpl(in1, ppmImageModel1, v);
//    controller1.runProgram();
//    for (int i = 0; i < 2; i++) {
//      for (int j = 0; j < 3; j++) {
//        assertEquals(red2by3[i][j],
//                ppmImageModel1.getImage("im2-red").getColors()[i][j]);
//      }
//    }
//
//    Readable in2 = new StringReader("red-component" + " "
//            + "im1"
//            + " " + "im1-red");
//    ImageProcessingController controller2 =
//            new ImageProcessingControllerImpl(in2, genImageModel1, v);
//    controller2.runProgram();
//    for (int i = 0; i < 3; i++) {
//      for (int j = 0; j < 3; j++) {
//        assertEquals(redrgb3by3[i][j],
//                genImageModel1.getImage("im1-red").getColors()[i][j]);
//      }
//    }
//  }
//
//  @Test
//  public void testCreateGreen() {
//    Readable in1 = new StringReader("green-component" + " "
//            + "im2"
//            + " " + "im2-green");
//    ImageProcessingView v = new PPMTextView();
//    ImageProcessingController controller1 =
//            new ImageProcessingControllerImpl(in1, ppmImageModel1, v);
//    controller1.runProgram();
//    for (int i = 0; i < 2; i++) {
//      for (int j = 0; j < 3; j++) {
//        assertEquals(green2by3[i][j],
//                ppmImageModel1.getImage("im2-green").getColors()[i][j]);
//      }
//    }
//
//    Readable in2 = new StringReader("green-component" + " "
//            + "im1"
//            + " " + "im1-green");
//    ImageProcessingController controller2 =
//            new ImageProcessingControllerImpl(in2, genImageModel1, v);
//    controller2.runProgram();
//    for (int i = 0; i < 3; i++) {
//      for (int j = 0; j < 3; j++) {
//        assertEquals(greenrgb3by3[i][j],
//                genImageModel1.getImage("im1-green").getColors()[i][j]);
//      }
//    }
//  }
//
//  @Test
//  public void testCreateBlue() {
//    Readable in1 = new StringReader("blue-component" + " "
//            + "im2"
//            + " " + "im2-blue");
//    ImageProcessingView v = new PPMTextView();
//    ImageProcessingController controller1 =
//            new ImageProcessingControllerImpl(in1, ppmImageModel1, v);
//    controller1.runProgram();
//    for (int i = 0; i < 2; i++) {
//      for (int j = 0; j < 3; j++) {
//        assertEquals(blue2by3[i][j],
//                ppmImageModel1.getImage("im2-blue").getColors()[i][j]);
//      }
//    }
//
//    Readable in2 = new StringReader("blue-component" + " "
//            + "im1"
//            + " " + "im1-blue");
//    ImageProcessingController controller2 =
//            new ImageProcessingControllerImpl(in2, genImageModel1, v);
//    controller2.runProgram();
//    for (int i = 0; i < 3; i++) {
//      for (int j = 0; j < 3; j++) {
//        assertEquals(bluergb3by3[i][j],
//                genImageModel1.getImage("im1-blue").getColors()[i][j]);
//      }
//    }
//  }
//
//  @Test
//  public void testCreateValue() {
//    Readable in1 = new StringReader("value-component" + " "
//            + "im2"
//            + " " + "im2-value");
//    ImageProcessingView v = new PPMTextView();
//    ImageProcessingController controller1 =
//            new ImageProcessingControllerImpl(in1, ppmImageModel1, v);
//    controller1.runProgram();
//    for (int i = 0; i < 2; i++) {
//      for (int j = 0; j < 3; j++) {
//        assertEquals(value2by3[i][j],
//                ppmImageModel1.getImage("im2-value").getColors()[i][j]);
//      }
//    }
//
//    Readable in2 = new StringReader("value-component" + " "
//            + "im1"
//            + " " + "im1-value");
//    ImageProcessingController controller2 =
//            new ImageProcessingControllerImpl(in2, genImageModel1, v);
//    controller2.runProgram();
//    for (int i = 0; i < 3; i++) {
//      for (int j = 0; j < 3; j++) {
//        assertEquals(valuergb3by3[i][j],
//                genImageModel1.getImage("im1-value").getColors()[i][j]);
//      }
//    }
//  }
//
//
//  @Test
//  public void testCreateIntensity() {
//    Readable in1 = new StringReader("intensity-component" + " "
//            + "im2"
//            + " " + "im2-intensity");
//    ImageProcessingView v = new PPMTextView();
//    ImageProcessingController controller1 =
//            new ImageProcessingControllerImpl(in1, ppmImageModel1, v);
//    controller1.runProgram();
//    for (int i = 0; i < 2; i++) {
//      for (int j = 0; j < 3; j++) {
//        assertEquals(intensity2by3[i][j],
//                ppmImageModel1.getImage("im2-intensity").getColors()[i][j]);
//      }
//    }
//
//    Readable in2 = new StringReader("intensity-component" + " "
//            + "im1"
//            + " " + "im1-intensity");
//    ImageProcessingController controller2 =
//            new ImageProcessingControllerImpl(in2, genImageModel1, v);
//    controller2.runProgram();
//    for (int i = 0; i < 3; i++) {
//      for (int j = 0; j < 3; j++) {
//        assertEquals(intensityrgb3by3[i][j],
//                genImageModel1.getImage("im1-intensity").getColors()[i][j]);
//      }
//    }
//  }
//
//
//  @Test
//  public void testCreateLuma() {
//    Readable in1 = new StringReader("luma-component" + " "
//            + "im2"
//            + " " + "im2-luma");
//    ImageProcessingView v = new PPMTextView();
//    ImageProcessingController controller1 =
//            new ImageProcessingControllerImpl(in1, ppmImageModel1, v);
//    controller1.runProgram();
//    for (int i = 0; i < 2; i++) {
//      for (int j = 0; j < 3; j++) {
//        assertEquals(luma2by3[i][j],
//                ppmImageModel1.getImage("im2-luma").getColors()[i][j]);
//      }
//    }
//
//    Readable in2 = new StringReader("luma-component" + " "
//            + "im1"
//            + " " + "im1-luma");
//    ImageProcessingController controller2 =
//            new ImageProcessingControllerImpl(in2, genImageModel1, v);
//    controller2.runProgram();
//    for (int i = 0; i < 3; i++) {
//      for (int j = 0; j < 3; j++) {
//        assertEquals(lumargb3by3[i][j],
//                genImageModel1.getImage("im1-luma").getColors()[i][j]);
//      }
//    }
//  }
//
//  @Test
//  public void testFlipHoriz() {
//    Readable in1 = new StringReader("horizontal-flip" + " "
//            + "im2"
//            + " " + "im2-hflip");
//    ImageProcessingView v = new PPMTextView();
//    ImageProcessingController controller1 =
//            new ImageProcessingControllerImpl(in1, ppmImageModel1, v);
//    controller1.runProgram();
//    for (int i = 0; i < 2; i++) {
//      for (int j = 0; j < 3; j++) {
//        assertEquals(hFlip2by3[i][j],
//                ppmImageModel1.getImage("im2-hflip").getColors()[i][j]);
//      }
//    }
//
//    Readable in2 = new StringReader("horizontal-flip" + " "
//            + "im1"
//            + " " + "im1-hflip");
//    ImageProcessingController controller2 =
//            new ImageProcessingControllerImpl(in2, genImageModel1, v);
//    controller2.runProgram();
//    for (int i = 0; i < 3; i++) {
//      for (int j = 0; j < 3; j++) {
//        assertEquals(hfliprgb3by3[i][j],
//                genImageModel1.getImage("im1-hflip").getColors()[i][j]);
//      }
//    }
//  }
//
//  @Test
//  public void testFlipVert() {
//    Readable in1 = new StringReader("vertical-flip" + " "
//            + "im2"
//            + " " + "im2-vflip");
//    ImageProcessingView v = new PPMTextView();
//    ImageProcessingController controller1 =
//            new ImageProcessingControllerImpl(in1, ppmImageModel1, v);
//    controller1.runProgram();
//    for (int i = 0; i < 2; i++) {
//      for (int j = 0; j < 3; j++) {
//        assertEquals(vFlip2by3[i][j],
//                ppmImageModel1.getImage("im2-vflip").getColors()[i][j]);
//      }
//    }
//
//    Readable in2 = new StringReader("vertical-flip" + " "
//            + "im1"
//            + " " + "im1-vflip");
//    ImageProcessingController controller2 =
//            new ImageProcessingControllerImpl(in2, genImageModel1, v);
//    controller2.runProgram();
//    for (int i = 0; i < 3; i++) {
//      for (int j = 0; j < 3; j++) {
//        assertEquals(vfliprgb3by3[i][j],
//                genImageModel1.getImage("im1-vflip").getColors()[i][j]);
//      }
//    }
//  }
//
//  @Test
//  public void testBrighten() {
//    Readable in1 = new StringReader("brighten" + " " + "4" + " "
//            + "im2"
//            + " " + "im2-brighten");
//    ImageProcessingView v = new PPMTextView();
//    ImageProcessingController controller1 =
//            new ImageProcessingControllerImpl(in1, ppmImageModel1, v);
//    controller1.runProgram();
//    for (int i = 0; i < 2; i++) {
//      for (int j = 0; j < 3; j++) {
//        assertEquals(brighten2by3[i][j],
//                ppmImageModel1.getImage("im2-brighten").getColors()[i][j]);
//      }
//    }
//  }
//
//  @Test
//  public void testDarken() {
//    Readable in1 = new StringReader("darken" + " " + "3" + " "
//            + "im2"
//            + " " + "im2-darken");
//    ImageProcessingView v = new PPMTextView();
//    ImageProcessingController controller1 =
//            new ImageProcessingControllerImpl(in1, ppmImageModel1, v);
//    controller1.runProgram();
//    for (int i = 0; i < 2; i++) {
//      for (int j = 0; j < 3; j++) {
//        assertEquals(darken2by3[i][j],
//                ppmImageModel1.getImage("im2-darken").getColors()[i][j]);
//      }
//    }
//  }
//
//  @Test
//  public void testSepia() {
//    Readable in1 = new StringReader("sepia" + " "
//            + "im2"
//            + " " + "im2-sepia");
//    ImageProcessingView v = new PPMTextView();
//    ImageProcessingController controller1 =
//            new ImageProcessingControllerImpl(in1, ppmImageModel1, v);
//    controller1.runProgram();
//    for (int i = 0; i < 2; i++) {
//      for (int j = 0; j < 3; j++) {
//        assertEquals(sepiargb2by3[i][j],
//                ppmImageModel1.getImage("im2-sepia").getColors()[i][j]);
//      }
//    }
//
//    Readable in2 = new StringReader("sepia" + " "
//            + "im1"
//            + " " + "im1-sepia");
//    ImageProcessingController controller2 =
//            new ImageProcessingControllerImpl(in2, genImageModel1, v);
//    controller2.runProgram();
//    for (int i = 0; i < 3; i++) {
//      for (int j = 0; j < 3; j++) {
//        assertEquals(sepiargb3by3[i][j],
//                genImageModel1.getImage("im1-sepia").getColors()[i][j]);
//      }
//    }
//  }
//
//  @Test
//  public void testGreyScale() {
//    Readable in1 = new StringReader("greyscale" + " "
//            + "im2"
//            + " " + "im2-greyscale");
//    ImageProcessingView v = new PPMTextView();
//    ImageProcessingController controller1 =
//            new ImageProcessingControllerImpl(in1, ppmImageModel1, v);
//    controller1.runProgram();
//    for (int i = 0; i < 2; i++) {
//      for (int j = 0; j < 3; j++) {
//        assertEquals(greyScalergb3by3[i][j],
//                ppmImageModel1.getImage("im2-greyscale").getColors()[i][j]);
//      }
//    }
//
//    Readable in2 = new StringReader("greyscale" + " "
//            + "im1"
//            + " " + "im1-greyscale");
//    ImageProcessingController controller2 =
//            new ImageProcessingControllerImpl(in2, genImageModel1, v);
//    controller2.runProgram();
//    for (int i = 0; i < 3; i++) {
//      for (int j = 0; j < 3; j++) {
//        assertEquals(greyScalergb3by3[i][j],
//                genImageModel1.getImage("im1-greyscale").getColors()[i][j]);
//      }
//    }
//  }
//
//  @Test
//  public void testBlur() {
//    Readable in1 = new StringReader("blur" + " "
//            + "im2"
//            + " " + "im2-blur");
//    ImageProcessingView v = new PPMTextView();
//    ImageProcessingController controller1 =
//            new ImageProcessingControllerImpl(in1, ppmImageModel1, v);
//    controller1.runProgram();
//    for (int i = 0; i < 2; i++) {
//      for (int j = 0; j < 3; j++) {
//        assertEquals(blurrgb2by3[i][j],
//                ppmImageModel1.getImage("im2-blur").getColors()[i][j]);
//      }
//    }
//
//    Readable in2 = new StringReader("blur" + " "
//            + "im1"
//            + " " + "im1-blur");
//    ImageProcessingController controller2 =
//            new ImageProcessingControllerImpl(in2, genImageModel1, v);
//    controller2.runProgram();
//    for (int i = 0; i < 3; i++) {
//      for (int j = 0; j < 3; j++) {
//        assertEquals(blurrgb3by3[i][j],
//                genImageModel1.getImage("im1-blur").getColors()[i][j]);
//      }
//    }
//  }
//
//  @Test
//  public void testSharpen() {
//    Readable in1 = new StringReader("sharpen" + " "
//            + "im2"
//            + " " + "im2-sharpen");
//    ImageProcessingView v = new PPMTextView();
//    ImageProcessingController controller1 =
//            new ImageProcessingControllerImpl(in1, ppmImageModel1, v);
//    controller1.runProgram();
//    for (int i = 0; i < 2; i++) {
//      for (int j = 0; j < 3; j++) {
//        assertEquals(sharpenrgb2by3[i][j],
//                ppmImageModel1.getImage("im2-sharpen").getColors()[i][j]);
//      }
//    }
//
//    Readable in2 = new StringReader("sharpen" + " "
//            + "im1"
//            + " " + "im1-sharpen");
//    ImageProcessingController controller2 =
//            new ImageProcessingControllerImpl(in2, genImageModel1, v);
//    controller2.runProgram();
//    for (int i = 0; i < 3; i++) {
//      for (int j = 0; j < 3; j++) {
//        assertEquals(sharpenrgb3by3[i][j],
//                genImageModel1.getImage("im1-sharpen").getColors()[i][j]);
//      }
//    }
//  }
//
//
//  private void savePandas() {
//    Readable in = new StringReader("load" + " "
//            + "res/panda.jpg"
//            + " " + "panda-original");
//    Map<String, Image> images = new HashMap<>();
//    ImageProcessingModel loadModel = new PPMImageModel(images);
//    ImageProcessingView v = new PPMTextView();
//    ImageProcessingController controller = new ImageProcessingControllerImpl(in, loadModel, v);
//    controller.runProgram();
//
//    Readable blurIn = new StringReader("blur" + " "
//            + "panda-original"
//            + " " + "panda-blur");
//    ImageProcessingController blurController =
//            new ImageProcessingControllerImpl(blurIn, loadModel, v);
//    blurController.runProgram();
//
//    Readable sharpenIn = new StringReader("sharpen" + " "
//            + "panda-original"
//            + " " + "panda-sharpen");
//    ImageProcessingController sharpenController =
//            new ImageProcessingControllerImpl(sharpenIn, loadModel, v);
//    sharpenController.runProgram();
//
//    Readable sepiaIn = new StringReader("sepia" + " "
//            + "panda-original"
//            + " " + "panda-sepia");
//    ImageProcessingController sepiaController =
//            new ImageProcessingControllerImpl(sepiaIn, loadModel, v);
//    sepiaController.runProgram();
//
//    Readable greyScaleIn = new StringReader("greyscale" + " "
//            + "panda-original"
//            + " " + "panda-greyscale");
//    ImageProcessingController greyscaleController =
//            new ImageProcessingControllerImpl(greyScaleIn, loadModel, v);
//    greyscaleController.runProgram();
//
//    Readable saveSharpenIn = new StringReader("save" + " "
//            + "res/panda-sharpen.jpg"
//            + " " + "panda-sharpen");
//    ImageProcessingController saveSharpenController =
//            new ImageProcessingControllerImpl(saveSharpenIn, loadModel, v);
//    saveSharpenController.runProgram();
//
//    Readable saveBlurIn = new StringReader("save" + " "
//            + "res/panda-blur.jpg"
//            + " " + "panda-blur");
//    ImageProcessingController saveBlurController =
//            new ImageProcessingControllerImpl(saveBlurIn, loadModel, v);
//    saveBlurController.runProgram();
//
//    Readable saveSepiaIn = new StringReader("save" + " "
//            + "res/panda-sepia.jpg"
//            + " " + "panda-sepia");
//    ImageProcessingController saveSepiaController =
//            new ImageProcessingControllerImpl(saveSepiaIn, loadModel, v);
//    saveSepiaController.runProgram();
//
//    Readable saveGreyScaleIn = new StringReader("save" + " "
//            + "res/panda-greyscale.jpg"
//            + " " + "panda-greyscale");
//    ImageProcessingController saveGreyscaleController =
//            new ImageProcessingControllerImpl(saveGreyScaleIn, loadModel, v);
//    saveGreyscaleController.runProgram();
//  }
//}
