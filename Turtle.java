/**
 * Author: Yue Sun
 * email: yus002@ucsd.edu
 * CSE8B Login : cs8bwadc
 * Date: 2/20/19
 * File: Turtle.java 
 * 
 * Sources of Help: PA4 writeup
 *    
 * This file is a solution to Implementation Details of PSA4
 * This file contains the Turtle class
 */

import java.util.Random;
import java.awt.*;

/**
 * Uses Turtle class to contain methods and variables inherited from
 * Critter class and Movable class and override some methods
 *
 * Instance variable: none
 */

public class Turtle extends Critter implements Movable{
   
    // for not using magic numbers
    private static final String turtle = "Tu";
    private static final String food = ".";
    private static final String space = " ";
    private static final int sampleSpace = 2;
    private static final int increment = 5;


    /** 
     * the string representation of of Turtle is "Tu"
     * 
     * @param none  
     * @return nothing
     */

    public Turtle(){
        super(turtle);
    }
    @Override
    /** Turtles are GREEN.
     *
     * @param none
     * @return the Colorful name of turtles
     */
        
    public Color getColor(){
        return Color.GREEN;
    }
    
    @Override
    /** 
     * Turtles always move WEST.
     * 
     * @param none
     * @return move WEST
     */

    public Direction getMove() {
        return Direction.WEST;
    }
    
    @Override
    /** Turtles like to play it safe when eating. 
     * They only eat when there are no hostile animals 
     * next to the Turtle (hostile animals are anything 
     * that is not an empty space, food, or Turtle).     
     * 
     * @param none
     * @return true there is no hostile animal nearby
     *  otherwise, return false
     */
        
    public boolean eat() {
        String north = getNeighbor(Direction.NORTH);
        String south = getNeighbor(Direction.SOUTH);
        String east = getNeighbor(Direction.EAST);
        String west = getNeighbor(Direction.WEST);
        
        // check whether north direction exists hostile animals
        // return true if it does
        boolean northThreat = (north != space) && (north != food)
            && (north != turtle);
        boolean southThreat = (south != space) && (south != food)
            && (south != turtle);
        boolean eastThreat = (east != space) && (east != food)
            && (east != turtle);
        boolean westThreat = (west != space) && (west != food)
            && (west != turtle);
        
        // if there exists a threat nearby
        // don't eat
        if (northThreat || southThreat || eastThreat || westThreat){
            return false;
        }
        else{
            return true;
        }

    }
    
    @Override
    /**  Turtles don't always fight, but sometimes they do. 
     * Turtles attack with ROAR 50% of the time and try to 
     * FORFEIT the other 50%. Slow and steady wins the race, after all.   
     *
     * @param opponent The different species met
     * @return an attack method
     */

    public Attack getAttack(String opponent){
        // Turtles attack with ROAR 50% of the time 
        // and try to FORFEIT the other 50%.
        if (random.nextInt(sampleSpace) == 0){
            return Attack.ROAR;
        }
        else{
            return Attack.FORFEIT;
        }
    }
    @Override
   /** increase the instance variable count by 5 during 
    * the call of Turtle's buff behavior.
    *
    * @param s the status of a turtle
    * @return nothing
    */
    public void buffBehavior(CritterState s){
        s.count = s.count + increment;
    }
    
    @Override
   /**  change the count of Turtles back.
    * 
    * @param s the status of a turtle
    * @return nothing
    */

    public void debuff(CritterState s){
        s.count = s.count - increment;

    }

}
