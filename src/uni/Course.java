package uni;

import java.util.ArrayList;

public class Course {
    public int ID;
    public String title;
    public int units;
    public static ArrayList<Course> courseList = new ArrayList<>();

    public Course(String title, int units){
        this.title = title;
        this.units = units;

        ID = courseList.size() + 1;
        courseList.add(this);
    }

    public static Course findByID(int ID){
        if(courseList.size() < ID)
            return null;
        return courseList.get(ID - 1);
    }
}