package io.pivotal.coffeemachine;

import java.util.*;

public class CoffeeService {

	private Inventory inventory;
	private HashMap<String, Double> menu = new HashMap<>();
	private HashMap<String, Drink> drinks = new HashMap<>();

	public CoffeeService(Inventory inventory) {
		this.inventory = inventory;
		addDrink("coffee", 2.75, 2, 1, 0);
		addDrink("cappuccino", 2.90, 2, 1, 1);
		addDrink("caffe mocha", 3.90, 1, 1, 1);
	}


	/**
	 * Returns the menu for this coffee machine.
	 *
	 * @return a map of drink name to drink cost
	 */
	public Map<String, Double> getMenu() {
		return this.menu;
	}


	/**
	 * Make a drink using the given name. Ingredients for the drink are deducted from the inventory.
	 *
	 * @param name the name of the drink
	 */
	public Drink makeDrink(String name) {
		Map<String, Integer> ingredients = drinks.get(name).getIngredients();
		Set<String> parts = ingredients.keySet();
		for (String part : parts) {
			inventory.deduct(part, ingredients.get(part));
		}
		return drinks.get(name);
	}

	public void addDrink(String name, double cost, int coffee, int sugar, int cream) {
		Drink newDrink = new Drink();
		newDrink.setName(name);
		newDrink.setCost(cost);
		HashMap<String, Integer> ingred = new HashMap<>();
		ingred.put("coffee", coffee);
		ingred.put("sugar", sugar);
		ingred.put("cream", cream);
		newDrink.setIngredients(ingred);
		menu.put(name, cost);
		drinks.put(name, newDrink);
	}

}
