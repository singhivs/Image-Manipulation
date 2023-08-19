package model.imageio;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import model.image.Color;

/**
 * A class that reads or writes for any image type.
 */
public class GeneralReadWrite implements ImageReadWrite {
  String inputPath;
  public int width;
  public int height;

  public GeneralReadWrite(String inputPath) {
    this.inputPath = inputPath;
  }

  @Override
  public void exportImage(String path, Color[][] colors) throws IOException {
    BufferedImage img = ImageIO.read(new File(this.inputPath));
    int height = colors.length;
    int width = colors[0].length;
    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        java.awt.Color color = new java.awt.Color(colors[y][x].getRed(),
                colors[y][x].getGreen(), colors[y][x].getBlue());
        img.setRGB(x, y, color.getRGB());
      }
    }
    File out = new File(path);
    ImageIO.write(img, path.substring(path.lastIndexOf(".") + 1), out);
  }

  @Override
  public Color[][] readRGB() throws IOException {
    String path = inputPath;
    BufferedImage inputIo = ImageIO.read(new File(path));
    int height = inputIo.getHeight();
    int width = inputIo.getWidth();
    this.width = width;
    this.height = height;
    Color[][] colors = new Color[height][width];
    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        int pixel = inputIo.getRGB(x,y);
        java.awt.Color color = new java.awt.Color(pixel);
        int red = color.getRed();
        int green = color.getGreen();
        int blue = color.getBlue();
        colors[y][x] = new Color(red, green, blue);
      }
    }
    return colors;
  }
}
