package be.kdg.model;
//todo BIG SHIT LATER ZET DE RICHTINGEN IN ALLEEN MAAR VERTICAAL OF HORIZONTAAL WANT DAN IS ER GEEN STRESS MET DIE -- ALS DA 'E' OF 'S' IS

public class Game {
    public Ocean ocean1; //todo pas terug naar private
    private Ocean ocean2;
    private AI ai;
    private Ship keuze;
    private int x;
    private int y;
    private char direction;

    public Game(int length, int height) {
        ocean1 = new Ocean(length, height);
        ocean2 = new Ocean(length, height);
        ai = new AI(length, height, ocean1);
    }

    public Game() {
        ocean1 = new Ocean(10,10);
        ocean2 = new Ocean(10,10);
    }

    public void addPlayer1(String name) {
        ocean1.addPlayer(new Player(name));
    }

    public Player getPlayer1() {
        return ocean1.getOwner();
    }

    public String getPlayer1Name() {
        return ocean1.getOwner().getName();
    }

    public String getPlayer2() {
        return ocean2.getOwner().getName();
    }

    public void addPlayer2(String name) {
        ocean2.addPlayer(new Player(name));
    }

    public boolean player1AddShip(Ship ship,char direction, int x, int y) {
        if(ocean1.addShipEnum(ship, direction, x, y))
        {
            System.out.println("This is a valid place for your ship");
            return true;
        } else {
            System.out.println("This is not a valid place for your ship");
            return false;
        }
    }

    public boolean player1AddShipOutline(Ship ship,char direction, int x, int y, boolean placement) {
        if(ocean1.addOutlineShipEnum(ship, direction, x, y, placement)) {
            System.out.println("Outline placed!");
            return true;
        } else {
            System.out.println("Outline not placed!");
            return false;
        }
    }

    public int getAmountShips() {
        return ocean1.getAmountShips();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }

    public char getDirection() {
        return direction;
    }

    public void setKeuze(Ship keuze) {
        this.keuze = keuze;
    }

    public Ship getKeuze() {
        return this.keuze;
    }

    public void player2AddShip(Ship ship,char direction, int x, int y) {
        if(ocean2.addShipEnum(ship, direction, x, y))
        {
            System.out.println("This is a valid place for your ship");
        } else {
            System.out.println("This is not a valid place for your ship");
        }
    }

    public void player1GetEntireField(){
        System.out.println(ocean1.getOwner().getName() + "'s field:");
        ocean1.getEntireField();
    }

    public void player2GetEntireField(){
        System.out.println(ocean2.getOwner().getName() + "'s field:");
        ocean2.getEntireField();
    }

    public boolean[][] getEntireFieldBoolean() {
        return ocean1.getEntireFieldBoolean();
    }

    public boolean[][] getEntireFieldPlacement() {
        return ocean1.getEntireFieldPlacement();
    }

    public void player1Hit(int x, int y) {
        ocean2.hitField(x, y);
    }

    public void player2Hit(int x, int y) {
        ocean1.hitField(x, y);
    }


}
