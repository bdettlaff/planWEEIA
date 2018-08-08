package searching;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileOpening {

    public void openFile(String group){
        FileReader fileReader = null;
        String line;

        Searching searching = new Searching();

        try {
            fileReader = new FileReader("18june06.txt");
        } catch (FileNotFoundException e) {
            System.out.println("BŁĄD PRZY OTWIERANIU PLIKU!");
            System.exit(1);
        }

        BufferedReader bufferedReader = new BufferedReader(fileReader);
        try {
            while((line = bufferedReader.readLine()) != null){
                searching.searchForLesson(group,line);
            }
        } catch (IOException e) {
            System.out.println("BŁĄD ODCZYTU Z PLIKU!");
            System.exit(2);
        }

        searching.printListOfLessons();

        try {
            fileReader.close();
        } catch (IOException e) {
            System.out.println("BŁĄD PRZY ZAMYKANIU PLIKU!");
            System.exit(3);
        }
    }
}




