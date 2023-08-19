package view;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

/**
 * The interface for our view class.
 */
public interface IView {

  //  void setLoadButton(BufferedImage image);

  void setButton(BufferedImage image, BufferedImage hist);


  /**
   * Get the string from the text field and return it.
   */
  String getInput1String();


  /**
   * Clear the text field. Note that a more general "setInputString" would work for this purpose but
   * would be incorrect. This is because the text field is not set programmatically in general but
   * input by the user.
   */
  void clearInput1String();

  String getInput2String();

  void clearInput2String();

  String getInput3String();

  void clearInput3String();

  /**
   * Set the listener for any actions.
   */
  void setListener(ActionListener listener);

  /**
   * Display this view.
   */
  void display();

  void renderMessage(String message);
}

