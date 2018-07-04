package Searching;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Searching {


    public static void searchForLesson(String Sheet, String Line){
        Pattern patternLine = Pattern.compile(Sheet);
        Matcher matcherLine = patternLine.matcher(Line);
        String result="";
        int indexBeforeTime;
        char signSemicolon =';';
        int counterOfSemicolons=0;
        int i=0;
        int beginningIndex=0;
        int endingIndex=0;

        if(matcherLine.find()){
            String day = Line.substring(1,3);
            result = Searching.switchDayOfWeek(day).toString()+",";

            indexBeforeTime = Line.indexOf(" ");

            result = result + Searching.switchTime(Line.substring(indexBeforeTime+1,indexBeforeTime+3)) + "," + Searching.switchTime(Line.substring(indexBeforeTime+7,indexBeforeTime+9))+ ",";

           while(counterOfSemicolons<4) {

                if(Line.charAt(i) == signSemicolon){
                    counterOfSemicolons++;
                }

                if(counterOfSemicolons == 3 && beginningIndex==0){
                    beginningIndex = i;
                 //   System.out.println("BEGIN:" + i);
                }
                else if(counterOfSemicolons == 4 && endingIndex==0){
                    endingIndex = i;
                 //   System.out.println("END:" + i);
                }
                i++;
            }

            result = result + Line.substring(beginningIndex+2,endingIndex-1)+",";
            addLessonToArrayList(result);
        }
    }

    public static Integer switchDayOfWeek(String day){

        if(day.equals("Pn")){
            return 1;
        }

        if(day.equals("Wt")){
            return 2;
        }

        if(day.equals("Śr")){
            return 3;
        }

        if(day.equals("Cz")){
            return 4;
        }

        return 5;
    }

    public static Integer switchTime(String time){
        try{
            int timeAfterConversion;
            timeAfterConversion = Integer.parseInt(time);
            return timeAfterConversion-7;
        }catch(NumberFormatException e){
            return 0;
        }

    }

    public ArrayList<String> getListOfLessons() {
        return listOfLessons;
    }

    public static void addLessonToArrayList(String lesson){
        listOfLessons.add(lesson);
    }
}
