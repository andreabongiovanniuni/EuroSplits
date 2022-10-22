import java.util.HashMap;

public class User {
    /** nome dell'utente corrente */
    public String username;

    /** debts contiene l'elenco dei creditori dell'utente corrente e i rispettivi debiti*/
    public HashMap<String, Double> debts;

    /** costruttore di UserBis */

    public User(String username) {
        this.username = username;
        debts = new HashMap<>();
    }

    /**costruttore di default */
    public User() {

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

    @Override
    public String toString() {
        return "L'utente " + username + " ha i seguenti debiti: " +  debts + '\n' ;
    }

    public HashMap<User, Double> splitExpenseCreditors(Shop shop) {
        HashMap<User, Double> creditorsHashmap = new HashMap<>();
        int debtorsNumber = shop.participants.size();
        double expenseDivided = shop.total / (debtorsNumber + 1);
        creditorsHashmap.put(shop.creditor, expenseDivided);
        return creditorsHashmap;
    }
}
