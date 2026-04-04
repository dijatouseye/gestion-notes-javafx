import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Charger le FXML dans un Parent
        Parent root = FXMLLoader.load(getClass().getResource("/gestion/view/View.fxml"));

        // Créer la scène avec ce root
        Scene scene = new Scene(root, 800, 600);

        // Ajouter le CSS
        scene.getStylesheets().add(
                getClass().getResource("/gestion/view/Style.css").toExternalForm()
        );

        // Configurer la scène sur le stage
        stage.setScene(scene);
        stage.setTitle("Gestion des étudiants");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}