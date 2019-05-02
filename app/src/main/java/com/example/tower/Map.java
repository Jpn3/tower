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
        tileType = new String[4][size][size];
        booleanBoard = new boolean[4][size][size];
        map = new String[4][size][size];
        floor0(0);
        floorKey(1);
        //floorMasterSword(2);
        //floorHolyGarlic(3);
        //floorCatGun(4);
        floorBucket(2);
        floorwin(3);
    }
    private void floor0(int floorLevel) {
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                tileType[floorLevel][x][y] = "rock";
                booleanBoard[floorLevel][x][y] = false;
            }
        }
        for (int x = 3; x < 7 ; x++) {
            for (int y = 1; y < 6; y ++) {
                tileType[floorLevel][x][y] = "path";
                booleanBoard[floorLevel][x][y] = true;
            }
        }
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                map[floorLevel][x][y] = "--";
            }
        }
        tileType[floorLevel][3][6] = "tower";
        tileType[floorLevel][4][6] = "tower";
        tileType[floorLevel][5][6] = "tower";
        tileType[floorLevel][6][6] = "tower";
        for (int y = 1; y < 5; y++) {
            tileType[floorLevel][3][y] = "grass";
            tileType[floorLevel][3][y] = "grass";
        }
        tileType[floorLevel][3][5] = "switch";
        tileType[floorLevel][6][5] = "switch";
        booleanBoard[floorLevel][3][5] = false;
        booleanBoard[floorLevel][6][5] = false;
        tileType[floorLevel][4][5] = "door";
        tileType[floorLevel][5][5] = "door";
        booleanBoard[floorLevel][4][5] = false;
        booleanBoard[floorLevel][5][5] = false;
        map[floorLevel][3][1] = "G";
        map[floorLevel][3][2] = "G";
        map[floorLevel][4][1] = "P";
        map[floorLevel][4][2] = "P";
        map[floorLevel][6][1] = "G";
        map[floorLevel][6][2] = "G";
        map[floorLevel][5][1] = "P";
        map[floorLevel][5][2] = "P";
    }

    public void floorKey(int floorLevel) {
        for (int x = 0; x < tileType[1].length; x++) {
            for (int y = 0; y < tileType[1].length; y++) {
                tileType[floorLevel][x][y] = "walls";
                booleanBoard[floorLevel][x][y] = false;
            }
        }
        for (int x = 0; x < tileType[1].length; x++) {
            for (int y = 0; y < tileType[1].length; y++) {
                map[floorLevel][x][y] = "--";
            }
        }
        tileType[floorLevel][2][1] ="floor";
        booleanBoard[floorLevel][2][1] =true;
        tileType[floorLevel][2][2] ="floor";
        booleanBoard[floorLevel][2][2] =true;
        tileType[floorLevel][2][3] ="floor";
        booleanBoard[floorLevel][2][3] =true;
        tileType[floorLevel][2][6] ="floor";
        booleanBoard[floorLevel][2][6] =true;
        tileType[floorLevel][3][3] ="floor";
        booleanBoard[floorLevel][3][3] =true;
        tileType[floorLevel][3][4] ="floor";
        booleanBoard[floorLevel][3][4] =true;
        tileType[floorLevel][3][5] ="floor";
        booleanBoard[floorLevel][3][5] =true;
        tileType[floorLevel][3][6] ="floor";
        booleanBoard[floorLevel][3][6] =true;
        tileType[floorLevel][4][1] ="floor";
        booleanBoard[floorLevel][4][1] =true;
        tileType[floorLevel][4][2] ="floor";
        booleanBoard[floorLevel][4][2] =true;
        tileType[floorLevel][4][3] ="floor";
        booleanBoard[floorLevel][4][3] =true;
        tileType[floorLevel][4][6] ="floor";
        booleanBoard[floorLevel][4][6] =true;
        tileType[floorLevel][5][1] ="floor";
        booleanBoard[floorLevel][5][1] =true;
        tileType[floorLevel][5][2] ="floor";
        booleanBoard[floorLevel][5][2] =true;
        tileType[floorLevel][5][3] ="floor";
        booleanBoard[floorLevel][5][3] =true;
        tileType[floorLevel][5][6] ="floor";
        booleanBoard[floorLevel][5][6] =true;
        tileType[floorLevel][6][6] = "key";
        booleanBoard[floorLevel][6][6] = false;
        tileType[floorLevel][2][7] = "locked door";
        booleanBoard[floorLevel][2][7] = false;

        map[floorLevel][4][1] = "F";
        map[floorLevel][4][2] = "F";
        map[floorLevel][5][1] = "F";
        map[floorLevel][5][2] = "F";
        map[floorLevel][3][0] = "W";
        map[floorLevel][3][1] = "W";
        map[floorLevel][3][2] = "W";
        map[floorLevel][4][0] = "W";
        map[floorLevel][5][0] = "W";
        map[floorLevel][6][0] = "W";
        map[floorLevel][6][1] = "W";
        map[floorLevel][6][2] = "W";

    }


    public void floorBucket(int floorLevel) {
        for (int x = 0; x < tileType[1].length; x++) {
            for (int y = 0; y < tileType[1].length; y++) {
                tileType[floorLevel][x][y] = "walls";
                booleanBoard[floorLevel][x][y] = false;
            }
        }
        for (int x = 1; x < tileType[1].length - 1; x++) {
            for (int y = 1; y < tileType[1].length - 1; y++) {
                tileType[floorLevel][x][y] = "floor";
                booleanBoard[floorLevel][x][y] = true;
            }
        }
        for (int x = 0; x < tileType[1].length; x++) {
            for (int y = 0; y < tileType[1].length; y++) {
                map[floorLevel][x][y] = "--";
            }
        }
        tileType[floorLevel][4][0] = "door";
        map[floorLevel][4][0] = "D";
        tileType[floorLevel][5][0] = "door";
        map[floorLevel][5][0] = "D";
        map[floorLevel][3][0] = "W";
        map[floorLevel][6][0] = "W";
        for (int x = 3; x < 7; x++) {
            for (int y = 1; y < 3; y++) {
                map[floorLevel][x][y] = "F";
            }
        }
        for (int x = 1; x < 9; x++) {
            tileType[floorLevel][x][8] = "wall";
            booleanBoard [floorLevel][x][8] = false;
        }
        tileType[floorLevel][1][7] = "wall";
        booleanBoard[floorLevel][1][7] = false;
        tileType[floorLevel][2][7] = "wall";
        booleanBoard[floorLevel][2][7] = false;
        tileType[floorLevel][3][7] = "Water Bucket";
        booleanBoard[floorLevel][3][7] = false;
        tileType[floorLevel][5][7] = "wall";
        booleanBoard[floorLevel][5][7] = false;
        tileType[floorLevel][3][6] = "wall";
        booleanBoard[floorLevel][3][6] = false;
        tileType[floorLevel][7][6] = "wall";
        booleanBoard[floorLevel][7][6] = false;
        for (int x = 3; x < 8; x++) {
            for (int y = 4; y < 6; y++) {
                if (x == 5 && y == 4) {
                    tileType[floorLevel][5][4] = "locked door";
                    booleanBoard[floorLevel][5][4] = false;
                } else {
                    tileType[floorLevel][x][y] = "wall";
                    booleanBoard[floorLevel][x][y] = false;
                }
            }
        }
        tileType[floorLevel][2][6] = "key";
        booleanBoard[floorLevel][2][6] = false;
        tileType[floorLevel][2][4] = "box";
        booleanBoard[floorLevel][2][4] = false;
        tileType[floorLevel][2][5] = "box";
        booleanBoard[floorLevel][2][5] = false;
        tileType[floorLevel][1][3] = "fire";
        booleanBoard[floorLevel][1][3] = false;
        tileType[floorLevel][1][2] = "wall";
        booleanBoard[floorLevel][1][2] = false;
        tileType[floorLevel][1][1] = "wall";
        booleanBoard[floorLevel][1][1] = false;
        tileType[floorLevel][2][1] = "wall";
        booleanBoard[floorLevel][2][1] = false;
        tileType[floorLevel][7][1] = "wall";
        booleanBoard[floorLevel][7][1] = false;
        tileType[floorLevel][8][1] = "wall";
        booleanBoard[floorLevel][8][1] = false;
        tileType[floorLevel][8][2] = "wall";
        booleanBoard[floorLevel][8][2] = false;

    }

    public static void floorwin(int floorLevel) {
        for (int x = 0; x < tileType[1].length; x++) {
            for (int y = 0; y < tileType[1].length; y++) {
                tileType[floorLevel][x][y] = "wall";
                booleanBoard[floorLevel][x][y] = false;
                map[floorLevel][x][y] = "--";
            }
        }
        for (int x = 3; x < 7; x++) {
            for (int y = 0; y < 6; y++) {
                map[floorLevel][x][y] = "W";
            }
        }
        for (int x = 4; x < 7; x++) {
            for (int y = 1; y < 3; y++) {
                booleanBoard[floorLevel][x][y] = true;
                tileType[floorLevel][x][y] = "floor";
                map[floorLevel][x][y] = "F";
            }
        }
        for (int x = 4; x < 7; x++) {
            for (int y = 3; y < 5; y++) {
                tileType[floorLevel][x][y] = "treasure";
                map[floorLevel][x][y] = "t";
            }
        }
        tileType[floorLevel][5][3] = "big treasure";
        map[floorLevel][5][3] = "X";

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
            upDateMapBucket(x, y);
        } else if (floor == 2) {
            upDateMapBucket(x, y);
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

    public static void upDateMapBucket(int x, int y) {
        if (tileType[floor][x][y].equals("walls")) {
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
        } else if (tileType[floor][x][y].equals("Evil Roomba")) {
            map[floor][x][y] = "E";
        } else if (tileType[floor][x][y].equals("Vampire Roomba")) {
            map[floor][x][y] = "V";
        } else if (tileType[floor][x][y].equals("Master Sword")) {
            map[floor][x][y] = "T";
        } else if (tileType[floor][x][y].equals("Holy Garlic")) {
            map[floor][x][y] = "F";
        } else if (tileType[floor][x][y].equals("Altar")) {
            map[floor][x][y] = "A";
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
    public static void keyKey() {
        booleanBoard[1][6][6] = true;
        tileType[1][6][6] = "floor";
        map[1][6][6] = "F";
    }

    public static void keyToBucket() {
        Tower.scrollview("The locker door opens.");
        floor++;
        Player.location[0] = 2;
        Player.location[1] = 4;
        Player.location[2] = 1;
        printCharMap();
    }

    public static void key() {
        booleanBoard[2][2][6] = true;
        tileType[2][2][6] = "floor";
        map[2][2][6] = "F";
    }

    public static void fire() {
        booleanBoard[2][1][3] = true;
        tileType[2][1][3] = "floor";
        map[2][1][3] = "F";
    }

    public static void water() {
        booleanBoard[2][3][7] = true;
        tileType[2][3][7] = "floor";
        map[2][3][7] = "F";
    }

    public static void lockedDoor() {
        floor++;
        Player.location[0] = 3;
        Tower.scrollview("You unlock the door and proceed to the next floor.");
        Tower.scrollview("You have entered the treasure room.");
        Player.action();

    }

    public static void printCharMap() {
        String toPrint = "";
        for (int x = 0; x < map[1].length; x++) {
            for (int y = map[1].length - 1; y >= 1; y--) {
                if (y == map[1].length - 1) {
                    toPrint += "|";
                }
                toPrint += map[floor][y][x] + "|";
                if (y == 1) {
                    toPrint += " ";
                }
            }
        }
        Tower.mapView(toPrint);
    }
}
