package searching;

import java.util.*;

public class ConverterCsvToObjects {

    private String[] temporaryStringArray;
    private List<String> neededElementsFromTemporaryStringArray = new ArrayList<String>();
    private List<String> elementsWithoutQuotationMarks = new ArrayList<String>();
    private String[] dateList;

    private int typeOfWeek;

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
}
