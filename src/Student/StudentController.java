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

        Searching searching = new Searching();
        searching.openFile();
        ArrayList<String> listOfLessons = new ArrayList<String>();
        int dayOfWeek=0;
        int hourOfLessonBeginning=0;
        int hourOfLessonEnding=0;
        int endOfNameOfLesson=0;

        listOfLessons=searching.getListOfLessons();


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
                    btn[i][j] = new Button("");
                    btn[i][j].setPrefSize(165, 60);
                    schedule.add(btn[i][j], i, j);
                }

            }
        }

        listOfLessons=searching.getListOfLessons();

        int counterOfCommas = 0;
        char signComma = ',';

        for(int z=0;z<listOfLessons.size();z++) {
            counterOfCommas=0;
            String lesson = listOfLessons.get(z);
            int i=0;
                while (counterOfCommas < 4) {
                    if (lesson.charAt(i) == signComma) {
                        counterOfCommas++;
                    }
                    if (counterOfCommas == 1 && i == 1) {
                        dayOfWeek = i-1;
                    } else if (counterOfCommas == 2 && i == 3) {
                        hourOfLessonBeginning = i-1;
                    } else if (counterOfCommas == 3 && i == 5) {
                        hourOfLessonEnding= i-1;
                    } else if (counterOfCommas == 4 && i > 5) {
                        endOfNameOfLesson = i;
                    }
                    i++;
                }
            System.out.println(z+" to jest lekcja,"+dayOfWeek+","+hourOfLessonBeginning+","+hourOfLessonEnding+","+lesson);
            hourOfLessonBeginning = Integer.parseInt(lesson.substring(hourOfLessonBeginning,hourOfLessonBeginning+1));
            hourOfLessonEnding = Integer.parseInt(lesson.substring(hourOfLessonEnding,hourOfLessonEnding+1));
            dayOfWeek = Integer.parseInt(lesson.substring(dayOfWeek, dayOfWeek + 1));


            if(hourOfLessonBeginning != 0 || hourOfLessonEnding != 0 ) {
                for (int j = hourOfLessonBeginning; j < hourOfLessonEnding; j++) {
                    btn[dayOfWeek][j] = new Button(lesson.substring(hourOfLessonEnding + 2, endOfNameOfLesson));
                    btn[dayOfWeek][j].setPrefSize(165, 60);
                    schedule.add(btn[dayOfWeek][j], dayOfWeek, j);
                    System.out.println("TU JESTEM");
                }
            }
        }
    }


}
