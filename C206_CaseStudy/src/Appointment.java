public class Appointment {
    String AppointmentName;
    int CustomerID;
    double AppointmentTime;
    String AppointmentStatus;
    String description;
    int SPID;
  public Appointment(String appointmentName, int customerID, double appointmentTime, String appointmentStatus,
      String description, int sPID) {
    super();
    AppointmentName = appointmentName;
    CustomerID = customerID;
    AppointmentTime = appointmentTime;
    AppointmentStatus = appointmentStatus;
    this.description = description;
    SPID = sPID;
  }
  public double getAppointmentTime() {
    return AppointmentTime;
  }
  public void setAppointmentTime(double appointmentTime) {
    AppointmentTime = appointmentTime;
  }
  public String getAppointmentStatus() {
    return AppointmentStatus;
  }
  public void setAppointmentStatus(String appointmentStatus) {
    AppointmentStatus = appointmentStatus;
  }
  public String getAppointmentName() {
    return AppointmentName;
  }
  public int getCustomerID() {
    return CustomerID;
  }
  public int getSPID() {
    return SPID;
  }
  
  
    
}