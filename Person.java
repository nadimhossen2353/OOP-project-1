abstract class Person {
private int id;
    private String name;
    private String phone;

    Person( int id, String name, String phone) {
this.id= id;
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

}
