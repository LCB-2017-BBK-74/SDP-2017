/**
 * Created by lucieburgess on 20/01/2017.
 */
class BankAccount {
    private float balance = 100.0F;

    public void deposit(float amount) {
        this.balance += amount;
    }

    public float showBalance() {
        return this.balance;
    }

    BankAccount() {
    }
}

