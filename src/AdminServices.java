import java.util.InputMismatchException;
import java.util.Scanner;

public class AdminServices {
    static FoodDeliveryManagementSystem fdms = new FoodDeliveryManagementSystem();
    static Scanner sc = new Scanner(System.in);
    static Admin admin = new Admin();
    public static void loginAsAdmin() throws SizeLimitExceeded {
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();
        if(admin.getUsername().equals(username) && admin.getPassword().equals(password)){
            System.out.println("Logged in as Admin.");
            adminMenu();
        }
        else{
            System.out.println("Invalid admin credentials. Please try again.");
        }
    }

    public static void adminMenu() throws SizeLimitExceeded{
        while(true){
            try{
                System.out.println("\n---Admin Menu---");
                System.out.println("1. Add food item");
                System.out.println("2. Update food item");
                System.out.println("3. Remove food item");
                System.out.println("4. Display all food items");
                System.out.println("5. Display all customers");
                System.out.println("6. Add delivery boys");
                System.out.println("7. Update delivery boys");
                System.out.println("8. Remove delivery boys");
                System.out.println("9. Display all delivery boys");
                System.out.println("10. Logout");

                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice){
                    case 1: addFoodItem(); break;
                    case 2: updateFoodItem(); break;
                    case 3: removeFoodItem(); break;
                    case 4: foodMenu(); break;
                    case 5: displayAllCustomers(); break;
                    case 6: try{ addDeliveryBoys(); } //exception handling
                    catch(SizeLimitExceeded e){
                        System.out.println("System Limit: " + e.getMessage());
                    }break;
                    case 7: updateDeliveryBoys(); break;
                    case 8: removeDeliveryBoys(); break;
                    case 9: displayAllDeliveryboys(); break;
                    case 10: return;
                    default: System.out.println("Invalid choice. Please enter valid one.");
                }
            }
            catch(InputMismatchException e){
                System.out.println("Kindly select an integer value among above listed!");
                return;
            }
        }
    }

    public static void addFoodItem(){
        System.out.println("\n---Add Food Item---");
        System.out.println("1. Dindigul Thalappakati");
        System.out.println("2. KFC");
        System.out.println("3. Anandha Bhavan");
        System.out.print("\nEnter restaurant id to add the food item to the menu: ");
        int restaurantId =sc.nextInt();
        sc.nextLine();

        System.out.print("Enter the dish id: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter the dish name: ");
        String dish = sc.nextLine();
        System.out.print("Enter the price: ");
        double price = sc.nextDouble();
        sc.nextLine();

        if(restaurantId == 1){
            int i = fdms.foodsList1Count;
            fdms.foodsList1[i] = new Food();
            fdms.foodsList1[i].setId(id);
            fdms.foodsList1[i].setDish(dish);
            fdms.foodsList1[i].setPrice(price);
            fdms.foodsList1Count++;
            System.out.println("Dish added successfully.");
        } else if (restaurantId == 2) {
            int j = fdms.foodsList2Count;
            fdms.foodsList2[j] = new Food();
            fdms.foodsList2[j].setId(id);
            fdms.foodsList2[j].setDish(dish);
            fdms.foodsList2[j].setPrice(price);
            fdms.foodsList2Count++;
            System.out.println("Dish added successfully.");
        }
        else if (restaurantId == 3) {
            int k = fdms.foodsList3Count;
            fdms.foodsList3[k] = new Food();
            fdms.foodsList3[k].setId(id);
            fdms.foodsList3[k].setDish(dish);
            fdms.foodsList3[k].setPrice(price);
            fdms.foodsList3Count++;
            System.out.println("Dish added successfully.");
        }
        else{
            System.out.println("Invalid id. Please try again.");
        }
    }

    public static void updateFoodItem(){
        System.out.println("\n---Update Food Item---");
        System.out.println("1. Dindigul Thalappakati");
        System.out.println("2. KFC");
        System.out.println("3. Anandha Bhavan");
        System.out.print("Enter restaurant id whose food menu you want to update: ");
        int restaurantId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter the dish id: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter the dish name: ");
        String dish = sc.nextLine();
        System.out.print("Enter the price: ");
        double price = sc.nextDouble();
        sc.nextLine();

        if(restaurantId == 1){
            for(Food food : fdms.foodsList1){
                if(food.getId() == id){
                    food.setDish(dish);
                    food.setPrice(price);
                    break;
                }
            }
            System.out.println("Food item updated successfully.");
        }
        else if (restaurantId == 2) {
            for(Food food : fdms.foodsList2){
                if(food.getId() == id){
                    food.setDish(dish);
                    food.setPrice(price);
                    break;
                }
            }
            System.out.println("Food item updated successfully.");
        }
        else if (restaurantId == 3) {
            for(Food food : fdms.foodsList3){
                if(food.getId() == id){
                    food.setDish(dish);
                    food.setPrice(price);
                    break;
                }
            }
            System.out.println("Food item updated successfully.");
        }
        else{
            System.out.println("Invalid id. Please try again.");
        }
    }

    public static void removeFoodItem(){
        System.out.print("Enter restaurant id to open food menu: ");
        int restaurantId = sc.nextInt();
        sc.nextLine();

        Food[] foodsList = findFoodListById(restaurantId);

        if(foodsList == null) {
            System.out.println("Invalid id. Please try again.");
            return;
        }

        System.out.print("Enter food id to remove the food item: ");
        int foodId = sc.nextInt();
        sc.nextLine();

        Food[] TempFoodList = new Food[foodsList.length];

        int i = 0;

        for(int j = 0;j < foodsList.length;j++){
            if(foodsList[j] != null && foodsList[j].getId() != foodId){
                TempFoodList[i++] = foodsList[j];
            }
        }

        for(int j = 0;j < foodsList.length;j++){
            foodsList[j++] = TempFoodList[j++];
        }

        if(restaurantId == 1){
            fdms.foodsList1Count ++;
        }
        else if(restaurantId == 2){
            fdms.foodsList2Count++;
        }
        else{
            fdms.foodsList3Count++;
        }

        System.out.println("Food item removed successfully.");
    }

    private static void foodMenu(){
        while(true){
            System.out.println("\n---Restaurants---");
            System.out.println("1. Dindigul Thalappakati");
            System.out.println("2. KFC");
            System.out.println("3. Anandha Bhavan");
            System.out.println("4. Close the menu!");
            System.out.print("Enter the choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1:
                    System.out.println("\n---Dindigul Thalappakati---");
                    boolean value = true;
                    for(int i = 0;i < fdms.foodsList1Count;i++){
                        if(fdms.foodsList1 != null){
                            value = true;
                            System.out.println(fdms.foodsList1[i].getId() + ". Dish: " + fdms.foodsList1[i].getDish() + ", Price: Rs." + fdms.foodsList1[i].getPrice());
                        }
                        else{
                            value = false;
                        }
                    }
                    if(!value){
                        System.out.println("Food menu is empty!");
                    }
                    break;
                case 2:
                    System.out.println("\n---KFC---");
                    boolean value1 = true;
                    for(int i = 0;i < fdms.foodsList2Count;i++){
                        if(fdms.foodsList2 != null){
                            value1 = true;
                            System.out.println(fdms.foodsList2[i].getId() + ". Dish: " + fdms.foodsList2[i].getDish() + ", Price: Rs." + fdms.foodsList2[i].getPrice());
                        }
                        else{
                            value1 = false;
                        }
                    }
                    if(!value1){
                        System.out.println("Food menu is empty!");
                    }
                    break;
                case 3:
                    System.out.println("\n---Anandha Bhavan---");
                    boolean value2 = true;
                    for(int i = 0;i < fdms.foodsList3Count;i++){
                        if(fdms.foodsList3 != null) {
                            value2 = true;
                            System.out.println(fdms.foodsList3[i].getId() + ". Dish: " + fdms.foodsList3[i].getDish() + ", Price: Rs." + fdms.foodsList3[i].getPrice());
                        }
                        else{
                            value2 = false;
                        }
                    }
                    if(!value2){
                        System.out.println("Food menu is empty!");
                    }
                    break;
                case 4: System.out.println("Food menu is closing...");return;
                default: System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static Food[] findFoodListById(int restaurantId){
        if(restaurantId == 1){
            return fdms.foodsList1;
        }
        else if(restaurantId == 2){
            return fdms.foodsList2;
        }
        else if(restaurantId == 3){
            return fdms.foodsList3;
        }
        return null;
    }

    private static void displayAllCustomers(){
        System.out.println("\n---Customers---");
        for(int i = 0;i < fdms.customerCount;i++){
            System.out.println(fdms.customers[i].getId() + ". Name: " + fdms.customers[i].getUsername() + ", Location: " + fdms.customers[i].getLocation() + ", PhoneNo: " + fdms.customers[i].getPhoneNo());
        }
    }

    private static void addDeliveryBoys() throws SizeLimitExceeded {//perfect logic
        System.out.println("\n---Add Delivery Boys---");
        System.out.print("Count: ");
        int count = sc.nextInt();
        sc.nextLine();

        if(count > fdms.deliveryBoys.length || count + fdms.deliveryBoysCount > fdms.deliveryBoys.length){
            throw new SizeLimitExceeded("Count should be less than the list size, " + fdms.deliveryBoys.length +
                    " && when added to existing count, " + fdms.deliveryBoysCount + " should not exceed the list size!");
        }

        else{
            int k = fdms.deliveryBoysCount + 1;
            int id = 0;
            for(int i = fdms.deliveryBoysCount;i <= count;i++){
                System.out.println("\n---Enter delivery boy" + (i+1) + " details!---");
                System.out.print("Name: ");
                String name = sc.nextLine();

                System.out.print("Phone No: ");
                String phoneNo = sc.nextLine();

                System.out.print("Vehicle No: ");
                String vehicleNo = sc.nextLine();

                id = k++;
                String code = "DB_" + id;

                DeliveryBoys db = new DeliveryBoys();
                db.setName(name);
                db.setId(id);
                db.setPhoneNo(phoneNo);
                db.setVehicleNo(vehicleNo);
                db.setDbCode(code);
                fdms.deliveryBoys[i] = db;
                fdms.deliveryBoysCount++;
            }

            System.out.println("Delivery boy(s) added successfully.");
        }
    }

    private static void displayAllDeliveryboys(){
        System.out.println("\n---List of Delivery Boys---");
        for(int i = 0;i < fdms.deliveryBoysCount;i++){
            if(fdms.deliveryBoys[i] == null){
                System.out.println("It's empty! There are no delivery boys present.");
            }
            else{
                System.out.println("------Delivery Boy " + (i+1) + "------");
                System.out.println("Id: " + fdms.deliveryBoys[i].getId());
                System.out.println("Code: " + fdms.deliveryBoys[i].getDbCode());
                System.out.println("Name: " + fdms.deliveryBoys[i].getName());
                System.out.println("Phone No: " + fdms.deliveryBoys[i].getPhoneNo());
                System.out.println("Vehicle No: " + fdms.deliveryBoys[i].getVehicleNo());
                System.out.println("----------------------------");
            }
        }
    }

    public static void updateDeliveryBoys(){
        System.out.println("\n---Update Delivery Boy---");
        System.out.println("---Enter delivery boy details---");
        System.out.print("Id: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Phone No: ");
        String phoneNo = sc.nextLine();
        System.out.print("Vehicle No: ");
        String vehicleNo = sc.nextLine();

        boolean exist = true;

        for(DeliveryBoys d : fdms.deliveryBoys){
            if(d.getId() == id){
                exist = true;
                d.setName(name);
                d.setPhoneNo(phoneNo);
                d.setVehicleNo(vehicleNo);
                break;
            }
            else{
                exist = false;
            }
        }
        if(!exist){
            System.out.println("Delivery boy not exist");
        }
        else{
            System.out.println("Delivery boy updated successfully.");
        }
    }

    public static void removeDeliveryBoys(){
        System.out.print("\nEnter count of Delivery boys: ");
        int count = sc.nextInt();

        DeliveryBoys[] temp = new DeliveryBoys[fdms.deliveryBoys.length];

        if(count > fdms.deliveryBoysCount){
            System.out.println("Count should be less than the list size, " + fdms.deliveryBoys.length +
                    " && when added to existing count, " + fdms.deliveryBoysCount + " should not exceed the list size!");
        }
        else{
            int k = 0;
            for(int i = 0;i < count;i++){
                System.out.print("Enter delivery boy id: ");
                int id = sc.nextInt();

                for(int j = 0;j < fdms.deliveryBoysCount;j++){
                    if(fdms.deliveryBoys[j] != null && fdms.deliveryBoys[j].getId() != id){
                        temp[k++] = fdms.deliveryBoys[j];
                    }
                }
            }
            int j = 0;
            for(DeliveryBoys d : temp){
                fdms.deliveryBoys[j++] = d;
            }
            System.out.println("Delivery boy removed successfully.");
            fdms.deliveryBoysCount = k;
        }
    }
}




//                System.out.println("10. Allocate delivery boys");
//                case 10: allocateDeliveryBoy();//haven't build logic yet