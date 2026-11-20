package ma.enset.repository;

import ma.enset.model.AccountStatus;
import ma.enset.model.AccountType;
import ma.enset.model.BankAccount;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;

/**
 *
 * @author Yousef ELHAID
 */
public class AccountRepositoryImpl implements AccountRepository {
    private Map<Long, BankAccount> bankAccountMap = new HashMap<>();
    private long accountsCount = 0;

    @Override
    public BankAccount save(BankAccount bankAccount) {
        Long accountId = ++accountsCount;
        bankAccount.setAccountId(accountId);
        bankAccountMap.put(accountId, bankAccount);
        return bankAccount;
    }

    @Override
    public List<BankAccount> findAll() {
        return bankAccountMap.values().stream().toList();
    }

    @Override
    public Optional<BankAccount> findById(Long id) {
        BankAccount account = bankAccountMap.get(id);
        if (account == null) {
            return Optional.empty();
        }
        return Optional.of(account);
    }

    @Override
    public List<BankAccount> searchAccounts(Predicate<BankAccount> predicate) {
        return bankAccountMap.values().stream().filter(predicate).toList();
    }

    @Override
    public BankAccount update(BankAccount bankAccount) {
        bankAccountMap.put(bankAccount.getAccountId(), bankAccount);
        return bankAccount;
    }

    @Override
    public void deleteById(Long id) {
        bankAccountMap.remove(id);
    }

    public void populateData() {
        for (int i = 0; i < 10; i++) {
            BankAccount account = new BankAccount();
            account.setBalance(10000 + Math.random() * 90000);
            account.setType(Math.random() > 0.5 ? AccountType.SAVING_ACCOUNT : AccountType.CURRENT_ACCOUNT);
            account.setStatus(Math.random() > 0.5 ? AccountStatus.CREATED : AccountStatus.ACTIVATED);
            account.setCurrency(Math.random() > 0.5 ? "MAD" : "USD");
            save(account);
        }
    }
}