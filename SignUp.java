import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.OutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SignUp extends JFrame implements ActionListener {
    JLabel usernameLabel, passwordLabel, messageLabel, emailLabel, nameLabel;
    JTextField usernameField, nameField, emailField;
    JPasswordField passwordField;
    public SignUp()
    {
        setTitle("SignUp Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // set to full screen
        setSize(Toolkit.getDefaultToolkit().getScreenSize());

        Font font = new Font("Fira Code",Font.BOLD, 20);
        Color main_color = new Color(10, 108, 92);
        getContentPane().setBackground(main_color);
        nameLabel = new JLabel("Name: ");
        usernameLabel = new JLabel("Username: ");
        passwordLabel = new JLabel("Password: ");
        messageLabel = new JLabel("");
        emailLabel = new JLabel("Email: ");
        nameField = new JTextField(20);
        usernameField = new JTextField(20);
        emailField = new JTextField(20);
        passwordField = new JPasswordField(20);
        nameLabel.setBounds(50,50, 300,45);
        usernameLabel.setBounds(50,120, 300,45);
        emailLabel.setBounds(50,190, 300,45);
        passwordLabel.setBounds(50,260, 300,45);
        nameField.setBounds(300,50,300,45);
        usernameField.setBounds(300,120,300,45);
        emailField.setBounds(300,190,300,45);
        passwordField.setBounds(300,260,300,45);
        messageLabel.setBounds(300, 360,500, 45);
        nameLabel.setFont(font);
        usernameLabel.setFont(font);
        emailLabel.setFont(font);
        passwordLabel.setFont(font);
        messageLabel.setFont(font);
        nameField.setFont(font);
        usernameField.setFont(font);
        emailField.setFont(font);
        passwordField.setFont(font);
        nameLabel.setForeground(Color.white);
        usernameLabel.setForeground(Color.white);
        emailLabel.setForeground(Color.white);
        passwordLabel.setForeground(Color.white);
        GradientButton signUpBtn = new GradientButton("SignUp");
        signUpBtn.setBounds(250,400, 200, 60);
        signUpBtn.setFont(font);
        signUpBtn.setForeground(Color.white);
        //Add the components to the frame
         add(nameLabel);
         add(nameField);
         add(usernameLabel);
         add(usernameField);
         add(emailField);
         add(emailLabel);
         add(passwordLabel);
         add(passwordField);
         add(signUpBtn);
         add(messageLabel);
        // Add an action listener to the buttons
         signUpBtn.addActionListener(this);
        // Display the frame
         setVisible(true);
    }
    //Button on Click
    public void actionPerformed(ActionEvent e) {

        // Get the data entered by the user
        String name = nameField.getText();
        String username = usernameField.getText();
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());

        String data = "{\"name\":\"" + name + "\",\"username\":\"" + username + "\",\"email\":\""+email+"\",\"password\":\""+password+"\"}";
        try {
            // Create URL object
            URL url = new URL("https://java-swing-project.vercel.app/users/");

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

            // Read response from the input stream
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();



            messageLabel.setText("SignUp Successful");
            messageLabel.setForeground(Color.green);
            //Delay 1s
            ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
            Runnable task = new Runnable() {
                public void run() {
                    new Login();
                    dispose();
                }
            };
            executor.schedule(task, 1, TimeUnit.SECONDS);
        } catch (Exception event) {
            event.printStackTrace();
            System.out.println(event.getMessage());
            messageLabel.setText("Username already Exists");
            messageLabel.setForeground(Color.red);
        }



    }
}
