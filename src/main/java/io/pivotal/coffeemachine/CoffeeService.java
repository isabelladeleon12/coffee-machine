package io.pivotal.coffeemachine;

import java.util.*;

public class CoffeeService {

	private Inventory inventory;
	private HashMap<String, Double> menu = new HashMap<>();
	private HashMap<String, Drink> drinks = new HashMap<>();

	public CoffeeService(Inventory inventory) {
		this.inventory = inventory;
		menu.put("coffee", 2.75);
		menu.put("cappuccino", 2.90);
		menu.put("caffe mocha", 3.90);

		//name, cost, ingredients,
		Drink coffee = new Drink();
		coffee.setName("coffee");
		coffee.setCost(menu.get(coffee.getName()));
		HashMap<String, Integer> coffeeIngred = new HashMap<>();
		coffeeIngred.put("coffee", 2);
		coffeeIngred.put("sugar", 1);
		coffeeIngred.put("cream", 0);
		coffee.setIngredients(coffeeIngred);

		Drink cappuccino = new Drink();
		cappuccino.setName("cappucino");
		cappuccino.setCost(menu.get(cappuccino.getName()));
		HashMap<String, Integer> capIngred = new HashMap<>();
		capIngred.put("coffee", 2);
		capIngred.put("sugar", 1);
		capIngred.put("cream", 1);
		cappuccino.setIngredients(capIngred);

		Drink caffe_mocha = new Drink();
		caffe_mocha.setName("caffe mocha");
		caffe_mocha.setCost(menu.get(caffe_mocha.getName()));
		HashMap<String, Integer> caffeIngred = new HashMap<>();
		caffeIngred.put("coffee", 1);
		caffeIngred.put("sugar", 1);
		caffeIngred.put("cream", 1);
		caffe_mocha.setIngredients(coffeeIngred);

		drinks.put("coffee", coffee);
		drinks.put("cappuccino", cappuccino);
		drinks.put("caffe mocha", caffe_mocha);

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

}
