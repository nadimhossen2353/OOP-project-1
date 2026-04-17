class Bike extends Vehicle implements Rentable {

    Bike(int id, String brand, String model, int year, double rent) {
        super(id, brand, model, year, rent);
    }
    public boolean checkAvailability() {
        return isAvailable();
    }

    public void reserveVehicle() {
        setAvailable(false);
    }

}
