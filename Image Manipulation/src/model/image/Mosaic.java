package model.image;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * A Mosaic class that represents the command that can be applied to an image in order to be
 * edited as a mosaic with a provided number of seeds.
 */
public class Mosaic {
  private final int seeds;
  private final List<int[]> col;
  private final List<List<Integer>> num;

  /**
   * Constructs a mosaic object using a given number of seeds that are assigned randomly throughout
   * the image.
   *
   * @param seeds the number of seeds of this mosaic
   */
  public Mosaic(int seeds) {
    if (seeds <= 0) {
      throw new IllegalArgumentException("The number of seeds should be positive.");
    }
    this.seeds = seeds;
    this.col = new ArrayList<>();
    this.num = new ArrayList<>();
  }

  /**
   * Applies this mosaic to a provided image (to all the pixels/colors in the image).
   *
   * @param img the image that is being processed
   * @return returns the new image after the mosaic was applied
   */
  public Image applyMosaic(Image img) {
    if (seeds > img.getHeight() * img.getWidth()) {
      throw new IllegalArgumentException("Invalid number of seeds.");
    }
    initSeeds(img);
    Color[][] newImg = new Color[img.getHeight()][img.getWidth()];
    for (int i = 0; i < img.getHeight(); i++) {
      for (int j = 0; j < img.getWidth(); j++) {
        newImg[i][j] = applyToColorPix(img, i, j);
      }
    }
    return new GeneralImage(img.getWidth(), img.getHeight(), newImg, img.getPath());
  }


  private void initSeeds(Image img) {
    col.clear();
    Map<Integer, ArrayList<int[]>> map = getClosestSeed(img.getWidth(), img.getHeight());
    Color[][] cols = img.getColors();
    for (int i = 0; i < seeds; i++) {
      int[] avgCol = {0, 0, 0};
      if (map.containsKey(i)) {
        for (int j = 0; j < map.get(i).size(); j++) {
          int[] coords = map.get(i).get(j);
          int y = coords[0];
          int x = coords[1];
          Color c = cols[y][x];
          avgCol[0] += c.getRed();
          avgCol[1] += c.getGreen();
          avgCol[2] += c.getBlue();
        }

        avgCol[0] = avgCol[0] / map.get(i).size();
        avgCol[1] = avgCol[1] / map.get(i).size();
        avgCol[2] = avgCol[2] / map.get(i).size();

        col.add(avgCol);
      }
    }
  }

  private Map<Integer, ArrayList<int[]>> getClosestSeed(int w, int h) {
    num.clear();
    List<int[]> loc = createSeeds(h, w);
    HashMap<Integer, ArrayList<int[]>> closestSeedMap = new HashMap<>();

    for (int i = 0; i < w; i++) {
      num.add(new ArrayList<>());
      for (int j = 0; j < h; j++) {
        Double[] dist = new Double[loc.size()];
        for (int k = 0; k < loc.size(); k++) {
          dist[k] = (Math.sqrt(
                  Math.pow(loc.get(k)[0] - i, 2) + Math.pow(loc.get(k)[1] - j, 2)));
        }
        double min = dist[0];
        int index = 0;
        for (int m = 0; m < dist.length; m++) {
          if (dist[m] < min && dist[m] != 0) {
            min = dist[m];
            index = m;
          }
        }

        int seedNum = index;
        num.get(i).add(seedNum);
        if (!closestSeedMap.containsKey(seedNum)) {
          closestSeedMap.put(seedNum, new ArrayList<>());
        }
        int[] coordsPix = new int[]{j, i};
        closestSeedMap.get(seedNum).add(coordsPix);
      }
    }

    return closestSeedMap;
  }

  private List<int[]> createSeeds(int h, int w) {
    List<int[]> locs = new ArrayList<>();
    List<List<Boolean>> checked = new ArrayList<>();
    Random r = new Random();

    for (int i = 0; i < w; i++) {
      checked.add(new ArrayList<>());
      for (int j = 0; j < h; j++) {
        checked.get(i).add(false);
      }
    }

    for (int i = 0; i < seeds; i++) {
      int x = r.nextInt(w);
      int y = r.nextInt(h);
      while (checked.get(x).get(y)) {
        x = r.nextInt(w);
        y = r.nextInt(h);
      }
      locs.add(new int[]{y, x});
      checked.get(x).set(y, true);
    }
    return locs;
  }

  private Color applyToColorPix(Image img, int y, int x) {
    int[] colors = col.get(num.get(x).get(y));
    return new Color(colors[0], colors[1], colors[2]);
  }

}
