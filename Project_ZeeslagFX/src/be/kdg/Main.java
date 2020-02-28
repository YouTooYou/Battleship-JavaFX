package be.kdg;

import be.kdg.model.Game;
import be.kdg.view.GamePresenter;
import be.kdg.view.GameView;
import be.kdg.view.player.PlayerNameView;
import be.kdg.view.start.StartPresenter;
import be.kdg.view.start.StartView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Game model = new Game();
        StartView startView = new StartView();
        StartPresenter startPresenter = new StartPresenter(model, startView);
        Scene scene = new Scene(startView);

        stage.setTitle("Zeeslag");
        stage.setScene(scene);
        stage.show();
    }
}
