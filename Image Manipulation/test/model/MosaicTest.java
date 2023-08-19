package model;

import org.junit.Test;

import java.util.HashMap;

import java.util.Map;

import model.PPMImageModel;
import model.image.Color;
import model.image.Image;
import model.image.PPMImage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * test class for mosaic.
 */
public class MosaicTest {
  Color[][] rgb2by3;
  PPMImage ppm2by3;

  Color rgb800 = new Color(8, 0, 0);
  Color rgb555 = new Color(5, 5, 5);
  Color rgb268 = new Color(2, 6, 8);
  Color rgb000 = new Color(0, 0, 0);
  Color rgb888 = new Color(8, 8, 8);

  String file2 = "path";

  private void setUpPPM() {
    rgb2by3 = new Color[2][3];
    rgb2by3[0][0] = rgb000;
    rgb2by3[0][1] = rgb268;
    rgb2by3[0][2] = rgb555;
    rgb2by3[1][0] = rgb800;
    rgb2by3[1][1] = rgb888;
    rgb2by3[1][2] = rgb000;

    ppm2by3 = new PPMImage(3, 2, 8, rgb2by3, file2);

  }

  // test for mosaic
  @Test
  public void testMosaic() {
    setUpPPM();
    Map<String, Image> images1 = new HashMap<>();
    images1.put("im2", ppm2by3);
    PPMImageModel imageModel1 = new PPMImageModel(images1);
    Image mosaicImg = imageModel1.mosaic("im2", "mosaicImage", 2);

    assertEquals(ppm2by3.getHeight(), mosaicImg.getHeight());
    assertEquals(ppm2by3.getWidth(), mosaicImg.getWidth());

    Color[][] colorArray = mosaicImg.getColors();
    int total = 0;
    for (int row = 0; row < colorArray.length; row++) {
      for (int col = 0; col < colorArray[row].length; col++) {
        if (colorArray[row][col] == null) {
          continue;
        }
        boolean foundUnique = true;
        for (int i = row; i < colorArray.length; i++) {
          for (int j = row == col ? row : 0; j < colorArray[i].length; j++) {
            if (colorArray[i][j] == null || (i == row && j == col)) {
              continue;
            }
            if (colorArray[i][j].equals(colorArray[row][col])) {
              foundUnique = false;
              colorArray[i][j] = null;
            }

          }
          if (foundUnique) {
            total++;
          }
        }

        if (!foundUnique) {
          colorArray[row][col] = null;
        }
      }
    }
    assertTrue(2 >= total);
  }

  // testing constructor with negative seed values
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor() {
    setUpPPM();
    Map<String, Image> images1 = new HashMap<>();
    images1.put("im2", ppm2by3);
    PPMImageModel imageModel1 = new PPMImageModel(images1);
    Image mosaicImg = imageModel1.mosaic("im2", "mosaicImage", -1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor2() {
    setUpPPM();
    Map<String, Image> images1 = new HashMap<>();
    images1.put("im2", ppm2by3);
    PPMImageModel imageModel1 = new PPMImageModel(images1);
    Image mosaicImg = imageModel1.mosaic("im2", "mosaicImage", 0);
  }

  // testing apply mosaic with more seeds that the image height and width
  @Test(expected = IllegalArgumentException.class)
  public void testApplyMosaic() {
    setUpPPM();
    Map<String, Image> images1 = new HashMap<>();
    images1.put("im2", ppm2by3);
    PPMImageModel imageModel1 = new PPMImageModel(images1);
    Image mosaicImg = imageModel1.mosaic("im2", "mosaicImage", 20);
  }
}



