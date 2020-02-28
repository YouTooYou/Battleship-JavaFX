package be.kdg.model;
//todo BIG SHIT LATER ZET DE RICHTINGEN IN ALLEEN MAAR VERTICAAL OF HORIZONTAAL WANT DAN IS ER GEEN STRESS MET DIE -- ALS DA 'E' OF 'S' IS

public class Field {
    private boolean containsShip;
    private boolean testContainsShip;
    private boolean bombarded;
    //todo zet hier private int shipValue; = de waarde
    private int shipValue;
    private boolean placement;
    private String ship;
    private Ship enumShip;

    public Field() {
        containsShip = false;
        bombarded = false;
        placement = false;
        ship = "null";
    }

    public String getShipName() {
        return ship;
    }

    public Ship getEnumShip() {
        return enumShip;
    }

    public void setEnumShip(Ship enumShip) {
        this.enumShip = enumShip;
    }

    public void setShipName(String ship) {
        this.ship = ship;
    }

    public boolean getTestContainsShip() {
        return testContainsShip;
    }

    public void setTestContainsShip(boolean testContainsShip) {
        this.testContainsShip = testContainsShip;
    }



    public void setShip() {
        containsShip = true;
    }

    public void removeShip() { //todo remove becqus test tsest test testtestte stestestsetestestest
        containsShip = false;
    }

    public int getShipValue() {
        return shipValue;
    }

    public void setShipValuePlus() {
        this.shipValue ++;
    }

    public boolean containsShip() {
        return containsShip;
    }

    public boolean isPlacement() {
        return placement;
    }

    public void setPlacement(boolean placement) {
        this.placement = placement;
    }

    public boolean bombard() {
        bombarded = true;
        return containsShip;
    }

    public boolean isBombarded() {
        return bombarded;
    }

    @Override
    public String toString() {
        return ship;
    }
}
