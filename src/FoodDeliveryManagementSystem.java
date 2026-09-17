import java.util.Scanner;

public class FoodDeliveryManagementSystem {
    static Scanner sc = new Scanner(System.in);

    static Customer c = new Customer();

    static Customer[] customers = new Customer[5];
    static int customerCount = 1;

    static DeliveryBoys[] deliveryBoys = new DeliveryBoys[5];
    static int deliveryBoysCount = 1;

    static Restaurant[] restaurants = new Restaurant[3];

    static Food[] foodsList1 = new Food[5];
    static int foodsList1Count = 1;

    static Food[] foodsList2 = new Food[5];
    static int foodsList2Count = 1;

    static Food[] foodsList3 = new Food[5];
    static int foodsList3Count = 1;

    public static void main(String[] args) throws InvalidRole, SizeLimitExceeded {
        customers[0] = new Customer();
        customers[0].setId(1);
        customers[0].setUsername("Abinaya J");
        customers[0].setLocation("Velachery");
        customers[0].setPhoneNo("6383325022");

        deliveryBoys[0] = new DeliveryBoys();
        deliveryBoys[0].setId(1);
        deliveryBoys[0].setDbCode("DB_1");
        deliveryBoys[0].setName("Karthik");
        deliveryBoys[0].setPhoneNo("8778699232");
        deliveryBoys[0].setVehicleNo("TN 01 AB 1234");

        restaurants[0] = new Restaurant();
        restaurants[0].setId(1);
        restaurants[0].setRestaurantName("Dindigul Thalappakati");
        restaurants[0].setFoodList(foodsList1);

        restaurants[1] = new Restaurant();
        restaurants[1].setId(2);
        restaurants[1].setRestaurantName("KFC");
        restaurants[1].setFoodList(foodsList2);

        restaurants[2] = new Restaurant();
        restaurants[2].setId(3);
        restaurants[2].setRestaurantName("Anandha Bhavan");
        restaurants[2].setFoodList(foodsList3);

        foodsList1[0] = new Food();
        foodsList1[0].setId(1);
        foodsList1[0].setDish("Chicken Biryani");
        foodsList1[0].setPrice(360.00);

        foodsList2[0] = new Food();
        foodsList2[0].setId(1);
        foodsList2[0].setDish("Zinger Burger");
        foodsList2[0].setPrice(199.00);

        foodsList3[0] = new Food();
        foodsList3[0].setId(1);
        foodsList3[0].setDish("Full Meals");
        foodsList3[0].setPrice(120.00);

        System.out.println("------Food Delivery Management System------");
        while(true){
            System.out.print("\nEnter role admin/user or 'quit': ");
            String role = sc.nextLine();

            if(role.equals("admin")){
                AdminServices.loginAsAdmin();
            }
            else if(role.equals("user")){
                CustomerServices.loginAsUser();
            }
            else if(role.equals("quit")){
                break;
            }
            else{
                System.out.println("Invalid role. Please try again");
                throw new InvalidRole("The role must be present in the above mentioned!");
            }
        }
    }
}






//foodcart

//        customers[1] = new Customer();
//        customers[1].setUsername("Justin Raj S");
//        customers[1].setLocation("Thambaram");
//        customers[1].setPhoneNo("8778699232");

//        deliveryBoys[1].setName("Vikram");
//        deliveryBoys[1].setPhoneNo("8220795312");
//        deliveryBoys[1].setVehicleNo("TN 27 BC 6724");

//        foodsList1[1] = new Food();
//        foodsList1[1].setId(2);
//        foodsList1[1].setDish("Mutton Biryani");
//        foodsList1[1].setPrice(380.00);

//        foodsList2[1] = new Food();
//        foodsList2[1].setId(2);
//        foodsList2[1].setDish("Fried chicken Wings");
//        foodsList2[1].setPrice(299.00);

//        foodsList3[1] = new Food();
//        foodsList3[1].setId(2);
//        foodsList3[1].setDish("Variety Rice");
//        foodsList3[1].setPrice(60.00);