//////////////// Fish Tank 3000 //////////////////////////
//
// Title: AddOrangeFishButton.java
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

/**
 * An instantiable class that represents a button to add an orange fish
 */
public class AddOrangeFishButton extends Button {

  /**
   * Creates a new AddOrangeFishButton
   * 
   * @param x is the x position of the button
   * @param y is the y position of the button
   */
  public AddOrangeFishButton(float x, float y) {
    super("Add Orange", x, y);
  }

  /**
   * Adds a new orange Fish to the tank when the button is pressed
   */
  @Override
  public void mousePressed() {
    tank.addObject(new Fish());
  }

}
