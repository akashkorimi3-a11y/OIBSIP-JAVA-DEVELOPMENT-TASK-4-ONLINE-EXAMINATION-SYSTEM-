import java.awt.*;
import javax.swing.*;

public class Main extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;

    private String[] questions = {
        "1. Which language is used for Java development?",
        "2. Which method is the starting point of a Java program?",
        "3. Which keyword is used to create a class in Java?"
    };

    private String[][] options = {
        {"HTML", "Java", "CSS", "SQL"},
        {"start()", "run()", "main()", "init()"},
        {"define", "class", "create", "newclass"}
    };

    private int[] answers = {1, 2, 1};
    private int currentQuestion = 0;
    private int score = 0;

    private JLabel questionLabel;
    private JRadioButton[] optionButtons;
    private ButtonGroup optionGroup;

    public Main() {
        showLoginScreen();
    }

    private void showLoginScreen() {
        setTitle("Online Examination System");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        panel.add(new JLabel("Online Examination System"));
        panel.add(new JLabel(""));
        panel.add(new JLabel("Username:"));

        usernameField = new JTextField();
        panel.add(usernameField);

        panel.add(new JLabel("Password:"));

        passwordField = new JPasswordField();
        panel.add(passwordField);

        JButton loginButton = new JButton("Login");
        panel.add(new JLabel(""));
        panel.add(loginButton);

        setContentPane(panel);

        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password =
                new String(passwordField.getPassword());

            if (username.equals("venkat sai")
                    && password.equals("1432")) {
                showExamScreen();
            } else {
                JOptionPane.showMessageDialog(
                    this, "Invalid username or password!"
                );
            }
        });

        setVisible(true);
    }

    private void showExamScreen() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        );

        questionLabel = new JLabel();
        questionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(questionLabel, BorderLayout.NORTH);

        JPanel optionsPanel = new JPanel(
            new GridLayout(4, 1, 5, 5)
        );

        optionButtons = new JRadioButton[4];
        optionGroup = new ButtonGroup();

        for (int i = 0; i < 4; i++) {
            optionButtons[i] = new JRadioButton();
            optionGroup.add(optionButtons[i]);
            optionsPanel.add(optionButtons[i]);
        }

        panel.add(optionsPanel, BorderLayout.CENTER);

        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(e -> {
            if (optionGroup.getSelection() == null) {
                JOptionPane.showMessageDialog(
                    this, "Please select an answer."
                );
                return;
            }

            if (optionButtons[answers[currentQuestion]]
                    .isSelected()) {
                score++;
            }

            currentQuestion++;

            if (currentQuestion < questions.length) {
                displayQuestion();
            } else {
                showResult();
            }
        });

        panel.add(nextButton, BorderLayout.SOUTH);

        setTitle("Online Examination - Exam");
        setSize(600, 350);
        setLocationRelativeTo(null);
        setContentPane(panel);

        displayQuestion();
        revalidate();
        repaint();
    }

    private void displayQuestion() {
        questionLabel.setText(questions[currentQuestion]);

        for (int i = 0; i < 4; i++) {
            optionButtons[i].setText(options[currentQuestion][i]);
        }

        optionGroup.clearSelection();
    }

    private void showResult() {
        JOptionPane.showMessageDialog(
            this,
            "Exam completed!\nYour score: "
                + score + "/" + questions.length
        );

        dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main());
    }
}