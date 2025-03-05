package uni;

import java.util.ArrayList;

public class PresentedCourse {
    public int ID;
    public int courseID;
    public int professorID;
    public int maxCapacity;
    public static ArrayList<PresentedCourse> presentedCourseList = new ArrayList<>();
    public ArrayList<Integer> studentIDs;

    public PresentedCourse(int courseID, int professorID, int maxCapacity){
        this.courseID = courseID;
        this.professorID = professorID;
        this.maxCapacity = maxCapacity;

        studentIDs = new ArrayList<>();

        ID = presentedCourseList.size() + 1;
        presentedCourseList.add(this);
    }

    public static PresentedCourse findByID(int ID){
        if(presentedCourseList.size() < ID)
            return null;
        return presentedCourseList.get(ID - 1);
    }

    public void addStudent(int studentID){
        if (studentIDs.size() > maxCapacity){
            System.out.println("Eror!\nwe can't add Student.");
            System.out.println("This PresentedMajor reached full capacity.");
        }
        else
            studentIDs.add(studentID);
    }
}
