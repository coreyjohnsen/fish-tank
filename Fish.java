//////////////// Fish Tank 3000 //////////////////////////
//
// Title: Fish.java
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
 * An instantiable class that represents a fish in the fish tank
 */
public class Fish extends TankObject {

  // define instance fields
  private int speed;
  private boolean isSwimming;

  /**
   * Creates a new Fish
   * 
   * @param speed             is the speed that the fish will swim at
   * @param fishImageFileName is the image that the fish will be
   * @throws IllegalArgumentException if speed is negative
   */
  public Fish(int speed, String fishImageFileName) throws IllegalArgumentException {
    super(tank.randGen.nextInt(tank.width), tank.randGen.nextInt(tank.height), fishImageFileName);
    if (speed >= 0)
      this.speed = speed;
    else
      throw new IllegalArgumentException("Warning: speed cannot be negative");
  }

  /**
   * Creates a new fish
   */
  public Fish() {
    this(5, "images" + File.separator + "orange.png");
  }

  /**
   * Draws the fish to the screen and handles swimming and dragging
   */
  @Override
  public void draw() {
    // updates x and y for swimming
    if (this.isSwimming) {
      this.swim();
    }
    // drags and draws
    super.draw();
  }

  /**
   * Checks if the fish is swimming
   * 
   * @returns true if the fish is swimming, false otherwise
   */
  public boolean isSwimming() {
    return isSwimming;
  }

  /**
   * Makes the fish start swimming
   */
  public void startSwimming() {
    super.stopDragging();
    isSwimming = true;
  }

  /**
   * Makes the fish stop swimming
   */
  public void stopSwimming() {
    isSwimming = false;
  }

  /**
   * Gets the speed of the fish
   * 
   * @returns the speed of the fish
   */
  public int speed() {
    return speed;
  }

  /**
   * Makes the fish swim by moving it one speed step from left to right
   */
  public void swim() {
    super.move(speed, 0);
    super.setX(super.getX() % tank.width);
  }
}
