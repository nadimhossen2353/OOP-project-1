import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

        UIManager.put("OptionPane.background", new Color(245, 248, 255));
        UIManager.put("Panel.background", new Color(245, 248, 255));
        UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 16));
        UIManager.put("OptionPane.buttonFont", new Font("Segoe UI", Font.BOLD, 14));

        int id = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Enter Customer ID:", "Registration",
                JOptionPane.PLAIN_MESSAGE));

        String name = JOptionPane.showInputDialog(null,
                "Enter Customer Name:", "Registration",
                JOptionPane.PLAIN_MESSAGE);

        String phone = JOptionPane.showInputDialog(null,
                "Enter Phone Number:", "Registration",
                JOptionPane.PLAIN_MESSAGE);

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

        while (true) {

            String menu = """
                    🚗 VEHICLE RENTAL SYSTEM 🚗

                    1. Rent Car
                    2. Rent Bike
                    3. Exit
                    """;

            int type = Integer.parseInt(JOptionPane.showInputDialog(null,
                    menu, "Main Menu",
                    JOptionPane.PLAIN_MESSAGE));

            // ================= CAR =================
            if (type == 1) {

                String list = "🚘 Available Cars:\n\n";

                for (int i = 0; i < cars.length; i++) {
                    if (cars[i].checkAvailability()) {
                        list += (i + 1) + ". " + cars[i].getBrand() + " "
                                + cars[i].getModel()
                                + " | " + cars[i].getRentPerDay()
                                + " Tk/day\n";
                    }
                }

                if (list.equals("🚘 Available Cars:\n\n")) {
                    JOptionPane.showMessageDialog(null,
                            "❌ Car Not Available",
                            "Unavailable",
                            JOptionPane.WARNING_MESSAGE);
                    continue;
                }

                int choice = Integer.parseInt(JOptionPane.showInputDialog(null,
                        list + "\nSelect Car:",
                        "Car Selection",
                        JOptionPane.PLAIN_MESSAGE));

                int days = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "How many days?",
                        "Rental Duration",
                        JOptionPane.PLAIN_MESSAGE));

                Car selectedCar = cars[choice - 1];

                if (selectedCar.checkAvailability()) {

                    selectedCar.reserveVehicle();
                    double total = selectedCar.calculateRent(days);

                    int pay = Integer.parseInt(JOptionPane.showInputDialog(null,
                            """
                            💳 Payment Method

                            1. Bkash
                            2. Nagad
                            3. Cash
                            """,
                            "Payment",
                            JOptionPane.PLAIN_MESSAGE));

                    String method = "Cash";
                    if (pay == 1) method = "Bkash";
                    else if (pay == 2) method = "Nagad";

                    Payment p1 = new Payment(501, total, method);

                    JOptionPane.showMessageDialog(null,
                            """
                            ✅ BOOKING CONFIRMED

                            Customer: """ + c1.getName() +
                                    "\nPhone: " + phone +
                                    "\nVehicle: " + selectedCar.getBrand() + " " + selectedCar.getModel() +
                                    "\nDays: " + days +
                                    "\nPayment: " + method +
                                    "\nTotal: " + total + " Tk",
                            "Receipt",
                            JOptionPane.INFORMATION_MESSAGE);
                }

            }

            // ================= BIKE =================
            else if (type == 2) {

                String list = "🏍 Available Bikes:\n\n";

                for (int i = 0; i < bikes.length; i++) {
                    if (bikes[i].checkAvailability()) {
                        list += (i + 1) + ". " + bikes[i].getBrand() + " "
                                + bikes[i].getModel()
                                + " | " + bikes[i].getRentPerDay()
                                + " Tk/day\n";
                    }
                }

                if (list.equals("🏍 Available Bikes:\n\n")) {
                    JOptionPane.showMessageDialog(null,
                            "❌ Bike Not Available",
                            "Unavailable",
                            JOptionPane.WARNING_MESSAGE);
                    continue;
                }

                int choice = Integer.parseInt(JOptionPane.showInputDialog(null,
                        list + "\nSelect Bike:",
                        "Bike Selection",
                        JOptionPane.PLAIN_MESSAGE));

                int days = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "How many days?",
                        "Rental Duration",
                        JOptionPane.PLAIN_MESSAGE));

                Bike selectedBike = bikes[choice - 1];

                if (selectedBike.checkAvailability()) {

                    selectedBike.reserveVehicle();
                    double total = selectedBike.calculateRent(days);

                    int pay = Integer.parseInt(JOptionPane.showInputDialog(null,
                            """
                            💳 Payment Method

                            1. Bkash
                            2. Nagad
                            3. Cash
                            """,
                            "Payment",
                            JOptionPane.PLAIN_MESSAGE));

                    String method = "Cash";
                    if (pay == 1) method = "Bkash";
                    else if (pay == 2) method = "Nagad";

                    Payment p2 = new Payment(502, total, method);

                    JOptionPane.showMessageDialog(null,
                            """
                            ✅ BOOKING CONFIRMED

                            Customer: """ + c1.getName() +
                                    "\nPhone: " + phone +
                                    "\nVehicle: " + selectedBike.getBrand() + " " + selectedBike.getModel() +
                                    "\nDays: " + days +
                                    "\nPayment: " + method +
                                    "\nTotal: " + total + " Tk",
                            "Receipt",
                            JOptionPane.INFORMATION_MESSAGE);
                }

            }

            else if (type == 3) {
                JOptionPane.showMessageDialog(null,
                        "🙏 Thank You For Using Our Service",
                        "Good Bye",
                        JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }

            else {
                JOptionPane.showMessageDialog(null,
                        "❌ Invalid Option",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

            int again = JOptionPane.showConfirmDialog(null,
                    "Do you want another booking?",
                    "Continue",
                    JOptionPane.YES_NO_OPTION);

            if (again != JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null,
                        "🙏 Thank You!",
                        "Exit",
                        JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        }
    }
}
