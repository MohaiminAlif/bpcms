package org.bpcms;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Patient {
    private static String lastDate = "";
    private static int dailyCounter = 0;

    private int id;
    private String name;
    private String address;
    private String phone;

    public Patient(String name, String address, String phone) {
        this.id = generateID();
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    private int generateID() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMdd");
        String today = LocalDate.now().format(formatter);

        if (!today.equals(lastDate)) {
            dailyCounter = 1;
            lastDate = today;
        } else {
            dailyCounter++;
        }

        String counterStr = String.format("%03d", dailyCounter);
        String fullId = today + counterStr;

        return Integer.parseInt(fullId);
    }


    public int getID() { return id; }

    public String getName() { return name; }

    public String getAddress() { return address; }

    public String getPhone() { return phone; }

    @Override
    public String toString() {
        return "Patient ID: " + id + ", Name: " + name + ", Address: " + address + ", Phone: " + phone;
    }
}
