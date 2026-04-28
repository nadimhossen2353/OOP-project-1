import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);


        System.out.println("-------Customer Registration------");
        System.out.println("Enter Customer ID: ");
        int id = input.nextInt();
        input.nextLine();

        System.out.print("Enter Customer Name : ");
        String name = input.nextLine();

        System.out.print("Enter Phone         : ");
        String phone = input.nextLine();

        Customer c1 = new Customer(id, name, phone);

        Car[] cars = {
                new Car(101, "Toyota", "Premio", 2022, 5000),
                new Car(102, "Honda", "Civic", 2021, 4500),
                new Car(103, "BMW", "X5", 2023, 9000)
        };

        Bike[] bikes = {
                new Bike(201, "Yamaha", "R15", 2023, 2000),
                new Bike(202, "Suzuki", "Gixxer", 2022, 1800),
                new Bike(203, "Honda", "CBR", 2024, 2500)
        };



        int again = 1;

        while (again == 1) {

            System.out.println("\n===== Vehicle Rental System =====");
            System.out.println("1. Rent Car");
            System.out.println("2. Rent Bike");
            System.out.println("3. Exit");
            System.out.print("Choose Option: ");
            int type = input.nextInt();

            if (type == 1) {

                System.out.println("\nAvailable Cars:");
                for (int i = 0; i < cars.length; i++) {
                    if (cars[i].checkAvailability()) {
                        System.out.println((i + 1) + ". " +
                                cars[i].getBrand() + " " +
                                cars[i].getModel() + " - " +
                                cars[i].getRentPerDay() + " Tk/day");
                    }
                }

                System.out.print("Select Car: ");
                int choice = input.nextInt();

                System.out.print("How many days: ");
                int days = input.nextInt();

                Car selectedCar = cars[choice - 1];

                if (selectedCar.checkAvailability()) {

                    selectedCar.reserveVehicle();
                    double total = selectedCar.calculateRent(days);

                    System.out.println("Payment Method:");
                    System.out.println("1. Bkash");
                    System.out.println("2. Nagad");
                    System.out.println("3. Cash");
                    int pay = input.nextInt();

                    String method = "Cash";
                    if (pay == 1) method = "Bkash";
                    else if (pay == 2) method = "Nagad";

                    Payment p1 = new Payment(501, total, method);

                    System.out.println("\n===== Booking Receipt =====");
                    selectedCar.showDetails();
                    System.out.println("Customer Name : " + c1.getName());
                    System.out.println("Customer Phone: " + phone);
                    System.out.println("Booked For    : " + days + " Days");
                    p1.showPaymentInfo();

                } else {
                    System.out.println("Car Not Available.");
                }

            } else if (type == 2) {

                System.out.println("\nAvailable Bikes:");
                for (int i = 0; i < bikes.length; i++) {
                    if (bikes[i].checkAvailability()) {
                        System.out.println((i + 1) + ". " +
                                bikes[i].getBrand() + " " +
                                bikes[i].getModel() + " - " +
                                bikes[i].getRentPerDay() + " Tk/day");
                    }
                }

                System.out.print("Select Bike: ");
                int choice = input.nextInt();

                System.out.print("How many days: ");
                int days = input.nextInt();

                Bike selectedBike = bikes[choice - 1];

                if (selectedBike.checkAvailability()) {

                    selectedBike.reserveVehicle();
                    double total = selectedBike.calculateRent(days);

                    System.out.println("Payment Method:");
                    System.out.println("1. Bkash");
                    System.out.println("2. Nagad");
                    System.out.println("3. Cash");
                    int pay = input.nextInt();

                    String method = "Cash";
                    if (pay == 1) method = "Bkash";
                    else if (pay == 2) method = "Nagad";

                    Payment p2 = new Payment(502, total, method);

                    System.out.println("\n===== Booking Receipt =====");
                    selectedBike.showDetails();
                    System.out.println("Customer Name : " + c1.getName());
                    System.out.println("Booked For    : " + days + " Days");
                    p2.showPaymentInfo();

                } else {
                    System.out.println("Bike Not Available.");
                }

            } else if (type == 3) {
                break;
            } else {
                System.out.println("Invalid Option.");
            }

            System.out.print("\nDo you want another booking? (press : 1=Yes / 0=No): ");
            again = input.nextInt();
        }


    }
}
