package be.kdg.view.start;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;

public class StartView extends BorderPane {
    private Button btnStart;
    private ImageView ivLogo;

    public StartView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        btnStart = new Button("Start Battleship");
        ivLogo = new ImageView("/BATTLESHIP_LOGO.png");

    }

    private void layoutNodes() {
        super.setBottom(btnStart);
        BorderPane.setAlignment(btnStart, Pos.CENTER);
        BorderPane.setMargin(btnStart, new Insets(10));
        btnStart.setFont(new Font(20));
        btnStart.setPrefSize(200,100);
        setPrefSize(1000,500);
        super.getChildren().add(ivLogo);
        ivLogo.setFitHeight(270);
        ivLogo.setFitWidth(750);
    }

    Button getBtnStart() {
        return btnStart;
    }

    ImageView getImageView() {
        return ivLogo;
    }

}