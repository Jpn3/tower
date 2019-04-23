package classes.tower.map.util;

/**
 * Creates the map that a player can interact with.
 */
public class Map {
    //The type of floor the player encounters.
    private String[][] tileType;
    //A map of where the person has been.
    private char[][] map;
    //Were the player can move.
    private boolean[][] booleanBoard;

    /**
     * Class' constructor, calls setMap function.
     */
    Map() {
        setMap(10);
    }

    /**
     * Creates the map for each towers' floor.
     * @param size dimensions of each floor.
     */
    private void setMap(int size) {

    }

    /**
     * returns if a player can move to this position.
     * @param x x of new position
     * @param y y of new position
     * @return the boolean of the player's ability to move there.
     */
    public boolean check(int x, int y) {
        return booleanBoard[x][y];
    }

    /**
     * gets the type of tyle from the tile board.
     * @param x x position
     * @param y y position
     * @return the type of tile
     */
    public String type(int x, int y) {
        return (tileType[x][y]);
    }
}
