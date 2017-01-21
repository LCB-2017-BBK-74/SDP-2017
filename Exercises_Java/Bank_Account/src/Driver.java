/**
 * Created by lucieburgess on 20/01/2017.
 */

public class Driver {
    public Driver() {
    }

    public static void main(String[] args) {
        Storage aStorage = new Storage();
        Storage sStorage = new Storage();
        Class baClass = BankAccount.class;

        try {
            BankAccount myAccount = (BankAccount)baClass.newInstance();
            aStorage.setValue(myAccount);
            myAccount.deposit(15.0F);
        } catch (InstantiationException var5) { ;
        } catch (IllegalAccessException var6) { ;
        }

        System.out.println(((BankAccount)aStorage.getValue()).showBalance());
        if(aStorage.getClass() == sStorage.getClass()) {
            System.out.println("EQUAL");
        } else {
            System.out.println("NOT EQUAL");
        }

    }
}

