Design critique:

Strengths and Limitations:

- The code respected the MVC framework, as it has a model, view and controller. The view is
  designed well since it does not depend on the model or controller. The controller handles
  operations between the model and the view(in the case of the GUI, as the view is not relevant in
  the script/text aspect of the code), which is optimal. The program also has two different controllers, one
  that handles the GUI implementation and one that accepts the script or text commands. We think this is a good implementation,
  because the graphical controller takes in the graphical view and model and adds the model according to the instructions taken in by the view, whereas the text
  controller doesn't depend on the view, it takes in input from the console or a script command file. While the text-based controller and graphical controller
  add to the model in the same way , they take in inputs from the user differently and the GUI controller asks the view to display the image every time,
  which shows that it is dependent on the view.
- One aspect that we thought needed improvement was the fact that the program did not use the command design pattern. We consider that by
  implementing the pattern in this code it would have been easier to add additional functionality, such as the mosaic, and the code would have been
  much cleaner and easier to understand. The commands were all added to the model, which made it seem a bit clustered. However, there were helper methods
  for each filter or color transformation. Therefore, the methods were concise and quite easy to understand.
- The GUI controller was an action listener which was a good design choice and it used the view and model properly,
  depending on the command that was given.

Implementation critique

Strengths and Limitations:

- We thought that the implementation was a good approach. They used inheritance in numerous classes which
  prevented code duplication, such as creating the abstract classes: AbstractImageModel and AbstractImage.
  We also thought that creating a separate class for the color, to represent each pixel was a good choice,
  as it made it easier to manipulate the images, by accessing each pixel at a time. What's more, the model
  has the ability to work with multiple images as it has a map that stores each image under a given name.

- The implementation of the Image requires, however, extra information that does seem relevant or could be retrieved
  by calling a method. For example, the constructor of the abstract image class takes in the width and height of the image.
  However, since we are passing as an argument the array of colors, we could get the width and height from the dimensions of
  the array. Our suggestion would be minimize the number of arguments in the constructor, as it might get confusing when someone
  tries to implement new images.

- The interfaces were well implemented in the classes provided. The methods defined were relevant for the type
of objects that were being represented and there was not much code duplication within the implementation. However,
there were extra classes that did not really seem to have a relevance within the code, such as PPMImage and GeneralImage,
which could have been represented as one class rather two different ones. Our suggestion would have been to make a more general object (class),
ImageImpl that would have extended abstract class and would have represented a general image(ppm or any other type).

- The GUI was not fully functional. They mentioned that the buttons do not work properly. However, the implementation of
  the view was well structured, as it allowed us to add new functionality(we added a new button for the mosaic). Even if the
  buttons did not actually work, we could see the panel, the buttons and the messages sent by the controller.

- One suggestion that we would have for the GUI would be to load and save the image using the JFileChooser as it would
  be much easier for the user. Their program currently requires the user to type in the path of the image, which might be
  complicated depending on where the image is placed on the computer.

Requested Changes:

- We requested them to update their GUI and script commands as they were not working properly. They
  were not able to fix the code in time. Therefore, we managed to add the script commands functionality
  to the code, but we were not able to fix the GUI (we just added buttons, but they do not work).

Documentation Critique
- The documentation is thorough. They explain what each function is supposed to do and what most fields represent.
  However, one aspect that we would suggest some improvement on was the consistency between the comments
  from the interfaces and the ones in the implementation classes. Some methods were not explained in the
  interface but had javadoc comments in the other classes where they were overridden. This made the code seem
  a bit messy, as the documentation was not placed in the same class. We would suggest keeping all the comments
  in the appropriate interfaces to make the code seem cleaner.
- The USEME file did not have specific examples of commands that we could use to run the program which made
  it quite hard to figure the exact command that we needed to call. It would have been a better approach to
  be more specific with description for the command. For example to say "load source-file-path dest-name".
  In the USEME we included the command that would be used to run the mosaic which is
  "mosaic num-seeds source-image-name dest-image-name", which makes it more specific.
- While the README includes some information about the code, it does not have specific details about
  the purpose of each class and interface and their methods. Sometimes, while reviewing the code, we were quite
  confused about certain fields or methods that it would have been helpful to have access to some extra
  information about them and their purpose in the code.

Overall, the code was pretty convenient to use even though there a few functionalities missing. We
found that there were some classes and interface whose purposes were not clear in the code. However,
we did manage to figure out their design choice and implementation fairly quickly. 