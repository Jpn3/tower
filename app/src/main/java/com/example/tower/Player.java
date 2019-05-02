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
    public static int[] location = new int[3];
    /**
     * Item player is holding.
     */
    private static String item = "";
    /**
     * Check for win condition;
     */
    private static boolean win = false;

    /**
     * Public constructor:
     * Sets the board and places your charactor at the starting position.
     *
     * @param newName sets the name of the player
     */
    public Player(String newName) {
        super(10);
        if (!newName.equals("")) {
            String[] names = newName.split(" ");
            name = "";
            for (int i = 0; i < names.length; i++) {
                names[i] = names[i].toUpperCase();
                name += names[i].charAt(0) + names[i].substring(1, names[i].length()).toLowerCase() + " ";
            }
            name = name.trim();
        }
        location[0] = 0;
        location[1] = 4;
        location[2] = 1;
    }

    /**
     * Check if a change in x will cause a failure in the boolean map
     *
     * @param newX Integer to be tested if the player can move that X location
     * @return a boolean if the person can or cannot; it also sets that newX as the x location
     */
    private static boolean setX(int newX) {
        if (check(newX, location[2])) {
            location[1] = newX;
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
        if (check(location[1], newY)) {
            location[2] = newY;
            return (true);
        } else {
            return (false);
        }
    }

    /**
     * Moves character up by 1
     * Prints if the player moves or not and if they move the 3 spaces in front of them are printed; if the player has won
     */
    public static void up() {
        int newY = location[2] + 1;
        if (setY(newY)) {
            Tower.scrollview(" ");
            Tower.scrollview(name + " has moved up by 1");
            Tower.scrollview(name + " now sees:");
            Tower.scrollview(type(location[1] + 1, location[2] + 1) + "| " + type(location[1], location[2] + 1) + "| " + type(location[1] - 1, location[2] + 1) + ".");
            Tower.scrollview(" ");
        } else {
            Tower.scrollview(" ");
            Tower.scrollview(name + " has not moved");
            Tower.scrollview(" ");
        }
    }

    public static void down() {
        int newY = location[2] - 1;
        if (setY(newY)) {
            Tower.scrollview(" ");
            Tower.scrollview(name + " has moved down by 1");
            Tower.scrollview(name + " now sees:");
            Tower.scrollview(type(location[1] + 1, location[2] - 1) + "| " + type(location[1], location[2] - 1) + "| " + type(location[1] - 1, location[2] - 1) + ".");
            Tower.scrollview(" ");
        } else {
            Tower.scrollview(" ");
            Tower.scrollview(name + " has not moved");
            Tower.scrollview(" ");
        }
    }

    public static void left() {
        int newX = location[1] + 1;
        if (setX(newX)) {
            Tower.scrollview(" ");
            Tower.scrollview(name + " has moved left by 1");
            Tower.scrollview(name + " now sees:");
            Tower.scrollview(type(location[1] + 1, location[2] + 1) + "| " + type(location[1] + 1, location[2]) + "| " + type(location[1] + 1, location[2] - 1) + ".");
            Tower.scrollview(" ");
        } else {
            Tower.scrollview(" ");
            Tower.scrollview(name + " has not moved");
            Tower.scrollview(" ");
        }
    }

    public static void right() {
        int newX = location[1] - 1;
        if (setX(newX)) {
            Tower.scrollview(" ");
            Tower.scrollview(name + " has moved right by 1");
            Tower.scrollview(name + " now sees:");
            Tower.scrollview(type(location[1] - 1, location[2] + 1) + "| " + type(location[1] - 1, location[2]) + "| " + type(location[1] - 1, location[2] - 1) + ".");
            Tower.scrollview(" ");
        } else {
            Tower.scrollview(" ");
            Tower.scrollview(name + " has not moved");
            Tower.scrollview(" ");
        }
    }

    public static void action() {
        if (location[0] == 0) {
            action0();
        } else if (location[0] == 1) {
            actionKey();
        } else if (location[0] == 2) {
            actionBucket();
        } else if (location[0] == 3) {
            Tower.scrollview("Congrats!!!");
            Tower.scrollview("You Win!!");
            Tower.scrollview(" ");
            win = true;
        }
        if (!win) {
            if (location[0] == 0) {
                Tower.scrollview(name + " is outside the Tower:");
                Tower.scrollview("Your location is " + location[1] + " " + location[2] + ".");
                Tower.scrollview(" ");
            } else {
                Tower.scrollview(name + " is on floor " + location[0] + ":");
                Tower.scrollview("Your location is " + location[1] + " " + location[2] + ".");
                Tower.scrollview(" ");
            }
        }
    }

    public static boolean switch1 = true;
    public static boolean switch2 = true;

    public static void action0() {
        if (location[2] == 4) {
            if (location[1] == 6) {
                if (switch1) {
                    outsideSwitches();
                    switch1 = false;
                } else {
                    Tower.scrollview("There is nothing to do here.");
                    Tower.scrollview(" ");
                }
            } else if (location[1] == 3) {
                if (switch2) {
                    outsideSwitches();
                    switch2 = false;
                } else {
                    Tower.scrollview("There is nothing to do here.");
                    Tower.scrollview(" ");
                }
            } else {
                if (!switch1 && !switch2) {
                    towerDoor();
                } else {
                    Tower.scrollview("There is nothing to do here.");
                    Tower.scrollview(" ");
                }
            }
        } else {
            Tower.scrollview("There is nothing to do here.");
            Tower.scrollview(" ");
        }
    }

    public static boolean keyKey = true;

    public static void actionKey() {
        if (location[2] == 6) {
            if (location[1] == 5) {
                if (keyKey) {
                    item = "keyKey";
                    Tower.scrollview("You pick up the key.");
                    Tower.scrollview(" ");
                    keyKey = false;
                    keyKey();
                } else {
                    Tower.scrollview("There is nothing to be done.");
                    Tower.scrollview(" ");
                }
            } else if (location[1] == 2 && item.equals("keyKey")) {
                keyToBucket();
            }
        } else {
            Tower.scrollview("There is nothing to be done.");
            Tower.scrollview(" ");
        }
    }

    public static boolean fire = true;
    public static boolean keyBucket = true;
    public static boolean water = true;

    public static void actionBucket() {
        if (location[2] == 3) {
            if (location[1] == 2 && item.equals("water")) {
                if (fire) {
                    Tower.scrollview("You dump you bucket of water on the floor, and the fire goes out.");
                    Tower.scrollview(" ");
                    fire();
                    fire = false;
                } else {
                    Tower.scrollview("There is nothing to be done.");
                    Tower.scrollview(" ");
                }
            } else if (location[1] == 5 && item.equals("key")) {
                lockedDoor();
            } else {
                Tower.scrollview("There is nothing to be done.");
                Tower.scrollview(" ");
            }
        } else if (location[2] == 6) {
            if (location[1] == 1) {
                if (keyBucket) {
                    item = "key";
                    Tower.scrollview("You pick up the key.");
                    Tower.scrollview(" ");
                    key();
                    keyBucket = false;
                } else {
                    Tower.scrollview("There is nothing to be done.");
                    Tower.scrollview(" ");
                }
            }
        } else if (location[2] == 7) {
            if (location[1] == 4) {
                if (water) {
                    item = "water";
                    Tower.scrollview("You pick up the bucket.");
                    Tower.scrollview(" ");
                    water();
                    water = false;
                } else {
                    Tower.scrollview("There is nothing to be done.");
                    Tower.scrollview(" ");
                }
            }
        } else {
            Tower.scrollview("There is nothing to be done.");
            Tower.scrollview(" ");
        }
    }
}
