package com.example.tower;

import android.widget.ScrollView;

/**
 * Gives the player all the functions that can interact with the map.
 */
public class Player extends Map {
    /**
     * Character name
     */
    private static String name = "Geoff";

    /**
     * Player's position.
     */
    private static int[] location = new int[3];
    /**
     * Item player is holding.
     */
    private static String item ="";


    /**
     * Public constructor:
     * Sets the board and places your charactor at the starting position.
     *
     * @param setName sets the name of the player
     */
    public Player (String setName) {
        super(5);
        if (!setName.equals("")) {
            name = setName;
        }
        location[0] = 1;
        location[1] = 1;
        location[2] = 1;
    }

    /**
     * Check if a change in x will cause a failure in the boolean map
     *
     * @param newX Integer to be tested if the player can move that X location
     * @return a boolean if the person can or cannot; it also sets that newX as the x location
     */
    private static boolean setX(int newX) {
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
    private static boolean setY(int newY) {
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
    public static void up() {
        int newY = location[1] + 1;
        if (setY(newY)) {
            Tower.scrollview(" ");
            Tower.scrollview(name + " has moved up by 1");
            Tower.scrollview(name + " now sees:");
            Tower.scrollview(type(location[0] - 1, location[1] + 1) + "| " + type(location[0], location[1] + 1) + "| " + type(location[0] + 1, location[1] + 1) + ".");
            Tower.scrollview(" ");
        } else {
            Tower.scrollview(" ");
            Tower.scrollview(name + " has not moved");
            Tower.scrollview(" ");
        }
    }
    public static void down() {
        int newY = location[1] - 1;
        if (setY(newY)) {
            Tower.scrollview(" ");
            Tower.scrollview(name + " has moved down by 1");
            Tower.scrollview(name + " now sees:");
            Tower.scrollview(type(location[0] - 1, location[1] - 1) + "| " + type(location[0], location[1] - 1) + "| " + type(location[0] + 1, location[1] - 1) + ".");
            Tower.scrollview(" ");
        } else {
            Tower.scrollview(" ");
            Tower.scrollview(name + " has not moved");
            Tower.scrollview(" ");
        }
    }
    public static void right() {
        int newX = location[0] + 1;
        if (setY(newX)) {
            Tower.scrollview(" ");
            Tower.scrollview(name + " has moved right by 1");
            Tower.scrollview(name + " now sees:");
            Tower.scrollview(type(location[0] + 1, location[1] + 1) + "| " + type(location[0] + 1, location[1]) + "| " + type(location[0] + 1, location[1] - 1) + ".");
            Tower.scrollview(" ");
        } else {
            Tower.scrollview(" ");
            Tower.scrollview(name + " has not moved");
            Tower.scrollview(" ");
        }
    }
    public static void left() {
        int newX = location[0] - 1;
        if (setY(newX)) {
            Tower.scrollview(" ");
            Tower.scrollview(name + " has moved left by 1");
            Tower.scrollview(name + " now sees:");
            Tower.scrollview(type(location[0] - 1, location[1] + 1) + "| " + type(location[0] - 1, location[1]) + "| " + type(location[0] - 1, location[1] - 1) + ".");
            Tower.scrollview(" ");
        } else {
            Tower.scrollview(" ");
            Tower.scrollview(name + " has not moved");
            Tower.scrollview(" ");
        }
    }

    public static void action() {
        Tower.scrollview("action");
    }
}
