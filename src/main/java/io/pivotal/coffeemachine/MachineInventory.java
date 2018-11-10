package io.pivotal.coffeemachine;

import java.util.HashMap;
import java.util.Map;

public class MachineInventory implements Inventory {

    HashMap<String, Integer> currInventory = new HashMap<>();
    public MachineInventory() {
        //Default starting units for each ingredient.
        currInventory.put("coffee", 10);
        currInventory.put("sugar", 10);
        currInventory.put("cream", 10);
    }


    @Override
    public Map<String, Integer> getIngredients() {
        return currInventory;
    }

    @Override
    public void deduct(String name, Integer amount) {
        //Units cannot fall below 0
        if (currInventory.get(name) - amount < 0) {
            System.out.println("Not enough " + name + "!");
        }
        currInventory.put(name, currInventory.get(name) - amount);
    }
}
