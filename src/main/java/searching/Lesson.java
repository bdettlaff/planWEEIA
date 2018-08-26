package searching;

import java.util.List;

public class Lesson {
     private String dayOfWeek;
     private String startTime;
     private String endTime;
     private String weeks;
     private String type;
     private int typeOfWeek;
     private String name;
     private String location;
     private String nameOfLecturer;
     private List<String> groups;

     public String getLocation() {
          return location;
     }
     public String getDayOfWeek() {
          return dayOfWeek;
     }

     public String getStartTime() {
          return startTime;
     }

     public String getEndTime() {
          return endTime;
     }

     public String getWeeks() {
          return weeks;
     }

     public String getType() {
          return type;
     }

     public int getTypeOfWeek() {
          return typeOfWeek;
     }

     public String getName() {
          return name;
     }

     public String getNameOfLecturer() {
          return nameOfLecturer;
     }

     public List<String> getGroups() {
          return groups;
     }

     public void setDayOfWeek(String dayOfWeek) {
          this.dayOfWeek = dayOfWeek;
     }

     public void setStartTime(String startTime) {
          this.startTime = startTime;
     }

     public void setEndTime(String endTime) {
          this.endTime = endTime;
     }

     public void setWeeks(String weeks) {
          this.weeks = weeks;
     }

     public void setType(String type) {
          this.type = type;
     }

     public void setTypeOfWeek(int typeOfWeek) {
          this.typeOfWeek = typeOfWeek;
     }

     public void setName(String name) {
          this.name = name;
     }

     public void setNameOfLecturer(String nameOfLecturer) {
          this.nameOfLecturer = nameOfLecturer;
     }

     public void setGroups(List<String> groups) {
          this.groups = groups;
     }

     public void setLocation(String location) {
          this.location = location;
     }

}
