package com.example.tower;

/**
 * Creates the map that a player can interact with.
 */
public class Map {
    //The type of floor the player encounters.
    private static String[][] tileType;
    //A map of where the person has been.
    private static char[][] map;
    //Were the player can move.
    private static boolean[][] booleanBoard;
    //size of the board
    private int size;

    /**
     * Class' constructor, calls setMap function.
     */
    Map(int setSize) {
        size = setSize;
        setMap(size);
    }

    /**
     * Creates the map for each towers' floor.
     * @param size dimensions of each floor.
     */
    private void setMap(int size) {
        tileType = new String[size][size];
        booleanBoard = new boolean[size][size];
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                tileType[x][y] = "ground";
                booleanBoard[x][y] = false;
            }
        }
        for (int x = 1; x < size -1 ; x++) {
            for (int y = 1; y < size - 1; y ++) {
                booleanBoard[x][y] = true;
            }
        }

    }

    /**
     * returns if a player can move to this position.
     * @param x x of new position
     * @param y y of new position
     * @return the boolean of the player's ability to move there.
     */
    public static boolean check(int x, int y) {
        return booleanBoard[x][y];
    }

    /**
     * gets the type of tyle from the tile board.
     * @param x x position
     * @param y y position
     * @return the type of tile
     */
    public static String type(int x, int y) {
        return (tileType[x][y]);
    }
}
