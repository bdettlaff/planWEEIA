package searching;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class ConverterCsvToObjects {

    private String[] temporaryStringArray;
    private List<String> neededElementsFromTemporaryStringArray = new ArrayList<String>();
    private List<String> elementsWithoutQuotationMarks = new ArrayList<String>();
    private String[] dateList;
    private String[] timeOfBeginningAndEnding;
    private int typeOfWeek;
    private String typeOfLesson;
    private Lesson lesson = new Lesson();

    public String[] getTimeOfBeginningAndEnding() {
        return timeOfBeginningAndEnding;
    }

    public String getTypeOfLesson() {
        return typeOfLesson;
    }

    public void setTypeOfLesson(String typeOfLesson) {
        this.typeOfLesson = typeOfLesson;
    }

    public void setTimeOfBeginningAndEnding(String[] timeOfBeginningAndEnding) {
        this.timeOfBeginningAndEnding = timeOfBeginningAndEnding;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public void setTypeOfWeek(int typeOfWeek) {
        this.typeOfWeek = typeOfWeek;
    }

    public int getTypeOfWeek() {
        return typeOfWeek;
    }

    public String[] getDateList() {
        return dateList;
    }

    public void setDateList(String[] dateList) {
        this.dateList = dateList;
    }

    public List<String> getElementsWithoutQuotationMarks() {
        return elementsWithoutQuotationMarks;
    }

    public List<String> getNeededElementsFromTemporaryStringArray() {
        return neededElementsFromTemporaryStringArray;
    }

    public void setTemporaryStringArray(String[] temporaryLesson) {
        this.temporaryStringArray = temporaryLesson;
    }

    public String[] getTemporaryStringArray() {
        return temporaryStringArray;
    }

    public void splitStringFromCsv(String stringFromCsv) {
        setTemporaryStringArray(stringFromCsv.split(";"));
    }

    public void selectNeededStringsFromTemporaryList() {
        neededElementsFromTemporaryStringArray.add(temporaryStringArray[0]);
        neededElementsFromTemporaryStringArray.add(temporaryStringArray[1]);
        neededElementsFromTemporaryStringArray.add(temporaryStringArray[3]);
        neededElementsFromTemporaryStringArray.add(temporaryStringArray[4]);
        neededElementsFromTemporaryStringArray.add(temporaryStringArray[5]);
        neededElementsFromTemporaryStringArray.add(temporaryStringArray[7]);
    }

    public void deleteQuotationMarksFromStrings() {
        String temporaryString;
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

        setLesson(lesson);
    }
}
