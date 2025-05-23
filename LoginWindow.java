import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginWindow extends JFrame {
    private JPasswordField masterPasswordField;
    private static final String MASTER_PASSWORD = "admin"; // Change this to securely store/check master password

    public LoginWindow() {
        setTitle("Password Manager - Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 150);
        setLocationRelativeTo(null);

        JLabel label = new JLabel("Enter Master Password:");
        masterPasswordField = new JPasswordField(20);
        JButton loginButton = new JButton("Login");

        loginButton.addActionListener(e -> checkPassword());

        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(masterPasswordField);
        panel.add(loginButton);

        add(panel);
        setVisible(true);
    }

    private void checkPassword() {
        String input = new String(masterPasswordField.getPassword());
        if (input.equals(MASTER_PASSWORD)) {
            dispose();
            new MainAppWindow(input);
        } else {
            JOptionPane.showMessageDialog(this, "Incorrect master password.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}