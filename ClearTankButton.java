//////////////// Fish Tank 3000 //////////////////////////
//
// Title: ClearTankButton.java
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
 * An instantiable class that represents a button to clear the fish in the tank
 */
public class ClearTankButton extends Button {

  /**
   * Creates a new ClearTankButton
   * 
   * @param x is the x position of the button
   * @param y is the y position of the button
   */
  public ClearTankButton(float x, float y) {
    super("clear", x, y);
  }

  /**
   * Clears the tank of fish when the button is clicked
   */
  @Override
  public void mousePressed() {
    tank.clear();
  }


}
