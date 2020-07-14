package view;

import java.util.List;
import java.util.Scanner;
import model.Item;

public class ConsoleView implements View{
    private Scanner scanner = new Scanner(System.in);
    private int acceptNumber(){
        int result = 0;
        if(scanner.hasNextInt()){
            result = scanner.nextInt();
        }
        return result;
    }

    @Override
    public int start(){
        System.out.println("==========Simple Vending Machine Console==========");
        System.out.println("1. List Item");
        System.out.println("2. Buy Item");
        System.out.println("3. Turn Off");
        System.out.println("What would you like to do?");
        return acceptNumber();
    }

    @Override
    public void listItem(List<Item> items){
        System.out.println("==========List Item==========");
        for(Item item : items){
            System.out.printf("%d. %s (%d) %d available%n", item.getId(), item.getName(), item.getPrice(), item.getStock());
        }
    }

    @Override
	public int acceptMoney(int balance) {
        System.out.println("==========Buy Item==========");
        System.out.printf("Current Balance : %d%n", balance);
		System.out.println("Insert your money (Only accept 2000, 5000, 10000, 20000, 50000)");
        System.out.println("0 to complete your balance");
        return acceptNumber();
    }
    
    @Override
	public int pickableItem(List<Item> validItem, int balance) {
        System.out.println("==========Pick Item==========");
        for(Item item : validItem){
            System.out.printf("%d. %s (%d) %d available%n", item.getId(), item.getName(), item.getPrice(), item.getStock());
        }
        System.out.printf("Current Balance : %d%n", balance);
        System.out.println("What would you like to buy?");
        System.out.println("0 to finish your transaction and dispense");
		return acceptNumber();
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