package service;

import java.util.ArrayList;
import java.util.List;

import model.Item;

public class ItemServiceImpl implements ItemService {
    List<Item> items;
    List<Item> boughtItems;
    List<Item> availableItems;

    public ItemServiceImpl(){
        this.items = new ArrayList<>();
        this.boughtItems = new ArrayList<>();
        this.availableItems = new ArrayList<>();
    }

    @Override
    public void setItems(List<Item> items) {
        this.items = items;
        this.availableItems = items;
    }

    @Override
    public List<Item> getItems() {
        return items;
    }

    public Item findItem(int id){
        for(Item it : availableItems){
            if(it.getId() == id && it.getStock() > 0){
                return it;
            }
        }
        return null;
    }

    @Override
    public List<Item> getValidItem(int money) {
        List<Item> result = new ArrayList<>();
        for(Item it : availableItems){
            if(it.getPrice() <= money && it.getStock() > 0){
                result.add(it);
            }
        }
        return result;
    }

    @Override
    public void addBoughtItem(Item item) {
        this.boughtItems.add(item);
        for(Item ai : availableItems){
            if(ai.getId() == item.getId()){
                ai.setStock(ai.getStock() - 1);
            }
        }

    }

    @Override
    public String[] getBoughtItem() {
        String[] result = new String[boughtItems.size()];
        for(int i = 0; i < result.length; i++){
            result[i] = boughtItems.get(i).getName();
        }
        return result;
    }

    /**
     * Save the current available items into the machine items
     */
    @Override
    public void save() {
        items = availableItems;
    }
}