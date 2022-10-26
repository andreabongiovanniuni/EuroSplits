import java.util.*;

public class Shop extends User {
    /** contiene il valore totale della spesa*/
    public double total;
    /** Utente che anticipa i soldi per tutti(non per forza deve partecipare alla spesa) */
    public User creditor;

    /** id della spesa */
    public int id;

    /** Lista delle persone che partecipano alla spesa */
    public ArrayList<User> participants;

     /** costruttore */
    public Shop(double total, User creditor, ArrayList<User> participants) {
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
    public User getCreditor() {
        return creditor;
    }

    /** setta/cambia l'utente che ha anticipato i soldi */
    public void setCreditor(User creditor) {
        this.creditor = creditor;
    }

    /** ritorna la lista di utenti che partecipano alla spesa */
    public List<User> getParticipants() {
        return participants;
    }

    /** setta/cambia la lista di utenti che partecipano alla spesa */
    public void setParticipants(ArrayList<User> debtorsList) {
        this.participants = debtorsList;
    }

    @Override
    public String toString() {
        return "ShopBis{" + "total=" + total + ", creditor=" + creditor + ", id=" + id + ", participants=" + participants + '}';
    }

    public HashMap<User, Double> splitExpenseDebtors(User creditor, List <User> debtorsList ){
        HashMap<User, Double> debtorsHashmap=new HashMap<>();
        int debtorsNumber= debtorsList.size();
        double expenseDivided = total / (debtorsNumber + 1);
        User debtorOut;
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
        for(User u : participants){
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
    public void EqualSplit(double total, List<User> participants){
        /*
            Divide il totale per il numero di partecipanti e mette il risultato in part
         */
        double part = total / participants.size();

        //Update debts of users
        for(User u : participants){
            //no debt for the payer
            if(!Objects.equals(creditor.getUsername(), u.getUsername())) {
                u.debtUpdate(part, creditor.getUsername());
            }
        }
    }


    /** NotEqualSplit divide in parti disuguali tra i partecipanti */
    public void NotEqualSplit(HashMap<User, Double> amounts){
        if(amounts.size() != participants.size()) {
            System.out.println("Errore: Il numero di utenti passati come parametro tramite HashMap non corrisponde al" +
                    " numero " +
                    "di partecipanti della spesa");
            return;
        }
        Set<User> keys = amounts.keySet();
        for(User key : keys){
            if(!Objects.equals(creditor.getUsername(), key.getUsername())){
                key.debtUpdate(amounts.get(key), creditor.getUsername());
            }
        }
    }



    /**
     * SpecialSplit tiene conto della spesa comune tra tutti i partecipanti e in seguito considera i valori condivisi
     * da sottogruppi di partecipants
     */
    public void SpecialSplit(ArrayList<Double> prices, LinkedHashMap<Integer, LinkedList<User>> users2){
        //common pay
        double specialstotal = 0;
        for(double i : prices){
            specialstotal += i;
        }
        double common = total - specialstotal;
        EqualSplit(common, participants);

        //split the special products
        Set<Integer> keys = users2.keySet();
        Iterator<Double> i = prices.iterator();
        for (Integer key : keys) {
            if(i.hasNext()) {
                Double p = i.next();
                EqualSplit(p, users2.get(key));
            }
        }
    }
}



