import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println(" Enter Customer Details ");

        System.out.print("Enter ID: ");
        int id = input.nextInt();
        input.nextLine();

        System.out.print("Enter Name: ");
        String name = input.nextLine();

        System.out.print("Enter Email: ");
        String email = input.nextLine();

        System.out.print("Enter Phone: ");
        String phone = input.nextLine();

        Customer c1 = new Customer(id, name, email, phone);

        Car[] car1={
                new Car(101, "Toyota", "Premio", 2022, 5000),
                new Car(102, "Honda", "Civic", 2021, 4500),
                new Car(103, "BMW", "X5", 2023, 9000)
        };

        Bike[] bike1 = {
                new Bike(201, "Yamaha", "R15", 2023, 2000),
                new Bike(202, "Suzuki", "Gixxer", 2022, 1800),
                new Bike(203, "Honda", "CBS", 2024, 2500)
        };



        System.out.println("\n Wellcome to Vehicle Rental System ");
        System.out.println("1. Rent Car");
        System.out.println("2. Rent Bike");
        System.out.print("Take any Option: ");
        int type = input.nextInt();

        if (type == 1) {

            System.out.println("\nAvailable Cars:");
            for (int i = 0; i < car1.length; i++) {
                System.out.println((i + 1) + ". " +
                        car1[i].getBrand() + " " +
                        car1[i].getModel() + " - " +
                        car1[i].getRentPerDay() + " Tk/day");
            }

            System.out.print("Book a car: ");
            int choice = input.nextInt();

            System.out.print("How many days need: ");
            int days = input.nextInt();

            Car selectedCar = car1[choice - 1];
            selectedCar.reserveVehicle();

            double total = selectedCar.calculateRent(days);

            System.out.println("1. Bkash");
            System.out.println("2. Nagad");
            System.out.println("3. Cash");
            System.out.print("Payment Method: ");
            int pay = input.nextInt();

            String method = "Cash";
            if (pay == 1) method = "Bkash";
            else if (pay == 2) method = "Nagad";

            Payment p1 = new Payment(501, total, method);

            System.out.println("\n Bokking details/reciept: ");
            selectedCar.showDetails();
            System.out.println("Customer Name : " + c1.getName());
            System.out.println("Booked For    : " + days + " Days");
            p1.showPaymentInfo();
        }

        else if (type == 2) {

            System.out.println("\nAvailable Bikes:");
            for (int i = 0; i < bike1.length; i++) {
                System.out.println((i + 1) + ". " +
                        bike1[i].getBrand() + " " +
                        bike1[i].getModel() + " - " +
                        bike1[i].getRentPerDay() + " Tk/day");
            }
            System.out.print("Select a bike:");
            int choice = input.nextInt();

            System.out.print("How many days: ");
            int days = input.nextInt();

            Bike selectedBike = bike1[choice - 1];
            selectedBike.reserveVehicle();

            double total = selectedBike.calculateRent(days);

            System.out.println("1. Bkash");
            System.out.println("2. Nagad");
            System.out.println("3. Cash");
            System.out.print("Payment type: ");
            int pay = input.nextInt();

            String method = "Cash";
            if (pay == 1) method = "Bkash";
            else if (pay == 2) method = "Nagad";

            Payment p2 = new Payment(502, total, method);

            System.out.println("\n Booking details/recipt:");
            selectedBike.showDetails();
            System.out.println("Customer Name : " + c1.getName());
            System.out.println("Booked For    : " + days + " Days");
            p2.showPaymentInfo();
        }

      }
}
