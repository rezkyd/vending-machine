package view;

import java.util.List;

import model.Item;

public interface View {
    int start();
    void listItem(List<Item> items);
    int acceptMoney(int balance);
    int pickableItem(List<Item> validItem, int currentBalance);
    void dispense(String[] itemName, int total, int change);
    void end(int totalMoney);

    void invalidInput();
    void invalidMoney();
    void invalidItem();
}