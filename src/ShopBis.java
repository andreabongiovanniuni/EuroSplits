import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class ShopBis extends UserBis{
    /** contiene il valore totale della spesa*/
    double total;
    /** Persona che anticipa i soldi per tutti(non per forza deve partecipare alla spesa) */
    UserBis creditor;

    /** id della spesa */
    int id;

    /** Lista delle persone che partecipano alla spesa */
     List<UserBis> participants;

     /** costruttore */
    public ShopBis(double expense, UserBis creditor, List<UserBis> participants) {
        super();
        this.total = expense;
        this.creditor = creditor;
        this.participants = participants;
    }

    /** ritorna il valore totale della spesa */
    public double getTotal() {
        return total;
    }

    /** setta/cambia il valore totale della spesa */
    public void setTotal(double total) {
        this.total = total;
    }

    /** ritorna l'utente che ha anticipato i soldi */
    public UserBis getCreditor() {
        return creditor;
    }

    /** setta/cambia l'utente che ha anticipato i soldi */
    public void setCreditor(UserBis creditor) {
        this.creditor = creditor;
    }

    /** ritorna la lista di utenti che partecipano alla spesa */
    public List<UserBis> getParticipants() {
        return participants;
    }

    /** setta/cambia la lista di utenti che partecipano alla spesa */
    public void setParticipants(List<UserBis> debtorsList) {
        this.participants = debtorsList;
    }

    public HashMap<UserBis, Double> splitExpenseDebtors(UserBis creditor, List <UserBis> debtorsList ){
        HashMap<UserBis, Double> debtorsHashmap=new HashMap<>();
        int debtorsNumber= debtorsList.size();
        double expenseDivided = total / (debtorsNumber + 1);
        UserBis debtorOut;
         for (int i = 1; i < debtorsNumber ; i++) {
             debtorOut =  debtorsList.get(i);
            debtorsHashmap.put(debtorOut, expenseDivided);
        }
        return debtorsHashmap;
    }

    /** EqualSplit divide la spesa in parti uguali tra i partecipanti */
    public void EqualSplit(){
        /*
            Divide in equal parts the param total in equal parts and put the result in imp
         */
        double imp = this.total / participants.size();

        //Update debts of users
        for(UserBis u : participants){
            //no debt for the payer
            if(!Objects.equals(creditor.getUsername(), u.getUsername())) {
                u.debtUpdate(imp, creditor.getUsername());
            }
        }
    }


    /**
     * Seconda veraione di EqualSplit divide la spesa in parti uguali tra i partecipanti
     * il valore totale della spesa e la lista di partecipanti sono specificati nei parametri
     */
    public void EqualSplit(double total, List<UserBis> participants){
        /*
            Divide il totale per il numero di partecipanti e mette il risultato in part
         */
        double part = total / participants.size();

        //Update debts of users
        for(UserBis u : participants){
            //no debt for the payer
            if(!Objects.equals(creditor.getUsername(), u.getUsername())) {
                u.debtUpdate(part, creditor.getUsername());
            }
        }
    }


    /** NotEqualSplit divide in parti disuguali tra i partecipanti */
    public void NotEqualSplit(HashMap<UserBis, Double> amounts){

        Set<UserBis> keys = amounts.keySet();
        for(UserBis key : keys){
            key.debtUpdate(amounts.get(key), creditor.getUsername());
        }
    }



    /**
     * SpecialSplit tiene conto della spesa comune tra tutti i partecipanti e in seguito considera i valori condivisi
     * da sottogruppi di partecipants
     */
    public void SpecialSplit(double common, int[] prices, HashMap<Integer, List<UserBis>> users2){
        //common pay
        EqualSplit(common, participants);

        //split the special products
        Set<Integer> keys = users2.keySet();
        int i = 0;
        for (Integer key : keys) {
            EqualSplit(prices[i], users2.get(key));
            ++i;
        }
    }
}



