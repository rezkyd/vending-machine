package controller;

import java.util.List;

import model.Item;
import view.View;
import service.ItemService;
import service.ItemServiceImpl;
import service.MoneyService;
import service.MoneyServiceImpl;

enum Step{
    START,
    LIST_ITEM,
    ENTER_MONEY,
    PICK_ITEM,
    DISPENSE,
    TURN_OFF,
    END
}
public class VendingMachine extends Controller {
    private ItemService itemService;
    private MoneyService moneyService;
    private View view;
    private Step step;

    public VendingMachine(View viewImplement){
        this.itemService = new ItemServiceImpl();
        this.moneyService = new MoneyServiceImpl();
        this.view = viewImplement;
        this.step = Step.START;
    }
    
    public void initItems(List<Item> listItems){
        this.itemService.setItems(listItems);
    }
    
    public boolean isComplete(){
        return this.step == Step.END;
    }
    public void process(){
        switch(this.step){
            case START:
                stepStart();
            break;
            case LIST_ITEM:
                stepListItem();
            break;
            case ENTER_MONEY:
                stepEnterMoney();
            break;
            case PICK_ITEM:
                stepPickItem();
            break;
            case DISPENSE:
                stepDispense();
            break;
            case TURN_OFF:
                stepTurnOff();
            break;
            case END:
            break;
        }
    }
    private void stepStart(){
        int next = this.view.start();
        if(next == 1){
            this.step = Step.LIST_ITEM;
        } else if(next == 2){
            this.step = Step.ENTER_MONEY;
        } else if(next == 3){
            this.step = Step.TURN_OFF;
        } else{
            this.view.invalidInput();
        }
    }
    private void stepListItem(){
        this.view.listItem(this.itemService.getItems());
        this.step = Step.START;
    }
    private void stepEnterMoney(){
        int balance = this.moneyService.getBalance();
        int result = this.view.acceptMoney(balance);
        if(result > 0){
            boolean isValid = this.moneyService.validateMoney(result);
            if(isValid){
                this.moneyService.deposit(result);
            } else{
                this.view.invalidMoney();
            } 
        }else{
            this.step = Step.PICK_ITEM;
        }
    }
    private void stepPickItem(){
        int currentBalance = this.moneyService.getCurrentBalance();
        List<Item> validItem = this.itemService.getValidItem(currentBalance);
        if(!validItem.isEmpty()){
            int id = this.view.pickableItem(validItem, currentBalance);
            if(id > 0){
                Item item = this.itemService.findItem(id);
                if(item != null && item.getPrice() < currentBalance){
                    this.itemService.addBoughtItem(item);
                    this.moneyService.addCharge(item.getPrice());
                } else{
                    this.view.invalidItem();
                }
            } else{
                this.step = Step.DISPENSE;
            }
        } else{
            this.step = Step.DISPENSE;
        }
        
    }
    private void stepDispense(){
        String[] boughtItem = this.itemService.getBoughtItem();
        int change = this.moneyService.getCurrentBalance();
        int boughtTotal = this.moneyService.getCharge();
        this.view.dispense(boughtItem, boughtTotal, change);
        this.itemService.save();
        this.moneyService.save();
        this.step = Step.START;
    }
    private void stepTurnOff(){
        int totalMoney = this.moneyService.getTotalMoney();
        this.view.end(totalMoney);
        this.step = Step.END;
    }
    
}