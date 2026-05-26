import javax.swing.*;
import java.awt.*;

public class FitnessTracker {

    JFrame frame;
    JTextField exerciseField;
    JTextField minutesField;
    JTextArea resultArea;

    public FitnessTracker() {

        frame = new JFrame("Fitness Tracker");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel exerciseLabel = new JLabel("Exercise:");
        exerciseField = new JTextField(15);

        JLabel minutesLabel = new JLabel("Minutes:");
        minutesField = new JTextField(10);

        JButton addButton = new JButton("Add Activity");
        JButton clearButton = new JButton("Clear");

        resultArea = new JTextArea(12,35);
        resultArea.setEditable(false);

        JScrollPane scroll = new JScrollPane(resultArea);

        addButton.addActionListener(e -> addActivity());

        clearButton.addActionListener(e -> {
            resultArea.setText("");
            exerciseField.setText("");
            minutesField.setText("");
        });

        frame.add(exerciseLabel);
        frame.add(exerciseField);

        frame.add(minutesLabel);
        frame.add(minutesField);

        frame.add(addButton);
        frame.add(clearButton);

        frame.add(scroll);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void addActivity() {

        String exercise = exerciseField.getText();
        String minutes = minutesField.getText();

        if(exercise.isEmpty() || minutes.isEmpty()){

            JOptionPane.showMessageDialog(
                    frame,
                    "Fill all fields!"
            );

            return;
        }

        resultArea.append(
                "Exercise: " + exercise +
                " | Time: " + minutes +
                " min\n"
        );

        exerciseField.setText("");
        minutesField.setText("");
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() ->
                new FitnessTracker()
        );
    }
}