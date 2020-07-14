package service;

import java.util.stream.IntStream;

public class MoneyServiceImpl implements MoneyService {

    private int totalMoney;
    private int balance;
    private int charge;

    public MoneyServiceImpl(){
        this.totalMoney = 0;
        this.balance = 0;
        this.charge = 0;
    }
    @Override
    public boolean validateMoney(int money) {
        int[] validMoney = {2000, 5000, 10000, 20000, 50000};

        return IntStream.of(validMoney).anyMatch(v -> v == money);
    }

    @Override
    public void deposit(int money) {
        this.balance += money;
    }

    @Override
    public int getBalance() {
        return this.balance;
    }

    @Override
    public int getCurrentBalance() {
        return this.balance-this.charge;
    }

    @Override
    public int getCharge() {
        return this.charge;
    }

    @Override
    public void addCharge(int charge) {
        this.charge += charge;
    }

    @Override
    public int getTotalMoney() {
        return this.totalMoney;
    }

    @Override
    public void save() {
        this.totalMoney += this.charge;
        this.balance = 0;
        this.charge = 0;
    }
}