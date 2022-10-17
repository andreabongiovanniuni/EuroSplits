import java.util.HashMap;
import java.util.List;

public class UserBis {
    String username;

    public UserBis(String username) {
        this.username = username;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public HashMap<UserBis, Double> splitExpenseCreditors(ShopBis shopBis) {
        HashMap<UserBis, Double> creditorsHashmap = new HashMap<>();
        int debtorsNumber = shopBis.debtorsList.size();
        double expenseDivided = shopBis.expense / (debtorsNumber + 1);
        creditorsHashmap.put(shopBis.creditor, expenseDivided);
        return creditorsHashmap;
    }
}
