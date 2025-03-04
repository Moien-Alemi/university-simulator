package base;

import java.util.ArrayList;

public class Person {
    public int ID;
    public static ArrayList<Person> personList = new ArrayList<>();
    public String name;
    public String nationalID;

    public Person(String name, String nationalID){
        this.name = name;
        this.nationalID = nationalID;
        ID = personList.size() + 1;
        personList.add(this);
    }

    public static Person findByID(int ID){
        if(ID > personList.size())
            return null;
        return personList.get(ID - 1);
    }
}
