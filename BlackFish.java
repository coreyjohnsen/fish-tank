//////////////// Fish Tank 3000 //////////////////////////
//
// Title: BlackFish.java
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
 * An instantiable class that represents a black fish that swims between two objects
 */
public class BlackFish extends Fish {

  private TankObject source; // object that BlackFish will swim from
  private TankObject destination; // object that BlackFish will swim towards

  /**
   * Creates a new BlackFish
   * 
   * @param source      is the object that BlackFish will swim away from
   * @param desintaiton is the object that BlackFish will swim towards
   */
  public BlackFish(TankObject source, TankObject destination) {
    super(2, "images" + File.separator + "black.png");
    this.source = source;
    this.destination = destination;
  }

  /**
   * Moves the BlackFish one speed step towards the destination
   */
  public void moveTowardsDestination() {
    // find dx and dy between Fish and object
    float dx = (destination.getX() - super.getX());
    float dy = (destination.getY() - super.getY());
    // calculate distance from Fish to object
    int distanceTo = (int) Math.sqrt(dx * dx + dy * dy);
    // calculate the new value of x and y
    float newX =
        super.getX() + ((super.speed() * (destination.getX() - super.getX())) / distanceTo);
    float newY =
        super.getY() + ((super.speed() * (destination.getY() - super.getY())) / distanceTo);
    // move the fish
    super.setX(newX);
    super.setY(newY);
  }

  /**
   * Determines whether the BlackFish is over another TankObject
   * 
   * @param other object to test if the BlackFish is over
   * @return true if the BlackFish is over other, false otherwise
   */
  public boolean isOver(TankObject other) {
    // defines bottom left (x1, y1) (x3, y3) and top right (x2, y2) (x4, y4) points on each image
    float x1 = (super.getX() - (super.getImage().width / 2));
    float x2 = (super.getX() + (super.getImage().width / 2));
    float x3 = (other.getX() - (other.getImage().width / 2));
    float x4 = (other.getX() + (other.getImage().width / 2));
    float y1 = (super.getY() - (super.getImage().height / 2));
    float y2 = (super.getY() + (super.getImage().height / 2));
    float y3 = (other.getY() - (other.getImage().height / 2));
    float y4 = (other.getY() + (other.getImage().height / 2));

    // checks if overlapping
    if (x1 < x4 && x3 < x2 && y1 < y4 && y3 < y2)
      return true;
    else
      return false;
  }

  /**
   * Makes the BlackFish swim between the two objects
   */
  @Override
  public void swim() {
    // move the fish towards its destination and switch target if reached
    moveTowardsDestination();
    // check if fish has reached its destination
    if (isOver(destination)) {
      TankObject temp = this.destination;
      this.destination = this.source;
      this.source = temp;
    }
  }

}
