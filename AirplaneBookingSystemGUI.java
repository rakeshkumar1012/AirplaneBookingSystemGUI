// Source code is decompiled from a .class file using FernFlower decompiler.
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

class AirplaneBookingSystemGUI {
   private AirplaneBookingSystem bookingSystem = new AirplaneBookingSystem();
   private JFrame loginFrame = new JFrame("Airplane Booking System - Login");
   private JFrame mainFrame = new JFrame("Airplane Booking System - Main Menu");
   private JTextField usernameField = new JTextField(20);
   private JPasswordField passwordField = new JPasswordField(20);
   private JLabel statusLabel = new JLabel();

   public AirplaneBookingSystemGUI() {
   }

   public void initializeLoginFrame() {
      this.loginFrame.setDefaultCloseOperation(3);
      this.loginFrame.setSize(400, 200);
      this.loginFrame.setLayout(new FlowLayout());
      JLabel var1 = new JLabel("Username:");
      JLabel var2 = new JLabel("Password:");
      JButton var3 = new JButton("Login");
      JButton var4 = new JButton("Cancel");
      JButton var5 = new JButton("Create Account");
      var3.addActionListener(new AirplaneBookingSystemGUI$1(this));
      var4.addActionListener(new AirplaneBookingSystemGUI$2(this));
      var5.addActionListener(new AirplaneBookingSystemGUI$3(this));
      this.loginFrame.add(var1);
      this.loginFrame.add(this.usernameField);
      this.loginFrame.add(var2);
      this.loginFrame.add(this.passwordField);
      this.loginFrame.add(var3);
      this.loginFrame.add(var4);
      this.loginFrame.add(var5);
      this.loginFrame.add(this.statusLabel);
      this.loginFrame.setVisible(true);
   }

   public void login() {
      String var1 = this.usernameField.getText();
      String var2 = new String(this.passwordField.getPassword());
      if (this.bookingSystem.login(var1, var2)) {
         this.loginFrame.setVisible(false);
         this.mainFrame.setVisible(true);
         this.statusLabel.setText("Login successful");
      } else {
         this.statusLabel.setText("Invalid username or password");
      }

   }

   public void createAccount() {
      String var1 = this.usernameField.getText();
      String var2 = new String(this.passwordField.getPassword());
      if (!var1.isEmpty() && !var2.isEmpty()) {
         this.bookingSystem.createAccount(var1, var2);
      } else {
         this.statusLabel.setText("Username and password cannot be empty");
      }
   }

   public void initializeMainFrame() {
      this.mainFrame.setDefaultCloseOperation(3);
      this.mainFrame.setSize(400, 300);
      this.mainFrame.setLayout(new FlowLayout());
      JButton var1 = new JButton("View Available Flights");
      JButton var2 = new JButton("Book a Seat");
      JButton var3 = new JButton("Cancel a Seat");
      JButton var4 = new JButton("View Available Seats");
      JButton var5 = new JButton("Logout");
      var1.addActionListener(new AirplaneBookingSystemGUI$4(this));
      var2.addActionListener(new AirplaneBookingSystemGUI$5(this));
      var3.addActionListener(new AirplaneBookingSystemGUI$6(this));
      var4.addActionListener(new AirplaneBookingSystemGUI$7(this));
      var5.addActionListener(new AirplaneBookingSystemGUI$8(this));
      this.mainFrame.add(var1);
      this.mainFrame.add(var2);
      this.mainFrame.add(var3);
      this.mainFrame.add(var4);
      this.mainFrame.add(var5);
      this.mainFrame.setVisible(false);
   }

   public void displayAvailableFlights() {
      String var1 = this.bookingSystem.getAvailableFlightsInfo();
      JOptionPane.showMessageDialog(this.mainFrame, var1, "Available Flights", 1);
   }

   public void bookSeat() {
      String var1 = JOptionPane.showInputDialog(this.mainFrame, "Enter flight number:");
      String var2 = JOptionPane.showInputDialog(this.mainFrame, "Enter class type (1 for Business Class, 2 for Economy Class):");
      String var3 = JOptionPane.showInputDialog(this.mainFrame, "Enter seat number:");

      int var4;
      int var5;
      try {
         var4 = Integer.parseInt(var2);
         var5 = Integer.parseInt(var3);
      } catch (NumberFormatException var7) {
         JOptionPane.showMessageDialog(this.mainFrame, "Invalid input. Please enter valid numbers.", "Invalid Input", 0);
         return;
      }

      this.bookingSystem.bookSeat(var1, var4, var5);
   }

   public void cancelSeat() {
      String var1 = JOptionPane.showInputDialog(this.mainFrame, "Enter flight number:");
      String var2 = JOptionPane.showInputDialog(this.mainFrame, "Enter class type (1 for Business Class, 2 for Economy Class):");
      String var3 = JOptionPane.showInputDialog(this.mainFrame, "Enter seat number:");

      int var4;
      int var5;
      try {
         var4 = Integer.parseInt(var2);
         var5 = Integer.parseInt(var3);
      } catch (NumberFormatException var7) {
         JOptionPane.showMessageDialog(this.mainFrame, "Invalid input. Please enter valid numbers.", "Invalid Input", 0);
         return;
      }

      this.bookingSystem.cancelSeat(var1, var4, var5);
   }

   public void displayAvailableSeats() {
      String var1 = JOptionPane.showInputDialog(this.mainFrame, "Enter flight number:");
      String var2 = JOptionPane.showInputDialog(this.mainFrame, "Enter class type (1 for Business Class, 2 for Economy Class):");

      int var3;
      try {
         var3 = Integer.parseInt(var2);
      } catch (NumberFormatException var5) {
         JOptionPane.showMessageDialog(this.mainFrame, "Invalid input. Please enter valid numbers.", "Invalid Input", 0);
         return;
      }

      String var4 = this.bookingSystem.getAvailableSeatsInfo(var1, var3);
      JOptionPane.showMessageDialog(this.mainFrame, var4, "Available Seats", 1);
   }

   public void logout() {
      this.bookingSystem.logout();
      this.loginFrame.setVisible(true);
      this.mainFrame.setVisible(false);
      this.statusLabel.setText("");
   }

   public static void main(String[] var0) {
      SwingUtilities.invokeLater(new AirplaneBookingSystemGUI$9());
   }
}
