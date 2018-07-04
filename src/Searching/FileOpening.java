package Searching;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileOpening {

    public void openFile(String group){
        FileReader fr = null;
        String linia = "";

        try {
            fr = new FileReader("18june06.txt");
        } catch (FileNotFoundException e) {
            System.out.println("BŁĄD PRZY OTWIERANIU PLIKU!");
            System.exit(1);
        }

        BufferedReader bfr = new BufferedReader(fr);
        try {
            while((linia = bfr.readLine()) != null){
                Searching.searchForLesson(group,linia);
            }
        } catch (IOException e) {
            System.out.println("BŁĄD ODCZYTU Z PLIKU!");
            System.exit(2);
        }

        try {
            fr.close();
        } catch (IOException e) {
            System.out.println("BŁĄD PRZY ZAMYKANIU PLIKU!");
            System.exit(3);
        }
    }
}




