package org.bpcms;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Patient {
    private static String lastDate = "";
    private static int dailyCounter = 0;

    private int id;
    private String name;
    private String address;
    private String telephone;

    public Patient(String name, String address, String phone) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Patient name cannot be empty.");
        }
        if (address == null || address.trim().isEmpty()) {
            throw new IllegalArgumentException("Patient address cannot be empty.");
        }
        if (phone == null || phone.trim().isEmpty()) {
            throw new IllegalArgumentException("Patient phone number cannot be empty.");
        }

        this.id = generateID();
        this.name = name.trim();
        this.address = address.trim();
        this.telephone = phone.trim();
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

    @Override
    public String toString() {
        return "Patient ID: " + id + ", Name: " + name + ", Address: " + address + ", Telephone: " + telephone;
    }
}
