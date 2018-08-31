package searching;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileOpening {

    public void openFile(){
        FileReader fileReader = null;
        ConverterCsvToObjects converterCsvToObjects = new ConverterCsvToObjects();
        String line;


        try {
            fileReader = new FileReader("18june06.txt");
        } catch (FileNotFoundException e) {
            System.out.println("BŁĄD PRZY OTWIERANIU PLIKU!");
            System.exit(1);
        }

        BufferedReader bufferedReader = new BufferedReader(fileReader);
        try {
            while((line = bufferedReader.readLine()) != null){
                converterCsvToObjects.convertStringToLessonObject(line);
            }
        } catch (IOException e) {
            System.out.println("BŁĄD ODCZYTU Z PLIKU!");
            System.exit(2);
        }

        try {
            fileReader.close();
        } catch (IOException e) {
            System.out.println("BŁĄD PRZY ZAMYKANIU PLIKU!");
            System.exit(3);
        }
    }
}




