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

        assertTrue(this.listOfLessons.sex == "0");
    }
}