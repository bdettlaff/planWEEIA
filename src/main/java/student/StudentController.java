package student;

import searching.ConverterCsvToObjects;
import searching.FileOpening;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import searching.Lesson;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class StudentController implements Initializable {

    @FXML
    private ComboBox<String> listOfGroupsComboBox;

    @FXML
    private GridPane schedule;

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


    public void initialize(URL location, ResourceBundle resources) {
        listOfGroupsComboBox.setItems(listOfGroups);
        insertButtonsTest();
    }

    public void insertButtonsTest() {

        FileOpening fileOpening = new FileOpening();
        List<Lesson> listOfLessons;

        fileOpening.openFile();
        listOfLessons = ConverterCsvToObjects.finalListOfLessons;

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 13; j++) {

            }
        }
/*
        int counterOfCommas = 0;
        char signComma = ',';

        for (int z = 0; z < listOfLessons.size(); z++) {
            counterOfCommas = 0;
            Lesson lesson = listOfLessons.get(z);
            int i = 0;
            while (counterOfCommas < 4) {
                if (lesson.charAt(i) == signComma) {
                    counterOfCommas++;
                }
                if (counterOfCommas == 1 && i == 1) {
                    dayOfWeek = i - 1;
                } else if (counterOfCommas == 2 && i == 3) {
                    hourOfLessonBeginning = i - 1;
                } else if (counterOfCommas == 3 && i == 5) {
                    hourOfLessonEnding = i - 1;
                } else if (counterOfCommas == 4 && i > 5) {
                    endOfNameOfLesson = i;
                }
                i++;
            }

            hourOfLessonBeginning = Integer.parseInt(lesson.substring(hourOfLessonBeginning, hourOfLessonBeginning + 1));
            hourOfLessonEnding = Integer.parseInt(lesson.substring(hourOfLessonEnding, hourOfLessonEnding + 1));
            dayOfWeek = Integer.parseInt(lesson.substring(dayOfWeek, dayOfWeek + 1));

            if (hourOfLessonBeginning != 0 || hourOfLessonEnding != 0) {
                for (int j = hourOfLessonBeginning; j < hourOfLessonEnding; j++) {

                }
            }
        }
*/
       /* btn[dayOfWeek][j] = new Button(lesson.substring(hourOfLessonEnding + 2, endOfNameOfLesson));
        btn[dayOfWeek][j].setPrefSize(165, 60);
        schedule.add(btn[dayOfWeek][j], dayOfWeek, j);*/
    }


}
