package com.example.tower;

import android.widget.ScrollView;

/**
 * Gives the player all the functions that can interact with the map.
 */
public class Player extends Map {
    /**
     * Character name
     */
    private String name = "Geoff";

    /**
     * Player's position.
     */
    private int[] location = new int[3];
    /**
     * Item player is holding.
     */
    private String item ="";


    /**
     * Public constructor:
     * Sets the board and places your charactor at the starting position.
     *
     * @param setName sets the name of the player
     */
    public Player (String setName) {
        super(10);
        name = setName;
        location[0] = 0;
        location[1] = 1;
        location[2] = 1;
        java.lang.String intro = "Your goal is to complete all the challenges in this tower.";
        //scrollView(intro);
    }

    /**
     * Check if a change in x will cause a failure in the boolean map
     *
     * @param newX Integer to be tested if the player can move that X location
     * @return a boolean if the person can or cannot; it also sets that newX as the x location
     */
    private boolean setX(int newX) {
        if (check(newX, location[1])) {
            location[0] = newX;
            return (true);
        } else {
            return (false);
        }
    }

    /**
     * Check if a change in y will cause a failure in the boolean map
     *
     * @param newY Integer to be tested if the player can move that Y location
     * @return a boolean if the person can or cannot; it also sets that newX as the xYlocation
     */
    private boolean setY(int newY) {
        if (check(location[0], newY)) {
            location[1] = newY;
            return (true);
        } else {
            return (false);
        }
    }

    /**
     *Moves character up by 1
     *Prints if the player moves or not and if they move the 3 spaces in front of them are printed; if the player has won
     */
    public void up() {
        int newY = location[1] + 1;
        if (setY(newY)) {
            System.out.println(" ");
            System.out.println(name + " has moved north by 1");
            System.out.println(name + " now sees:");
            System.out.print(type(location[0] - 1, location[1] + 1));
            System.out.print("| " + type(location[0], location[1] + 1) + "| ");
            System.out.print(type(location[0] + 1, location[1] + 1) + ".");
            System.out.println(" ");
        } else {
            System.out.println(" ");
            System.out.println(name + " has not moved");
            System.out.println(" ");
        }
    }
}
