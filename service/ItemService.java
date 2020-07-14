package service;

import java.util.List;

import model.Item;

public interface ItemService{
    
    void setItems(List<Item> items);

    List<Item> getItems();

    Item findItem(int id);

    List<Item> getValidItem(int money);
    
    void addBoughtItem(Item item);
    
    String[] getBoughtItem();
    
    void save();
}