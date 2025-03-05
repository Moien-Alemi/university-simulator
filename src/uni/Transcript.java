package uni;

import java.util.HashMap;
import base.Person;

public class Transcript {
    public int studentID;
    public HashMap<Integer, Double> transcript;

    public Transcript(int studentID){
        this.studentID = studentID;
        transcript = new HashMap<>();
    }

    public void setGrade(int presentedCourseID, double grade){
        boolean isINStudentsList = false;
        PresentedCourse presentedCourse = PresentedCourse.findByID(presentedCourseID);
        if(presentedCourse == null){
            System.out.println("Error!\nPresented course doesn't exist.");
        }
        for(int studentID : presentedCourse.studentIDs){
            if(studentID == this.studentID){
                transcript.put(presentedCourseID, grade);
                isINStudentsList = true;
                break;
            }
        }
        if(isINStudentsList == false){
            System.out.println("Error!\nStudent is not in the presented course.");
        }
    }

    public void printTranscript(){
        Student student = Student.findByID(this.studentID);
        Person person  = Person.findByID(student.personID);
        System.out.println("Student's name: " + person.name);
        System.out.println("Student's ID: " + student.studentID);

        PresentedCourse presentedCourse;
        Course course;
        for(int key : transcript.keySet()){
            presentedCourse = PresentedCourse.findByID(key);
            course = Course.findByID(presentedCourse.courseID);
            if(course == null){
                System.out.println("Error!\ncourse doesn't exist.");
            }
            System.out.println(course.title + " : " + transcript.get(key));
        }
    }

    public double getGPA(){
        PresentedCourse presentedCourse;
        Course course;
        double sum = 0.0;
        int sumOfUnits = 0;

        for(int key : transcript.keySet()){
            presentedCourse = PresentedCourse.findByID(key);
            if(presentedCourse == null){
                System.out.println("Error!\nPresented course doesn't exist.");
            }
            course = Course.findByID(presentedCourse.courseID);
            if(course == null){
                System.out.println("Error!\ncourse doesn't exist.");
            }
            sum += transcript.get(key) * course.units;
            sumOfUnits += course.units;
        }

        return sum / sumOfUnits;
    }
}