
package gestion.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import java.io.IOException;

public class accueilcontroller {

    @FXML
    private Button goEtudiants, goMatieres, goNotes, goResultats;

    // Méthode pour aller à la fenêtre Étudiants
    @FXML
    private void goEtudiants() {
        changerScene("/gestion/view/Etudiants.fxml");
    }

    // Méthode pour aller à la fenêtre Matières
    @FXML
    private void goMatieres() {
        changerScene("/gestion/view/Matieres.fxml");
    }


    @FXML
    private void goNotes() {
        changerScene("/gestion/view/Notes.fxml");
    }


    @FXML
    private void goResultats() {
        changerScene("/gestion/view/Resultats.fxml");
    }


    private void changerScene(String fxml) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage) goEtudiants.getScene().getWindow(); // récupère la fenêtre actuelle
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}