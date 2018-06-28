package Student;

import Searching.Searching;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import java.net.URL;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class StudentController implements Initializable {
    @FXML
    private ComboBox<String> listOfGroupsComboBox;

    @FXML
    private GridPane schedule;

    private Button[][] btn = new Button[6][13];

    private ArrayList<String> daysOfTheWeek = new ArrayList<String>() {{
        add("Poniedziałek");
        add("Wtorek");
        add("Sroda");
        add("Czwartek");
        add("Piątek");
    }};

    private ArrayList<String> hoursInTheDay = new ArrayList<String>() {{
        add("8.00");
        add("9.00");
        add("10.00");
        add("11.00");
        add("12.00");
        add("13.00");
        add("14.00");
        add("15.00");
        add("16.00");
        add("17.00");
        add("18.00");
        add("19.00");
    }};

    private ObservableList<String> listOfGroups =
            FXCollections.observableArrayList(
                    "4I04",
                    "4I05",
                    "4I06"
            );

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listOfGroupsComboBox.setItems(listOfGroups);
        insertButtonsTest();
    }

    public void insertButtonsTest() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 13; j++) {
                if (j == 0 && i!=0) {
                    btn[i][j] = new Button(daysOfTheWeek.get(i-1));
                   // System.out.println(s.indexOf(" "));
                    btn[i][j].setPrefSize(165, 60);
                    schedule.add(btn[i][j], i, j);
                } else if (i == 0 && j!=0) {
                    btn[i][j] = new Button(hoursInTheDay.get(j-1));
                    btn[i][j].setPrefSize(165, 60);
                    schedule.add(btn[i][j], i, j);
                } else if( i == 0 && j ==0){
                    btn[i][j] = new Button();
                    btn[i][j].setPrefSize(165, 60);
                    schedule.add(btn[i][j], i, j);
                } else {
                    btn[i][j] = new Button("1-15\n Podstawy programowania\n II i24 CTI406\n Cisłak A.");
                    btn[i][j].setPrefSize(165, 60);
                    schedule.add(btn[i][j], i, j);
                }

            }
        }

        Searching test = new Searching();
        test.openFile();
    }


}
