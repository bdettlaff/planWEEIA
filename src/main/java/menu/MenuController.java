package menu;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;

import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {

    @FXML
    private void studentButton_onMouseClicked(MouseEvent event) throws IOException{
        Parent window1;
        window1 = FXMLLoader.load(getClass().getResource("/student/student_window.fxml"));
        Scene newSceneWindow1 = new Scene(window1);
        Stage mainStage;
        mainStage = Main.getPrimaryStage();
        mainStage.setScene(newSceneWindow1);
        mainStage.show();
    }

    @FXML
    private void lecturerButton_onMouseClicked(MouseEvent event) throws IOException{
        Parent window1;
        window1 = FXMLLoader.load(getClass().getResource("/lecturer/lecturer_window.fxml"));
        Scene newSceneWindow1 = new Scene(window1);
        Stage mainStage;
        mainStage = Main.getPrimaryStage();
        mainStage.setScene(newSceneWindow1);
        mainStage.show();
    }

}
