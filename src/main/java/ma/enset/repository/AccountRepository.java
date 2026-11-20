package ma.enset.repository;

import ma.enset.model.BankAccount;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

/**
 *
 * @author Yousef ELHAID
 */
public interface AccountRepository {
    BankAccount save(BankAccount bankAccount);

    List<BankAccount> findAll();

    Optional<BankAccount> findById(Long id);

    List<BankAccount> searchAccounts(Predicate<BankAccount> predicate);

    BankAccount update(BankAccount bankAccount);

    void deleteById(Long id);
}