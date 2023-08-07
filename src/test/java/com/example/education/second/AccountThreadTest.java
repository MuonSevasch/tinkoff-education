package com.example.education.second;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AccountThreadTest {

    @Test
    void deadLockTest() {
        Account account1 = new Account(1000);
        Account account2 = new Account(2000);

        Thread thread1 = new Thread(new AccountThread(account1, account2, 100));
        Thread thread2 = new Thread(new AccountThread(account2, account1, 200));

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final balance of account1: " + account1.getCacheBalance());
        System.out.println("Final balance of account2: " + account2.getCacheBalance());
    }
}