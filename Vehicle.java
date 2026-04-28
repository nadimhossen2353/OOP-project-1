abstract class Vehicle {
    private int vehicleId;
    private String brand;
    private String model;
    private int year;
    private double rentPerDay;
    private boolean available = true;

    Vehicle(int vehicleId, String brand, String model,
            int year, double rentPerDay) {
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.rentPerDay = rentPerDay;
    }
public int getvehicleId(){
        return vehicleId;
    }
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getRentPerDay() {
        return rentPerDay;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean status) {
        available = status;
    }

    void showDetails() {
        System.out.println("Vehicle ID   : " + vehicleId);
        System.out.println("Brand        : " + brand);
        System.out.println("Model        : " + model);
        System.out.println("Year         : " + year);
        System.out.println("Rent Per Day : " + rentPerDay + " Tk");
    }

    double calculateRent(int days) {
        return rentPerDay * days;
    }
}
