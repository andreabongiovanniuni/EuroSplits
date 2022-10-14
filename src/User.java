import java.util.HashMap; // import the HashMap class

public class User {
    String username;
    HashMap<String, Double> debt = new HashMap<>(); // HashMap<creditor, debtvalue>


    public User(String username, HashMap debt) {
        this.username = username;
        this.debt = debt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public HashMap<String, Double> getDebt() {
        return debt;
    }

    public void setDebt(HashMap debt) {
        this.debt = debt;
    }

    @Override
    public String toString() {
        return "User{" + "username='" + username + '\'' + ", debt=" + debt + '}';
    }
}