package view;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Map;

import model.image.Image;
import model.GeneralImageModel;
import model.ImageProcessingModel;

/**
 * A JFrameView is an GUI implementation using the JFrame Class.
 */
public class JFrameView extends JFrame implements IView {

  private JLabel display;

  private JButton loadButton;
  private JButton saveButton;
  private JButton redComponentButton;
  private JButton greenComponentButton;
  private JButton blueComponentButton;
  private JButton valueComponentButton;
  private JButton intensityComponentButton;
  private JButton lumaComponentButton;
  private JButton horizontalFlipButton;
  private JButton verticalFlipButton;
  private JButton brightenButton;
  private JButton darkenButton;
  private JButton sepiaButton;
  private JButton greyscaleButton;
  private JButton blurButton;
  private JButton sharpenButton;
  private JButton mosaicButton;

  private JPanel imagePanel;
  private JLabel imageLabel;


  private JPanel graphPanel;
  private JLabel graphLabel;

  private JPanel mainPanel;
  private JScrollPane mainScrollPane;
  private JTextField input1;
  private JTextField input2;
  private JTextField input3;
  private Map<String, Image> images;

  /**
   * A constructor that constructs the default view.
   * Constructs all of the buttons and panels for the view.
   *
   * @param caption the caption for the Frame
   */
  public JFrameView(String caption) {
    super(caption);

    ImageProcessingModel model = new GeneralImageModel();
    Image thisImage = null;


    setSize(300, 300);
    setLocation(200, 200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    JPanel buttonPanel1;
    JPanel buttonPanel2;

    //button panel 1
    buttonPanel1 = new JPanel();
    buttonPanel1.setLayout(new FlowLayout());
    this.add(buttonPanel1, BorderLayout.CENTER);
    //button panel 2
    buttonPanel2 = new JPanel();
    buttonPanel2.setLayout(new FlowLayout());
    this.add(buttonPanel2, BorderLayout.SOUTH);


    this.setLayout(new FlowLayout());

    display = new JLabel("To be displayed");
    //label = new JLabel(new ImageIcon("Jellyfish.JPG"));


    this.add(display);

    //the textfield
    input1 = new JTextField(10);
    this.add(input1);

    //the textfield
    input2 = new JTextField(10);
    this.add(input2);

    //the textfield
    input3 = new JTextField(10);
    this.add(input3);

    //loadButton
    loadButton = new JButton("Load");
    loadButton.setActionCommand("load");
    buttonPanel1.add(loadButton);

    //saveButton
    saveButton = new JButton("Save");
    saveButton.setActionCommand("save");
    buttonPanel1.add(saveButton);

    //redComponentButton
    redComponentButton = new JButton("Red Component");
    redComponentButton.setActionCommand("red-component");
    buttonPanel1.add(redComponentButton);

    //greenComponentButton
    greenComponentButton = new JButton("Green Component");
    greenComponentButton.setActionCommand("green-component");
    buttonPanel1.add(greenComponentButton);

    //blueComponentButton
    blueComponentButton = new JButton("Blue Component");
    blueComponentButton.setActionCommand("blue-component");
    buttonPanel1.add(blueComponentButton);

    //valueComponentButton
    valueComponentButton = new JButton("Value Component");
    valueComponentButton.setActionCommand("value-component");
    buttonPanel1.add(valueComponentButton);

    //intensityComponentButton
    intensityComponentButton = new JButton("Intensity Component");
    intensityComponentButton.setActionCommand("intensity-component");
    buttonPanel1.add(intensityComponentButton);

    //lumaComponentButton
    lumaComponentButton = new JButton("Luma Component");
    lumaComponentButton.setActionCommand("luma-component");
    buttonPanel1.add(lumaComponentButton);

    //horizontalFlipButton
    horizontalFlipButton = new JButton("Horizontal Flip");
    horizontalFlipButton.setActionCommand("horizontal-flip");
    buttonPanel2.add(horizontalFlipButton);

    //verticalFlipButton
    verticalFlipButton = new JButton("Vertical Flip");
    verticalFlipButton.setActionCommand("vertical-flip");
    buttonPanel2.add(verticalFlipButton);

    //brightenButton
    brightenButton = new JButton("Brighten");
    brightenButton.setActionCommand("brighten");
    buttonPanel2.add(brightenButton);

    //darkenButton
    darkenButton = new JButton("Darken");
    darkenButton.setActionCommand("darken");
    buttonPanel2.add(darkenButton);

    //sepiaButton
    sepiaButton = new JButton("Sepia");
    sepiaButton.setActionCommand("sepia");
    buttonPanel2.add(sepiaButton);

    //greyscaleButton
    greyscaleButton = new JButton("Greyscale");
    greyscaleButton.setActionCommand("geyscale");
    buttonPanel2.add(greyscaleButton);

    //blurButton
    blurButton = new JButton("Blur");
    blurButton.setActionCommand("blur");
    buttonPanel2.add(blurButton);

    //sharpenButton
    sharpenButton = new JButton("Sharpen");
    sharpenButton.setActionCommand("sharpen");
    buttonPanel2.add(sharpenButton);

    //mosaicButton
    mosaicButton = new JButton("Mosaic");
    mosaicButton.setActionCommand("mosaic");
    buttonPanel2.add(mosaicButton);

    //    this.add(mainPanel);


    //show an image with a scrollbar
    JPanel imagePanel = new JPanel();
    //a border around the panel with a caption
    imagePanel.setBorder(BorderFactory.createTitledBorder("Current Image"));
    imagePanel.setLayout(new GridLayout(1, 0, 10, 10));
    //imagePanel.setMaximumSize(null);
    this.add(imagePanel, BorderLayout.WEST);

    String imageString = "";

    JScrollPane imageScrollPane;
    imageLabel = new JLabel();
    imageScrollPane = new JScrollPane(imageLabel);
    imageLabel.setIcon(new ImageIcon(imageString));
    imageScrollPane.setPreferredSize(new Dimension(600, 600));
    imagePanel.add(imageScrollPane);

    //show an image with a scrollbar
    JPanel graphPanel = new JPanel();
    //a border around the panel with a caption
    graphPanel.setBorder(BorderFactory.createTitledBorder("Current Image"));
    graphPanel.setLayout(new GridLayout(1, 0, 10, 10));
    //imagePanel.setMaximumSize(null);
    this.add(graphPanel, BorderLayout.WEST);

    JScrollPane graphScrollPane;
    graphLabel = new JLabel();
    graphScrollPane = new JScrollPane(graphLabel);
    graphLabel.setIcon(new ImageIcon(imageString));
    graphLabel.setPreferredSize(new Dimension(200, 200));
    imagePanel.add(graphScrollPane);


    pack();
  }

  @Override
  public void display() {
    setVisible(true);
  }


  @Override
  public void setListener(ActionListener listener) {
    loadButton.addActionListener(listener);
    saveButton.addActionListener(listener);
    redComponentButton.addActionListener(listener);
    greenComponentButton.addActionListener(listener);
    blueComponentButton.addActionListener(listener);
    valueComponentButton.addActionListener(listener);
    intensityComponentButton.addActionListener(listener);
    lumaComponentButton.addActionListener(listener);
    horizontalFlipButton.addActionListener(listener);
    verticalFlipButton.addActionListener(listener);
    brightenButton.addActionListener(listener);
    darkenButton.addActionListener(listener);
    sepiaButton.addActionListener(listener);
    greyscaleButton.addActionListener(listener);
    blurButton.addActionListener(listener);
    sharpenButton.addActionListener(listener);
    mosaicButton.addActionListener(listener);
  }


  @Override
  public void setButton(BufferedImage image, BufferedImage hist) {
    ImageIcon icon = new ImageIcon();
    icon.setImage(image);
    ImageIcon histIcon = new ImageIcon();
    histIcon.setImage(hist);
    imageLabel.setIcon(icon);
    graphLabel.setIcon(histIcon);
    // this.repaint();
  }

  @Override
  public String getInput1String() {
    return input1.getText();
  }

  @Override
  public void clearInput1String() {
    input1.setText("");
  }

  @Override
  public String getInput2String() {
    return input2.getText();
  }

  @Override
  public void clearInput2String() {
    input2.setText("");
  }

  @Override
  public String getInput3String() {
    return input3.getText();
  }

  @Override
  public void clearInput3String() {
    input3.setText("");
  }

  @Override
  public void renderMessage(String message) throws IllegalStateException {
    display.setText(message);

  }

}
