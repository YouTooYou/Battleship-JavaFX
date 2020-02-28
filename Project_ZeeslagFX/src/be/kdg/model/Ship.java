package be.kdg.model;

public enum Ship {
    CARRIER(5, "CARRIER.png", "Carrier"), BATTLESHIP(4, "BATTLESHIP.png", "Battleship"),
    CRUISER(3, "CRUISER.png", "Cruiser"), SUBMARINE(3, "SUBMARINE.png", "Submarine"), DESTORYER(2, "DESTROYER.png", "Destroyer");

    private int length;
    private String link;
    private String name;

    Ship(int length, String link, String name) {
        this.length = length;
        this.link = link;
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public String getLink() {
        return link;
    }

    public String getName() {
        return name;
    }
}
