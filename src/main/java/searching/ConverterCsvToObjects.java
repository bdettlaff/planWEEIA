package searching;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class ConverterCsvToObjects {


    public static List<Lesson> finalListOfLessons = new ArrayList<Lesson>();

    private String[] temporaryStringArray;
    private List<String> neededElementsFromTemporaryStringArray = new ArrayList<String>();
    private List<String> elementsWithoutQuotationMarks = new ArrayList<String>();
    private String[] dateList;
    private String[] timeOfBeginningAndEnding;
    private int typeOfWeek;
    private String typeOfLesson;
    private Lesson lesson = new Lesson();


    public void splitStringFromCsv(String stringFromCsv) {
        setTemporaryStringArray(stringFromCsv.split(";"));
    }

    public void selectNeededStringsFromTemporaryList() {
        List<String> temporaryList = new ArrayList<String>();
        temporaryList.add(temporaryStringArray[0]);
        temporaryList.add(temporaryStringArray[1]);
        temporaryList.add(temporaryStringArray[3]);
        temporaryList.add(temporaryStringArray[4]);
        temporaryList.add(temporaryStringArray[5]);
        temporaryList.add(temporaryStringArray[7]);
        System.out.println(temporaryList.get(0));
        setNeededElementsFromTemporaryStringArray(temporaryList);
    }

    public void deleteQuotationMarksFromStrings() {
        String temporaryString;
        List<String> temporaryList = new ArrayList<String>();
        for (int i = 0; i < neededElementsFromTemporaryStringArray.size(); i++) {
            temporaryString = neededElementsFromTemporaryStringArray.get(i).replace("\"", "");
            elementsWithoutQuotationMarks.add(temporaryString);
        }
    }

    public void splitDate() {
        String temporaryString = elementsWithoutQuotationMarks.get(0);
        setDateList(temporaryString.split(" "));
    }

    public void convertDotsIntoTypeOfWeek(){
        int occurrence =  getElementsWithoutQuotationMarks().get(1).length() - getElementsWithoutQuotationMarks().get(1).replace(".", "").length();

        if(occurrence == 1){
            setTypeOfWeek(1);
        }else{
            setTypeOfWeek(2);
        }
    }

    public void gettingTypeOfLessonFromString(){
        setTypeOfLesson(getElementsWithoutQuotationMarks().get(1).substring(0,1));
    }

    public void splitHours(){
        setTimeOfBeginningAndEnding(getDateList()[1].split("-"));
    }

    public void createObject(){
        Lesson lesson = new Lesson();
        List<String> listOfGroups = new ArrayList<String>();
        lesson.setDayOfWeek(getDateList()[0]);
        lesson.setStartTime(getTimeOfBeginningAndEnding()[0]);
        lesson.setEndTime(getTimeOfBeginningAndEnding()[1]);
        lesson.setWeeks(getDateList()[2]);
        lesson.setType(getTypeOfLesson());
        lesson.setTypeOfWeek(getTypeOfWeek());
        lesson.setName(getElementsWithoutQuotationMarks().get(2));
        lesson.setLocation(getElementsWithoutQuotationMarks().get(3));
        lesson.setNameOfLecturer(getElementsWithoutQuotationMarks().get(4));
        listOfGroups.add(getElementsWithoutQuotationMarks().get(5));
        lesson.setGroups(listOfGroups);
        //printElementsOfLesson(lesson);
        setLesson(lesson);
    }

    public void addToList(){
        finalListOfLessons.add(getLesson());
    }

    public void convertStringToLessonObject(String lineFromFile){
        splitStringFromCsv(lineFromFile);
        selectNeededStringsFromTemporaryList();
        deleteQuotationMarksFromStrings();
        splitDate();
        convertDotsIntoTypeOfWeek();
        splitHours();
        gettingTypeOfLessonFromString();
        createObject();
        addToList();
    }

    public void printElementsOfLesson(Lesson lesson){
        System.out.println(lesson.getDayOfWeek()+" "+
                lesson.getStartTime()+" "+
                lesson.getEndTime()+" "+
                lesson.getWeeks()+" "+
                lesson.getType()+" "+
                lesson.getTypeOfWeek()+" "+
                lesson.getName()+" "+
                lesson.getLocation()+" "+
                lesson.getNameOfLecturer()+" "+
                lesson.getGroups().get(0));
    }
}
