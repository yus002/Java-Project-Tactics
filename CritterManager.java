/**
 * class that supers CritterModel. So students only need to implement an extra
 * update method here instead of dealing with the thousand-line code
 * Cheng Shen
 */

/**
 * Author: Yue Sun
 * email: yus002@ucsd.edu
 * CSE8B Login : cs8bwadc
 * Date: 2/20/19
 * File: CirtterManager.java
 * 
 * Sources of Help: PA4 writeup
 *    
 * This file is a solution to Hack into the Game of PSA4
 * This file contains the CritterManager class
 */

import java.util.*;
import java.awt.Point;

public class CritterManager extends Observable{
	// Instance variables useful for fancy operations
	protected final List<Critter> critterList;//list holding your critters
	private final int buffTurn = 25; //25 moves until buff
	private final int teleportTurn = 15; // 15 moves until teleport 
	protected int moveCount;
	protected final Map<Critter, Point> locationMap;
	protected final Critter[][] grid;


	protected final SortedMap<String, CritterState> classStateMap;
	protected final Map<Critter, CritterState> critterStateMap;

	protected final boolean NEED_BUFF = true;

	public CritterManager(int width, int height){
		critterList = new ArrayList<Critter>();
		moveCount = 0;
		locationMap = new HashMap<Critter, Point>();
		grid = new Critter[width][height];


		// initialize various data structures
		classStateMap = new TreeMap<String, CritterState>();
		// important to use IdentityHashMap so they can't trick me by overriding hashCode
		critterStateMap = new IdentityHashMap<Critter, CritterState>();
	}

	//Student TODO
	public synchronized boolean addBuff(){
		moveCount ++;//Increment moveCount 

		if (NEED_BUFF == false) return false;

		boolean extraEffect = false;

		//TODO: fill in your solution code here
		/* HINTS:Look at critterList. It has the critters you to buff/debuff
		 * for. You also have instance variables for the amount of moves 
		 * you need to wait before buffing/debuffing/teleporting. You'll need
		 * use getState as a helper method. It returns the CritterState of 
		 * the given critter. 
		 * 
		*/
        

        if ((moveCount % buffTurn) != 0){
              for (int i = 0; i < critterList.size();i++){
                if (critterList.get(i) instanceof Critter){
                    critterList.get(i).debuff
                        (getState(critterList.get(i)));
                }
            }    
         
           return false;
        
        }
        else if ((moveCount % buffTurn) == 0){
            for (int i = 0; i < critterList.size();i++){
                if (critterList.get(i) instanceof Critter){
                    critterList.get(i).buffBehavior
                        (getState(critterList.get(i)));
                }
            }    
            return true;
        }
        return false;
	}

	// Helper method to get the state students need to pass in buffBehavior/debuff
	// Provided to students
	public CritterState getState (Critter c){
		// Return state from classState if it changes some data of the whole species
		if (c instanceof Turtle) return classStateMap.get("Turtle");
		if (c instanceof Ocelot) return classStateMap.get("Ocelot");
		if (c instanceof Elephant) return classStateMap.get("Elephant");
		if (c instanceof Starfish) return classStateMap.get("Starfish");

		// Return state from critterStateMap if the change only applies to one individual.
		if (c instanceof Feline) return critterStateMap.get(c);
		return null;
	}

	// Provided to student
	public Point getLocation (Critter c){
		return locationMap.get(c);
	}
}
