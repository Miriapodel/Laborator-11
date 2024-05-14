package exercitiul1.model;

import exercitiul1.calcul.ConversieCalculImpl;

import static exercitiul1.model.Currency.EUR;

//utilizare Cloneable; se pune pe toate obiectele care trebuie clonate
public class Transaction extends ConversieCalculImpl implements Cloneable{
    private int id;
    private Payment payment;
    private Currency currency = EUR;
    private float amount;
    private int refNmb;

    public Transaction(int id, Payment payment) throws Exception {
        this.id = id;
        this.payment = payment;
        this.amount = super.conversieValutaToEur(payment.getCurrency(), payment.getAmount());
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Payment getPayment() {
        return payment;
    }

    public void negativeAmount(int refNmb) throws CloneNotSupportedException {
        amount = - amount;
        payment.setAmount(- payment.getAmount());
        this.refNmb = refNmb;
    }

    @Override
    public Transaction clone () throws CloneNotSupportedException {
        Transaction transactionCloned = (Transaction) super.clone();
        transactionCloned.setPayment((Payment) transactionCloned.getPayment().clone());
        return transactionCloned;
    }

    private void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", payment=" + payment +
                ", currency=" + currency +
                ", amount=" + amount +
                ", refNmb=" + refNmb +
                "} ";
    }

}
