package gestion.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;

import java.io.IOException;

public class AccueilController {

    @FXML
    private void goEtudiants(ActionEvent event) {
        changerScene(event, "View.fxml"); // ⚠️ ton fichier réel
    }

    @FXML
    private void goMatieres(ActionEvent event) {
        changerScene(event, "Matieres.fxml");
    }

    @FXML
    private void goNotes(ActionEvent event) {
        changerScene(event, "Notes.fxml");
    }

    @FXML
    private void goResultats(ActionEvent event) {
        changerScene(event, "Resultats.fxml");
    }

    private void changerScene(ActionEvent event, String fxml) {
        try {
            Parent root = FXMLLoader.load(
                    getClass().getResource("/gestion/view/" + fxml)
            );

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}