public class Customer {
    private String name;
    private String phone;
    private Address address;

    public Customer() {}

    public Customer(String name, String phone, Address address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

}
