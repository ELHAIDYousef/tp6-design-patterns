package ma.enset;

import ma.enset.model.AccountStatus;
import ma.enset.model.AccountType;
import ma.enset.model.BankAccount;
import ma.enset.repository.AccountRepositoryImpl;
import ma.enset.util.JsonSerializer;

import java.util.function.Predicate;

/**
 *
 * @author Yousef ELHAID
 */
public class JsonApp {
    public static void main(String[] args) {
        AccountRepositoryImpl accountRepository = AccountRepositoryImpl.getInstance();        accountRepository.populateData();
        JsonSerializer<BankAccount> bankAccountJsonSerializer = new JsonSerializer<>();

        System.out.println("---- findAll() as JSON ----");
        accountRepository.findAll()
                .stream()
                .map(bankAccountJsonSerializer::toJson)
                .forEach(System.out::println);

        System.out.println("---- findById(1L) ----");
        BankAccount account = accountRepository.findById(1L).orElse(null);
        if (account != null) {
            System.out.println(bankAccountJsonSerializer.toJson(account));
        }

        System.out.println("---- findById(99L) ----");
        BankAccount missing = accountRepository.findById(99L).orElse(null);
        if (missing == null) {
            System.out.println("Account 99 not found");
        }

        System.out.println("---- CURRENT accounts (anonymous class) ----");
        accountRepository.searchAccounts(bankAccount ->
                bankAccount.getType().equals(AccountType.CURRENT_ACCOUNT))
                .forEach(System.out::println);

        System.out.println("---- ACTIVATED accounts (lambda) ----");
        accountRepository.searchAccounts(a -> a.getStatus() == AccountStatus.ACTIVATED)
                .forEach(System.out::println);

        System.out.println("---- CURRENT and ACTIVATED (&&) ----");
        accountRepository.searchAccounts(a -> a.getType() == AccountType.CURRENT_ACCOUNT
                        && a.getStatus() == AccountStatus.ACTIVATED)
                .forEach(System.out::println);

        System.out.println("---- CURRENT and ACTIVATED and balance > 50000 (Predicate.and) ----");
        Predicate<BankAccount> isCurrent = a -> a.getType() == AccountType.CURRENT_ACCOUNT;
        Predicate<BankAccount> isActivated = a -> a.getStatus() == AccountStatus.ACTIVATED;
        Predicate<BankAccount> isRich = a -> a.getBalance() > 50000;
        accountRepository.searchAccounts(isCurrent.and(isActivated).and(isRich))
                .forEach(System.out::println);
    }
}