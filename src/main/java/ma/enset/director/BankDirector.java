package ma.enset.director;

import ma.enset.model.BankAccount;

/**
 *
 * @author Yousef ELHAID
 */
public class BankDirector {
    public static BankAccount.AccountBuilder accountBuilder() {
        return new BankAccount.AccountBuilder();
    }
}