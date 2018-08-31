package searching;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConverterCsvToObjectsTest {

    private ConverterCsvToObjects listOfLessons;

    @Before
    public void setUp() {
        this.listOfLessons = new ConverterCsvToObjects();
        listOfLessons.splitStringFromCsv("\"Pn 08:15-10:00 1-8\";\"w. 1-8\";\"f\";\"Metodologia projektowania\";\"2E418\";\"Glaba M\";\"\";\"6ET.PE\";\"\";\"N\";\"N\";\"\"");
        listOfLessons.selectNeededStringsFromTemporaryList();
        listOfLessons.deleteQuotationMarksFromStrings();
        listOfLessons.splitDate();
        listOfLessons.convertDotsIntoTypeOfWeek();
        listOfLessons.splitHours();
        listOfLessons.gettingTypeOfLessonFromString();
        listOfLessons.createObject();
        listOfLessons.addToList();
    }

    @Test
    public void shouldReturnTrueIfListContainsCorrectAmountOfElements() {
        assertTrue(listOfLessons.getTemporaryStringArray().length == 12);
        assertFalse(listOfLessons.getTemporaryStringArray().length == 10);
    }

    @Test
    public void shouldReturnTrueIfListContainsExactlySixElements() {
        assertTrue(listOfLessons.getNeededElementsFromTemporaryStringArray().size() == 6);
    }

    @Test
    public void shouldReturnTrueIfIndexTwoContainsNameOfLesson() {
        assertTrue(listOfLessons.getNeededElementsFromTemporaryStringArray().get(2).equals("\"Metodologia projektowania\""));
    }

    @Test
    public void shouldReturnTrueIfStringDoesNotContainsQuotationMarks() {
        boolean isQuotiationMark = false;

        for (int i = 0; i < listOfLessons.getElementsWithoutQuotationMarks().size(); i++) {
            if (listOfLessons.getElementsWithoutQuotationMarks().get(i).contains("\"")) {
                isQuotiationMark = true;
            }
        }
        assertTrue(!isQuotiationMark);
    }

    @Test
    public void shouldReturnTrueIfArrayListContainsExactlyThreeElements() {
        assertTrue(listOfLessons.getDateList().length == 3);
    }

    @Test
    public void shouldReturnTrueIfTypeOfWeekIsX1() {
        assertTrue(listOfLessons.getTypeOfWeek()==1);
    }

    @Test
    public void shouldReturnTrueIfStartAndEndTimeIsSplit(){
        assertTrue(listOfLessons.getTimeOfBeginningAndEnding()[0].equals("08:15") && listOfLessons.getTimeOfBeginningAndEnding()[1].equals("10:00"));
    }

    @Test
    public void shouldReturnTrueIfTypeOfLessonIsW(){
        assertTrue(listOfLessons.getTypeOfLesson().equals("w"));
    }

    @Test
    public void shouldReturnTrueIfObjectHasProperNamesOnTheAppropriateFields(){
        assertTrue(listOfLessons.getLesson().getDayOfWeek().equals("Pn"));
        assertTrue(listOfLessons.getLesson().getStartTime().equals("08:15"));
        assertTrue(listOfLessons.getLesson().getEndTime().equals("10:00"));
        assertTrue(listOfLessons.getLesson().getWeeks().equals("1-8"));
        assertTrue(listOfLessons.getLesson().getType().equals("w"));
        assertTrue(listOfLessons.getLesson().getTypeOfWeek()==1);
        assertTrue(listOfLessons.getLesson().getName().equals("Metodologia projektowania"));
        assertTrue(listOfLessons.getLesson().getLocation().equals("2E418"));
        assertTrue(listOfLessons.getLesson().getNameOfLecturer().equals("Glaba M"));
        assertTrue(listOfLessons.getLesson().getGroups().get(0).equals("6ET.PE"));

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 13; j++) {
                System.out.println(i+j+"");
            }
            System.out.println("\n");
        }
    }
}