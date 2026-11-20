package ma.enset;

import ma.enset.model.BankAccount;
import ma.enset.repository.AccountRepositoryImpl;

import java.util.List;

/**
 *
 * @author Yousef ELHAID
 */
public class RepositoryApp {
    public static void main(String[] args) {
        AccountRepositoryImpl accountRepository = AccountRepositoryImpl.getInstance();        accountRepository.populateData();

        List<BankAccount> accounts = accountRepository.findAll();
        accounts.forEach(System.out::println);

        System.out.println(accountRepository.findById(3L));
        System.out.println(accountRepository.findById(99L));
    }
}