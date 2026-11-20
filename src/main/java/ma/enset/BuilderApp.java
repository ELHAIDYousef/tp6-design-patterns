package ma.enset;

import ma.enset.director.BankDirector;
import ma.enset.model.AccountStatus;
import ma.enset.model.AccountType;
import ma.enset.model.BankAccount;
import ma.enset.repository.AccountRepositoryImpl;

/**
 *
 * @author Yousef ELHAID
 */
public class BuilderApp {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount();
        account1.setAccountId(1L);
        account1.setBalance(7000);
        account1.setCurrency("MAD");
        account1.setType(AccountType.CURRENT_ACCOUNT);
        account1.setStatus(AccountStatus.CREATED);

        BankAccount account2 = new BankAccount(2L, 12000, "USD", AccountType.SAVING_ACCOUNT, AccountStatus.ACTIVATED);

        BankAccount account3 = BankAccount.builder()
                .accountId(3L)
                .balance(5000)
                .currency("MAD")
                .type(AccountType.CURRENT_ACCOUNT)
                .status(AccountStatus.ACTIVATED)
                .build();

        BankAccount account4 = BankDirector.accountBuilder()
                .accountId(4L)
                .currency("EUR")
                .balance(9000)
                .type(AccountType.SAVING_ACCOUNT)
                .status(AccountStatus.SUSPENDED)
                .build();

        System.out.println(account1);
        System.out.println(account2);
        System.out.println(account3);
        System.out.println(account4);

        System.out.println("---- populateData() with the Builder ----");
        AccountRepositoryImpl accountRepository = AccountRepositoryImpl.getInstance();        accountRepository.populateData();
        accountRepository.findAll().forEach(System.out::println);
    }
}