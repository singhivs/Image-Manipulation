package view;

import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * A class that tests the methods of PPMTextView.
 */
public class PPMTextViewTest {
  private ImageProcessingView view;

  String file2 = "0 0 0\n" + "2 6 8\n" + "5 5 5\n"
          + "8 0 0\n" + "8 8 8\n" + "0 0 0\n";

  String printFile2 = "Color of pixel (" + 0 + "," + 0 + "): " + 0 + "," + 0 + "," + 0 + "\n"
          + "Color of pixel (" + 0 + "," + 1 + "): " + 2 + "," + 6 + "," + 8 + "\n"
          + "Color of pixel (" + 0 + "," + 2 + "): " + 5 + "," + 5 + "," + 5 + "\n"
          + "Color of pixel (" + 1 + "," + 0 + "): " + 8 + "," + 0 + "," + 0 + "\n"
          + "Color of pixel (" + 1 + "," + 1 + "): " + 8 + "," + 8 + "," + 8 + "\n"
          + "Color of pixel (" + 1 + "," + 2 + "): " + 0 + "," + 0 + "," + 0 + "\n";


  @Test
  public void testRenderMessage() {
    Appendable ap = new StringBuilder();
    view = new PPMTextView(ap);
    try {
      view.renderMessage("A B C");
      assertEquals("A B C", ap.toString());
    }
    catch (IllegalStateException e) {
      fail("Transmission failed");
    }
  }

  @Test
  public void testSaveInProgram() {
    Appendable ap = new StringBuilder();
    view = new PPMTextView(ap);
    Scanner scan = new Scanner(this.file2);
    view.printColors(scan, 3, 2);
    assertEquals(printFile2, ap.toString());
  }
}
