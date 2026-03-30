package gestion.model;

public class Matiere {
    private int id;
    private String libelle;
    private int coefficient;

    public Matiere(int id, String libelle, int coefficient) {
        this.id = id;
        this.libelle = libelle;
        this.coefficient = coefficient;
    }

    public int getId() { return id; }
    public String getLibelle() { return libelle; }
    public int getCoefficient() { return coefficient; }
}