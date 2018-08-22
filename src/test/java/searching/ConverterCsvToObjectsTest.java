package searching;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConverterCsvToObjectsTest {

    private ConverterCsvToObjects listOfLessons;


    @Before
    public void setUp() {
        this.listOfLessons = new ConverterCsvToObjects();
        listOfLessons.splitStringFromCsv("\"Pn 08:15-10:00 1-8\";\"w 1-8\";\"f\";\"Metodologia projektowania\";\"2E418\";\"Glaba M\";\"\";\"6ET.PE\";\"\";\"N\";\"N\";\"\"");
        listOfLessons.selectNeededStringsFromTemporaryList();
        listOfLessons.deleteQuotationMarksFromStrings();
        listOfLessons.splitDate();
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
        boolean isQuatiationMark = false;

        for (int i = 0; i < listOfLessons.getElementsWithoutQuotationMarks().size(); i++) {
            if (listOfLessons.getElementsWithoutQuotationMarks().get(i).contains("\"")) {
                isQuatiationMark = true;
            }
        }
        assertTrue(!isQuatiationMark);
    }

    @Test
    public void shouldReturnTrueIfArrayListContainsExactlyThreeElements() {
        assertTrue(listOfLessons.getDateList().length == 3);
    }

    @Test
    public void shouldReturnTrueIfTypeOfWeekIsX1() {

    }
}