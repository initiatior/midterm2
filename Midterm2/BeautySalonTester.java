package Midterm2;

import java.util.Scanner;

public class BeautySalonTester {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] customerNames = {"Alice", "John", "Emily"};
        String[] stylistNames = {"Sarah", "Michael", "Emma"};


        BeautySalon salon = new BeautySalon();
        for (String customerName : customerNames) {
            Customer customer = new Customer(customerName);
            salon.addCustomer(customer);
        }

        for (String stylistName : stylistNames) {
            Stylist stylist = new Stylist(stylistName);
            salon.addStylist(stylist);
        }


        System.out.println("Add appointments:");
        while (true) {
            System.out.println("Enter customer name, appointment date (YYYY-MM-DD), stylist name (or type 'done' to finish):");
            System.out.print("Customer name: ");
            String customer = scanner.nextLine();
            if (customer.equalsIgnoreCase("done")) {
                break;
            }

            System.out.print("Appointment date: ");
            String appointmentDate = scanner.nextLine();

            System.out.print("Stylist name: ");
            String stylist = scanner.nextLine();

            salon.addAppointment(new Appointment(customer, appointmentDate, stylist));
        }


        System.out.println("\nAppointments:");
        for (Appointment appointment : salon.getAppointments()) {
            System.out.println("Customer: " + appointment.getCustomerName() +
                    ", Date: " + appointment.getAppointmentDate() +
                    ", Stylist: " + appointment.getStylistName());
        }
        salon.saveState();


        salon.getAppointments().clear();


        salon.restoreState();


        System.out.println("\nAppointments after restoration:");
        for (Appointment appointment : salon.getAppointments()) {
            System.out.println("Customer: " + appointment.getCustomerName() +
                    ", Date: " + appointment.getAppointmentDate() +
                    ", Stylist: " + appointment.getStylistName());
        }

        scanner.close();
    }
}
