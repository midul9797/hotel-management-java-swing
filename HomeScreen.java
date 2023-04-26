import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HomeScreen extends JFrame implements ActionListener {

    // Declare the components
    private JLabel  messageLabel,l;
    private ImageIcon logo;
    public HomeScreen() {

        // Set the frame properties
        setTitle("Hotel Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize);
        Font font = new Font("Fira Code", Font.BOLD, 20);
        Font titleFont = new Font("Fira Code", Font.BOLD, 40);
        Color main_color = new Color(10, 108, 92);
        getContentPane().setBackground(main_color);


        logo = new ImageIcon("src/logo.png");
         l = new JLabel(logo);
        l.setBounds(50,50,100,100);
    add(l);
        JLabel title = new JLabel("Hotel Delta Management System");
        title.setBounds(300,75,800,50);
        title.setFont(titleFont);
        title.setForeground(Color.cyan);
        add(title);

        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER,20,20));
        buttons.setBounds(0, 300, screenSize.width, 300);
        buttons.setVisible(true);
        buttons.setOpaque(false);
        GradientButton bookingBtn = new GradientButton("New Booking");
        bookingBtn.setFont(font);
        bookingBtn.setForeground(Color.white);
        GradientButton allBookingBtn = new GradientButton("All Bookings");
        allBookingBtn.setFont(font);
        allBookingBtn.setForeground(Color.white);
        GradientButton cancelBookingBtn = new GradientButton("Cancel Booking");
        cancelBookingBtn.setFont(font);
        cancelBookingBtn.setForeground(Color.white);
        GradientButton logOut = new GradientButton("LogOut");
        logOut.setFont(font);
        logOut.setBounds(1100,75,200,45);
        logOut.setBorderPainted(false);
        logOut.setForeground(Color.white);
        add(logOut);
        GradientButton cost = new GradientButton("Cost");
        cost.setFont(font);
        cost.setForeground(Color.white);
        GradientButton checkOut = new GradientButton("Check Out");
        checkOut.setFont(font);
        checkOut.setForeground(Color.white);
        messageLabel = new JLabel("");
        messageLabel.setBounds(200, 300, 500, 45);
        messageLabel.setFont(font);

        buttons.add(bookingBtn);
        buttons.add(allBookingBtn);
        buttons.add(cancelBookingBtn);
        buttons.add(cost);
        buttons.add(checkOut);
        // Add the components to the frame
        getContentPane().add(buttons, BorderLayout.CENTER
        );
        add(messageLabel);
// Add an action listener to the buttons
        logOut.addActionListener(this);
        bookingBtn.addActionListener(this);
        allBookingBtn.addActionListener(this);
        cancelBookingBtn.addActionListener(this);
        cost.addActionListener(this);
        checkOut.addActionListener(this);
        // Display the frame
        setVisible(true);
    }
    //Button on Click
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton click = (JButton) e.getSource();
            if (click.getText().equals("LogOut")) {
                new Login();
                dispose();
            } else if (click.getText().equals("New Booking")) {
               new NewBooking();

            } else if (click.getText().equals("All Bookings")) {
                new AllBookings();


            } else if (click.getText().equals("Cancel Booking")) {
                new CancelBooking();
            } else if (click.getText().equals("Cost")) {
                new Cost();
            } else if (click.getText().equals("Check Out")) {
                new CheckOut();
            }
        }

        }

    }
