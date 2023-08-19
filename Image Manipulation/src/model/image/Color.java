package model.image;

/**
 * A class that represents a color.
 */
public class Color {
  public int red;
  public int green;
  public int blue;

  /**
   * A constructor that takes in values of red, green and blue.
   *
   * @param red the red value
   * @param green the green value
   * @param blue the green value
   * @throws IllegalArgumentException if invalid values are assigned
   */
  public Color(int red, int green, int blue) throws IllegalArgumentException {
    if (red < 0 || red > 255 || green < 0 || green > 255 || blue < 0 || blue > 255) {
      throw new IllegalArgumentException("Invalid color fields");
    }
    this.red = red;
    this.green = green;
    this.blue = blue;
  }

  /**
   * Returns the maximum value of the three components for each pixel.
   *
   * @return the maximum value of the three components for each pixel
   */
  //Value: the maximum value of the three components for each pixel
  public int getValue() {
    return Math.max(Math.max(red, green), blue);
  }

  /**
   * Returns the average of the three components for each pixel.
   *
   * @return the average of the three components for each pixel
   */
  //Intensity: the average of the three components for each pixel
  public int getIntensity() {
    return Math.round((red + green + blue) / 3);
  }

  /**
   * Returns the weighted sum 0.2126𝑟+0.7152𝑔+0.0722𝑏.
   *
   * @return the weighted sum 0.2126𝑟+0.7152𝑔+0.0722𝑏
   */
  //Luma: the weighted sum 0.2126𝑟+0.7152𝑔+0.0722𝑏
  public int getLuma() {
    return (int) Math.round(0.2126 * red + 0.7152 * green + 0.0722 * blue);
  }

  /**
   * Returns the red value of this color.
   * @return the red value of this color.
   */
  public int getRed() {
    return this.red;
  }

  /**
   * Returns the green value of this color.
   * @return the green value of this color.
   */
  public int getGreen() {
    return this.green;
  }

  /**
   * Returns the blue value of this color.
   * @return the blue value of this color.
   */
  public int getBlue() {
    return this.blue;
  }

  /**
   * returns a new Color with all of its components equal to this Color's value.
   * @return the new Color
   */
  public Color valueColor() {
    int value = this.getValue();
    return new Color(value, value, value);
  }

  /**
   * returns a new Color with all of its components equal to this color's intensity.
   * @return the new Color
   */
  public Color intensityColor() {
    int intensity = this.getIntensity();
    return new Color(intensity, intensity, intensity);
  }

  /**
   * returns a new color with all of its components equal to this color's luma.
   * @return the new Color
   */
  public Color lumaColor() {
    int luma = this.getLuma();
    return new Color(luma, luma, luma);
  }

  /**
   * Subtracts the given int from each component of the color.
   * if the new value is less than 0, it is 0.
   * @param i the amount subtracted
   * @return a new Color that has been darkened
   */
  public Color darkenColor(int i) {
    int r = this.red - i;
    int g = this.green - i;
    int b = this.blue - i;

    if (r < 0) {
      r = 0;
    }
    if (g < 0) {
      g = 0;
    }
    if (b < 0) {
      b = 0;
    }

    return new Color(r, g, b);
  }

  /**
   * Adds the given int from each component of the color.
   * if the new value is more than the maximum value, it is the maximum value.
   * @param i the amount added
   * @param maxVal the maximum value that a color can be
   * @return a new Color that has been brightened
   */
  public Color brightenColor(int i, int maxVal) {
    int r = this.red + i;
    int g = this.green + i;
    int b = this.blue + i;

    if (maxVal < r) {
      r = maxVal;
    }
    if (maxVal < g) {
      g = maxVal;
    }
    if (maxVal < b) {
      b = maxVal;
    }

    return new Color(r, g, b);
  }

  /**
   * Returns the String that represents this color.
   * @return the String that represents this color
   */
  public String colorToString() {
    return this.red + " " + this.blue + " " + this.blue;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) {
      return true;
    } else if (other.getClass() != this.getClass()) {
      return false;
    } else {
      Color o = (Color) other;
      return ((this.red == o.getRed()) && (this.blue == o.getBlue())
              && (this.green == o.getGreen()));

    }
  }

  @Override
  public int hashCode() {
    return 10000 * this.red + 100 * this.green + 1 * this.blue;
  }
}
