public class Therapist {
    private int uniqueId;
    private String name;
    private String address;
    private String number;
    private String email;

    public Therapist(int uniqueId, String name, String address, String number, String email) {
        this.uniqueId = uniqueId;
        this.name = name;
        this.address = address;
        this.number = number;
        this.email = email;
    }

    // Getters
    public int getUniqueId() {
        return uniqueId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getNumber() {
        return number;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Therapist{" +
                "uniqueId=" + uniqueId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", number='" + number + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}