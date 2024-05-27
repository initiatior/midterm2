package Midterm2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class BeautySalon {
    private List<Appointment> appointments;

    public BeautySalon() {
        this.appointments = new ArrayList<>();
    }

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    public void removeAppointment(Appointment appointment) {
        appointments.remove(appointment);
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void addStylist(Stylist stylist) {
    }

    public void addCustomer(Customer customer) {
    }

    public void saveState() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("state.csv"))) {
            for (Appointment appointment : appointments) {
                writer.println(appointment.getCustomerName() + "," +
                        appointment.getAppointmentDate() + "," +
                        appointment.getStylistName());
            }
            System.out.println("State saved successfully.");
        } catch (IOException e) {
            System.err.println("Error saving state: " + e.getMessage());
        }
    }

    public void restoreState() {
        appointments.clear();
        try (Scanner scanner = new Scanner(new File("state.csv"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    appointments.add(new Appointment(parts[0], parts[1], parts[2]));
                }
            }
            System.out.println("State restored successfully.");
        } catch (FileNotFoundException e) {
            System.err.println("Error restoring state: File not found.");
        }
    }
}