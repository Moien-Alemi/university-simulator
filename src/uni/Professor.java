package uni;

import java.util.ArrayList;

public class Professor {
    public int ID;
    public int personID;
    public int majorID;
    public static ArrayList<Professor> professorList = new ArrayList<>();

    public Professor(int personID, int majorID){
        this.personID = personID;
        this.majorID = majorID;

        ID = professorList.size() + 1;
        professorList.add(this);
    }

    public static Professor findByID(int ID){
        if(professorList.size() < ID)
            return null;
        return professorList.get(ID - 1);
    }
}
