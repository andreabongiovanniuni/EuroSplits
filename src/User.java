import java.util.HashMap; // import the HashMap class

public class User {
    String username;
    HashMap<String, Double> debt = new HashMap<>(); // HashMap<creditor, debtvalue>

    public User(){
        this.username = "";
        this.debt = null;
    }
    public User(String username, HashMap debt) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" + "username='" + username + '\'' + '}';
    }
}