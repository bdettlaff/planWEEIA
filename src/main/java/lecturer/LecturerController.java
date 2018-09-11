package lecturer;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextArea;
import lombok.Getter;
import lombok.Setter;
import searching.ConverterCsvToObjects;
import searching.FileOpening;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import searching.Lesson;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

@Getter
@Setter
public class LecturerController implements Initializable {

    @FXML
    private ComboBox<String> listOfNamesComboBox;

    @FXML
    private GridPane schedule;

    @FXML
    private ComboBox<String> typeOfWeekComboBox;

    private int selectedTypeOfWeek;
    private String selectedName = "";

    private ArrayList<String> daysOfTheWeek = new ArrayList<String>() {{
        add("Poniedziałek");
        add("Wtorek");
        add("Sroda");
        add("Czwartek");
        add("Piątek");
    }};

    private ArrayList<String> hoursInTheDay = new ArrayList<String>() {{
        add("8:00");
        add("9:00");
        add("10:00");
        add("11:00");
        add("12:00");
        add("13:00");
        add("14:00");
        add("15:00");
        add("16:00");
        add("17:00");
        add("18:00");
        add("19:00");
        add("20:00");
    }};

    private List<Lesson> lessonsOfSelectedName = new ArrayList<Lesson>();
    private List<Integer> indexesOfDays = new ArrayList<Integer>();
    private List<Integer> indexesOfHoursBeginning = new ArrayList<Integer>();
    private List<Integer> indexesOfHoursEnding = new ArrayList<Integer>();

    private ObservableList<String> listOfNames = FXCollections.observableArrayList();

    private ObservableList<String> typeOfWeek = FXCollections.observableArrayList(   "x1",
            "x2");

