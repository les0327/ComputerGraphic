package lab4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created on 18.04.2017.
 *
 * @author Les.
 * @version 1.0.
 */
public class Lab4 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = new FXMLLoader().load(getClass().getResourceAsStream("/fxml/lab4.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Lab4");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
