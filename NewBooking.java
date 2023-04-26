
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.awt.event.*;

import java.io.OutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NewBooking extends JFrame implements ActionListener {
        private JLabel nameLabel,ageLabel, phnNoLabel,genderLabel, heading1Label,heading2Label,roomTypeLabel,bedTypeLabel,noOfRoomsLabel,checkInLabel, stayingDaysLabel,messageLabel;
        private JRadioButton male, female, ac, noAc, single, doubleBed;
        private JTextField nameField,ageField,PhnNoField,noOfRoomsField,checkInField, stayingDaysField;
    public NewBooking() {

        setTitle("Hotel Management System");

        setSize(900,500);

        Font bigFont = new Font("Fira Code", Font.BOLD, 20);
        Font smallFont = new Font("Fira Code", Font.BOLD, 14);
        Color main_color = new Color(10, 108, 92);
        getContentPane().setBackground(main_color);
        heading1Label = new JLabel("Customer Details");
        heading1Label.setBounds(350,10,300,45);
        heading1Label.setForeground(Color.white);
        heading1Label.setFont(bigFont);
        nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 50, 300, 45);
        nameLabel.setFont(smallFont);
        nameLabel.setForeground(Color.white);
        ageLabel = new JLabel("Age:");
        ageLabel.setBounds(550, 55, 100, 45);
        ageLabel.setFont(smallFont);
        ageLabel.setForeground(Color.white);
        phnNoLabel = new JLabel("Mobile NO.:");
        phnNoLabel.setBounds(50, 120, 300, 45);
        phnNoLabel.setFont(smallFont);
        phnNoLabel.setForeground(Color.WHITE);
        genderLabel = new JLabel("Gender: ");
        genderLabel.setBounds(550,125,100,30);
        genderLabel.setFont(smallFont);
        genderLabel.setForeground(Color.white);
        heading2Label = new JLabel("Booking Details");
        heading2Label.setBounds(350,180,300,30);
        heading2Label.setFont(bigFont);
        heading2Label.setForeground(Color.white);
        roomTypeLabel = new JLabel("Room Type: ");
        roomTypeLabel.setBounds(50,220,300,30);
        roomTypeLabel.setFont(smallFont);
        roomTypeLabel.setForeground(Color.white);
        bedTypeLabel = new JLabel("Bed Type: ");
        bedTypeLabel.setBounds(550,220,300,30);
        bedTypeLabel.setFont(smallFont);
        bedTypeLabel.setForeground(Color.white);
        noOfRoomsLabel = new JLabel("No. of Rooms: ");
        noOfRoomsLabel.setBounds(50,270,200,30);
        noOfRoomsLabel.setFont(smallFont);
        noOfRoomsLabel.setForeground(Color.white);
        checkInLabel = new JLabel("Check In: ");
        checkInLabel.setBounds(400,270,200,30);
        checkInLabel.setFont(smallFont);
        checkInLabel.setForeground(Color.white);
        stayingDaysLabel = new JLabel("Staying Days: ");
        stayingDaysLabel.setBounds(50, 320, 150, 30);
        stayingDaysLabel.setFont(smallFont);
        stayingDaysLabel.setForeground(Color.WHITE);
        messageLabel = new JLabel("");
        messageLabel.setBounds(150, 380, 100, 45);
        messageLabel.setFont(smallFont);
        messageLabel.setForeground(Color.red);

        nameField = new JTextField(20);
        nameField.setBounds(200, 55, 300, 30);
        nameField.setFont(smallFont);
        PhnNoField = new JTextField(20);
        PhnNoField.setBounds(200, 125, 300, 30);
        PhnNoField.setFont(smallFont);
        //Only number input is acceptable
        PhnNoField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = PhnNoField.getText();
                if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')|| ke.getKeyChar()==8) {
                    PhnNoField.setEditable(true);

                } else {
                    PhnNoField.setEditable(false);

                }
            }
        });
        ageField = new JTextField(20);
        ageField.setBounds(650, 55, 100, 30);
        ageField.setFont(smallFont);
        //Only number input is acceptable
        ageField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = ageField.getText();
                int l = value.length();
                if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')|| ke.getKeyChar()==8) {
                    ageField.setEditable(true);
                } else {
                    ageField.setEditable(false);

                }
            }
        });
        noOfRoomsField = new JTextField(5);
        noOfRoomsField.setBounds(200, 270, 50, 30);
        noOfRoomsField.setFont(smallFont);
        //Only number input is acceptable
        noOfRoomsField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = noOfRoomsField.getText();
                int l = value.length();
                if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')|| ke.getKeyChar()==8) {
                    noOfRoomsField.setEditable(true);
                } else {
                    noOfRoomsField.setEditable(false);

                }
            }
        });
        checkInField = new JTextField(15);
        checkInField.setBounds(500, 270, 150, 30);
        checkInField.setText("DD/MM/YYYY");
        checkInField.setFont(smallFont);
        checkInField.setForeground(Color.GRAY);
        //Only number input is acceptable
        checkInField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = checkInField.getText();
                int l = value.length();
                if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')|| ke.getKeyChar()==8 || ke.getKeyChar()==45) {
                    checkInField.setEditable(true);

                } else {
                    checkInField.setEditable(false);
                }
            }
        });
        //Placeholder
        checkInField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (checkInField.getText().equals("DD/MM/YYYY")) {
                    checkInField.setText("");
                    checkInField.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (checkInField.getText().isEmpty()) {
                    checkInField.setForeground(Color.GRAY);
                    checkInField.setText("DD/MM/YYYY");
                }
            }
        });
        stayingDaysField = new JTextField(5);
        stayingDaysField.setBounds(200, 320, 50, 30);
        stayingDaysField.setFont(smallFont);
        stayingDaysField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = stayingDaysField.getText();
                int l = value.length();
                if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')|| ke.getKeyChar()==8) {
                    stayingDaysField.setEditable(true);

                } else {
                    stayingDaysField.setEditable(false);

                }
            }
        });
        GradientButton todayBtn = new GradientButton("Today");
        todayBtn.setFont(smallFont);
        todayBtn.setForeground(Color.white);
        todayBtn.setBounds(670,270,100,30);

        male = new JRadioButton("Male");
        male.setBounds(650,125,100,30);
        male.setFont(smallFont);
        male.setForeground(Color.white);
        male.setOpaque(false);
        male.setSelected(true);
        female = new JRadioButton("Female");
        female.setBounds(750,125,100,30);;
        female.setFont(smallFont);
        female.setForeground(Color.white);
        female.setOpaque(false);
        ac = new JRadioButton("AC");
        ac.setBounds(180,220, 50, 30);
        ac.setForeground(Color.white);
        ac.setFont(smallFont);
        ac.setOpaque(false);
        noAc = new JRadioButton("Non-AC");
        noAc.setBounds(240,220, 100, 30);
        noAc.setForeground(Color.white);
        noAc.setFont(smallFont);
        noAc.setOpaque(false);
        noAc.setSelected(true);
        single = new JRadioButton("Single");
        single.setBounds(650, 220, 100, 30);
        single.setFont(smallFont);
        single.setForeground(Color.white);
        single.setOpaque(false);
        single.setSelected(true);

        doubleBed = new JRadioButton("Double");
        doubleBed.setBounds(750, 220, 100, 30);
        doubleBed.setFont(smallFont);
        doubleBed.setForeground(Color.white);
        doubleBed.setOpaque(false);
        //Grouping radio buttons
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        ButtonGroup roomTypeGroup = new ButtonGroup();
        roomTypeGroup.add(ac);
        roomTypeGroup.add(noAc);
        ButtonGroup bedTypeGroup = new ButtonGroup();
        bedTypeGroup.add(single);
        bedTypeGroup.add(doubleBed);
        GradientButton submitBtn = new GradientButton("Submit");
        submitBtn.setBounds(550, 400, 200, 40);
        submitBtn.setFont(smallFont);
        submitBtn.setForeground(Color.white);



        // Add the components to the frame
        add(heading1Label);
        add(heading2Label);
        add(nameLabel);
        add(nameField);
        add(ageLabel);
        add(ageField);
        add(phnNoLabel);
        add(PhnNoField);
        add(genderLabel);
        add(male);
        add(female);
        add(roomTypeLabel);
        add(ac);
        add(noAc);
        add(bedTypeLabel);
        add(single);
        add(doubleBed);
        add(noOfRoomsLabel);
        add(noOfRoomsField);
        add(checkInLabel);
        add(checkInField);
        add(todayBtn);
        add(stayingDaysLabel);
        add(stayingDaysField);
        add(submitBtn);
        add(messageLabel);

        todayBtn.addActionListener(this);
        submitBtn.addActionListener(this);
        setLocationRelativeTo(null);


        setVisible(true);
    }
        public void actionPerformed(ActionEvent e){
        if(e.getSource() instanceof JButton)
        {
            JButton click = (JButton) e.getSource();
            if(click.getText() == "Today"){
            //Setting up Today's date
            LocalDate today = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            String formattedDate = today.format(formatter);
            checkInField.setText(formattedDate);
            checkInField.setForeground(Color.BLACK);
            }else {
                //Sending data to database
                String name = nameField.getText();
                String mobile = PhnNoField.getText();
                String age = ageField.getText();
                String checkIn = checkInField.getText();
                String rooms = noOfRoomsField.getText();
                String days = stayingDaysField.getText();
                String roomType,gender,bedType;

                if(ac.isSelected())roomType="AC";
                else roomType= "Non-AC";
                if(male.isSelected())gender = "Male";
                else gender = "Female";
                if(single.isSelected())bedType="Single";
                else bedType = "Double";


                String data = "{\"name\":\"" + name + "\",\"mobile\":\"" + mobile + "\",\"age\":\""+age+"\",\"gender\":\""+gender+"\",\"roomType\":\""+roomType+"\",\"bedType\":\""+bedType+"\",\"checkIn\":\""+checkIn+"\",\"stayingDays\":\""+days+"\",\"rooms\":\""+rooms+"\"}";
                System.out.println(data);
                try {
                    // Create URL object
                    URL url = new URL("https://java-swing-project.vercel.app/booking/");

                    // Open connection
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                    // Set request method to POST
                    conn.setRequestMethod("POST");

                    // Enable output and disable caching
                    conn.setDoOutput(true);
                    conn.setUseCaches(false);

                    // Set request headers
                    conn.setRequestProperty("Content-Type", "application/json");
                    conn.setRequestProperty("Accept", "application/json");


                    // Write data to the output stream
                    OutputStream os = conn.getOutputStream();
                    os.write(data.getBytes());
                    os.flush();
                    os.close();


                    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    String inputLine;
                    StringBuilder response = new StringBuilder();
                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();
                    JOptionPane.showMessageDialog(null, "Booking Successful");
                    dispose();

                } catch (Exception event) {
                    event.printStackTrace();
                    System.out.println(event.getMessage());
                    if(PhnNoField.getText().length() != 11){
                    JOptionPane.showMessageDialog(null, "There are 11 Digits in a mobile number");}

                }
            }
        }
        }

}