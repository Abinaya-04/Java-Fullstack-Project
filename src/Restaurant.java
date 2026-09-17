public class Restaurant {
    private int id;
    private String restaurantName;
    private Food[] foodList;

    public int getId() { return id; }

    public String getRestaurantName() {
        return restaurantName;
    }

    public Food[] getFoodList() {
        return foodList;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public void setFoodList(Food[] foodList) {
        this.foodList = foodList;
    }
}
