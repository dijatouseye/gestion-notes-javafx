
package gestion.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import java.io.IOException;

public class AccueilController {

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

    // Méthode pour aller à la fenêtre Notes
    @FXML
    private void goNotes() {
        changerScene("/gestion/view/Notes.fxml");
    }

    // Méthode pour aller à la fenêtre Résultats
    @FXML
    private void goResultats() {
        changerScene("/gestion/view/Resultats.fxml");
    }

    // Fonction utilitaire pour changer de scène
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