package exercitiul1;

import exercitiul1.model.Payment;
import exercitiul1.model.Transaction;
import exercitiul1.model.User;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static exercitiul1.model.Currency.*;

public class Main {
    public static void main(String[] args) throws Exception {
        List<User> userList = usersInit();
        List<Payment> paymentList = paymentsInit(userList);
        List<Transaction> transactionList = transactionsInit(paymentList);

        //2) Sa se afiseze lista tarilor/zonei pentru care s-au facut plati
        showListaTari(paymentList);

        //3) Sa se afiseze Tranzactiile facute pentru un user, amountul si valuta in care a platit initial.
        transactionsUsers(transactionList, userList);

    }

    private static List<Transaction> transactionsInit(List<Payment> paymentList) throws Exception {
        List<Transaction> transactionList = new ArrayList<>();

        Transaction transactionInitial1 = new Transaction(1, paymentList.get(0));
        transactionList.add(transactionInitial1);
        Transaction transactionStornat1 = (Transaction) transactionInitial1.clone();
        transactionStornat1.setId(2);
        transactionStornat1.negativeAmount(transactionInitial1.getId());
        transactionList.add(transactionStornat1);
        //1) afisam tranzactia initiala si tranzactia stornata finala
        System.out.println("transactionInitial1: " + transactionInitial1);
        System.out.println("transactionStornat1: " + transactionStornat1);

        Transaction transactionInitial2 = new Transaction(3, paymentList.get(1));
        transactionList.add(transactionInitial2);
        System.out.println("transactionInitial2: " + transactionInitial2);
        return transactionList;
    }

    private static List<Payment> paymentsInit(List<User> userList) {
        List<Payment> paymentList = new ArrayList<>();
        Payment p1 = new Payment(100, USD, userList.get(0), "chirie");
        Payment p2 = new Payment(200, EUR, userList.get(1), "rata masina");
        Payment p3 = new Payment(300, GBP, userList.get(1), "rata casa");
        paymentList.add(p1);
        paymentList.add(p2);
        paymentList.add(p3);
        return paymentList;
    }

    private static List<User> usersInit() {
        List<User> userList = new ArrayList<>();
        User u1 = new User("Popa", "Ana", "521746601743");
        userList.add(u1);
        User u2 = new User("Georgescu", "Ioan", "688392");
        userList.add(u2);
        return userList;
    }

    private static void transactionsUsers(List<Transaction> transactionList, List<User> userList) {
       //cu stream -> nu mai are nevoie de lista separata de useri
        transactionList.stream().map(transaction -> transaction.getPayment())
            .map(Payment::getUser).distinct()
            .forEach(user -> {
            System.out.println("Transactions for " + user.getNume() + " " + user.getPrenume());
            transactionList.stream()
                    .map(Transaction::getPayment)
                    .filter(payment -> payment.getUser().equals(user))
                    .forEach(payment -> System.out.println( payment.getAmount() + " " + payment.getCurrency()));
        });


        //clasic
        for (User user : userList) {
            System.out.println("\nTransactions for " + user.getNume() + " " + user.getPrenume());
            for (Transaction transaction : transactionList) {
                if (user.equals(transaction.getPayment().getUser())) {
                    System.out.println(transaction.getPayment().getAmount() + " " + transaction.getPayment().getCurrency());
                }
            }
        }
    }

    private static void showListaTari(List<Payment> paymentList) {
        Set<String> setTari = new HashSet<>();
        for (Payment payment : paymentList) {
            setTari.add(payment.getCurrency().getZone());
        }
        System.out.println("\nLista tari pt care s-au facut paymenturi " + setTari);
        //varianta cu stream
        //System.out.println(paymentList.stream().map(p -> p.getCurrency().getZone()).distinct().collect(Collectors.toList()));
    }
}
