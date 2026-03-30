package gestion.dao;

import gestion.database.DatabaseConnection;
import gestion.model.Etudiant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EtudiantDAO {

    public void ajouter(Etudiant e) {
        String sql = "INSERT INTO etudiant(nom, prenom) VALUES (?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, e.getNom());
            ps.setString(2, e.getPrenom());
            ps.executeUpdate();

        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public List<Etudiant> getAll() {
        List<Etudiant> list = new ArrayList<>();
        String sql = "SELECT * FROM etudiant";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Etudiant(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("prenom")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public void modifier(Etudiant e) {
        String sql = "UPDATE etudiant SET nom=?, prenom=? WHERE id=?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, e.getNom());
            ps.setString(2, e.getPrenom());
            ps.setInt(3, e.getId());
            ps.executeUpdate();

        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public void supprimer(int id) {
        String sql = "DELETE FROM etudiant WHERE id=?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
