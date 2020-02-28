package be.kdg.view.player;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PlayerNameView extends VBox {
    private Label lblName;
    private TextField tfName;
    private Button btnSend;

    public PlayerNameView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        lblName = new Label("Voer uw naam in");
        tfName = new TextField();
        btnSend = new Button("Send");
    }

    private void layoutNodes() {
        super.setAlignment(Pos.CENTER);
        HBox hBoxLayout = new HBox();
        hBoxLayout.getChildren().add(lblName);
        HBox hBoxInput = new HBox();
        hBoxInput.getChildren().add(tfName);
        HBox hboxSend = new HBox();
        hboxSend.setAlignment(Pos.CENTER_RIGHT);
        hboxSend.getChildren().add(btnSend);

        super.setMargin(hBoxLayout, new Insets(10, 50, 15, 50));
        super.setMargin(hBoxInput, new Insets(10, 50, 15, 50));
        super.setMargin(hboxSend, new Insets(10, 50, 15, 50));

        super.getChildren().addAll(hBoxLayout, hBoxInput, hboxSend); //todo  GIJ WAS ENKEL DIT VERGETEN TE DOEN DEREST WAS PERFECT KHEB GWN BEETJE PROPERDER GEMAAKT

    }

    Label getLblName() {
        return lblName;
    }

    TextField getTfName() {
        return tfName;
    }

    Button getBtnSend() {
        return btnSend;
    }
}