    public void initialize(URL location, ResourceBundle resources) {
        listOfNamesComboBox.setItems(listOfNames);
        typeOfWeekComboBox.setItems(typeOfWeek);
        try {
            insertButtonsTest();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public void insertButtonsTest() throws FileNotFoundException, UnsupportedEncodingException {

        FileOpening fileOpening = new FileOpening();
        List<Lesson> listOfLessons;

        fileOpening.openFile();
        listOfLessons = ConverterCsvToObjects.finalListOfLessons;

        for(int i = 0; i<listOfLessons.size(); i++){
            addToListOfNames(listOfLessons.get(i).getNameOfLecturer());
        }

        sortListOfNames();

        typeOfWeekComboBox.getSelectionModel().selectedItemProperty()
                .addListener(new ChangeListener<String>() {
                    public void changed(ObservableValue<? extends String> observable,
                                        String oldValue, String newValue) {
                        newValue = newValue.substring(1,2);
                        setSelectedTypeOfWeek(Integer.parseInt(newValue));
                    }
                });

        listOfNamesComboBox.getSelectionModel().selectedItemProperty()
                .addListener(new ChangeListener<String>() {
                    public void changed(ObservableValue<? extends String> observable,
                                        String oldValue, String newValue) {
                        setSelectedName(newValue);
                    }
                });

        printNameOfDay();
        printHourOfDay();

        filterLessonsByLecturer(getSelectedName(), listOfLessons);
        filterLessonsByWeek(getSelectedTypeOfWeek());

        transformHoursAndWeeks();

        printLessons();
    }

    private void printLessons(){
        int z=0;

        while(z<getIndexesOfDays().size()){
            for (int i = 1; i < 6; i++) {
                for (int j = 1; j < 13; j++) {

                    if(getIndexesOfDays().get(z).equals(i)){
                        if(getIndexesOfHoursBeginning().get(z).equals(j)){
                            TextArea textarea = new TextArea();
                            textarea.setText(getLessonsOfSelectedName().get(z).getName());
                            textarea.setStyle("-fx-opacity: 1;");
                            textarea.setDisable(true);
                            schedule.add(textarea, i, j);
                        }
                    }
                }
            }
            z++;
        }
    }

    private void transformHoursAndWeeks(){
        List<Integer> temporary = new ArrayList<Integer>();
        for(int i = 0; i< getLessonsOfSelectedName().size(); i++){
            temporary.add(matchTheDayOfWeek(getLessonsOfSelectedName().get(i).getDayOfWeek()));
        }
        setIndexesOfDays(temporary);

        temporary = new ArrayList<Integer>();
        for(int i = 0; i< getLessonsOfSelectedName().size(); i++){
            temporary.add(matchTheHoursOfDay(getLessonsOfSelectedName().get(i).getStartTime()));
        }
        setIndexesOfHoursBeginning(temporary);

        temporary = new ArrayList<Integer>();
        for(int i = 0; i< getLessonsOfSelectedName().size(); i++){
            temporary.add(matchTheHoursOfDay(getLessonsOfSelectedName().get(i).getEndTime()));
        }
        setIndexesOfHoursEnding(temporary);
    }

    private void printNameOfDay() {
        int j = 0;
        for (int i = 1; i < 6; i++) {
            TextArea textarea = new TextArea();
            textarea.setText(daysOfTheWeek.get(i-1));
            textarea.setStyle("-fx-opacity: 1;");
            textarea.setId("Label"+daysOfTheWeek.get(i-1));
            textarea.setDisable(true);
            schedule.add(textarea, i, j);
        }
    }

    private void printHourOfDay(){
        int i = 0;
        for (int j = 1; j < 13; j++) {
            TextArea textarea = new TextArea();
            textarea.setText(hoursInTheDay.get(j-1));
            textarea.setStyle("-fx-opacity: 1;");
            textarea.setId("Label"+hoursInTheDay.get(j-1));
            textarea.setDisable(true);
            schedule.add(textarea,i,j);
        }
    }

    private int matchTheHoursOfDay(String time){
        int hour = Integer.parseInt(time.substring(0,2));
        return hour-7;
    }

    private int matchTheDayOfWeek(String dayOfWeek){
        if(dayOfWeek.equals("Pn")){
            return 1;
        }else if(dayOfWeek.equals("Wt")){
            return 2;
        }else if(dayOfWeek.equals("Czw")){
            return 4;
        }
        else if(dayOfWeek.equals("Pt")){
            return 5;
        }else{
            return 3;
        }
    }

    private void addToListOfNames(String name){
        boolean isDuplicated = false;
        ObservableList<String> temporary = FXCollections.observableArrayList();
        temporary = getListOfNames();
        if(name.length()>=1){
            for(int i=0;i<temporary.size();i++){
                if(temporary.get(i).equals(name)){
                    isDuplicated = true;
                    break;
                }
            }

            if(isDuplicated==false){
                temporary.add(name);
                setListOfNames(temporary);
            }
        }
    }

    private void sortListOfNames(){
        ObservableList<String> temporary = FXCollections.observableArrayList();
        temporary = getListOfNames();
        Collections.sort(temporary);
        setListOfNames(temporary);
    }

    private void filterLessonsByWeek(int weekToFilter){
        List<Lesson> temporary = new ArrayList<Lesson>();

        if(weekToFilter!=1 && weekToFilter !=2){
            weekToFilter=0;
            setSelectedTypeOfWeek(weekToFilter);
        }

        for(int i = 0; i< getLessonsOfSelectedName().size(); i++){
            System.out.println(getLessonsOfSelectedName().get(i).getTypeOfWeek());
            if(getLessonsOfSelectedName().get(i).getTypeOfWeek()==weekToFilter){
                temporary.add(getLessonsOfSelectedName().get(i));
            }
        }

        setLessonsOfSelectedName(temporary);
    }
    
    private void filterLessonsByLecturer(String nameToFilter, List<Lesson> listOfLessons){
        List<Lesson> temporary = new ArrayList<Lesson>();

        if(nameToFilter.equals("")){
            nameToFilter="Duch P";
            setSelectedName(nameToFilter);
        }

        for(int i=0; i<listOfLessons.size(); i++){
            if(listOfLessons.get(i).getNameOfLecturer().equals(nameToFilter)){
                temporary.add(listOfLessons.get(i));
            }
        }

        setLessonsOfSelectedName(temporary);
    }
}