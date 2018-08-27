package searching;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
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
     
}
