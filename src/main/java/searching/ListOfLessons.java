package searching;

import java.util.*;

public class ListOfLessons {
    private String[] temporaryStringArray;
    private List<String> neededElementsFromTemporaryStringArray = new ArrayList<String>();


    public List<String> getNeededElementsFromTemporaryStringArray() {
        return neededElementsFromTemporaryStringArray;
    }

    public void setNeededElementsFromTemporaryStringArray(List<String> neededElementsFromTemporaryStringArray) {
        this.neededElementsFromTemporaryStringArray = neededElementsFromTemporaryStringArray;
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


}
