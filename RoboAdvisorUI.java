package RoboAdvisor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RoboAdvisorUI {

    public static void main(String[] args) {
        // 1️⃣ Create the main window (frame)
        JFrame frame = new JFrame("Robo Advisor");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(5, 2)); // 5 rows, 2 columns

        // 2️⃣ Add labels and text fields for user input
        JLabel salaryLabel = new JLabel("Monthly Salary (£):");
        JTextField salaryField = new JTextField();

        JLabel goalLabel = new JLabel("Desired Final Amount (£):");
        JTextField goalField = new JTextField();

        JLabel periodLabel = new JLabel("Saving Period (months):");
        JTextField periodField = new JTextField();

        // 3️⃣ Add a button to calculate
        JButton calculateButton = new JButton("Calculate");

        // 4️⃣ Add an area or placeholder for messages
        JTextArea resultArea = new JTextArea();
        resultArea.setEditable(false);

        // 5️⃣ Add components to the frame in order
        frame.add(salaryLabel);
        frame.add(salaryField);

        frame.add(goalLabel);
        frame.add(goalField);

        frame.add(periodLabel);
        frame.add(periodField);

        frame.add(calculateButton);
        frame.add(new JLabel()); // filler cell

        frame.add(new JLabel("Advice:"));
        frame.add(resultArea);

        // 6️⃣ Add logic for button click
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Read inputs
                    double salary = Double.parseDouble(salaryField.getText());
                    double goal = Double.parseDouble(goalField.getText());
                    int months = Integer.parseInt(periodField.getText());

                    // Create user profile and advisor
                    UserProfile user = new UserProfile(salary, goal, months);
                    RoboAdvisor advisor = new RoboAdvisor();

                    // Get the advice text
                    String advice = advisor.provideAdvice(user);

                    // Show advice in the text area
                    resultArea.setText(advice);

                } catch (NumberFormatException ex) {
                    // Handle invalid input
                    JOptionPane.showMessageDialog(frame,
                            "Please enter valid numbers for all fields.",
                            "Input Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // 7️⃣ Make the window visible
        frame.setVisible(true);
    }
}
