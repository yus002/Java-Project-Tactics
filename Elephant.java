/**
 * Author: Yue Sun
 * email: yus002@ucsd.edu
 * CSE8B Login : cs8bwadc
 * Date: 2/20/19
 * File: Elephant.java 
 * 
 * Sources of Help: PA4 writeup
 *  https://docs.oracle.com/javase/10/docs/api/java/awt/Color.html
 *  https://www.tutorialspoint.com/java/lang/math_abs_int.htm
 *  
 * This file is a solution to Implementation Details of PSA4
 * This file contains the Elephant class
 */

import java.util.Random;
import java.awt.*;
import java.lang.*;

/**
 * Uses Elephant class to contain methods and variables inherited from
 * Critter class and Movable class and override some methods
 * 
 *
 * Instance variable:
 *      goalX -  Elephants share an int goalX coordinate
 *      goalY - Elephants share an int goalY coordinate
 *      random - An Elephant also has a Random object used to 
 *      generating random ints when picking new goal coordinates.
 */

public class Elephant extends Critter implements Movable {
    // for not using magic numbers
    private static final String elephantRepresentation = "El";
    private static final int levelUp = 2;
    private static final int increment = 7;

    static int goalX;
    static int goalY;
    private Random random;
    
    /**
     * This constructor initializes the random object  
     * The very first goalX and goalY should be (0,0).
     * the string representation of Elephant is "El"
     * 
     * @param none  
     * @return nothing
     */

    public Elephant(){
        super(elephantRepresentation);
        random = new Random();
    }
    
    @Override
    /** Elephants are GRAY.
     *
     * @param none
     * @return the Colorful name of the elephant
     */
        
    public Color getColor(){
        return Color.GRAY;
    }

    @Override
    /** Elephants move in a certain pattern.      
     * @param none
     * @return the direction of the Leopard
     */

    public Direction getMove() {
        // check whether the elephant has reached the goal
        // if it has, change the goal
        if ((getX() == goalX) && (getY() == goalY)){
            goalX = random.nextInt(getWidth());
            goalY = random.nextInt(getHeight());
       
            
            // if an Elephant is further from its goal in the x-axis, 
            // it would move EAST or WEST depending on the location 
            // of their goal and their current location
            int absolute_X_Distance = Math.abs(getX() - goalX);
            int absolute_Y_Distance = Math.abs(getY() - goalY);

            if (absolute_X_Distance > absolute_Y_Distance){
                // if the goal is on the right side 
                // of the elephant
                // move EAST
                if ((goalX - getX()) > 0){
                    return Direction.EAST;
                }
                // if the goal is on the left
                else if ((goalX - getX()) < 0){
                    return Direction.WEST;
                }
            }
            // When an Elephant is further from its goal in the y-axis,
            // an Elephant would move NORTH or SOUTH. 
            else if (absolute_X_Distance < absolute_Y_Distance){
                // if the goal is on the bottom side 
                // of the elephant
                // move South
                if ((goalY - this.getY()) > 0){
                    return Direction.SOUTH;
                }
                // if the goal is on the top side
                else if ((goalY - this.getY()) < 0){
                    return Direction.NORTH;
                }
            }
            // If the distances are equal, 
            // choose to move on the x-axis
            else{
                
                // if the goal is on the right side 
                // of the elephant
                // move EAST
                if ((goalX - this.getX()) > 0){
                    return Direction.EAST;
                }
                // if the goal is on the left
                else if ((goalX - this.getX()) < 0){
                    return Direction.WEST;
                }
            }

        }
        
        // if the elephant has not reached the goal
        // start moving
        else{
            int absolute_X_Distance = Math.abs(getX() - goalX);
            int absolute_Y_Distance = Math.abs(getY() - goalY);

            if (absolute_X_Distance > absolute_Y_Distance){
                if ((goalX - getX()) > 0){
                    return Direction.EAST;
                }
                else if ((goalX - getX()) < 0){
                    return Direction.WEST;
                }
            }
            else if (absolute_X_Distance < absolute_Y_Distance){
                if ((goalY - getY()) > 0){
                    return Direction.SOUTH;
                }
                else if ((goalY - getY()) < 0){
                    return Direction.NORTH;
                }
            }
            else{
                if ((goalX - getX()) > 0){
                    return Direction.EAST;
                }
                else if ((goalX - getX()) < 0){
                    return Direction.WEST;
                }
            }
        }
        return null;
    }

    @Override
    /** elephants always eat
     *
     * @param none
     * @return true
     */
        
    public boolean eat() {
        return true;
    }
    
    @Override
    /** When an Elephant mates, increment its level by 2.
     *
     * @param none
     * @return nothing
     */
        
	public void mate() {
	    incrementLevel(levelUp);
    }
    
    @Override
   /** increase the variable foodEaten by 7 for every elephant.    
    *
    * @param s the status of elephants
    * @return nothing
    */

    public void buffBehavior(CritterState s){
        s.foodEaten = s.foodEaten + increment;
    }

    @Override
   /** change the count of foodEaten back.    
    * 
    * @param s the status of elephants
    * @return nothing
    */

    public void debuff(CritterState s){
        s.foodEaten = s.foodEaten - increment;
    }

}
