package ma.enset;

import ma.enset.model.AccountStatus;
import ma.enset.model.AccountType;
import ma.enset.model.BankAccount;

/**
 *
 * @author Yousef ELHAID
 */
public class ModelApp {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount();
        account1.setAccountId(1L);
        account1.setBalance(7000);
        account1.setCurrency("MAD");
        account1.setType(AccountType.CURRENT_ACCOUNT);
        account1.setStatus(AccountStatus.CREATED);

        BankAccount account2 = new BankAccount(2L, 12000, "USD", AccountType.SAVING_ACCOUNT, AccountStatus.ACTIVATED);

        System.out.println(account1);
        System.out.println(account2);
    }
}