package be.kdg.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AI {
    private Ocean aiOcean;
    private Ocean playerOcean;
    private Random rng;
    private int targetX;
    private int targetY;
    private int targetXNext = 1;
    private int targetYNext = 1;
    private boolean lastHit = false;
    private boolean firstTry = true;
    private boolean secondTry = false;
    private boolean thirdTry = false;
    private boolean fourthTry = false;
    private int aantalBeurten;
    private String name;

    public AI(int length, int height, Ocean ocean) {
        this.aiOcean = new Ocean(length, height);
        this.playerOcean = ocean;
        rng = new Random();
    }

    public AI(int length, int height, String name) {
        this.aiOcean = new Ocean(length, height);
        this.name=name;
        rng = new Random();
    }

    public void setPlayerOcean(Ocean playerOcean) {
        this.playerOcean = playerOcean;
    }

    public Ocean getAiOcean() { //todo teset doe weg
        return aiOcean;
    }

    public int getAantalBeurten() {//todo remove becqus test tsest test testtestte stestestsetestestest
        return aantalBeurten;
    }

    public void placeShips() {
        List<Ship> ships = new ArrayList<>();
        ships.add(Ship.SUBMARINE);
        ships.add(Ship.DESTORYER);
        ships.add(Ship.BATTLESHIP);
        ships.add(Ship.CRUISER);
        ships.add(Ship.CARRIER);

        List<Character> direction = new ArrayList<>();
        direction.add('N');
        direction.add('W');

        int limit = rng.nextInt(10) + 1;
        System.out.println(limit);
        for (int i = 0; i < limit; i++) {
            if (!aiOcean.addShipEnum(ships.get(rng.nextInt(5)), direction.get(rng.nextInt(2)), rng.nextInt(10), rng.nextInt(10))) {
                i--;
            }
        }
    }

    public void removeShips() {//todo remove becqus test tsest test testtestte stestestsetestestest
        for (int i = 0; i < aiOcean.getOcean().length; i++) {
            for (int j = 0; j < aiOcean.getOcean()[i].length; j++) {
                aiOcean.getOcean()[i][j].removeShip();
            }
        }
        aiOcean.removeAmountShips();
    }

    public void shoot() {
        System.out.println(name);
        System.out.println(aantalBeurten);
        boolean alreadyHit = false;//todo zet dit als een attribuut in field
        aantalBeurten++;
        if (!lastHit) {
            int x = rng.nextInt(aiOcean.getOcean().length);
            int y = rng.nextInt(aiOcean.getOcean().length);

            do {
                if (playerOcean.getOcean()[x][y].isBombarded()) {
                    alreadyHit = true;      //todo zet dit als een attribuut in field
                    x = rng.nextInt(aiOcean.getOcean().length);
                    y = rng.nextInt(aiOcean.getOcean().length);
//                    System.out.println("in de lus true");
                } else {
                    alreadyHit = false;
//                    System.out.println("in de lus false");
                }
            } while (alreadyHit);

            if (playerOcean.hitField(x, y)) {
                this.targetX = x;
                this.targetY = y;
                lastHit = true;
                System.out.println("ship X: " + targetX + ", ship Y: " + targetY);
            }
//            System.out.println("targetX: " + targetX + ", targetY: "+ targetY);
        } else {
            quickAdjustment();
            if (firstTry) {
                if (playerOcean.hitField(targetX + targetXNext, targetY)) {
                    System.out.println("First try:\nship target X: " + (targetX + targetXNext) + ", ship target Y: " + targetY);
                    this.targetXNext++;
                    isShipDestroyed();
//                    System.out.println("first try hit");
                } else {
                    firstTry = false;
                    secondTry = true;
                    this.targetXNext = 1;
//                    System.out.println("first try miss");
                }
            } else if (secondTry) {
                if (playerOcean.hitField(targetX - targetXNext, targetY)) {
                    System.out.println("Second try:\nship target X: " + (targetX - targetXNext) + ", ship target Y: " + targetY);
                    this.targetXNext++;
                    isShipDestroyed();
//                    System.out.println("second try hit");
                } else {
                    secondTry = false;
                    thirdTry = true;
                    this.targetXNext = 1;
//                    System.out.println("second try miss");
                }
            } else if (thirdTry) {
                if (playerOcean.hitField(targetX, targetY + targetYNext)) {
                    System.out.println("Third try:\nship target X: " + targetX + ", ship target Y: " + (targetY + targetYNext));
                    targetYNext++;
                    isShipDestroyed();
//                    System.out.println("third try hit");
                } else {
                    thirdTry = false;
                    fourthTry = true;
                    this.targetYNext = 1;
//                    System.out.println("third try miss");
                }
            } else if (fourthTry) {
                if (playerOcean.hitField(targetX, targetY - targetYNext)) {
                    System.out.println("Fourth try:\nship target X: " + targetX + ", ship target Y: " + (targetY - targetYNext));
                    targetYNext++;
                    isShipDestroyed();
//                    System.out.println("fourth try hit");
                }
            }
        }
    }

    private void quickAdjustment() {
        if (firstTry) {
            if (targetX + targetXNext >= aiOcean.getOcean().length) {
                firstTry = false;
                secondTry = true;
                this.targetXNext = 1;
            }
        } else if (secondTry) {
            if (targetX - targetXNext < 0) {
                if(targetY + targetYNext >= aiOcean.getOcean()[targetX].length) {
                    secondTry=false;
                    fourthTry=true;
                    this.targetXNext = 1;
                } else {
                    secondTry = false;
                    thirdTry = true;
                    this.targetXNext = 1;
                }
            }
        } else if (thirdTry) {
            if (targetY + targetYNext >= aiOcean.getOcean()[targetX].length) {
                thirdTry = false;
                fourthTry = true;
                this.targetYNext = 1;
            }
        }
    }

    private void isShipDestroyed() {
        if (playerOcean.shipDestroyed(targetX, targetY)) {
            targetXNext = 1;
            targetYNext = 1;
            lastHit = false;
            firstTry = true;
            secondTry = false;
            thirdTry = false;
            fourthTry = false;
        }
    }
}
