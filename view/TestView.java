package view;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import model.Item;

public class TestView implements View {

    private Queue<Integer> menuChoice;
    private Queue<Integer> moneyChoice;
    private Queue<Integer> itemChoice;

    public TestView(){
        this.menuChoice = new LinkedList<>();
        this.moneyChoice = new LinkedList<>();
        this.itemChoice = new LinkedList<>();
    }
    public void addMenuChoice(Integer n){
        this.menuChoice.add(n);
    }
    public void addMenuChoice(Integer[] q){
        for(Integer n : q){
            this.menuChoice.add(n);
        }
    }
    public void addMoneyChoice(Integer n){
        this.moneyChoice.add(n);
    }
    public void addMoneyChoice(Integer[] q){
        for(Integer n : q){
            this.moneyChoice.add(n);
        }
    }
    public void addItemChoice(Integer n){
        this.itemChoice.add(n);
    }
    public void addItemChoice(Integer[] q){
        for(Integer n : q){
            this.itemChoice.add(n);
        }
    }

    @Override
    public int start(){
        System.out.println("==========Simple Vending Machine Console==========");
        System.out.println("1. List Item");
        System.out.println("2. Buy Item");
        System.out.println("3. Turn Off");
        System.out.println("What would you like to do?");

        int result = menuChoice.remove();
        System.out.println(result);
        return result;
    }

    @Override
    public void listItem(List<Item> items){
        System.out.println("==========List Item==========");
        for(Item item : items){
            System.out.printf("%d. %s (%d)%n", item.getId(), item.getName(), item.getPrice());
        }
    }

    @Override
	public int acceptMoney(int balance) {
        System.out.println("==========Buy Item==========");
        System.out.printf("Current Balance : %d%n", balance);
		System.out.println("Insert your money (Only accept 2000, 5000, 10000, 20000, 50000)");
        System.out.println("0 to complete your balance");
        
        int result = moneyChoice.remove();
        System.out.println(result);
        return result;
    }
    
    @Override
	public int pickableItem(List<Item> validItem, int balance) {
        System.out.println("==========Pick Item==========");
        for(Item item : validItem){
            System.out.printf("%d. %s (%d)%n", item.getId(), item.getName(), item.getPrice());
        }
        System.out.printf("Current Balance : %d%n", balance);
        System.out.println("What would you like to buy?");
        System.out.println("0 to finish your transaction and dispense");

        int result = itemChoice.remove();
        System.out.println(result);
        return result;
    }
    
    @Override
	public void dispense(String[] boughtItem, int boughtTotal, int change) {
        System.out.println("==========Receipt==========");
        System.out.println("Bought Item : " + String.join(", ", boughtItem) );
        System.out.println("Your total  : " + boughtTotal);
        System.out.println("Your change : " + change);
        System.out.println("Thank you for purchasing");
        System.out.println("==================================================");
    }
    
    @Override
    public void end(int totalMoney){
        System.out.println("Total money earned from this run: " + totalMoney);
        System.out.println("Thank you for using Vending Machine!");
    }
    
    @Override
    public void invalidInput(){
        System.err.println("Invalid input detected! Please only enter the choice on vending machine");
    }
    
    @Override
	public void invalidMoney() {
        System.err.println("Money not accepted becase its not valid!");
	}
    
    @Override
    public void invalidItem() {
        System.err.println("There is no such item choice!");
    }
}