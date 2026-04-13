package gestion.controller;

import gestion.dao.EtudiantDAO;
import gestion.model.Etudiant;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class etudiantcontroller {

    @FXML private TableView<Etudiant> table;
    @FXML private TableColumn<Etudiant, Integer> colId;
    @FXML private TableColumn<Etudiant, String> colNom;
    @FXML private TableColumn<Etudiant, String> colPrenom;

    @FXML private TextField nomField;
    @FXML private TextField prenomField;

    private EtudiantDAO dao = new EtudiantDAO();

    @FXML
    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));

        chargerTable();
    }

    @FXML
    public void ajouterEtudiant() {
        Etudiant e = new Etudiant(0, nomField.getText(), prenomField.getText());
        dao.ajouter(e);
        chargerTable();
    }

    private void chargerTable() {
        table.setItems(FXCollections.observableArrayList(dao.getAll()));
    }
}