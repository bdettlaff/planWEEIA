package searching;

import java.io.*;

public class FileOpening {

    public void openFile() throws FileNotFoundException, UnsupportedEncodingException {
        File file = new File("plan.txt");;
        ConverterCsvToObjects converterCsvToObjects = new ConverterCsvToObjects();
        String line;

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"ISO-8859-2"));
        try {
            while((line = bufferedReader.readLine()) != null){
                converterCsvToObjects.convertStringToLessonObject(line);
            }
        } catch (IOException e) {
            System.out.println("BŁĄD ODCZYTU Z PLIKU!");
            System.exit(2);
        }
    }
}




