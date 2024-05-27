package Midterm2;

class Appointment {
    private String customerName;
    private String appointmentDate;
    private String stylistName;

    public Appointment(String customerName, String appointmentDate, String stylistName) {
        this.customerName = customerName;
        this.appointmentDate = appointmentDate;
        this.stylistName = stylistName;
    }

    // Getters and setters
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getStylistName() {
        return stylistName;
    }

    public void setStylistName(String stylistName) {
        this.stylistName = stylistName;
    }
}