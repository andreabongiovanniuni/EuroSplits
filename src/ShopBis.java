import java.util.*;

public class ShopBis extends UserBis{
    /** contiene il valore totale della spesa*/
    public double total;
    /** Utente che anticipa i soldi per tutti(non per forza deve partecipare alla spesa) */
    public UserBis creditor;

    /** id della spesa */
    public int id;

    /** Lista delle persone che partecipano alla spesa */
    public List<UserBis> participants;

     /** costruttore */
    public ShopBis(double total, UserBis creditor, List<UserBis> participants) {
        this.total = total;
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

    @Override
    public String toString() {
        return "ShopBis{" + "total=" + total + ", creditor=" + creditor + ", id=" + id + ", participants=" + participants + '}';
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
        if(amounts.size() != participants.size()) {
            System.out.println("Errore: Il numero di utenti passati come parametro tramite HashMap non corrisponde al" +
                    " numero " +
                    "di partecipanti della spesa");
            return;
        }
        Set<UserBis> keys = amounts.keySet();
        for(UserBis key : keys){
            if(!Objects.equals(creditor.getUsername(), key.getUsername())){
                key.debtUpdate(amounts.get(key), creditor.getUsername());
            }
        }
    }



    /**
     * SpecialSplit tiene conto della spesa comune tra tutti i partecipanti e in seguito considera i valori condivisi
     * da sottogruppi di partecipants
     */
    public void SpecialSplit(double[] prices, LinkedHashMap<Integer, List<UserBis>> users2){
        //common pay
        double specialstotal = 0;
        for(double i : prices){
            specialstotal += i;
        }
        double common = total - specialstotal;
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



