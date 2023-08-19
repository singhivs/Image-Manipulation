Implementing Mosaic:

*We were able to implement image mosaicking correctly, supported a script command for it. However, it is not
supported by the GUI implementation since the code provided to us was not able to load an image through the GUI and
the buttons did not work. We added the button and the action listener however, it does not work since the load is not
functioning properly.

Mosaic class:

- We created a mosaic class that mimics the command design pattern in a way. The class represents the command
that should be called on an image using the "applyMosaic" method.

We first added 3 fields to the class which represent the number of seeds, the list of colors(each color is a list of 3 ints) of the seeds in the image
and a 2d array list of seeds (the seed and the position x, y corresponds to the pixel at the position x, y in the array that represents the
image). Then, we take a constructor that takes in the number of seeds which can be specified by the user and initializes the field that corresponds
to the seeds with the provided number. It also initializes the color array and the seed 2d array with empty ones as they will be updated throughout the process.

We then implemented a method called applyMosaic, which takes in an object of type Image (this is an interface that was provided
to us in the code). This method randomizes the location of the seeds in the image, creates a 2d array with the seeds placed at the positions that
correspond to the pixels they are assigned to and creates an array of colors for each seed(each seed is assigned a color which is the average color of all the
pixels in its cluster). We did this through three helper methods:
- initSeeds - sets up the array of colors for each seed
- getClosestSeed - creates the array of seeds(that corresponds to the array of pixels) by computing the minimum distance
from the current pixel to each seed and identifying the one with the minimum value
- createSeeds - randomizes the location of the seeds in the image and returns an array of the locations of
all the seeds

Then, we created a new array of Colors(pixels). We simply called a method on each pixel in the original image(which is a type of Color object in the implementation provided to us) that identified the 
new color associated with the appropriate cluster(the cluster that the current pixel is part of) and returned it. We added the updated color to the new array after each call of the function.
Lastly, we created a new image with the same width, height, path but with the new array of colors and returned it.

ImageProcessingModel and AbstractImageModel

- We added a new method to the interface of the model called mosaic that takes in the name of the image that
will be processed, the name it will be added to the model under and the number of seeds.
- In the AbstractImageModel class we implemented the mosaic method. We first got the image from the map of the model,
using the first argument (the name). Then, we created a new Mosaic object using the number of seeds provided(the third argument
of the method). We created a new image by calling the applyMosaic method on the Mosaic object we created and passing as an
argument the current image. Then, we returned the value of the function saveInProgram which saves the new image under the destName 
provided(second argument) to the model(adds it to the map) and returns the new image.

ImageProcessingControllerImpl

- We added a new case to the switch statement of the runProgram class in the controller which handles the
command "mosaic". It first takes the number of seeds from the readable, then it takes the name of the source image
(the image that should be processed from the model) and the destination name(the name under which the model is saved in
the model). Then, we called the mosaic method on the model using the name of the image, the destination name and the number of
seeds and used break to end the case. 
- We also added a quit case that would break out of the switch since the program was not ending before.

ActionListenerController

- We added a new case to the GUI controller that takes the destination name, the name of the image and the number of seeds
from the view and calls the mosaic method on the model using that information. Then, we called the setButton method which we called
on the view, to access the GUI.

JFrameView

- In the GUI view, we added a new button that represents the mosaic command in the constructor and
also added the action listener to the button in the setListener method.

