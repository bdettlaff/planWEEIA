package Searching;

public class Searching {
/*
    Prospector Searching = new Prospector();

    FileReader fr = null;
    String linia = "";

    // OTWIERANIE PLIKU:
                try {
        fr = new FileReader("18mar15plany.txt");
    } catch (FileNotFoundException e) {
        System.out.println("BŁĄD PRZY OTWIERANIU PLIKU!");
        System.exit(1);
    }

    BufferedReader bfr = new BufferedReader(fr);
    // ODCZYT KOLEJNYCH LINII Z PLIKU:
                try {
        while((linia = bfr.readLine()) != null){
            Searching.searchForLecturer("Duch P",linia);
        }
    } catch (IOException e) {
        System.out.println("BŁĄD ODCZYTU Z PLIKU!");
        System.exit(2);
    }

    // ZAMYKANIE PLIKU
                try {
        fr.close();
    } catch (IOException e) {
        System.out.println("BŁĄD PRZY ZAMYKANIU PLIKU!");
        System.exit(3);
    }


    public void searchForLecturer(String Sheet, String Line){
        Pattern surname = Pattern.compile(Sheet);
        Matcher matcher2 = surname.matcher(Line);
        if(matcher2.find())
        {
            int foundBeginningIndex=0;
            int foundEndingIndex=0;
            String group;
            for(int i=0; i<Line.length(); i++) {

                if(Line.charAt(i) == '>') {
                    foundBeginningIndex = i+1;
                }

                if(foundBeginningIndex != 0){
                    for(i=foundBeginningIndex; i<Line.length(); i++){

                        if(Line.charAt(i) == '<') {
                            foundEndingIndex = i;
                            group=Line.substring(foundBeginningIndex,foundEndingIndex);
                            System.out.println(group);
                        }
                    }
                }
            }
        }
    }

*/
}
