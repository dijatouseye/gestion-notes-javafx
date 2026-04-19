package gestion.controller;

import gestion.dao.EtudiantDAO;
import gestion.model.Etudiant;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.*;
// modification test
public class EtudiantController {
    // modification test
    @FXML
    private VBox contentArea;

    private EtudiantDAO dao = new EtudiantDAO();

    private Map<String, List<Double>> notes = new HashMap<>();

    @FXML
    public void initialize() {
        showAccueil();
    }

    // ===== ACCUEIL =====
    @FXML
    private void showAccueil() {

        Label title = new Label("Bienvenue sur la Gestion des Notes");
        title.setStyle("-fx-font-size:26; -fx-font-weight:bold;");

        Label subtitle = new Label("Sélectionnez une option pour commencer");

        Button b1 = createBtn("Étudiants", "#3498db", this::showEtudiants);
        Button b2 = createBtn("Matières", "#2ecc71", this::showMatieres);
        Button b3 = createBtn("Notes", "#e67e22", this::showNotes);
        Button b4 = createBtn("Résultats", "#9b59b6", this::showResultats);

        VBox box = new VBox(15, b1, b2, b3, b4);
        box.setAlignment(Pos.CENTER);

        contentArea.getChildren().setAll(title, subtitle, box);
    }

    private Button createBtn(String text, String color, Runnable action) {
        Button btn = new Button(text);
        btn.setStyle("-fx-background-color:" + color +
                "; -fx-text-fill:white; -fx-font-size:16px; -fx-padding:10 40; -fx-background-radius:10;");
        btn.setOnAction(e -> action.run());
        return btn;
    }

    // ===== ETUDIANTS =====
    @FXML
    private void showEtudiants() {

        Label title = new Label("Gestion des Étudiants");
        title.setStyle("-fx-font-size:22; -fx-font-weight:bold;");

        TextField nom = new TextField();
        nom.setPromptText("Nom");

        TextField prenom = new TextField();
        prenom.setPromptText("Prénom");

        Button ajouter = new Button("Ajouter");
        ajouter.setStyle("-fx-background-color:#3498db; -fx-text-fill:white;");

        TableView<Etudiant> table = new TableView<>();

        TableColumn<Etudiant, Integer> colId = new TableColumn<>("ID");
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Etudiant, String> colNom = new TableColumn<>("Nom");
        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));

        TableColumn<Etudiant, String> colPrenom = new TableColumn<>("Prénom");
        colPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));

        table.getColumns().addAll(colId, colNom, colPrenom);
        table.setItems(FXCollections.observableArrayList(dao.getAll()));

        ajouter.setOnAction(e -> {
            dao.ajouter(new Etudiant(0, nom.getText(), prenom.getText()));
            table.setItems(FXCollections.observableArrayList(dao.getAll()));
        });

        contentArea.getChildren().setAll(title, nom, prenom, ajouter, table);
    }

    // ===== MATIERES =====
    @FXML
    private void showMatieres() {

        Label title = new Label("Gestion des Matières");
        title.setStyle("-fx-font-size:22; -fx-font-weight:bold;");

        TextField matiere = new TextField();
        matiere.setPromptText("Nom matière");

        TextField coef = new TextField();
        coef.setPromptText("Coefficient");

        Button ajouter = new Button("Ajouter");
        ajouter.setStyle("-fx-background-color:#2ecc71; -fx-text-fill:white;");

        ListView<String> list = new ListView<>();

        ajouter.setOnAction(e -> {
            list.getItems().add(matiere.getText() + " (coef " + coef.getText() + ")");
        });

        contentArea.getChildren().setAll(title, matiere, coef, ajouter, list);
    }

    // ===== NOTES =====
    @FXML
    private void showNotes() {

        Label title = new Label("Gestion des Notes");
        title.setStyle("-fx-font-size:22; -fx-font-weight:bold;");

        TextField nom = new TextField();
        nom.setPromptText("Nom étudiant");

        TextField note = new TextField();
        note.setPromptText("Note /20");

        Button ajouter = new Button("Ajouter");
        ajouter.setStyle("-fx-background-color:#e67e22; -fx-text-fill:white;");

        ListView<String> list = new ListView<>();

        ajouter.setOnAction(e -> {
            double n = Double.parseDouble(note.getText());
            notes.computeIfAbsent(nom.getText(), k -> new ArrayList<>()).add(n);
            list.getItems().add(nom.getText() + " : " + n);
        });

        contentArea.getChildren().setAll(title, nom, note, ajouter, list);
    }

    // ===== RESULTATS =====
    @FXML
    private void showResultats() {

        Label title = new Label("Classement des étudiants");
        title.setStyle("-fx-font-size:22; -fx-font-weight:bold;");

        ListView<String> classement = new ListView<>();

        Map<String, Double> moyennes = new HashMap<>();

        for (String nom : notes.keySet()) {
            List<Double> list = notes.get(nom);

            double somme = 0;
            for (double n : list) somme += n;

            double moy = list.isEmpty() ? 0 : somme / list.size();
            moyennes.put(nom, moy);
        }

        List<Map.Entry<String, Double>> sorted = new ArrayList<>(moyennes.entrySet());
        sorted.sort((a, b) -> Double.compare(b.getValue(), a.getValue()));

        int i = 1;
        for (Map.Entry<String, Double> e : sorted) {
            classement.getItems().add(i + ". " + e.getKey() + " → " + String.format("%.2f", e.getValue()));
            i++;
        }

        contentArea.getChildren().setAll(title, classement);
    }
}