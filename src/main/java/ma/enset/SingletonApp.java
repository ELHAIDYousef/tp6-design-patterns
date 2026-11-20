package ma.enset;

import ma.enset.repository.AccountRepositoryImpl;

/**
 *
 * @author Yousef ELHAID
 */
public class SingletonApp {
    public static void main(String[] args) {
        System.out.println("Start of main");

        AccountRepositoryImpl repository1 = AccountRepositoryImpl.getInstance();
        AccountRepositoryImpl repository2 = AccountRepositoryImpl.getInstance();
        AccountRepositoryImpl repository3 = AccountRepositoryImpl.getInstance();

        System.out.println(repository1);
        System.out.println(repository2);
        System.out.println(repository3);
        System.out.println("Same object? " + (repository1 == repository2 && repository2 == repository3));

        repository1.populateData();
        System.out.println("Accounts seen through repository3: " + repository3.findAll().size());
    }
}