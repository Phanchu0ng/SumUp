package Data;

public class Customer {
    String firstName;
    String lastName;
    String stress_address;
    String email;
    String state;
    String city;
    String country;
    String zip_code;
    String phone_number;
    public Customer(String lastName, String firstName, String email, String stress_address, String city,String state, String country, String zip_code,String phone_number){
        super();
        this.lastName= lastName;
        this.firstName=firstName;
        this.email=email;
        this.stress_address= stress_address;
        this.city=city;
        this.state=state;
        this.country=country;
        this.zip_code=zip_code;
        this.phone_number = phone_number;

    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStress_address() {
        return stress_address;
    }

    public void setStress_address(String stress_address) {
        this.stress_address = stress_address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String toString() {


        return "firstname: " + firstName + "\n"
                + "lastname: " + lastName + "\n"
                + "email: " + email + "\n"
                + "stress_address: " + stress_address + "\n"
                + "city: " + city + "\n"
                + "state: " + state + "\n"
                + "country: " + country+ "\n"
                + "zipcode: " + zip_code + "\n"
                + "phone_number: " + phone_number + "\n";


    }
}
