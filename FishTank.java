//////////////// Fish Tank 3000 //////////////////////////
//
// Title: FishTank.java
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
import java.util.ArrayList;
import java.util.Random;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * This class simulates a virtual Fish Tank with different kinds of fish and decorations
 */
public class FishTank extends PApplet {

  private PImage backgroundImage; // PImage object which represents the background image
  protected ArrayList<TankListener> objects; // list storing interactive objects
  protected Random randGen; // Generator of random numbers
  private TankObject flower;
  private TankObject log;
  private TankObject shell;
  private TankObject ship;

  /**
   * Sets the size of the window to 800 x 600
   */
  @Override
  public void settings() {
    size(800, 600);
  }

  /**
   * Defines initial environment properties, initalizes data fields, and loads images and fonts
   */
  @Override
  public void setup() {
    // Set and display the title of the display window
    this.getSurface().setTitle("Fish Tank 3000");
    // Set the location from which images are drawn to CENTER
    this.imageMode(PApplet.CENTER);
    // Set the location from which rectangles are drawn.
    this.rectMode(PApplet.CORNERS);
    this.focused = true; // Confirms that our Processing program is focused,
    // meaning that it is active and will accept mouse or keyboard input.

    // sets the text alignment to center
    this.textAlign(PApplet.CENTER, PApplet.CENTER);


    // loads the background image and store the loaded image to backgroundImage
    backgroundImage = this.loadImage("images" + File.separator + "background.png");
    // creates an empty array list of objects
    objects = new ArrayList<TankListener>();
    // sets randGen to the reference of a new Random objects
    randGen = new Random();
    // assigns TankObject and Button processing to this FishTank
    TankObject.setProcessing(this);
    Button.setProcessing(this);
    // assign TankObjects
    log = new TankObject(580, 470, "images" + File.separator + "log.png");
    flower = new TankObject(430, 60, "images" + File.separator + "flower.png");
    ship = new TankObject(280, 535, "images" + File.separator + "ship.png");
    shell = new TankObject(65, 520, "images" + File.separator + "shell.png");
    // add TankObjects to objects
    objects.add(flower);
    objects.add(log);
    objects.add(shell);
    objects.add(ship);
    objects.add(new BlackFish(log, flower));
    objects.add(new BlackFish(shell, flower));
    objects.add(new AddOrangeFishButton(129, 16));
    objects.add(new AddBlueFishButton(43, 16));
    objects.add(new AddYellowFishButton(215, 16));
    objects.add(new ClearTankButton(301, 16));
  }

  /**
   * Continuously draws and updates the application display window
   */
  @Override
  public void draw() {
    // clears the display window by drawing the background image
    this.image(backgroundImage, this.width / 2, this.height / 2);
    // traverse the objects list and draw each of the objects to this display window
    for (int i = 0; i < objects.size(); i++)
      objects.get(i).draw();
  }

  /**
   * Called each time the user presses the mouse
   */
  @Override
  public void mousePressed() {
    // traverses the objects list and call mousePressed method of the first object being clicked
    for (int i = 0; i < objects.size(); i++)
      if (objects.get(i).isMouseOver()) {
        objects.get(i).mousePressed();
        break;
      }
  }

  /**
   * Called each time the user releases the mouse
   */
  @Override
  public void mouseReleased() {
    // TODO traverse the objects list and call each object's mouseReleased() method
    for (int i = 0; i < objects.size(); i++)
      objects.get(i).mouseReleased();
  }

  /**
   * Adds a TankListener to the objects ArrayList
   */
  public void addObject(TankListener object) {
    objects.add(object);
  }

  /**
   * Called each time the user presses a key
   */
  @Override
  public void keyPressed() {

    switch (Character.toUpperCase(this.key)) {
      case 'O':
        // add new orange fish
        objects.add(new Fish());
        break;
      case 'Y':
        // add new yellow fish
        objects.add(new Fish(2, "images" + File.separator + "yellow.png"));
        break;
      case 'R':
        // removes Fish object that mouse is over
        for (int i = 0; i < objects.size(); i++) {
          if (objects.get(i) instanceof Fish && objects.get(i).isMouseOver()) {
            objects.remove(i);
            break;
          }
        }
      case 'S':
        // makes all fish start swimming
        for (int i = 0; i < objects.size(); i++) {
          if (objects.get(i) instanceof Fish) {
            ((Fish) objects.get(i)).startSwimming();
          }
        }
        break;
      case 'X':
        // stops all fish from swimming
        for (int i = 0; i < objects.size(); i++) {
          if (objects.get(i) instanceof Fish) {
            ((Fish) objects.get(i)).stopSwimming();
          }
        }
        break;
      case 'C':
        // clears all fish
        clear();
        break;
      case 'B':
        // creates a new BlueFish
        objects.add(new BlueFish());
    }
  }

  /**
   * Removes any Fish instances from the objects ArrayList and the tank
   */
  public void clear() {
    for (int i = 0; i < objects.size(); i++) {
      if (objects.get(i) instanceof Fish) {
        objects.remove(i);
        i--;
      }
    }
  }

  /**
   * Called when the program begins running
   */
  public static void main(String[] args) {
    PApplet.main("FishTank");
  }

}
