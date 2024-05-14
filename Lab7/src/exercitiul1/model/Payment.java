package exercitiul1.model;

//utilizare Cloneable; se pune pe toate obiectele care trebuie clonate
public class Payment implements Cloneable{
    private float amount;
    private Currency currency;
    private User user;
    private String purpose;

    public Payment(float amount, Currency currency, User user, String purpose) {
        this.amount = amount;
        this.currency = currency;
        this.user = user;
        this.purpose = purpose;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public User getUser(){
        return user;
    }
    @Override
    public Object clone () throws CloneNotSupportedException {
        return super.clone();
    }
    @Override
    public String toString() {
        return "Payment{" +
                "amount=" + amount +
                ", currency=" + currency +
                ", user=" + user +
                ", purpose='" + purpose + '\'' +
                '}';
    }
}
