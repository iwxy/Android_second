package edu.pxxy.wxy.bean;

public class Food {

    private Integer id;
    private String foodName;
    private double foodPrice;
    private Integer count;

    public Food(Integer id, String foodName, double foodPrice, Integer count) {
        this.id = id;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.count = count;
    }

    public Food() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(double foodPrice) {
        this.foodPrice = foodPrice;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}

