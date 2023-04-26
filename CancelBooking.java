
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.HttpURLConnection;
import java.net.URL;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CancelBooking extends JFrame implements ActionListener {
    JLabel nameLabel,ageLabel, phnNoLabel, heading1Label,heading2Label,roomTypeLabel,bedTypeLabel,noOfRoomsLabel,checkInLabel, stayingDaysLabel,messageLabel;

    JTextField nameField,ageField,PhnNoField,roomTypeField,bedTypeField,noOfRoomsField,checkInField, stayingDaysField;
    public CancelBooking() {

        setTitle("Cancel Booking");
        setSize(900,500);

        Font bigFont = new Font("Fira Code", Font.BOLD, 20);
        Font smallFont = new Font("Fira Code", Font.BOLD, 14);
        Color main_color = new Color(10, 108, 92);
        getContentPane().setBackground(main_color);
        heading1Label = new JLabel("Search Customer");
        heading1Label.setBounds(350,10,300,45);
        heading1Label.setForeground(Color.white);
        heading1Label.setFont(bigFont);
        phnNoLabel = new JLabel("Mobile NO.:");
        phnNoLabel.setBounds(50, 50, 300, 45);
        phnNoLabel.setFont(smallFont);
        phnNoLabel.setForeground(Color.WHITE);
        nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 150, 300, 45);
        nameLabel.setFont(smallFont);
        nameLabel.setForeground(Color.white);
        ageLabel = new JLabel("Age:");
        ageLabel.setBounds(550, 150, 100, 45);
        ageLabel.setFont(smallFont);
        ageLabel.setForeground(Color.white);

        heading2Label = new JLabel("Booking Details");
        heading2Label.setBounds(350,100,300,30);
        heading2Label.setFont(bigFont);
        heading2Label.setForeground(Color.white);
        roomTypeLabel = new JLabel("Room Type: ");
        roomTypeLabel.setBounds(50,220,300,30);
        roomTypeLabel.setFont(smallFont);
        roomTypeLabel.setForeground(Color.white);
        bedTypeLabel = new JLabel("Bed Type: ");
        bedTypeLabel.setBounds(500,220,300,30);
        bedTypeLabel.setFont(smallFont);
        bedTypeLabel.setForeground(Color.white);
        noOfRoomsLabel = new JLabel("No. of Rooms: ");
        noOfRoomsLabel.setBounds(50,270,200,30);
        noOfRoomsLabel.setFont(smallFont);
        noOfRoomsLabel.setForeground(Color.white);
        checkInLabel = new JLabel("Check In: ");
        checkInLabel.setBounds(500,270,200,30);
        checkInLabel.setFont(smallFont);
        checkInLabel.setForeground(Color.white);
        stayingDaysLabel = new JLabel("Staying Days: ");
        stayingDaysLabel.setBounds(50, 320, 150, 30);
        stayingDaysLabel.setFont(smallFont);
        stayingDaysLabel.setForeground(Color.WHITE);

        nameField = new JTextField(20);
        nameField.setBounds(200, 155, 300, 30);
        nameField.setFont(smallFont);
        nameField.setEditable(false);
        PhnNoField = new JTextField(20);
        PhnNoField.setBounds(200, 55, 300, 30);
        PhnNoField.setFont(smallFont);

        ageField = new JTextField(20);
        ageField.setBounds(600, 155, 100, 30);
        ageField.setFont(smallFont);
        ageField.setEditable(false);
        roomTypeField = new JTextField(10);
        roomTypeField.setBounds(200, 220,100,30);
        roomTypeField.setFont(smallFont);
        roomTypeField.setEditable(false);
        bedTypeField = new JTextField(10);
        bedTypeField.setBounds(600, 220,100,30);
        bedTypeField.setFont(smallFont);
        bedTypeField.setEditable(false);
        noOfRoomsField = new JTextField(5);
        noOfRoomsField.setBounds(200, 270, 100, 30);
        noOfRoomsField.setFont(smallFont);
        noOfRoomsField.setEditable(false);
        checkInField = new JTextField(15);
        checkInField.setBounds(600, 270, 100, 30);
        checkInField.setFont(smallFont);

        checkInField.setEditable(false);
        stayingDaysField = new JTextField(5);
        stayingDaysField.setBounds(200, 320, 100, 30);
        stayingDaysField.setFont(smallFont);
        stayingDaysField.setEditable(false);
        GradientButton searchBtn = new GradientButton("Search");
        searchBtn.setFont(smallFont);
        searchBtn.setBounds(550,55,120,30);
        searchBtn.setForeground(Color.white);



        GradientButton submitBtn = new GradientButton("Cancel Booking");
        submitBtn.setBounds(550, 400, 250, 40);
        submitBtn.setFont(smallFont);
        submitBtn.setForeground(Color.white);
        messageLabel = new JLabel("");
        messageLabel.setBounds(200, 300, 500, 45);
        messageLabel.setFont(smallFont);


        // Add the components to the frame
        add(heading1Label);
        add(heading2Label);
        add(nameLabel);
        add(nameField);
        add(ageLabel);
        add(ageField);
        add(phnNoLabel);
        add(PhnNoField);
        add(roomTypeLabel);
        add(roomTypeField);
        add(bedTypeLabel);
        add(bedTypeField);
        add(noOfRoomsLabel);
        add(noOfRoomsField);
        add(checkInLabel);
        add(checkInField);
        add(searchBtn);
        add(stayingDaysLabel);
        add(stayingDaysField);
        add(submitBtn);
        add(messageLabel);

        searchBtn.addActionListener(this);
        submitBtn.addActionListener(this);
        setLocationRelativeTo(null);
        // Display the frame
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() instanceof JButton)
        {
            JButton click = (JButton) e.getSource();
            if(click.getText() == "Search"){
                try {

                    URL url = new URL("https://java-swing-project.vercel.app/booking/"+PhnNoField.getText());

                    // Create an HttpURLConnection object to connect to the URL
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");

                    // Check if the connection was successful
                    if (connection.getResponseCode() == 500) {
                        JOptionPane.showMessageDialog(null, "Internal Server Error Try again");
                    }else if(connection.getResponseCode() ==400)
                    {
                        JOptionPane.showMessageDialog(null, "Wrong Moblie number. Data not found");

                    }

                    // Read the data from the input stream of the connection
                    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String inputLine;
                    StringBuffer response = new StringBuffer();
                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();

                    String s = response.toString();
                    String[] l = s.split(",");
                    nameField.setText(l[0]);
                    roomTypeField.setText(l[1]);
                    bedTypeField.setText(l[2]);
                    noOfRoomsField.setText(l[3]);
                    stayingDaysField.setText(l[4]);
                    checkInField.setText(l[5]);
                    ageField.setText(l[6]);
                    connection.disconnect();
                } catch (Exception event) {
                    event.printStackTrace();
                }
            }else {
                int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel this booking?");
                if (choice == JOptionPane.YES_OPTION) {
                    System.out.println("User clicked YES.");
                    // Do something if user clicked YES

                try {
                    // Create URL object
                    URL url = new URL("https://java-swing-project.vercel.app/booking/"+PhnNoField.getText());

                    // Open connection
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                    // Set request method to POST
                    conn.setRequestMethod("DELETE");
                    System.out.println(conn.getResponseCode());

                    if (conn.getResponseCode() == 500) {
                        JOptionPane.showMessageDialog(null, "Internal Server Error Try again");
                    }else if(conn.getResponseCode() ==400)
                    {
                        JOptionPane.showMessageDialog(null, "Wrong Moblie number. Data not found");

                    }else{
                        JOptionPane.showMessageDialog(null, "Booking Canceled");
                    }





                } catch (Exception event) {
                    event.printStackTrace();
                    System.out.println(event.getMessage());
                }
                } else if (choice == JOptionPane.NO_OPTION) {
                    dispose();
                    new CheckOut();
                } else {
                    System.out.println("User clicked CANCEL.");
                    // Do something if user clicked CANCEL
                }
            }
        }
    }

}