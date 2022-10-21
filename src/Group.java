import java.util.ArrayList;
import java.util.List;

public class Group extends UserBis{

    List<UserBis> group;

    public Group(){
        group = new ArrayList<UserBis>();
    }

    public void addUser(UserBis u){
        group.add(u);
    }

    public List<UserBis> getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return "Group{" + "group=" + group + '}';
    }

}
