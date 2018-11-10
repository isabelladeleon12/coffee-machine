package io.pivotal.coffeemachine;

public class InventoryTestClass extends InventoryTests {

    @Override
    protected Inventory getInventory() {
        MachineInventory myInventory = new MachineInventory();
        return myInventory;
    }
}
