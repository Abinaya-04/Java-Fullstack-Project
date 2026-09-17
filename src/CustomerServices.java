import java.util.Scanner;
public class CustomerServices {
    static Customer customer = new Customer();
    static FoodDeliveryManagementSystem fdms = new FoodDeliveryManagementSystem();
    static Scanner sc = new Scanner(System.in);

    public static void loginAsUser(){
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        if (findCustomerByUsername(username) != null) {
            System.out.println("Welcome back! " + username + " .");
            userMenu();
        }
        else{
            System.out.print("Enter location: ");
            String location = sc.nextLine();
            System.out.print("Enter phone number: ");
            String phoneNo = sc.nextLine();
            fdms.customers[fdms.customerCount++] = new Customer();
            fdms.customers[fdms.customerCount++].setUsername(username);
            fdms.customers[fdms.customerCount++].setLocation(location);
            fdms.customers[fdms.customerCount++].setPhoneNo(phoneNo);
            System.out.println("Registered and logged in as " + username + " !");
            userMenu();
        }
    }

    public static void userMenu(){
        while(true){
            System.out.println("\n---User Menu---");
            System.out.println("1. View food menu");
            System.out.println("2. Logout");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1: foodMenu(); break;
                case 2: return;
                default: System.out.println("Invalid choice. Please enter valid one.");
            }
        }
    }

    public static String findCustomerByUsername(String username){
        for(int i = 0; i < fdms.customerCount; i++){
            if(fdms.customers[i].getUsername().equals(username)){
                return username;
            }
        }
        return null;
    }

    private static void foodMenu(){
        while(true){
            System.out.println("\n---Restaurants---");
            System.out.println("1. Dindigul Thalappakati");
            System.out.println("2. KFC");
            System.out.println("3. Anandha Bhavan");
            System.out.println("4. Stop!");
            System.out.print("Enter the choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1:
                    System.out.println("\n---Dindigul Thalappakati---");
                    for(int i = 0;i < fdms.foodsList1Count;i++){
                        System.out.println(fdms.foodsList1[i].getId() + ". Dish: " + fdms.foodsList1[i].getDish() + ", Price: Rs." + fdms.foodsList1[i].getPrice());
                    }
                    break;
                case 2:
                    System.out.println("---KFC---");
                    for(int i = 0;i < fdms.foodsList2Count;i++){
                        System.out.println(fdms.foodsList2[i].getId() + ". Dish: " + fdms.foodsList2[i].getDish() + ", Price: Rs." + fdms.foodsList2[i].getPrice());
                    }
                    break;
                case 3:
                    for(int i = 0;i < fdms.foodsList3Count;i++){
                        System.out.println("---Anandha Bhavan---");
                        System.out.println(fdms.foodsList3[i].getId() + ". Dish: " + fdms.foodsList3[i].getDish() + ", Price: Rs." + fdms.foodsList3[i].getPrice());
                    }
                    break;
                case 4: return;
                default: System.out.println("Invalid choice.");
            }
        }
    }
}






//    public static String findFoodById(int id){
//
//    }


//                case 2: orderFood(); break;
//                case 3: trackOrder(); break;

//            System.out.println("2. Order food");//haven't implemented the logic yet
//            System.out.println("3. Track your order");//haven't build logic yet