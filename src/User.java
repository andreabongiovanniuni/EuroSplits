import java.util.HashMap; // import the HashMap class

public class User {
    String username;
    //todo: non qui HashMap<String, Double> debt = new HashMap<>(); // HashMap<creditor, debtvalue>

    public User(String username, HashMap debt) {
        this.username = username;
        //todo:    this.debt = debt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" + "username='" + username + '\'' + ", debt=" + debt + '}';
    }
}