import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class Login extends JFrame implements ActionListener {

    // Declare the components
    JLabel usernameLabel, passwordLabel, messageLabel;
    JTextField usernameField;
    JPasswordField passwordField;

    public Login() {

        // Set the frame properties
        setTitle("Login Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // set to full screen
        setSize(Toolkit.getDefaultToolkit().getScreenSize());

        // Create the components
        Font font = new Font("Fira Code",Font.BOLD, 20);
        Color main_color = new Color(10, 108, 92);
        getContentPane().setBackground(main_color);
        usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(50,50, 300,45);
        usernameLabel.setFont(font);
        usernameLabel.setForeground(Color.white);
        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 120, 300, 45);
        passwordLabel.setFont(font);
        passwordLabel.setForeground(Color.WHITE);
        usernameField = new JTextField(20);
        usernameField.setBounds(200, 50, 300, 45);
        usernameField.setFont(font);
        passwordField = new JPasswordField(20);
        passwordField.setBounds(200, 120, 300, 45);
        passwordField.setFont(font);
        GradientButton loginButton = new GradientButton("LogIn");
        loginButton.setBounds(200,200, 200, 60);
        loginButton.setFont(font);
        loginButton.setForeground(Color.white);
        GradientButton signupButton = new GradientButton("SignUp");
        signupButton.setBounds(450,200, 200, 60);
        signupButton.setFont(font);
        signupButton.setForeground(Color.white);
        messageLabel = new JLabel("");
        messageLabel.setBounds(200, 300,500, 45);
        messageLabel.setFont(font);


        // Add the components to the frame
        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(loginButton);
        add(signupButton);
        add(messageLabel);

        // Add an action listener to the buttons
        loginButton.addActionListener(this);
        signupButton.addActionListener(this);

        // Display the frame
        setLocationRelativeTo(null);
        setVisible(true);
    }
    //Button on Click
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() instanceof JButton){
            JButton click = (JButton) e.getSource();
            if(click.getText().equals("SignUp")){
        new SignUp();
        dispose();

            }else{
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // Check if the username and password are correct
                loginCheck p = new loginCheck();
                int code = p.passwordCheck(username, password);
                if( code == 200){
                    messageLabel.setText("LOGIN Successful");
                    messageLabel.setForeground(Color.GREEN);
                    //Delay 1s after login
                    ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
                    Runnable task = new Runnable() {
                        public void run() {
                            new HomeScreen();
                            dispose();
                        }
                    };
                    executor.schedule(task, 1, TimeUnit.SECONDS);

                }else if(code == 500) {messageLabel.setText("Internal Server Error. Try Again!");
                messageLabel.setForeground(Color.red);}
                else{
                    messageLabel.setText("Wrong username or password");
                messageLabel.setForeground(Color.red);
                }
            }
            }
        }

    }

