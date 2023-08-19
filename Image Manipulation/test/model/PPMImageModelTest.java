// COMBINED WITH ABSTRACTIMAGEMODELTESTS
//
// package model;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import static org.junit.Assert.assertEquals;
//
///**
// * A class in which to test the methods in the model package.
// */
//public class PPMImageModelTest {
//  ImageProcessingModel ppmImageModel1;
//
//  Color red1 = new Color(1, 0, 0);
//  Color green1 = new Color(0, 1, 0);
//  Color blue1 = new Color(0, 0, 1);
//  Color purple1 = new Color(0, 1, 1);
//  Color yellow1 = new Color(1, 1, 0);
//
//  Color rgb800 = new Color(8, 0, 0);
//  Color rgb555 = new Color(5, 5, 5);
//  Color rgb268 = new Color(2, 6, 8);
//  Color rgb000 = new Color(0, 0, 0);
//  Color rgb888 = new Color(8, 8, 8);
//
//  String file1 = "P3 3 3 255\n" + "1 0 0\n" + "0 1 1\n" + "1 0 0\n" + "0 0 1\n"
//          + "1 0 0\n" + "0 0 1\n" + "1 1 0\n" + "0 1 0\n" + "1 1 0\n";
//
//  String file2 = "P3 3 2 255\n" + "0 0 0\n" + "2 6 8\n" + "5 5 5\n"
//          + "8 0 0\n" + "8 8 8\n" + "0 0 0\n";
//
//  Color maxAll = new Color(1, 1, 1);
//  Color minAll = new Color(0, 0, 0);
//
//  String file1Red = "P3 3 3 255\n" + "1 1 1\n" + "0 0 0\n" + "1 1 1\n" + "0 0 0\n"
//          + "1 1 1\n" + "0 0 0\n" + "1 1 1\n" + "0 0 0\n" + "1 1 1\n";
//
//  String file2Red = "P3 3 2 255\n" + "0 0 0\n" + "2 2 2\n" + "5 5 5\n"
//          + "8 8 8\n" + "8 8 8\n" + "0 0 0\n";
//
//  String file1Green = "P3 3 3 255\n" + "0 0 0\n" + "1 1 1\n" + "0 0 0\n" + "0 0 0\n"
//          + "0 0 0\n" + "0 0 0\n" + "1 1 1\n" + "1 1 1\n" + "1 1 1\n";
//
//  String file2Green = "P3 3 2 255\n" + "0 0 0\n" + "6 6 6\n" + "5 5 5\n"
//          + "0 0 0\n" + "8 8 8\n" + "0 0 0\n";
//
//  String file1Blue = "P3 3 3 255\n" + "0 0 0\n" + "1 1 1\n" + "0 0 0\n" + "1 1 1\n"
//          + "0 0 0\n" + "1 1 1\n" + "0 0 0\n" + "0 0 0\n" + "0 0 0\n";
//
//  String file2Blue = "P3 3 2 255\n" + "0 0 0\n" + "8 8 8\n"
//          + "5 5 5\n" + "0 0 0\n" + "8 8 8\n" + "0 0 0\n";
//
//  String file1Value = "P3 3 3 255\n" + "1 1 1\n" + "1 1 1\n" + "1 1 1\n" + "1 1 1\n"
//          + "1 1 1\n" + "1 1 1\n" + "1 1 1\n" + "1 1 1\n" + "1 1 1\n";
//
//  String file2Value = "P3 3 2 255\n" + "0 0 0\n" + "8 8 8\n" + "5 5 5\n"
//          + "8 8 8\n" + "8 8 8\n" + "0 0 0\n";
//
//  String file1Intensity = "P3 3 3 255\n" + "0 0 0\n" + "0 0 0\n" + "0 0 0\n" + "0 0 0\n"
//          + "0 0 0\n" + "0 0 0\n" + "0 0 0\n" + "0 0 0\n" + "0 0 0\n";
//
//  String file2Intensity = "P3 3 2 255\n" + "0 0 0\n" + "5 5 5\n"
//          + "5 5 5\n" + "2 2 2\n" + "8 8 8\n" + "0 0 0\n";
//
//  String file1Luma = "P3 3 3 255\n" + "0 0 0\n" + "1 1 1\n" + "0 0 0\n" + "0 0 0\n"
//          + "0 0 0\n" + "0 0 0\n" + "1 1 1\n" + "1 1 1\n" + "1 1 1\n";
//
//  String file2Luma = "P3 3 2 255\n" + "0 0 0\n" + "2 6 8\n" + "5 5 5\n"
//          + "8 0 0\n" + "8 8 8\n" + "0 0 0\n";
//
//  String file1HFlip = "P3 3 3 255\n" + "1 1 0\n" + "0 1 0\n" + "1 1 0\n" + "0 0 1\n"
//          + "1 0 0\n" + "0 0 1\n" + "1 0 0\n" + "0 1 1\n" + "1 0 0\n";
//
//  String file2HFlip = "P3 3 2 255\n" + "8 0 0\n" + "8 8 8\n" + "0 0 0\n"
//          + "0 0 0\n" + "2 6 8\n" + "5 5 5\n";
//
//  String file1VFlip = "P3 3 3 255\n"  + "1 1 0\n" + "0 1 0\n" + "1 1 0\n" + "0 0 1\n"
//          + "1 0 0\n" + "0 0 1\n" + "1 0 0\n" + "0 1 1\n" + "1 0 0\n";
//
//  //String file1 = "P3 3 3 255\n" + "1 0 0\n" + "0 1 1\n" + "1 0 0\n" + "0 0 1\n"
//  //+ "1 0 0\n" + "0 0 1\n" + "1 1 0\n" + "0 1 0\n" + "1 1 0\n";
//
//  //String file2 = "P3 3 2 255\n" + "0 0 0\n" + "2 6 8\n" + "5 5 5\n"
//  //+ "8 0 0\n" + "8 8 8\n" + "0 0 0\n";
//
//  String file2VFlip = "P3 3 2 255\n" + "8 0 0\n" + "8 8 8\n" + "0 0 0\n"
//          + "0 0 0\n" + "2 6 8\n" + "5 5 5\n";
//
//  String file2Brighten = "P3 3 2 255\n" + "4 4 4\n" + "6 8 8\n" + "8 8 8\n"
//          + "8 4 4\n" + "8 8 8\n" + "4 4 4\n";
//
//  String file2Darken = "P3 3 2 255\n" + "0 0 0\n" + "0 3 5\n" + "2 2 2\n"
//          + "5 0 0\n" + "5 5 5\n" + "0 0 0\n";
//
//
//  Color red255 = new Color(255, 0, 0);
//  Color green255 = new Color(0, 255, 0);
//  Color blue255 = new Color(0, 0, 255);
//  Color black255 = new Color(0, 0, 0);
//  Color white255 = new Color(1, 1, 1);
//
//  Color [][] rgb3by3;
//  Image ppm3by3;
//  Color[][] red3by3;
//  Image ppm3by3Red;
//  Color[][] green3by3;
//  Image ppm3by3Green;
//  Color[][] blue3by3;
//  Image ppm3by3Blue;
//  Color[][] value3by3;
//  Image ppm3by3Value;
//  Color[][] intensity3by3;
//  Image ppm3by3Intensity;
//  Color[][] luma3by3;
//  Image ppm3by3Luma;
//  Color[][] hFlip3by3;
//  Image ppm3by3HFilp;
//  Color[][] vFlip3by3;
//  Image ppm3by3VFilp;
//
//  Color [][] rgb2by3;
//  Image ppm2by3;
//  Color[][] red2by3;
//  Image ppm2by3Red;
//  Color[][] green2by3;
//  Image ppm2by3Green;
//  Color[][] blue2by3;
//  Image ppm2by3Blue;
//  Color[][] value2by3;
//  Image ppm2by3Value;
//  Color[][] intensity2by3;
//  Image ppm2by3Intensity;
//  Color[][] luma2by3;
//  Image ppm2by3Luma;
//  Color[][] hFlip2by3;
//  Image ppm2by3HFilp;
//  Color[][] vFlip2by3;
//  Image ppm2by3VFilp;
//  Color[][] brighten2by3;
//  Image ppm2by3Brighten;
//  Color[][] darken2by3;
//  Image ppm2by3Darken;
//
//  Color [][] rgb4by5;
//  Image ppm4by5;
//
//  /**
//   * Sets up objects needed to test the 3by3 case.
//   */
//  private void setUp3by3() {
//    rgb3by3 = new Color[3][3];
//    rgb3by3[0][0] = red1;
//    rgb3by3[0][1] = purple1;
//    rgb3by3[0][2] = red1;
//    rgb3by3[1][0] = blue1;
//    rgb3by3[1][1] = red1;
//    rgb3by3[1][2] = blue1;
//    rgb3by3[2][0] = yellow1;
//    rgb3by3[2][1] = green1;
//    rgb3by3[2][2] = yellow1;
//
//    ppm3by3 = new PPMImage(3, 3, 255, rgb3by3, file1);
//
//    red3by3 = new Color[3][3];
//    red3by3[0][0] = maxAll;
//    red3by3[0][1] = maxAll;
//    red3by3[0][2] = maxAll;
//    red3by3[1][0] = minAll;
//    red3by3[1][1] = maxAll;
//    red3by3[1][2] = minAll;
//    red3by3[2][0] = maxAll;
//    red3by3[2][1] = minAll;
//    red3by3[2][2] = maxAll;
//
//    ppm3by3Red = new PPMImage(3, 3, 255, red3by3, file1Red);
//
//    green3by3 = new Color[3][3];
//    green3by3[0][0] = minAll;
//    green3by3[0][1] = minAll;
//    green3by3[0][2] = minAll;
//    green3by3[1][0] = minAll;
//    green3by3[1][1] = minAll;
//    green3by3[1][2] = minAll;
//    green3by3[2][0] = maxAll;
//    green3by3[2][1] = maxAll;
//    green3by3[2][2] = maxAll;
//
//    ppm3by3Green = new PPMImage(3, 3, 255, green3by3, file1Green);
//
//    blue3by3 = new Color[3][3];
//    blue3by3[0][0] = minAll;
//    blue3by3[0][1] = maxAll;
//    blue3by3[0][2] = minAll;
//    blue3by3[1][0] = maxAll;
//    blue3by3[1][1] = minAll;
//    blue3by3[1][2] = maxAll;
//    blue3by3[2][0] = minAll;
//    blue3by3[2][1] = minAll;
//    blue3by3[2][2] = minAll;
//
//    ppm3by3Blue = new PPMImage(3, 3, 255, blue3by3, file1Blue);
//
//    value3by3 = new Color[3][3];
//    value3by3[0][0] = maxAll;
//    value3by3[0][1] = maxAll;
//    value3by3[0][2] = maxAll;
//    value3by3[1][0] = maxAll;
//    value3by3[1][1] = maxAll;
//    value3by3[1][2] = maxAll;
//    value3by3[2][0] = maxAll;
//    value3by3[2][1] = maxAll;
//    value3by3[2][2] = maxAll;
//
//    ppm3by3Value = new PPMImage(3, 3, 255, value3by3, file1Value);
//
//    intensity3by3 = new Color[3][3];
//    intensity3by3[0][0] = minAll;
//    intensity3by3[0][1] = minAll;
//    intensity3by3[0][2] = minAll;
//    intensity3by3[1][0] = minAll;
//    intensity3by3[1][1] = minAll;
//    intensity3by3[1][2] = minAll;
//    intensity3by3[2][0] = minAll;
//    intensity3by3[2][1] = minAll;
//    intensity3by3[2][2] = minAll;
//
//    ppm3by3Intensity = new PPMImage(3, 3, 255, intensity3by3, file1Intensity);
//
//    luma3by3 = new Color[3][3];
//    luma3by3[0][0] = minAll;
//    luma3by3[0][1] = maxAll;
//    luma3by3[0][2] = minAll;
//    luma3by3[1][0] = minAll;
//    luma3by3[1][1] = minAll;
//    luma3by3[1][2] = minAll;
//    luma3by3[2][0] = maxAll;
//    luma3by3[2][1] = maxAll;
//    luma3by3[2][2] = maxAll;
//
//    ppm3by3Luma = new PPMImage(3, 3, 255, luma3by3, file1Luma);
//
//    hFlip3by3 = new Color[3][3];
//    hFlip3by3[0][0] = red1;
//    hFlip3by3[0][1] = purple1;
//    hFlip3by3[0][2] = red1;
//    hFlip3by3[1][0] = blue1;
//    hFlip3by3[1][1] = red1;
//    hFlip3by3[1][2] = blue1;
//    hFlip3by3[2][0] = yellow1;
//    hFlip3by3[2][1] = green1;
//    hFlip3by3[2][2] = yellow1;
//
//    ppm3by3HFilp = new PPMImage(3, 3, 255, hFlip3by3, file1HFlip);
//
//    vFlip3by3 = new Color[3][3];
//    vFlip3by3[0][0] = yellow1;
//    vFlip3by3[0][1] = green1;
//    vFlip3by3[0][2] = yellow1;
//    vFlip3by3[1][0] = blue1;
//    vFlip3by3[1][1] = red1;
//    vFlip3by3[1][2] = blue1;
//    vFlip3by3[2][0] = red1;
//    vFlip3by3[2][1] = purple1;
//    vFlip3by3[2][2] = red1;
//
//    ppm3by3VFilp = new PPMImage(3, 3, 255, vFlip3by3, file1VFlip);
//
//  }
//
//  /**
//   * Sets up objects to be used testing the 2by3 case.
//   */
//  private void setUp2by3() {
//    rgb2by3 = new Color[2][3];
//    rgb2by3[0][0] = rgb000;
//    rgb2by3[0][1] = rgb268;
//    rgb2by3[0][2] = rgb555;
//    rgb2by3[1][0] = rgb800;
//    rgb2by3[1][1] = rgb888;
//    rgb2by3[1][2] = rgb000;
//
//    ppm2by3 = new PPMImage(3, 2, 255, rgb2by3, file2);
//
//    red2by3 = new Color[2][3];
//    red2by3[0][0] = rgb000;
//    red2by3[0][1] = new Color(2, 2, 2);
//    red2by3[0][2] = rgb555;
//    red2by3[1][0] = new Color(8, 8, 8);
//    red2by3[1][1] = rgb888;
//    red2by3[1][2] = rgb000;
//
//    ppm2by3Red = new PPMImage(3, 2, 255, red2by3, file2Red);
//
//    green2by3 = new Color[2][3];
//    green2by3[0][0] = rgb000;
//    green2by3[0][1] = new Color(6, 6, 6);
//    green2by3[0][2] = rgb555;
//    green2by3[1][0] = rgb000;
//    green2by3[1][1] = rgb888;
//    green2by3[1][2] = rgb000;
//
//    ppm2by3Green = new PPMImage(3, 2, 255, green2by3, file2Green);
//
//    blue2by3 = new Color[2][3];
//    blue2by3[0][0] = rgb000;
//    blue2by3[0][1] = rgb888;
//    blue2by3[0][2] = rgb555;
//    blue2by3[1][0] = rgb000;
//    blue2by3[1][1] = rgb888;
//    blue2by3[1][2] = rgb000;
//
//    ppm2by3Blue = new PPMImage(3, 2, 255, blue2by3, file2Blue);
//
//    value2by3 = new Color[2][3];
//    value2by3[0][0] = rgb000;
//    value2by3[0][1] = rgb888;
//    value2by3[0][2] = rgb555;
//    value2by3[1][0] = rgb888;
//    value2by3[1][1] = rgb888;
//    value2by3[1][2] = rgb000;
//
//    ppm2by3Value = new PPMImage(3, 2, 255, value2by3, file2Value);
//
//    intensity2by3 = new Color[2][3];
//    intensity2by3[0][0] = rgb000;
//    intensity2by3[0][1] = rgb555;
//    intensity2by3[0][2] = rgb555;
//    intensity2by3[1][0] = new Color(2, 2,2);
//    intensity2by3[1][1] = rgb888;
//    intensity2by3[1][2] = rgb000;
//
//    ppm2by3Intensity = new PPMImage(3, 2, 255, intensity2by3, file2Intensity);
//
//    luma2by3 = new Color[2][3];
//    luma2by3[0][0] = rgb000;
//    luma2by3[0][1] = rgb268;
//    luma2by3[0][2] = rgb555;
//    luma2by3[1][0] = rgb800;
//    luma2by3[1][1] = rgb888;
//    luma2by3[1][2] = rgb000;
//
//    ppm2by3Luma = new PPMImage(3, 2, 255, luma2by3, file2Luma);
//
//    hFlip2by3 = new Color[2][3];
//    hFlip2by3[0][0] = rgb555;
//    hFlip2by3[0][1] = rgb268;
//    hFlip2by3[0][2] = rgb000;
//    hFlip2by3[1][0] = rgb000;
//    hFlip2by3[1][1] = rgb888;
//    hFlip2by3[1][2] = rgb800;
//
//    ppm2by3HFilp = new PPMImage(3, 2, 255, hFlip2by3, file2HFlip);
//
//    vFlip2by3 = new Color[2][3];
//    vFlip2by3[0][0] = rgb000;
//    vFlip2by3[0][1] = rgb268;
//    vFlip2by3[0][2] = rgb555;
//    vFlip2by3[1][0] = rgb800;
//    vFlip2by3[1][1] = rgb888;
//    vFlip2by3[1][2] = rgb000;
//
//    ppm2by3VFilp = new PPMImage(3, 2, 255, vFlip2by3, file2VFlip);
//
//    brighten2by3 = new Color[2][3];
//    brighten2by3[0][0] = new Color(4, 4, 4);
//    brighten2by3[0][1] = new Color(6, 8, 8);
//    brighten2by3[0][2] = rgb888;
//    brighten2by3[1][0] = new Color(8, 4, 4);
//    brighten2by3[1][1] = rgb888;
//    brighten2by3[1][2] = new Color(4, 4, 4);
//
//    ppm2by3Brighten = new PPMImage(3, 2, 255, brighten2by3, file2);
//
//    darken2by3 = new Color[2][3];
//    darken2by3[0][0] = rgb000;
//    darken2by3[0][1] = new Color(0, 3, 5);
//    darken2by3[0][2] = new Color(2, 2,2);
//    darken2by3[1][0] = new Color(5, 0,0);
//    darken2by3[1][1] = new Color(5, 5, 5);
//    darken2by3[1][2] = rgb000;
//
//    ppm2by3Darken = new PPMImage(3, 2, 255, darken2by3, file2);
//
//  }
//
//  @Before
//  public void setUp() {
//    setUp3by3();
//    setUp2by3();
//
//    rgb4by5 = new Color[4][5];
//    rgb4by5[0][0] = red255;
//    rgb4by5[0][1] = black255;
//    rgb4by5[0][2] = red255;
//    rgb4by5[0][3] = white255;
//    rgb4by5[0][4] = black255;
//    rgb4by5[1][0] = blue255;
//    rgb4by5[1][1] = red255;
//    rgb4by5[1][2] = blue255;
//    rgb4by5[1][3] = black255;
//    rgb4by5[1][4] = green255;
//    rgb4by5[2][0] = blue255;
//    rgb4by5[2][1] = green255;
//    rgb4by5[2][2] = white255;
//    rgb4by5[2][3] = green255;
//    rgb4by5[2][4] = red255;
//    rgb4by5[3][0] = white255;
//    rgb4by5[3][1] = red255;
//    rgb4by5[3][2] = green255;
//    rgb4by5[3][3] = blue255;
//    rgb4by5[3][4] = black255;
//
//    //    ppm4by5 = new PPMImage(4, 5, 255, rgb4by5);
//
//
//    Map<String, Image> images1 = new HashMap<>();
//    images1.put("im1", ppm3by3);
//    images1.put("im2", ppm2by3);
//    ppmImageModel1 = new PPMImageModel(images1);
//  }
//
//  @Test
//  public void testLoad() {
//    Map<String, Image> images = new HashMap<>();
//    ImageProcessingModel ppmImageModel1 = new PPMImageModel(images);
//    ppmImageModel1.load("res/TestLoad.ppm",
//            "TestLoad");
//    assertEquals("P3 2 2 255\n" + "3 0 1\n"
//                    + "2 1 2\n" + "1 1 0\n" + "0 1 0\n",
//            images.get("TestLoad").getImageFile());
//  }
//
//  @Test
//  public void testCreateRed() {
//    assertEquals(file1Red, ppmImageModel1.createRed("im1",
//            "im1-red").getImageFile());
//    assertEquals(file2Red, ppmImageModel1.createRed("im2",
//            "im2-red").getImageFile());
//  }
//
//  @Test
//  public void testCreateGreen() {
//    assertEquals(file1Green, ppmImageModel1.createGreen("im1",
//            "im1-green").getImageFile());
//    assertEquals(file2Green, ppmImageModel1.createGreen("im2",
//            "im2-green").getImageFile());
//  }
//
//  @Test
//  public void testCreateBlue() {
//    assertEquals(file1Blue, ppmImageModel1.createBlue("im1",
//            "im1-blue").getImageFile());
//    assertEquals(file2Blue, ppmImageModel1.createBlue("im2",
//            "im2-blue").getImageFile());
//  }
//
//  @Test
//  public void testCreateValue() {
//    assertEquals(file1Value, ppmImageModel1.createValue("im1",
//            "im1-value").getImageFile());
//    assertEquals(file2Value, ppmImageModel1.createValue("im2",
//            "im2-value").getImageFile());
//  }
//
//  @Test
//  public void testCreateIntensity() {
//    assertEquals(file1Intensity, ppmImageModel1.createIntensity("im1",
//            "im1-intensity").getImageFile());
//    assertEquals(file2Intensity, ppmImageModel1.createIntensity("im2",
//            "im2-intensity").getImageFile());
//
//  }
//
//  @Test
//  public void testCreateLuma() {
//    assertEquals(file1Luma, ppmImageModel1.createLuma("im1",
//            "im1-luma").getImageFile());
//  }
//
//
//  @Test
//  public void testFlipHoriz() {
//    assertEquals(file1HFlip, ppmImageModel1.flipHoriz("im1",
//            "im1-h-flip").getImageFile());
//    assertEquals(file2HFlip, ppmImageModel1.flipHoriz("im2",
//            "im2-h-flip").getImageFile());
//  }
//
//  @Test
//  public void testFlipVert() {
//    assertEquals(file1VFlip, ppmImageModel1.flipVert("im1",
//            "im1-v-flip").getImageFile());
//    assertEquals(file2VFlip, ppmImageModel1.flipVert("im2",
//            "im2-v-flip").getImageFile());
//  }
//
//  @Test
//  public void testBrighten() {
//    assertEquals(file2Brighten, ppmImageModel1.brighten(4, "im2",
//            "im2-brighten").getImageFile());
//  }
//
//  @Test
//  public void testDarken() {
//    assertEquals(file2Darken, ppmImageModel1.darken(3, "im2",
//            "im2-darken").getImageFile());
//  }
//}
