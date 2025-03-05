package uni;

import java.util.ArrayList;

public class Major {
    public final int capacity;
    public int ID;
    public String name;
    public int numberOfStudents = 0;
    public static ArrayList<Major> majorList = new ArrayList<>();


    public Major(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
        ID = majorList.size() + 1;
        majorList.add(this);
    }

    public static Major findByID(int ID){
        if(majorList.size() < ID)
            return null;
        return majorList.get(ID - 1);
    }

    public void addStudent(){
        if(capacity <= numberOfStudents){
            System.out.println("Eror!\nwe can't add Student.");
            System.out.println("This Major reached full capacity.");
        }
        else {
            numberOfStudents++;
        }

    }
}
