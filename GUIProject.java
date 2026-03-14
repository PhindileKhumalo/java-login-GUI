import java.awt.*;
import javax.swing.*;

public class GUIProject extends JFrame {

    private JRadioButton studentRadio, LecturerRadio, AdminRadio;
    private JTextField studentNumberField;
    private JPasswordField pinField;



    public GUIProject() {
        setTitle("Login Credentials");
        setSize(450, 420);setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	


        JPanel panel = new JPanel(new BorderLayout());


        JLabel titleLabel = new JLabel("Login Credentials", JLabel.CENTER);

       titleLabel.setOpaque(true);
        titleLabel.setBackground(new Color(114,188,212));
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setPreferredSize(new Dimension(450, 50));


	JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
titlePanel.add(titleLabel);

panel.add(titlePanel, BorderLayout.NORTH);

        // form panel
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(7, 7, 5, 8));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 15, 20, 15));


        studentRadio = new JRadioButton("Student", true);
        LecturerRadio = new JRadioButton("Lecturer");
        AdminRadio = new JRadioButton("Administrator");


        ButtonGroup group = new ButtonGroup();
        group.add(studentRadio);
        group.add(LecturerRadio);
        group.add(AdminRadio);

        // Alignment of Radiobuttons
        JPanel radioPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        radioPanel.add(studentRadio);
        radioPanel.add(LecturerRadio);
        radioPanel.add(AdminRadio);


        formPanel.add(radioPanel);


        formPanel.add(new JLabel("Student Number:"));
        studentNumberField = new JTextField();
        formPanel.add(studentNumberField);


        formPanel.add(new JLabel("Pin :"));
        pinField = new JPasswordField();
        formPanel.add(pinField);


        JPanel buttonPanel = new JPanel(new FlowLayout());

        JButton loginButton = new JButton("Login");
        JButton forgotPinButton = new JButton("Forgot Pin");


        buttonPanel.add(loginButton);
        buttonPanel.add(forgotPinButton);


        formPanel.add(buttonPanel);

        formPanel.add(new JLabel(""));
	  
 	JPanel centerWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER));
        centerWrapper.add(formPanel);

        panel.add(centerWrapper, BorderLayout.CENTER);

        add(panel);


       loginButton.addActionListener( e -> {
            String studentNumber = studentNumberField.getText();
            String pin = new String(pinField.getPassword());

            if (studentNumber.isEmpty() || pin.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields.");
            }else if (!studentNumber.matches("\\d{9}")) {
                JOptionPane.showMessageDialog(this, "try Again.");
            }
            else if (!pin.matches("[1-9][0-9]{3}")) {
                JOptionPane.showMessageDialog(this, "PIN must be 4 digits and not start with 0.");
            } else {
                JOptionPane.showMessageDialog(this, "Login Successful");
            }
        });

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GUIProject().setVisible(true);

        });
    }
}