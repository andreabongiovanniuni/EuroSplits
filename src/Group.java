import java.util.ArrayList;

public class Group extends User {

    ArrayList<User> group;

    public Group(){
        group = new ArrayList<>();
    }

    public void addUser(User u){
        group.add(u);
    }

    public void removeUser(String username){
        group.removeIf(u -> u.getUsername().equals(username));
    }

    public ArrayList<User> getGroup() {
        return group;
    }

    public boolean IsInGroup(String s){
        for(User u : group){
            if(u.getUsername().equals(s)) return true;
        }
        return false;
    }

    public User getUser(String s){
        for(User u : group){
            if(u.getUsername().equals(s)) return u;
        }
        return null;
    }
    @Override
    public String toString() {
        StringBuilder sol = new StringBuilder();
        for(User o : group){
            sol.append(o.toString());
        }
        return sol.toString();
    }

    public String toStringOnlyName(){

        StringBuilder sol = new StringBuilder();
        for(User o : group){
            sol.append(o.getUsername());
            sol.append('\n');
        }
        return sol.toString();

    }

}
