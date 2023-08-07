package com.example.education.second;

public class AccountThread implements Runnable {

    private final Account accountFrom;
    private final Account accountTo;
    private final int money;

    public AccountThread(Account accountFrom, Account accountTo, int money) {
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.money = money;
    }

    @Override
    public void run() {
        synchronized (accountFrom) { // Заблокируем аккаунтFrom
            try {
                Thread.sleep(100); // Имитируем небольшую задержку для увеличения вероятности deadlock
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (accountTo) { // Теперь попытаемся заблокировать аккаунтTo (должен быть заблокирован в другом потоке)
                if (accountFrom.takeOffMoney(money)) {
                    accountTo.addMoney(money);
                }
            }
        }
    }
}