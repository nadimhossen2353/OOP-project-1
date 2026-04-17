abstract class Person {

    private String name;
    private String email;
    private String phone;

    Person( String name, String email, String phone) {

        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

}
