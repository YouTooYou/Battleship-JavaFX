package be.kdg.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class GameView extends GridPane {
    private Label lbls[][];
    private Label lblAmountShips;
    private Label lblDirection;
//    private Label lblSelectedShip;
//    private BorderPane borderPanePictures;
    private ImageView battleship;
    private ImageView carrier;
    private ImageView cruiser;
    private ImageView destroyer;
    private ImageView submarine;
    private Button btnPlace;
    private Button btnVertical;
    private Button btnHorizontal;

    public GameView(/*int width, int height*/) {
//        setBoardSize(width, height);
        intitialiseNodes();
        layoutNodes();
    }

    private void intitialiseNodes() {
        lbls = new Label[10][10];
        for (int i = 0; i < lbls.length; i++) {
            for (int j = 0; j < lbls[i].length; j++) {
                String naam = i + " " + j;
                lbls[i][j] = new Label(naam);
            }
        }
        battleship = new ImageView("BATTLESHIP.png");
        battleship.setStyle("-fx-border-color: black");
        carrier = new ImageView("CARRIER.png");
        carrier.setStyle("-fx-border-color: black");
        cruiser = new ImageView("CRUISER.png");
        cruiser.setStyle("-fx-border-color: black");
        destroyer = new ImageView("DESTROYER Selected.png");
        destroyer.setStyle("-fx-border-color: black");
        submarine = new ImageView("SUBMARINE.png");
        submarine.setStyle("-fx-border-color: black");
        btnPlace = new Button("Place Ship");

        btnHorizontal = new Button("Horizontal");
        btnVertical = new Button("Vertical");

        lblAmountShips = new Label("Amount of ships: ");;
        lblAmountShips.setStyle("-fx-font-size: 20px");
        lblDirection = new Label("Current way of placing: ");;
        lblDirection.setStyle("-fx-font-size: 20px");
//        lblSelectedShip = new Label("Selected Ship: ");;
//        lblSelectedShip.setStyle("-fx-font-size: 22px");
    }

    private void layoutNodes() {

        Label lblCarrier = new Label("Carrier: length 5");
        Label lblBattleship = new Label("Battleship: length 4");
        Label lblCruiser = new Label("Cruiser: length 3");
        Label lblSubmarine = new Label("Submarine: length 3");
        Label lblDestroyer = new Label("Destroyer: length 2");
        Insets insets = new Insets(0, 10, 0, 10);
        super.setMargin(lblCarrier, insets);
        super.setMargin(lblBattleship, insets);
        super.setMargin(lblCruiser, insets);
        super.setMargin(lblSubmarine, insets);
        super.setMargin(lblDestroyer, insets);

        super.setMargin(carrier, insets);
        super.setMargin(battleship, insets);
        super.setMargin(cruiser, insets);
        super.setMargin(submarine, insets);
        super.setMargin(destroyer, insets);

        for (int i = 0; i < lbls.length; i++) {
            for (int j = 0; j < lbls[i].length; j++) {
                lbls[i][j].setPrefWidth(950/Double.parseDouble(lbls.length+""));
                lbls[i][j].setPrefHeight(950/Double.parseDouble(lbls[i].length+""));
                lbls[i][j].setStyle("-fx-border-color: black;");
                super.add(lbls[i][j], i, j);
                super.setMargin(lbls[0][j], new Insets(0, 0, 0, 200));
            }
        }
        HBox hboxImages = new HBox();
        hboxImages.getChildren().addAll(battleship, carrier, cruiser, destroyer, submarine);
//        super.add(lbls.length, battleship, carrier, cruiser, destroyer, submarine);
        super.add(carrier, lbls.length, 0);
        super.add(lblCarrier, lbls.length, 1);
        super.add(battleship, lbls.length, 2);
        super.add(lblBattleship, lbls.length, 3);
        super.add(cruiser, lbls.length, 4);
        super.add(lblCruiser, lbls.length, 5);
        super.add(submarine, lbls.length, 6);
        super.add(lblSubmarine, lbls.length, 7);
        super.add(destroyer, lbls.length, 8);
        super.add(lblDestroyer, lbls.length, 9);
        btnPlace.setPrefWidth(85);
        btnPlace.setPrefHeight(50);
        super.add(btnPlace, lbls.length/2, lbls[5].length+1);
        super.setMargin(btnPlace, new Insets(3));

        btnHorizontal.setPrefWidth(85);
        btnHorizontal.setPrefHeight(50);
        super.add(btnHorizontal, lbls.length/2-1, lbls.length);
        super.setMargin(btnHorizontal, new Insets(3));

        btnVertical.setPrefWidth(85);
        btnVertical.setPrefHeight(50);
        super.add(btnVertical, lbls.length/2+1, lbls.length);
        super.setMargin(btnVertical, new Insets(3));

        super.add(lblAmountShips, lbls.length+2, 0);
        lblAmountShips.setPrefWidth(400);
        super.setMargin(lblAmountShips, new Insets(3));
        super.add(lblDirection, lbls.length+2, 1);
        lblDirection.setPrefWidth(400);
        super.setMargin(lblDirection, new Insets(3));
    }

    void setBoardSize(int width, int height){
        lbls = new Label[width][height];
        intitialiseNodes();
    }

    Label[][] getLbls() {
        return lbls;
    }

    ImageView getBattleship() {
        return battleship;
    }

    ImageView getCarrier() {
        return carrier;
    }

    ImageView getCruiser() {
        return cruiser;
    }

    ImageView getDestroyer() {
        return destroyer;
    }

    ImageView getSubmarine() {
        return submarine;
    }

    Button getBtnPlace() {
        return btnPlace;
    }

    Button getBtnVertical() {
        return btnVertical;
    }

    Button getBtnHorizontal() {
        return btnHorizontal;
    }

    Label getLblAmountShips() {
        return lblAmountShips;
    }

    Label getLblDirection() {
        return lblDirection;
    }

//    Label getLblSelectedShip() {
//        return lblSelectedShip;
//    }
//    MISLUKTE PROJECT
//    private ImageView imgs [][];
//
//    public GameView(/*int width, int height*/) {
////        setBoardSize(width, height);
//        intitialiseNodes();
//        layoutNodes();
//    }
//
//    private void intitialiseNodes() {
//        imgs = new ImageView[10][10];
//        for (int i = 0; i < imgs.length; i++) {
//            for (int j = 0; j < imgs[i].length; j++) {
//                imgs[i][j] = new ImageView("white block.png");
//            }
//        }
//    }
//
//    private void layoutNodes() {
////        Button button = new Button("hallo");
//        for (int i = 0; i < imgs.length; i++) {
//            for (int j = 0; j < imgs[i].length; j++) {
//                super.add(imgs[i][j], i, j);
//            }
//        }
//    }
//
//    void setBoardSize(int width, int height){
//        imgs = new ImageView[width][height];
//        intitialiseNodes();
//    }
//
//    ImageView[][] getImgs() {
//        return imgs;
//    }

//    private TilePane tiles;
//    private ImageView imgs [][];
//
//    public GameView() {
//        intitialiseNodes();
//        layoutNodes();
//    }
//
//    private void intitialiseNodes() {
//        tiles = new TilePane();
//
//        imgs = new ImageView[10][10];
//        for (int i = 0; i < 10; i++) {
//            for (int j = 0; j < 10; j++) {
//                imgs[i][j] = new ImageView("white block.png");
//            }
//        }
//    }
//
//    private void layoutNodes() {
//        for (int i = 0; i < imgs.length; i++) {
//            for (int j = 0; j < imgs[i].length; j++) {
//                tiles.getChildren().add(imgs[i][j]);
//            }
//        }
//    }
}
