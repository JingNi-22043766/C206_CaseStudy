public class User {
    private String username;
    private String email;
    private String password;
    private int contactNumber;
    private String address;

    // Constructor
    public User(String username, String email, String password, int contactNumber, String address) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.contactNumber = contactNumber;
        this.address = address;
    }

    //Getters
 public String getUsername() {
  return username;
 }

 public String getEmail() {
  return email;
 }

 public String getPassword() {
  return password;
 }

 public int getContactNumber() {
  return contactNumber;
 }

 public String getAddress() {
  return address;
 }
 
 public String toString() {
        // Create a string representation of the user's information
        String output = "Username: " + username + "\n";
        output += "Email: " + email + "\n";
        output += "Password: " + password + "\n";
        output += "Contact number: " + contactNumber + "\n";
        output += "Address: " + address + "\n";
        return output;
    }
    
}