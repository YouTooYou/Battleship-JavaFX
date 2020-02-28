package be.kdg.model;

public class Ocean {

    //beste collectie voor alle vakjes
    private Field[][] ocean;
    private Player owner;
    private final static int MAX_SHIPS = 10;
    private int amountShips;

    public Ocean(int length, int height) {
        ocean = new Field[length][height];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < height; j++) {
                ocean[i][j] = new Field();
            }
        }
    }

    public void removeAmountShips() {       //todo  remove becqus test tsest test testtestte stestestsetestestest
        amountShips=0;
    }

    public void setActualShipVertical(int x, int y) {       //TODO kijk of dees nog anders gedaan kan worden
        ocean[x][y].setShipName("ship" + amountShips);
    }

    public void setActualShipHorizontal(int x, int y) {
            ocean[x][y].setShipName("ship" + amountShips);
    }

//    public void TESTgetEntireShips() {
//        for (String[] iets : ocean) {
//            for (String string : iets) {
//                System.out.print(string + " ");
//            }
//            System.out.println();
//        }
//    }


    public Player getOwner() {
        return owner;
    }

    public Field[][] getOcean() {
        return ocean;
    }

    public void getEntireField() {

        for (int i = 0; i < ocean.length; i++) {
            for (int j = 0; j < ocean[i].length; j++) {
//                System.out.printf("Row: %d Element: %d Value: %b\n", i, j, ocean[i][j].containsShip());
                System.out.printf("%6s", ocean[i][j].containsShip() + " ");
            }
            System.out.println();
        }

//        for (Field[] row : ocean) {
//            System.out.print("row: ");
//            for (Field cell : row) {
//                System.out.print(cell.containsShip());
//            }
//            System.out.println();
//        }
    }

    public boolean[][] getEntireFieldBoolean() {
        boolean[][] lijst = new boolean[ocean.length][ocean[0].length];
        for (int i = 0; i < ocean.length; i++) {
            for (int j = 0; j < ocean[i].length; j++) {
                lijst[i][j] = ocean[i][j].containsShip();
            }
        }
        return lijst;
    }

    public boolean[][] getEntireFieldPlacement() {
        boolean[][] lijst = new boolean[ocean.length][ocean[0].length];
        for (int i = 0; i < ocean.length; i++) {
            for (int j = 0; j < ocean[i].length; j++) {
                lijst[i][j] = ocean[i][j].isPlacement();
            }
        }
        return lijst;
    }

    public void addPlayer(Player player) {
        this.owner = player;
    }

    public Field getField(int length, int height) {
        return ocean[length][height];
    }

    private boolean getContainsship(int x, int y, int length) {
        for (int i = x; i > x - length; i--) {
            for (int j = y; j < 10; j++) {
                if (ocean[i][j].containsShip()) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isPlace(int x, int y, char direction, int length) { //todo pas dees aan naar de big todo
        boolean isPossible = true;
        int chance = 0;

        switch (direction) {
            case 'N':
                for (int i = x; i < x + length; i++) {
                    if (ocean[i][y].containsShip()) {
                        return false;
                    }
                }
                break;
            case 'W':
                for (int i = y; i < ocean[x].length; i++) {
                    chance++;
                    if (chance <= length) {
                        if (ocean[x][i].containsShip()) {
                            return false;
                        }
                    } else {
                        return isPossible;
                    }
                }
                break;
        }
        return isPossible;
    }

    public boolean addShipEnum(Ship ship, char direction, int x, int y) {  //todo pas dees aan naar big todo
        boolean isPossible = true;
        int length = ship.getLength();

        if (amountShips >= MAX_SHIPS) {
            System.out.println("You can't have more ships on your field.");
            return false;
        }

        if (!(length <= 5 && length >= 2)) {
            return false;
        }

//        if (x >= ocean.length && y >= ocean[x].length) {
//            System.out.println("Give a valid field");
//            return false;
//        }

        switch (direction) {
            case 'N':
                if (x + length <= ocean.length && x >= 0 && isPlace(x, y, direction, length) && checkSurrounding(ship, direction, x, y)) {
                    for (int i = 0; i < length; i++) {
                        setActualShipVertical(x, y);
                        ocean[x][y].setEnumShip(ship);
                        ocean[x][y].setShip();
                        x++;
                    }
                } else {
                    isPossible = false;
                }
                break;
            case 'W':
                if (length + y <= ocean[x].length && y >= 0 && isPlace(x, y, direction, length) && checkSurrounding(ship, direction, x, y)) {
                    for (int i = 0; i < length; i++) {
                        setActualShipHorizontal(x, y);
                        ocean[x][y].setEnumShip(ship);
                        ocean[x][y].setShip();
                        y++;
                    }
                } else {
                    isPossible = false;
                }
                break;
            default:
                System.out.println("Give a valid cardinal direction.");
                isPossible = false;
                break;
        }

        if (isPossible) {
            amountShips += 1;
        }
        return isPossible;
    }

    public void removeAllTestContainShip() {
        for (Field[] row : ocean) {
            for (Field cell : row) {
                cell.setTestContainsShip(false);
            }
        }
    }

    public void removeAllOutline() {
        for (Field[] row : ocean) {
            for (Field cell : row) {
                cell.setPlacement(false);
            }
        }
    }



    public boolean addOutlineShipEnum(Ship ship, char direction, int x, int y, boolean placement) {  //todo pas dees aan naar big todo
        boolean isPossible = true;
        int length = ship.getLength();

        removeAllOutline();

        if (amountShips >= MAX_SHIPS) {
            System.out.println("You can't have more ships on your field.");
            return false;
        }

        if (!(length <= 5 && length >= 2)) {
            return false;
        }

        switch (direction) {
            case 'N':
                if (x + length <= ocean.length && x >= 0 && isPlace(x, y, direction, length) && checkSurrounding(ship, direction, x, y)) {
                    for (int i = 0; i < length; i++) {
                        ocean[x][y].setPlacement(placement);
                        x++;
                    }
                } else {
                    isPossible = false;
                }
                break;
            case 'W':
                if (length + y <= ocean[x].length && y >= 0 && isPlace(x, y, direction, length) && checkSurrounding(ship, direction, x, y)) {
                    for (int i = 0; i < length; i++) {
                        ocean[x][y].setPlacement(placement);
                        y++;
                    }
                } else {
                    isPossible = false;
                }
                break;
            default:
                System.out.println("Give a valid cardinal direction.");
                isPossible = false;
                break;
        }
        return isPossible;
    }

    public boolean shipDestroyed(int x, int y) {
        int limit = ocean[x][y].getEnumShip().getLength();
        int bombarded = 0;
        for (int i = 0; i < ocean.length; i++) {
            for (int j = 0; j < ocean[i].length; j++) {
                if(ocean[i][j].getShipName().equals(ocean[x][y].getShipName()) && ocean[i][j].isBombarded()) {
                    bombarded++;
                }
            }
        }
        return bombarded==limit;
    }

    public boolean clear() {
        for(Field[] row: ocean) {
            for(Field cell: row) {
                if(cell.containsShip() && !cell.isBombarded()) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean hitField(int x, int y) {
//        if (x < 0 || x > ocean.length - 1 || y < 0 || y > ocean[x].length-1) {
//            return false;
//        } else {
            if (ocean[x][y].bombard()) {
                System.out.println("You hit a ship of the enemy team.");
                if (shipDestroyed(x, y)) {
                    System.out.println("You destroyed the " + ocean[x][y].getEnumShip().getName() + " of the enemy!");
                }
                if (clear()) {
                    System.out.println("you win");
                    System.exit(6942069);
                }
                return true;
            } else {
                System.out.println("You missed!");
                return false;
            }
//        }
    }

//    public boolean addShip(char direction, int x, int y, int length) {
//        boolean isPossible = true;
//        if (amountShips >= MAX_SHIPS) {
//            System.out.println("You can't have more ships on your field.");
//            return false;
//        }
//
//        if (!(length <= 5 && length >= 2)) {
//            return false;
//        }
//
////        for (int i = 0; i < ocean.length; i++) {
////            if (x >= ocean.length) {
////                isPossible = false;
////            } else {
////                for (int j = 0; j < ocean[i].length; j++) {
////                    if (y >= ocean[i].length) {
////                        isPossible = false;
////                        break;
////                    }
////                }
////            }
////        }
//
//        if (x >= ocean.length && y >= ocean[x].length) {
//            System.out.println("Give a valid field");
//            return false;
//        }
//
//        switch (direction) {
//            case 'S':
//                if (x < ocean.length && x - length >= -1 && isPlace(x, y, direction, length)) {
//                    for (int i = 0; i < length; i++) {
//                        ocean[x][y].setShip();
//                        x--;
//                    }
//                } else {
//                    isPossible = false;
//                }
//                break;
//            case 'N':
//                setActualShipVertical(x, y, length);
//                if (x + length <= ocean.length && x >= 0 && isPlace(x, y, direction, length)) {
//                    for (int i = 0; i < length; i++) {
//                        ocean[x][y].setShip();
//                        x++;
//                    }
//                } else {
//                    isPossible = false;
//                }
//                break;
//            case 'E':
//                if (y < ocean[x].length && y - length >= -1 && isPlace(x, y, direction, length)) {
//                    for (int i = 0; i < length; i++) {
//                        ocean[x][y].setShip();
//                        y--;
//                    }
//                } else {
//                    isPossible = false;
//                }
//                break;
//            case 'W':
//                setActualShipHorizontal(x, y, length);
//                if (length + y <= ocean[x].length && y >= 0 && isPlace(x, y, direction, length)) {
//                    for (int i = 0; i < length; i++) {
//                        ocean[x][y].setShip();
//                        y++;
//                    }
//                } else {
//                    isPossible = false;
//                }
//                break;
//            default:
//                System.out.println("Give a valid cardinal direction.");
//                isPossible = false;
//                break;
//        }
//
//        if (isPossible) {
//            amountShips += 1;
//        }
//        return isPossible;
//    }

    public int getAmountShips() {
        return amountShips;
    }

    private boolean checkSurrounding(Ship ship, char direction, int x, int y) {
        boolean isPossible = true;
        int length = ship.getLength();

        switch (direction) {
            case 'N':
                for (int i = 0; i < length; i++) {
                    switch (y) {
                        case 0:

                            if (x > 0 && x < ocean.length - 1) {
                                if (ocean[x - 1][y].containsShip() && ocean[x - 1][y].getShipName().equals(this.ocean[x][y].getShipName())) {
                                    if (!(ocean[x - 1][y + 1].containsShip() || ocean[x][y + 1].containsShip() || ocean[x + 1][y].containsShip() || ocean[x + 1][y + 1].containsShip())) {
                                        ocean[x][y].setTestContainsShip(true);
                                        ++x;
                                    } else {
                                        return false;
                                    }
                                } else if (!(ocean[x - 1][y].containsShip())) {
                                    if (!(ocean[x - 1][y + 1].containsShip() || ocean[x][y + 1].containsShip() || ocean[x + 1][y].containsShip() || ocean[x + 1][y + 1].containsShip())) {
                                        ocean[x][y].setTestContainsShip(true);
                                        ++x;
                                    } else {
                                        return false;
                                    }
                                } else {
                                    return false;
                                }
                            }

                            if (x == ocean.length - 1) {
                                if (ocean[x - 1][y].containsShip() && ocean[x - 1][y].getShipName().equals(this.ocean[x][y].getShipName())) {
                                    if (!(ocean[x - 1][y + 1].containsShip() || ocean[x][y + 1].containsShip())) {
                                        ocean[x][y].setTestContainsShip(true);
                                        ++x;
                                    } else {
                                        return false;
                                    }
                                } else if (!(ocean[x - 1][y].containsShip())) {
                                    if (!(ocean[x - 1][y + 1].containsShip() || ocean[x][y + 1].containsShip())) {
                                        ocean[x][y].setTestContainsShip(true);
                                        ++x;
                                    } else {
                                        return false;
                                    }
                                } else {
                                    return false;
                                }
                            }

                            if (x == 0) {
                                if (!(ocean[x][y + 1].containsShip() || ocean[x + 1][y].containsShip() || ocean[x + 1][y + 1].containsShip())) {
                                    ocean[x][y].setTestContainsShip(true);
                                    ++x;
                                } else {
                                    return false;
                                }
                            }
                            break;
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:


                            if (x == 9) {
                                if (ocean[x - 1][y].getTestContainsShip() && ocean[x - 1][y].getShipName().equals(this.ocean[x][y].getShipName())) {
                                    if (!(ocean[x - 1][y - 1].containsShip() || ocean[x - 1][y + 1].containsShip() || ocean[x][y - 1].containsShip() || ocean[x][y + 1].containsShip())) {
                                        ocean[x][y].setTestContainsShip(true);
                                        ++x;
                                    } else {
                                        return false;
                                    }
                                } else if (!(ocean[x - 1][y].containsShip())) {
                                    if (!(ocean[x - 1][y - 1].containsShip() || ocean[x - 1][y + 1].containsShip() || ocean[x][y - 1].containsShip() || ocean[x][y + 1].containsShip())) {
                                        ocean[x][y].setTestContainsShip(true);
                                        ++x;
                                    } else {
                                        return false;
                                    }
                                } else {
                                    return false;
                                }
                            } else if (x == 0) {
                                if (!(ocean[x][y - 1].containsShip() || ocean[x][y + 1].containsShip() || ocean[x + 1][y].containsShip() || ocean[x + 1][y - 1].containsShip() || ocean[x + 1][y + 1].containsShip())) {
                                    ocean[x][y].setTestContainsShip(true);
                                    ++x;
                                } else {
                                    return false;
                                }
                            } else if (x > 0 && x < ocean.length - 1) {
                                if (ocean[x - 1][y].getTestContainsShip() && ocean[x - 1][y].getShipName().equals(this.ocean[x][y].getShipName())) {
                                    if (!(ocean[x - 1][y - 1].containsShip() || ocean[x - 1][y + 1].containsShip() || ocean[x][y - 1].containsShip() || ocean[x][y + 1].containsShip() || ocean[x + 1][y].containsShip() || ocean[x + 1][y - 1].containsShip() || ocean[x + 1][y + 1].containsShip())) {
                                        ocean[x][y].setTestContainsShip(true);
                                        ++x;
                                    } else {
                                        return false;
                                    }
                                } else if (!(ocean[x - 1][y].containsShip())) {
                                    if (!(ocean[x - 1][y - 1].containsShip() || ocean[x - 1][y + 1].containsShip() || ocean[x][y - 1].containsShip() || ocean[x][y + 1].containsShip() || ocean[x + 1][y].containsShip() || ocean[x + 1][y - 1].containsShip() || ocean[x + 1][y + 1].containsShip())) {
                                        ocean[x][y].setTestContainsShip(true);
                                        ++x;
                                    } else {
                                        return false;
                                    }
                                } else {
                                    return false;
                                }
                            }
                            break;

                        case 9:

                            //todo
                            if (x > 0 && x < ocean.length - 1) {
                                if (ocean[x - 1][y].containsShip() && ocean[x - 1][y].getShipName().equals(this.ocean[x][y].getShipName())) {
                                    if (!(ocean[x - 1][y - 1].containsShip() || ocean[x][y - 1].containsShip() || ocean[x + 1][y].containsShip() || ocean[x + 1][y - 1].containsShip())) {
                                        ocean[x][y].setTestContainsShip(true);
                                        ++x;
                                    } else {
                                        return false;
                                    }
                                } else if (!(ocean[x - 1][y].containsShip())) {
                                    if (!(ocean[x - 1][y - 1].containsShip() || ocean[x][y - 1].containsShip() || ocean[x + 1][y].containsShip() || ocean[x + 1][y - 1].containsShip())) {
                                        ocean[x][y].setTestContainsShip(true);
                                        ++x;
                                    } else {
                                        return false;
                                    }
                                } else {
                                    return false;
                                }
                            }
                            //todo

                            if (x == ocean.length - 1) {
                                if (ocean[x - 1][y].containsShip() && ocean[x - 1][y].getShipName().equals(this.ocean[x][y].getShipName())) {
                                    if (!(ocean[x - 1][y - 1].containsShip() || ocean[x][y - 1].containsShip())) {
                                        ocean[x][y].setTestContainsShip(true);
                                        ++x;
                                    } else {
                                        return false;
                                    }
                                } else if (!(ocean[x - 1][y].containsShip())) {
                                    if (!(ocean[x - 1][y - 1].containsShip() || ocean[x][y - 1].containsShip())) {
                                        ocean[x][y].setTestContainsShip(true);
                                        ++x;
                                    } else {
                                        return false;
                                    }
                                } else {
                                    return false;
                                }
                            }

                            if (x == 0) {
                                if (!(ocean[x][y - 1].containsShip() || ocean[x + 1][y].containsShip() || ocean[x + 1][y - 1].containsShip())) {
                                    ocean[x][y].setTestContainsShip(true);
                                    ++x;
                                } else {
                                    return false;
                                }
                            }
                    }
                }
                break;

            case 'W':
                for (int i = 0; i < length; i++) {

                    switch (x) {
                        case 0:

                            if (y > 0 && y < ocean[x].length - 1) {
                                if (ocean[x][y - 1].containsShip() && ocean[x][y - 1].getShipName().equals(this.ocean[x][y].getShipName())) {
                                    if (!(ocean[x][y + 1].containsShip() || ocean[x + 1][y].containsShip() || ocean[x + 1][y - 1].containsShip() || ocean[x + 1][y + 1].containsShip())) {
                                        ocean[x][y].setTestContainsShip(true);
                                        ++y;
                                    } else {
                                        return false;
                                    }
                                } else if (!(ocean[x][y - 1].containsShip())) {
                                    if (!(ocean[x][y + 1].containsShip() || ocean[x + 1][y].containsShip() || ocean[x + 1][y - 1].containsShip() || ocean[x + 1][y + 1].containsShip())) {
                                        ocean[x][y].setTestContainsShip(true);
                                        ++y;
                                    } else {
                                        return false;
                                    }
                                } else {
                                    return false;
                                }
                            }

                            if (y == ocean[x].length - 1) {
                                if (ocean[x][y - 1].containsShip() && ocean[x][y - 1].getShipName().equals(this.ocean[x][y].getShipName())) {
                                    if (!(ocean[x][y - 1].containsShip() || ocean[x + 1][y].containsShip() || ocean[x + 1][y - 1].containsShip())) {
                                        ocean[x][y].setTestContainsShip(true);
                                        ++y;
                                    } else {
                                        return false;
                                    }
                                } else if (!(ocean[x][y - 1].containsShip())) {
                                    if (!(ocean[x][y - 1].containsShip() || ocean[x + 1][y].containsShip() || ocean[x + 1][y - 1].containsShip())) {
                                        ocean[x][y].setTestContainsShip(true);
                                        ++y;
                                    } else {
                                        return false;
                                    }
                                } else {
                                    return false;
                                }
                            }

                            if (y == 0) {
                                if (!(ocean[x][y + 1].containsShip() || ocean[x + 1][y].containsShip() || ocean[x + 1][y + 1].containsShip())) {
                                    ocean[x][y].setTestContainsShip(true);
                                    ++y;
                                } else {
                                    return false;
                                }
                            }

                            break;
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:

                            if (y > 0 && y < ocean[x].length - 1) {
                                if (ocean[x][y - 1].getTestContainsShip() && ocean[x][y - 1].getShipName().equals(this.ocean[x][y].getShipName())) {
                                    if (!(ocean[x - 1][y - 1].containsShip() || ocean[x - 1][y].containsShip() || ocean[x - 1][y + 1].containsShip() || ocean[x][y + 1].containsShip() || ocean[x + 1][y].containsShip() || ocean[x + 1][y - 1].containsShip() || ocean[x + 1][y + 1].containsShip())) {
                                        ocean[x][y].setTestContainsShip(true);
                                        ++y;
                                    } else {
                                        return false;
                                    }
                                } else if (!(ocean[x][y - 1].containsShip())) {
                                    if (!(ocean[x - 1][y - 1].containsShip() || ocean[x - 1][y].containsShip() || ocean[x - 1][y + 1].containsShip() || ocean[x][y + 1].containsShip() || ocean[x + 1][y].containsShip() || ocean[x + 1][y - 1].containsShip() || ocean[x + 1][y + 1].containsShip())) {
                                        ocean[x][y].setTestContainsShip(true);
                                        ++y;
                                    } else {
                                        return false;
                                    }
                                } else {
                                    return false;
                                }
                            }

                            if (y == 9) {
                                if (ocean[x][y - 1].getTestContainsShip() && ocean[x][y - 1].getShipName().equals(this.ocean[x][y].getShipName())) {
                                    if (!(ocean[x - 1][y - 1].containsShip() || ocean[x - 1][y].containsShip() || ocean[x + 1][y].containsShip() || ocean[x + 1][y - 1].containsShip())) {
                                        ocean[x][y].setTestContainsShip(true);
                                        ++y;
                                    } else {
                                        return false;
                                    }
                                } else if (!(ocean[x][y - 1].containsShip())) {
                                    if (!(ocean[x - 1][y - 1].containsShip() || ocean[x - 1][y].containsShip() || ocean[x + 1][y].containsShip() || ocean[x + 1][y - 1].containsShip())) {
                                        ocean[x][y].setTestContainsShip(true);
                                        ++y;
                                    } else {
                                        return false;
                                    }
                                } else {
                                    return false;
                                }
                            }

                            if (y == 0) {
                                if (!(ocean[x - 1][y].containsShip() || ocean[x - 1][y + 1].containsShip() || ocean[x][y + 1].containsShip() || ocean[x + 1][y].containsShip() || ocean[x + 1][y + 1].containsShip())) {
                                    ocean[x][y].setTestContainsShip(true);
                                    ++y;
                                } else {
                                    return false;
                                }
                            }

                            break;
                        case 9:

                            if (y > 0 && y < ocean[x].length - 1) {
                                if (ocean[x][y - 1].containsShip() && ocean[x][y - 1].getShipName().equals(this.ocean[x][y].getShipName())) {
                                    if (!(ocean[x - 1][y - 1].containsShip() || ocean[x - 1][y].containsShip() || ocean[x - 1][y + 1].containsShip() || ocean[x][y + 1].containsShip())) {
                                        ocean[x][y].setTestContainsShip(true);
                                        ++y;
                                    } else {
                                        return false;
                                    }
                                } else if (!(ocean[x][y - 1].containsShip())) {
                                    if (!(ocean[x - 1][y - 1].containsShip() || ocean[x - 1][y].containsShip() || ocean[x - 1][y + 1].containsShip() || ocean[x][y + 1].containsShip())) {
                                        ocean[x][y].setTestContainsShip(true);
                                        ++y;
                                    } else {
                                        return false;
                                    }
                                } else {
                                    return false;
                                }
                            }

                            if (y == ocean[x].length - 1) {
                                if (ocean[x][y - 1].containsShip() && ocean[x][y - 1].getShipName().equals(this.ocean[x][y].getShipName())) {
                                    if (!(ocean[x - 1][y - 1].containsShip() || ocean[x - 1][y].containsShip())) {
                                        ocean[x][y].setTestContainsShip(true);
                                        ++y;
                                    } else {
                                        return false;
                                    }
                                } else if (!(ocean[x][y - 1].containsShip())) {
                                    if (!(ocean[x - 1][y - 1].containsShip() || ocean[x - 1][y].containsShip())) {
                                        ocean[x][y].setTestContainsShip(true);
                                        ++y;
                                    } else {
                                        return false;
                                    }
                                } else {
                                    return false;
                                }
                            }

                            if (y == 0) {
                                if (!(ocean[x - 1][y].containsShip() || ocean[x - 1][y + 1].containsShip() || ocean[x][y + 1].containsShip())) {
                                    ocean[x][y].setTestContainsShip(true);
                                    ++y;
                                } else {
                                    return false;
                                }
                            }
                            break;
                    }
                }
        }
        removeAllTestContainShip();
        return isPossible;
    }
}


