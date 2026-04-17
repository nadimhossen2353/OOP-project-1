class Customer extends Person {
    int id;
    Customer(int id, String name, String email, String phone) {
        super( name, email, phone);
        this.id= id; }
}
