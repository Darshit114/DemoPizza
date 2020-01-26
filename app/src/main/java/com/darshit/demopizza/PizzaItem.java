package com.darshit.demopizza;

public class PizzaItem {

    private int pizzaImageId;
    private String pizzaName;

    public PizzaItem(int pizzaImageId, String pizzaName) {
        this.pizzaImageId = pizzaImageId;
        this.pizzaName = pizzaName;
    }

    public int getPizzaImageId() {
        return pizzaImageId;
    }

    public void setPizzaImageId(int pizzaImageId) {
        this.pizzaImageId = pizzaImageId;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }
}
