package com.example.tower;

/**
 * Creates the map that a player can interact with.
 */
public class Map {
    //The type of floor the player encounters.
    private static String[][][] tileType;
    //A map of where the person has been.
    private static String[][][] map;
    //Were the player can move.
    private static boolean[][][] booleanBoard;
    //size of the board
    private int size;
    //current floor.
    private static int floor = 0;

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
        tileType = new String[3][size][size];
        booleanBoard = new boolean[3][size][size];
        map = new String[3][size][size];
        floor0();
        floor1();
        floorwin();
    }
    private void floor0() {
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                tileType[0][x][y] = "rock";
                booleanBoard[0][x][y] = false;
            }
        }
        for (int x = 3; x < 7 ; x++) {
            for (int y = 1; y < 6; y ++) {
                tileType[0][x][y] = "path";
                booleanBoard[0][x][y] = true;
            }
        }
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                map[0][x][y] = "-";
            }
        }
        tileType[0][3][6] = "tower";
        tileType[0][4][6] = "tower";
        tileType[0][5][6] = "tower";
        tileType[0][6][6] = "tower";
        for (int y = 1; y < 5; y++) {
            tileType[0][3][y] = "grass";
            tileType[0][3][y] = "grass";
        }
        tileType[0][3][5] = "switch";
        tileType[0][6][5] = "switch";
        booleanBoard[0][3][5] = false;
        booleanBoard[0][6][5] = false;
        tileType[0][4][5] = "door";
        tileType[0][5][5] = "door";
        booleanBoard[0][4][5] = false;
        booleanBoard[0][5][5] = false;
        map[0][3][1] = "G";
        map[0][3][2] = "G";
        map[0][4][1] = "P";
        map[0][4][2] = "P";
        map[0][6][1] = "G";
        map[0][6][2] = "G";
        map[0][5][1] = "P";
        map[0][5][2] = "P";
    }

    public void floor1() {
        for (int x = 0; x < tileType[1].length; x++) {
            for (int y = 0; y < tileType[1].length; y++) {
                tileType[1][x][y] = "walls";
                booleanBoard[1][x][y] = false;
            }
        }
        for (int x = 1; x < tileType[1].length - 1; x++) {
            for (int y = 1; y < tileType[1].length - 1; y++) {
                tileType[1][x][y] = "floor";
                booleanBoard[1][x][y] = true;
            }
        }
        for (int x = 0; x < tileType[1].length; x++) {
            for (int y = 0; y < tileType[1].length; y++) {
                map[1][x][y] = "-";
            }
        }
        tileType[1][4][0] = "door";
        map[1][4][0] = "D";
        tileType[1][5][0] = "door";
        map[1][5][0] = "D";
        map[1][3][0] = "W";
        map[1][6][0] = "W";
        for (int x = 3; x < 7; x++) {
            for (int y = 1; y < 3; y++) {
                map[1][x][y] = "F";
            }
        }
        for (int x = 1; x < 9; x++) {
            tileType[1][x][8] = "wall";
            booleanBoard [1][x][8] = false;
        }
        tileType[1][1][7] = "wall";
        booleanBoard[1][1][7] = false;
        tileType[1][2][7] = "wall";
        booleanBoard[1][2][7] = false;
        tileType[1][3][7] = "Water Bucket";
        booleanBoard[1][3][7] = false;
        tileType[1][5][7] = "wall";
        booleanBoard[1][5][7] = false;
        tileType[1][3][6] = "wall";
        booleanBoard[1][3][6] = false;
        tileType[1][7][6] = "wall";
        booleanBoard[1][7][6] = false;
        for (int x = 3; x < 8; x++) {
            for (int y = 4; y < 6; y++) {
                if (x == 5 && y == 4) {
                    tileType[1][5][4] = "locked door";
                    booleanBoard[1][5][4] = false;
                } else {
                    tileType[1][x][y] = "wall";
                    booleanBoard[1][x][y] = false;
                }
            }
        }
        tileType[1][2][6] = "key";
        booleanBoard[1][2][6] = false;
        tileType[1][2][4] = "box";
        booleanBoard[1][2][4] = false;
        tileType[1][2][5] = "box";
        booleanBoard[1][2][5] = false;
        tileType[1][1][3] = "fire";
        booleanBoard[1][1][3] = false;
        tileType[1][1][2] = "wall";
        booleanBoard[1][1][2] = false;
        tileType[1][1][1] = "wall";
        booleanBoard[1][1][1] = false;
        tileType[1][2][1] = "wall";
        booleanBoard[1][2][1] = false;
        tileType[1][7][1] = "wall";
        booleanBoard[1][7][1] = false;
        tileType[1][8][1] = "wall";
        booleanBoard[1][8][1] = false;
        tileType[1][8][2] = "wall";
        booleanBoard[1][8][2] = false;
    }

    public static void floorwin() {
        for (int x = 0; x < tileType[1].length; x++) {
            for (int y = 0; y < tileType[1].length; y++) {
                tileType[2][x][y] = "wall";
                booleanBoard[2][x][y] = false;
                map[2][x][y] = "-";
            }
        }
        for (int x = 3; x < 7; x++) {
            for (int y = 0; y < 6; y++) {
                map[2][x][y] = "w";
            }
        }
        for (int x = 4; x < 7; x++) {
            for (int y = 1; y < 3; y++) {
                booleanBoard[2][x][y] = true;
                tileType[2][x][y] = "floor";
                map[2][x][y] = "f";
            }
        }
        for (int x = 4; x < 7; x++) {
            for (int y = 3; y < 5; y++) {
                tileType[2][x][y] = "treasure";
                map[2][x][y] = "t";
            }
        }
        tileType[2][5][3] = "big treasure";
        map[2][5][3] = "X";

    }

    /**
     * returns if a player can move to this position.
     * @param x x of new position
     * @param y y of new position
     * @return the boolean of the player's ability to move there.
     */
    public static boolean check(int x, int y) {
        return booleanBoard[floor][x][y];
    }

    /**
     * gets the type of tyle from the tile board.
     * @param x x position
     * @param y y position
     * @return the type of tile
     */
    public static String type(int x, int y) {
        if (floor == 0) {
            upDateMap0(x, y);
        } else if (floor == 1) {
            upDateMap1(x, y);
        }
        return (tileType[floor][x][y]);
    }

    public static void upDateMap0(int x, int y) {
        if (tileType[floor][x][y].equals("path")) {
            map[floor][x][y] = "P";
        } else if (tileType[floor][x][y].equals("grass")) {
            map[floor][x][y] = "G";
        } else if (tileType[floor][x][y].equals("rock")) {
            map[floor][x][y] = "R";
        } else if (tileType[floor][x][y].equals("door")) {
            map[floor][x][y] = "D";
        } else if (tileType[floor][x][y].equals("switch")) {
            map[floor][x][y] = "S";
        }
    }

    public static void upDateMap1(int x, int y) {
        if (tileType[floor][x][y].equals("wall")) {
            map[floor][x][y] = "W";
        } else if (tileType[floor][x][y].equals("fire")) {
            map[floor][x][y] = "X";
        } else if (tileType[floor][x][y].equals("box")) {
            map[floor][x][y] = "B";
        } else if (tileType[floor][x][y].equals("key")) {
            map[floor][x][y] = "K";
        } else if (tileType[floor][x][y].equals("Water Bucket")) {
            map[floor][x][y] = "X";
        } else if (tileType[floor][x][y].equals("locked door")) {
            map[floor][x][y] = "L";
        } else if (tileType[floor][x][y].equals("floor")) {
            map[floor][x][y] = "F";
        }
    }

    static boolean switch1 = false;
    static boolean switch2 = false;
    static int switchCount = 0;
    public static void outsideSwitches() {
        if (switchCount == 0) {
            switch1 = true;
            switchCount++;
            Tower.scrollview("You see an old switch and decide to switch it.");
        } else {
            switch2 = true;
            Tower.scrollview("You have found another old switch and you switch it.");
        }
    }

    public static void towerDoor() {
        if (switch1 && switch2) {
            Tower.scrollview("The old majestic doors swing open with an ancient rumbling, and you walk into the tower.");
            floor++;
            Player.location[0] = 1;
            Player.location[1] = 4;
            Player.location[2] = 1;
            printCharMap();
        } else {
            Tower.scrollview("These doors seem pretty old, I wonder if there is a way to open them.");
        }
    }

    public static void key() {
        booleanBoard[1][2][6] = true;
        tileType[1][2][6] = "floor";
        map[1][2][6] = "F";
    }

    public static void fire() {
        booleanBoard[1][1][3] = true;
        tileType[1][1][3] = "floor";
        map[1][1][3] = "F";
    }

    public static void water() {
        booleanBoard[1][3][7] = true;
        tileType[1][3][7] = "floor";
        map[1][3][7] = "F";
    }

    public static void lockedDoor() {
        floor++;
        Player.location[0] = 2;
        Tower.scrollview("You unlock the door and proceed to the next floor.");
        Tower.scrollview("You have entered the treasure room.");
        Player.action();

    }

    public static void printCharMap() {
        String toPrint = "";
        for (int x = 0; x < map[1].length; x++) {
            for (int y = map[1].length - 1; y >= 1; y--) {
                toPrint += map[floor][y][x];
                if (y == 1) {
                    toPrint += " ";
                }
            }
        }
        Tower.mapView(toPrint);
    }
}
