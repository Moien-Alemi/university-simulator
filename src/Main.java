import base.*;
import uni.*;

public class Main {
    public static void main(String[] args) {
        Person ali = new Person("Ali", "4570234765");
        Person amir = new Person("Amir", "4830765321");
        Person illia = new Person("Illia", "2630765691");
        Person farhad = new Person("Farhad", "1830773221");
        Person sobhan = new Person("Sobhan", "5933768521");
        Major math = new Major("Math", 45);
        Major CS = new Major("Computer science", 60);

        Student student1 = new Student(1, 403, 1);
        Student student2 = new Student(2, 402, 1);
        Student student3 = new Student(3, 401, 2);


        Person samplePerson;
        int counter;

        for(Student sampleStudent : Student.studentList){
            counter = 1;
            samplePerson = Person.findByID(sampleStudent.personID);
            if(samplePerson == null){
                System.out.println("Error!\nThis person doesn't exist.");
            }
            else {
                System.out.println("Student Number " + counter + " :");
                System.out.println("\tname : " + samplePerson.name);
                System.out.println("\tID : " + sampleStudent.studentID);
                counter++;
                System.out.println();
            }
        }

        Professor professor1 = new Professor(4, 1);
        Professor professor2 = new Professor(5, 2);

        for(Professor sampleProfessor : Professor.professorList){
            counter = 1;
            samplePerson = Person.findByID(sampleProfessor.personID);
            if(samplePerson == null){
                System.out.println("Error!\nThis person doesn't exist.");
            }
            else {
                System.out.println("Professor Number " + counter + " :");
                System.out.println("\tname : " + samplePerson.name);
                System.out.println("\tID : " + samplePerson.nationalID);
                System.out.println();
                counter++;
            }
        }

        Course math1 = new Course("Math1", 3);
        Course math2 = new Course("Math2", 3);
        Course AP = new Course("AP", 4);

        PresentedCourse math1Course = new PresentedCourse(1, 1, 30);
        math1Course.addStudent(1);
        math1Course.addStudent(2);

        PresentedCourse math2Course = new PresentedCourse(2, 1, 35);
        math2Course.addStudent(1);
        math2Course.addStudent(2);
        math2Course.addStudent(3);

        PresentedCourse APCourse = new PresentedCourse(3, 2, 40);
        APCourse.addStudent(3);

        Transcript transcript1 = new Transcript(1);
        transcript1.setGrade(1, 18.5);
        transcript1.setGrade(2, 20);

        Transcript transcript2 = new Transcript(2);
        transcript2.setGrade(1, 17.0);
        transcript2.setGrade(2, 19.25);

        Transcript transcript3 = new Transcript(3);
        transcript3.setGrade(2, 18.0);
        transcript3.setGrade(3, 18.7);

        transcript1.printTranscript();
        transcript2.printTranscript();
        transcript3.printTranscript();

        System.out.println("student1 GPA is : " + transcript1.getGPA());
        System.out.println();
        System.out.println("student2 GPA is : " + transcript2.getGPA());
        System.out.println();
        System.out.println("student3 GPA is : " + transcript3.getGPA());

    }
}