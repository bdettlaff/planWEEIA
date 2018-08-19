package searching;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ListOfLessonsTest {

    private ListOfLessons listOfLessons;

    @Before
    public void setUp() throws Exception {
        this.listOfLessons = new ListOfLessons();
    }

    @Test
    public void shouldReturnTrueIfListContainsCorrectAmountOfElements() {
        listOfLessons.splitStringFromCsv("\"Pn 08:15-10:00 1-8\";\"w 1-8\";\"f\";\"Metodologia projektowania\";\"2E418\";\"Glaba M\";\"\";\"6ET.PE\";\"\";\"N\";\"N\";\"\"");
        assertTrue(listOfLessons.getTemporaryStringArray().length == 12 );
        assertFalse(listOfLessons.getTemporaryStringArray().length == 10 );
    }

    @Test
    public void shouldReturnTrueIfListContainsExactlySixElements(){
        listOfLessons.splitStringFromCsv("\"Pn 08:15-10:00 1-8\";\"w 1-8\";\"f\";\"Metodologia projektowania\";\"2E418\";\"Glaba M\";\"\";\"6ET.PE\";\"\";\"N\";\"N\";\"\"");
        listOfLessons.selectNeededStringsFromTemporaryList();
        assertTrue(listOfLessons.getNeededElementsFromTemporaryStringArray().size() == 6);
    }

    @Test
    public void shouldReturnTrueIfIndexTwoContainsNameOfLesson(){
        listOfLessons.splitStringFromCsv("\"Pn 08:15-10:00 1-8\";\"w 1-8\";\"f\";\"Metodologia projektowania\";\"2E418\";\"Glaba M\";\"\";\"6ET.PE\";\"\";\"N\";\"N\";\"\"");
        listOfLessons.selectNeededStringsFromTemporaryList();
        System.out.println(listOfLessons.getNeededElementsFromTemporaryStringArray().get(2));
        assertTrue(listOfLessons.getNeededElementsFromTemporaryStringArray().get(2).equals("\"Metodologia projektowania\""));
    }
}
