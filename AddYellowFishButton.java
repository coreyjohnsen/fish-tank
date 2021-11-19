//////////////// Fish Tank 3000 //////////////////////////
//
// Title: AddYellowFishButton.java
// Course: CS 300 Fall 2021
//
// Author: Corey Johnsen
// Email: cjjohnsen@wisc.edu
// Lecturer: Hobbes LeGault
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: None
// Online Sources: None
//
///////////////////////////////////////////////////////////////////////////////

import java.io.File;

/**
 * An instantiable class that represents a button to add a yellow fish
 */
public class AddYellowFishButton extends Button {

  /**
   * Creates a new AddYellowFishButton
   * 
   * @param x is the x position of the button
   * @param y is the y position of the button
   */
  public AddYellowFishButton(float x, float y) {
    super("Add Yellow", x, y);
  }

  /**
   * Adds a yellow Fish to the tank when the button is pressed
   */
  @Override
  public void mousePressed() {
    tank.addObject(new Fish(2, "images" + File.separator + "yellow.png"));
  }

}
