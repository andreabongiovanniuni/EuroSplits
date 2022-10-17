import java.util.HashMap;

public class UserBis {
    /** nome dell'utente corrente */
    String username;

    /** debts contiene l'elenco dei creditori dell'utente corrente e i rispettivi debiti*/
    HashMap<String, Double> debts;

    /**costruttore di UserBis*/

    public UserBis(String username) {
        this.username = username;
        debts = new HashMap<>();
    }

    /**costruttore di default */
    public UserBis() {

    }

    /** ritorna il nome dell'utente */
    public String getUsername() {
        return username;
    }

    /** setta/cambia il nome dell'utente */
    public void setUsername(String username) {
        this.username = username;
    }


    /**
     * debtUpdate provvede ad aggiornare i debiti che l'utente corrente ha con gli altri utenti
     *
     * @param imp contiene il valore del debito da aggiungere
     * @param username il nome del pagante a cui dare i soldi
     */
    public void debtUpdate(double imp, String username){
        //controllo se il nome della persona a cui deve il debito non sia già presente nell'elenco
        if(debts.containsKey(username)){
            debts.replace(username, debts.get(username) + imp);
        }
        //altrimenti lo aggiungo
        else{
            debts.put(username, imp);
        }
    }


    public HashMap<UserBis, Double> splitExpenseCreditors(ShopBis shopBis) {
        HashMap<UserBis, Double> creditorsHashmap = new HashMap<>();
        int debtorsNumber = shopBis.participants.size();
        double expenseDivided = shopBis.total / (debtorsNumber + 1);
        creditorsHashmap.put(shopBis.creditor, expenseDivided);
        return creditorsHashmap;
    }
}
