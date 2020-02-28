package be.kdg.model;
//todo BIG SHIT LATER ZET DE RICHTINGEN IN ALLEEN MAAR VERTICAAL OF HORIZONTAAL WANT DAN IS ER GEEN STRESS MET DIE -- ALS DA 'E' OF 'S' IS

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
//        Ocean o = new Ocean(10, 10);
//        System.out.println(o.addShip('N', 0, 0, 2));
//        System.out.println(o.addShip('E', 1, 3, 2));
//        System.out.println(o.addShip('S', 9, 9, 2));
//        System.out.println(o.addShip('W', 5, 0, 2));
//        System.out.println(o.addShip('E', 6, 6, 2));
//        System.out.println(o.addShip('E', 8, 8, 3));
//
//        System.out.println();
//        o.getEntireField();
//        System.out.println();
//        System.out.println();
//
//        o.hitField(9,9);
//        o.hitField(0,1);

//        Game game = new Game(10, 10);   //dit moet momenteel 10 blijven; WOIP
//        game.addPlayer1("speler1");
//        game.addPlayer2("speler2");
//
//        game.player1AddShip(Ship.DESTORYER, 'W', 5, 7);
//        game.player1AddShip(Ship.BATTLESHIP, 'N', 5, 5);
//        game.player1AddShip(Ship.CRUISER, 'W', 5, 0);
//
//        game.player2Hit(5, 5);
//        game.player2Hit(6, 5);
//        game.player2Hit(7, 5);
//        game.player2Hit(8, 5);
//
//        game.player2Hit(5, 7);
//        game.player2Hit(5, 8);
//
//        game.player2Hit(5, 0);
//        game.player2Hit(5, 1);
//        game.player2Hit(5, 2);

//        x: 5, y: 5
//        x: 6, y: 5
//        x: 7, y: 5
//        x: 8, y: 5
//        This is a valid place for your ship
//        This is a valid place for your ship
//        This is a valid place for your ship
//        You hit a ship of the enemy team.
//        You hit a ship of the enemy team.
//        You hit a ship of the enemy team.
//        You hit a ship of the enemy team.
//        You destroyed the Battleship of the enemy!
//                You hit a ship of the enemy team.
//                You hit a ship of the enemy team.
//                You destroyed the Destroyer of the enemy!
//                You hit a ship of the enemy team.
//                You hit a ship of the enemy team.
//                You hit a ship of the enemy team.
//                You destroyed the Cruise of the enemy!
//                you win


        /*AI TESTING*/

        Random rng = new Random();

        List<Ship> ships = new ArrayList<>();
        ships.add(Ship.SUBMARINE);
        ships.add(Ship.DESTORYER);
        ships.add(Ship.BATTLESHIP);
        ships.add(Ship.CRUISER);
        ships.add(Ship.CARRIER);

        List<Character> direction = new ArrayList<>();
        direction.add('N');
        direction.add('W');

        Ocean myOcean = new Ocean(10,10);
        AI ai = new AI(10, 10, myOcean);

//        while(true) {
//            try{Thread.sleep(800);}catch(InterruptedException ie) {
//            }
//            ai.placeShips();
//            ai.removeShips();
//        }

        ai.getAiOcean().getEntireField();

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        for (int i = 0; i < 10; i++) {
            if(!myOcean.addShipEnum(ships.get(rng.nextInt(5)), direction.get(rng.nextInt(2)), rng.nextInt(10), rng.nextInt(10))){
                i--;
            }
        }

        myOcean.addShipEnum(Ship.BATTLESHIP, 'N', 6, 0);

        myOcean.getEntireField();
        while(true) {
            System.out.print("shoot ->   ");
            ai.shoot();
            System.out.println(ai.getAantalBeurten());
        }
        /*AI TEST FIGHT OF THE TITANS*/

//        AI ai1 = new AI(10, 10, "AI1");
//        AI ai2 = new AI(10, 10, "AI2");
//
//        ai1.placeShips();
//        ai2.placeShips();
//
//        ai1.setPlayerOcean(ai2.getAiOcean());
//        ai2.setPlayerOcean(ai1.getAiOcean());
//
//        while (true) {
//            ai1.shoot();
//            ai2.shoot();
//        }

//        game.player1AddShip('N', 0, 0, 2);
//        game.player1AddShip('N', 0, 3, 2);
//        game.player1AddShip('E', 1, 3, 2);
//        game.player1AddShip('S', 9, 9, 2);
//        game.player1AddShip('S', 1, 8, 2);
//        game.player1AddShip('W', 5, 0, 2);
//        game.player1AddShip('W', 7, 0, 2);
//        game.player1AddShip('E', 6, 6, 2);
//        game.player1AddShip('E', 8, 8, 3);
//        game.player1AddShip('E', 8, 0, 3);
//        game.player1AddShip('E', 4, 2, 3);

//        System.out.println();
//
//        game.player1GetEntireField();
//
//        System.out.println();

//        game.ocean1.TESTgetEntireShips();

//        game.player2Hit(0,0);
    }
}
