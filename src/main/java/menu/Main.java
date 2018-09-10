package menu;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application {

    private static Stage primaryStage;


    private void setPrimaryStage(Stage stage) {
        Main.primaryStage = stage;
    }

    static public Stage getPrimaryStage() {
        return Main.primaryStage;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader firstPaneLoader = new FXMLLoader(getClass().getResource("/menu_window.fxml"));
        Parent firstPane = firstPaneLoader.load();
        Scene firstScene = new Scene(firstPane);
       // primaryStage.getIcons().add(new Image("Images/test.png"));
        primaryStage.setTitle("planWEEIA");
        primaryStage.setScene(firstScene);
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
        this.setPrimaryStage(primaryStage);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
