import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ShopBis {
    double expense;
    UserBis creditor;

    List<UserBis> debtorsList;

    public ShopBis(double expense, UserBis creditor, List<UserBis> debtorsList) {
        this.expense = expense;
        this.creditor = creditor;
        this.debtorsList = debtorsList;
    }

    public double getExpense() {
        return expense;
    }

    public void setExpense(double expense) {
        this.expense = expense;
    }

    public UserBis getCreditor() {
        return creditor;
    }

    public void setCreditor(UserBis creditor) {
        this.creditor = creditor;
    }

    public List<UserBis> getDebtorsList() {
        return debtorsList;
    }

    public void setDebtorsList(List<UserBis> debtorsList) {
        this.debtorsList = debtorsList;
    }

    public HashMap<UserBis, Double> splitExpenseDebtors(UserBis creditor, LinkedList debtorsList ){
        HashMap<UserBis, Double> debtorsHashmap=new HashMap<>();
        int debtorsNumber= debtorsList.size();
        double expenseDivided = expense / (debtorsNumber + 1);
        UserBis debtorOut;
         for (int i = 1; i < debtorsNumber ; i++) {
             debtorOut =  debtorsList.get(i);
            debtorsHashmap.put(debtorOut, expenseDivided);
        }
        return debtorsHashmap;
    }
}
