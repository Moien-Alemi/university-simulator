package uni;

import java.util.ArrayList;

public class Student {
    public final int enteranceYear;
    public int ID;
    public int personID;
    public int majorID;
    public String studentID;
    public static ArrayList<Student> studentList = new ArrayList<>();

    public Student(int personID, int entranceYear, int majorID){
        this.enteranceYear = entranceYear;

        Major major = Major.findByID(majorID);
        if(major == null)
            System.out.println("Error!\nthe major doesn't exist.");
        else {
            major.addStudent();
            this.personID = personID;
            this.majorID = majorID;

            ID = studentList.size() + 1;
            setStudentCode();
            studentList.add(this);
        }
    }

    public static Student findByID(int ID){
        if(studentList.size() < ID)
            return null;
        return studentList.get(ID - 1);
    }

    public void setStudentCode(){
        studentID = String.valueOf(enteranceYear) + String.format("%02d", majorID) + String.format("%02d", Major.findByID(majorID).numberOfStudents);
    }
}
