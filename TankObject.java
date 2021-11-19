//////////////// Fish Tank 3000 //////////////////////////
//
// Title: TankObject.java
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

import processing.core.PImage;

/**
 * An instantiable class that represents an object in a tank
 */
public class TankObject implements TankListener {
  protected static FishTank tank; // PApplet object which represents
  // the display window
  protected PImage image; // image of this tank object
  private float x; // x-position of this tank in the display window
  private float y; // y-position of this tank in the display window
  private boolean isDragging; // indicates whether this tank object
  // is being dragged or not
  private static int oldMouseX; // old x-position of the mouse
  private static int oldMouseY; // old y-position of the mouse

  /**
   * Creates a new TankObject
   * 
   * @param x             is the x position of the object
   * @param y             is the y position of the object
   * @param imageFileName is the image associated with the object
   */
  public TankObject(float x, float y, String imageFileName) {
    this.x = x;
    this.y = y;
    image = tank.loadImage(imageFileName);
  }

  /**
   * Sets the processing of the TankObject
   * 
   * @param tank is the FishTank to set the processing to
   */
  public static void setProcessing(FishTank tank) {
    TankObject.tank = tank;
  }

  /**
   * Moves the TankObject by dx and dy
   * 
   * @param dx is the amount to move in the x direction
   * @param dy is the amount to move in the y direction
   */
  public void move(int dx, int dy) {
    this.x += dx;
    this.y += dy;
  }

  /**
   * Gets the x value of the object
   * 
   * @return the x value of the object
   */
  public float getX() {
    return this.x;
  }

  /**
   * Gets the y value of the object
   * 
   * @return the y value of the object
   */
  public float getY() {
    return this.y;
  }

  /**
   * Sets the x value of the object
   * 
   * @param x is the x value to set the object to
   */
  public void setX(float x) {
    this.x = x;
  }

  /**
   * Sets the y value of the object
   * 
   * @param y is the y value to set the object to
   */
  public void setY(float y) {
    this.y = y;
  }

  /**
   * Gets the image of this TankObject
   * 
   * @return the image of the object
   */
  public PImage getImage() {
    return image;
  }

  /**
   * Determines whether the object is being dragged
   * 
   * @return true if the object is being dragged, false otherwise
   */
  public boolean isDragging() {
    return isDragging;
  }

  /**
   * Starts dragging the object
   */
  public void startDragging() {
    oldMouseX = tank.mouseX;
    oldMouseY = tank.mouseY;
    isDragging = true;
  }

  /**
   * Stops dragging the object
   */
  public void stopDragging() {
    isDragging = false;
  }

  /**
   * Draws the TankObject to the display
   */
  @Override
  public void draw() {
    // if this object is dragging, set its position to follow the mouse moves
    if (this.isDragging) {
      int dx = tank.mouseX - oldMouseX;
      int dy = tank.mouseY - oldMouseY;
      this.move(dx, dy);
      oldMouseX = tank.mouseX;
      oldMouseY = tank.mouseY;
    }
    // draw this decoration object at its current position
    tank.image(this.image, this.x, this.y);
  }

  /**
   * Starts dragging the object if the mouse is pressed over the object
   */
  @Override
  public void mousePressed() {
    if (this.isMouseOver()) {
      this.startDragging();
    }
  }

  /**
   * Stops dragging the object if the mouse is released
   */
  @Override
  public void mouseReleased() {
    this.stopDragging();

  }

  /**
   * Determines if the mouse if over the object
   * 
   * @return true if the mouse if over the object, false otherwise
   */
  @Override
  public boolean isMouseOver() {
    // checks if the mouse is over this object
    return tank.mouseX >= x - (image.width / 2) && tank.mouseX <= x + (image.width / 2)
        && tank.mouseY >= y - (image.height / 2) && tank.mouseY <= y + (image.height / 2);
  }
}
