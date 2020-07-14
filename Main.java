
import java.util.ArrayList;
import java.util.List;

import controller.VendingMachine;
import model.Item;
import view.ConsoleView;
import view.TestView;
import view.View;

public class Main {
    public static void main(String[] args) {
        View viewMode;
        String mode = args.length > 0 ? args[0]: "";
        if(mode.equalsIgnoreCase("test")){
            TestView testView = new TestView();
            testView.addMenuChoice(1);
            testView.addMenuChoice(2);
            // Money choice must end at 0
            testView.addMoneyChoice(new Integer[]{2000, 2050, 5000, 4000, 0});
            // Item choice must end at 0
            testView.addItemChoice(new Integer[]{1, 2, 3, 0});
            // Menu choice must end at 3
            testView.addMenuChoice(3);

            viewMode = testView;
        } else{
            viewMode = new ConsoleView();
        }
        
        List<Item> items = new ArrayList<>();
        items.add(new Item(1, "Biskuit", 6000, 10));
        items.add(new Item(2, "Chips", 8000, 10));
        items.add(new Item(3, "Oreo", 10000, 10));
        items.add(new Item(4, "Tango", 12000, 10));
        items.add(new Item(5, "Cokelat", 15000, 10));

        VendingMachine vm = new VendingMachine(viewMode);
        vm.initItems(items);
        while(!vm.isComplete()){
            vm.process();
        }
    }
}