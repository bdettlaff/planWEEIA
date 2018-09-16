package menu;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class MenuController {

    @FXML
    private Button updatePlan;

    @FXML
    private void studentButton_onMouseClicked(MouseEvent event) throws IOException{
        Parent window1;
        window1 = FXMLLoader.load(getClass().getResource("/student_window.fxml"));
        Scene newSceneWindow1 = new Scene(window1);
        Stage mainStage;
        mainStage = Main.getPrimaryStage();
        mainStage.setScene(newSceneWindow1);
        mainStage.centerOnScreen();
        mainStage.show();
    }

    @FXML
    private void lecturerButton_onMouseClicked(MouseEvent event) throws IOException{
        Parent window1;
        window1 = FXMLLoader.load(getClass().getResource("/lecturer_window.fxml"));
        Scene newSceneWindow1 = new Scene(window1);
        Stage mainStage;
        mainStage = Main.getPrimaryStage();
        mainStage.setScene(newSceneWindow1);
        mainStage.centerOnScreen();
        mainStage.show();
    }

    @FXML
    private void downloadUsingNIO(MouseEvent event) throws IOException {

        String urlStr = "http://kgrudzi.iis.p.lodz.pl/index_PI.htm";
        String file = System.getProperty("user.home") + "\\plan.txt";

        URL url = new URL(urlStr);
        ReadableByteChannel rbc = Channels.newChannel(url.openStream());
        FileOutputStream fos = new FileOutputStream(file);
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        fos.close();
        rbc.close();

        File f = new File(file);
        if(f.exists() && !f.isDirectory()) {
            updatePlan.setText("Plan został zaktualizowany");
            updatePlan.setDisable(true);
            updatePlan.setLayoutX(143);
            updatePlan.setLayoutY(235);
        }
    }

}
