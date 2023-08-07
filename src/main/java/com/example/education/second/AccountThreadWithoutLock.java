package com.example.education.second;

public class AccountThreadWithoutLock implements Runnable {

    private final Account accountFrom;
    private final Account accountTo;
    private final int money;

    public AccountThreadWithoutLock(Account accountFrom, Account accountTo, int money) {
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.money = money;
    }

    @Override
    public void run() {
        for (int i = 0; i < 4000; i++) {
            // Избегаем ситуации дедлока, блокируя аккаунты в одном и том же порядке
            if (accountFrom.hashCode() < accountTo.hashCode()) {
                synchronized (accountFrom) {
                    synchronized (accountTo) {
                        transferMoney();
                    }
                }
            } else {
                synchronized (accountTo) {
                    synchronized (accountFrom) {
                        transferMoney();
                    }
                }
            }
        }
    }

    private void transferMoney() {
        if (accountFrom.takeOffMoney(money)) {
            accountTo.addMoney(money);
        }
    }
}