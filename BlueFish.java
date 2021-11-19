//////////////// Fish Tank 3000 //////////////////////////
//
// Title: BlueFish.java
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
 * An instantiable class that represents a blue fish that swims right to left
 */
public class BlueFish extends Fish {

  /**
   * Creates a new BlueFish
   */
  public BlueFish() {
    super(2, "images" + File.separator + "blue.png");
  }

  /**
   * Makes the BlueFish swim
   */
  @Override
  public void swim() {
    super.move(-1 * super.speed(), 0);
    super.setX(tank.width - ((tank.width - super.getX()) % tank.width));
  }

}
