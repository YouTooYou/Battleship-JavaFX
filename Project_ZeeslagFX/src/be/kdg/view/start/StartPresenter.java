package be.kdg.view.start;

import be.kdg.model.Game;
import be.kdg.view.GamePresenter;
import be.kdg.view.GameView;
import be.kdg.view.player.PlayerNamePresenter;
import be.kdg.view.player.PlayerNameView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class StartPresenter {
    private Game model;
    private StartView view;


    public StartPresenter(Game model, StartView view) {
        this.model = model;
        this.view = view;
        addEventhandler();
    }

    private void addEventhandler() {
        view.getBtnStart().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                PlayerNameView playerNameView = new PlayerNameView();
                PlayerNamePresenter playerNamePresenter = new PlayerNamePresenter(model, playerNameView);
                view.getScene().setRoot(playerNameView);
                playerNameView.getScene().getWindow().sizeToScene();
            }
        });
    }
}