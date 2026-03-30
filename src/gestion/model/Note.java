package gestion.model;

public class Note {
    private int id;
    private double valeur;
    private int idEtudiant;
    private int idMatiere;

    public Note(int id, double valeur, int idEtudiant, int idMatiere) {
        this.id = id;
        this.valeur = valeur;
        this.idEtudiant = idEtudiant;
        this.idMatiere = idMatiere;
    }

    public int getId() { return id; }
    public double getValeur() { return valeur; }
}