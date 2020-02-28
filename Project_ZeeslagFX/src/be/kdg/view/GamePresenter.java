package be.kdg.view;

import be.kdg.model.Game;
import be.kdg.model.Ship;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

public class GamePresenter {
    private GameView view;
    private Game model;

    public GamePresenter(GameView view, Game model) {
        this.view = view;
        this.model = model;
        addEventHandlers();
        updateView();
    }

    private void addEventHandlers() {
        model.setKeuze(Ship.DESTORYER);
        model.setDirection('W');
        for (int i = 0; i < view.getLbls().length; i++) {
            for (int j = 0; j < view.getLbls()[i].length; j++) {
                view.getLbls()[i][j].setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        for (int i = 0; i < view.getLbls().length; i++) {
                            for (int j = 0; j < view.getLbls()[i].length; j++) {
                                if (view.getLbls()[i][j].toString().equals(mouseEvent.getTarget().toString())) {
                                    model.setX(i);
                                    model.setY(j);
                                    model.player1AddShipOutline(model.getKeuze(), model.getDirection(), i, j, true);
                                    updateView();
                                }
                            }
                        }
                    }
                });
            }
        }

        char direction = 'W'; //todo zet 2 knoppen: horizontaal verticaal zodat gij dit aanpast

        view.getCarrier().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                model.setKeuze(Ship.CARRIER);
                model.player1AddShipOutline(model.getKeuze(), model.getDirection(), model.getX(), model.getY(), true);
                updateView();
                view.getCarrier().setImage(new Image("CARRIER Selected.png"));
            }
        });

        view.getBattleship().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                model.setKeuze(Ship.BATTLESHIP);
                model.player1AddShipOutline(model.getKeuze(), model.getDirection(), model.getX(), model.getY(), true);
                updateView();
                view.getBattleship().setImage(new Image("BATTLESHIP Selected.png"));
            }
        });

        view.getCruiser().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                model.setKeuze(Ship.CRUISER);
                model.player1AddShipOutline(model.getKeuze(), model.getDirection(), model.getX(), model.getY(), true);
                updateView();
                view.getCruiser().setImage(new Image("CRUISER Selected.png"));
            }
        });

        view.getSubmarine().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                model.setKeuze(Ship.SUBMARINE);
                model.player1AddShipOutline(model.getKeuze(), model.getDirection(), model.getX(), model.getY(), true);
                updateView();
                view.getSubmarine().setImage(new Image("SUBMARINE Selected.png"));
            }
        });

        view.getDestroyer().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                model.setKeuze(Ship.DESTORYER);
                model.player1AddShipOutline(model.getKeuze(), model.getDirection(), model.getX(), model.getY(), true);
                updateView();
                view.getDestroyer().setImage(new Image("DESTROYER Selected.png"));
            }
        });

        view.getBtnHorizontal().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                model.setDirection('N');
                model.player1AddShipOutline(model.getKeuze(), model.getDirection(), model.getX(), model.getY(), true);
                updateView();
            }
        });
        view.getBtnVertical().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                model.setDirection('W');
                model.player1AddShipOutline(model.getKeuze(), model.getDirection(), model.getX(), model.getY(), true);
                updateView();
            }
        });


        view.getBtnPlace().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                //if(model.testNoShip()) todo probeer dit te implementeren
                model.player1AddShip(model.getKeuze(), model.getDirection(), model.getX(), model.getY());
//                model.player1GetEntireField();
                updateView();
            }
        });
        view.getBtnPlace().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Alert amountAlert = new Alert(Alert.AlertType.WARNING);
                if (model.getAmountShips()==10) {
                    amountAlert.setTitle("Amount ships reached");
                    amountAlert.setHeaderText("you already have the limit of amount ships");
                    amountAlert.showAndWait();
                }
            }
        });
    }


    private void updateView() {

        for (int i = 0; i < model.getEntireFieldPlacement().length; i++) {
            for (int j = 0; j < model.getEntireFieldPlacement()[i].length; j++) {
                if (model.getEntireFieldPlacement()[i][j]) {
                    view.getLbls()[i][j].setStyle("-fx-background-color: orange");
                } else {
                    view.getLbls()[i][j].setStyle("-fx-background-color: white; -fx-border-color: black");
                }
            }
        }

        for (int i = 0; i < model.getEntireFieldBoolean().length; i++) {
            for (int j = 0; j < model.getEntireFieldBoolean()[i].length; j++) {
                if (model.getEntireFieldBoolean()[i][j]) {
                    view.getLbls()[i][j].setStyle("-fx-background-color: green");
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            System.out.println();
            for (int j = 0; j < 10; j++) {
                System.out.printf("%6s", model.getEntireFieldBoolean()[i][j] + " ");
            }
        }

        switch (model.getKeuze()) {
            case CARRIER:
                view.getBattleship().setImage(new Image(Ship.BATTLESHIP.getLink()));
                view.getCruiser().setImage(new Image(Ship.CRUISER.getLink()));
                view.getSubmarine().setImage(new Image(Ship.SUBMARINE.getLink()));
                view.getDestroyer().setImage(new Image(Ship.DESTORYER.getLink()));
                break;
            case BATTLESHIP:
                view.getCarrier().setImage(new Image(Ship.CARRIER.getLink()));
                view.getCruiser().setImage(new Image(Ship.CRUISER.getLink()));
                view.getSubmarine().setImage(new Image(Ship.SUBMARINE.getLink()));
                view.getDestroyer().setImage(new Image(Ship.DESTORYER.getLink()));
                break;
            case CRUISER:
                view.getCarrier().setImage(new Image(Ship.CARRIER.getLink()));
                view.getBattleship().setImage(new Image(Ship.BATTLESHIP.getLink()));
                view.getSubmarine().setImage(new Image(Ship.SUBMARINE.getLink()));
                view.getDestroyer().setImage(new Image(Ship.DESTORYER.getLink()));
                break;
            case SUBMARINE:
                view.getCarrier().setImage(new Image(Ship.CARRIER.getLink()));
                view.getBattleship().setImage(new Image(Ship.BATTLESHIP.getLink()));
                view.getCruiser().setImage(new Image(Ship.CRUISER.getLink()));
                view.getDestroyer().setImage(new Image(Ship.DESTORYER.getLink()));
                break;
            case DESTORYER:
                view.getCarrier().setImage(new Image(Ship.CARRIER.getLink()));
                view.getBattleship().setImage(new Image(Ship.BATTLESHIP.getLink()));
                view.getCruiser().setImage(new Image(Ship.CRUISER.getLink()));
                view.getSubmarine().setImage(new Image(Ship.SUBMARINE.getLink()));
                break;
        }
        if(model.getDirection()=='W') {
            view.getLblDirection().setText("Current way of placing: " + "Vertical");
        } else {
            view.getLblDirection().setText("Current way of placing: " + "Horizontal");
        }

        view.getLblAmountShips().setText("Amount of ships: "+model.getAmountShips());
    }
}
