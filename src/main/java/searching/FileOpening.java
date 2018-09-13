package searching;

import java.io.*;

public class FileOpening {

    public void openFile() throws FileNotFoundException, UnsupportedEncodingException {
        InputStream in = getClass().getResourceAsStream("/plan.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        //File file = new File("resources/plan.txt");;
        ConverterCsvToObjects converterCsvToObjects = new ConverterCsvToObjects();
        String line;

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in,"Windows-1250"));
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




