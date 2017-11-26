package d6_20171126.Zadania;

/**
 * Created: 26.11.17.
 */
public class BankAccount {
    private double balance;

    public BankAccount(double balance){
        this.balance=balance;
    }

    public void deposit(double amount){
        balance+=amount;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if(balance<amount){
            throw new InsufficientFundsException();
        } else {
            balance-=amount;
        }
    }

    public double getBalance() {
        return balance;
    }
}
