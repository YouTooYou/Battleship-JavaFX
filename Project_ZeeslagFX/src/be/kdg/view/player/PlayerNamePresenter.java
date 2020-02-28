package be.kdg.view.player;

import be.kdg.model.Game;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class PlayerNamePresenter {
    private Game model;
    private PlayerNameView view;

    public PlayerNamePresenter(Game model, PlayerNameView view) {
        this.model = model;
        this.view = view;
        addEventhandler();
        updateView();
    }

    private void addEventhandler() {
        view.getBtnSend().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(model.getPlayer1()==null) {
                    model.addPlayer1(view.getTfName().getText());
                } else {
                    model.addPlayer2(view.getTfName().getText());
                }
            }
        });
    }

    private void updateView() {

    }
}
