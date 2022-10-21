import java.util.ArrayList;
public class Group extends User {

    ArrayList<User> group;

    public Group(){
        group = new ArrayList<>();
    }

    public void addUser(User u){
        group.add(u);
    }

    public ArrayList<User> getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return "Group{" + "group=" + group + '}';
    }

}
