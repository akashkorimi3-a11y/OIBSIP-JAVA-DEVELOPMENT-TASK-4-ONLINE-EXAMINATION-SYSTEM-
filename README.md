# 📝 Online Examination System (Java)

A desktop-based Online Examination System built with Java Swing. It provides a login screen, displays multiple-choice Java questions, checks selected answers, and shows the final score.

## Features
- Login screen with username and password fields
- Multiple-choice Java questions
- Radio-button answer selection
- Validation to ensure an answer is selected before continuing
- Automatic score calculation
- Final score display when the exam is completed

## Technologies Used
- Java
- Java Swing (`JFrame`, `JPanel`, `JLabel`, `JButton`, `JRadioButton`)
- AWT layouts and event handling

## Requirements
- Java JDK installed
- A desktop environment that supports Java Swing

## Login Details for Demo

The source code contains hard-coded demo credentials:

- **Username:** `venkat sai`
- **Password:** `1432`

These credentials are for demonstration only. Do not use hard-coded passwords in a real application.

## How to Run

1. Open a terminal in the folder containing `Main.java`.

2. Compile the program:

```bash
javac Main.java
```

3. Run the application:

```bash
java Main
```

A login window should open. Enter the demo credentials above to access the exam.

## How It Works
1. The user enters the login credentials.
2. After a successful login, the exam screen appears.
3. The user selects one answer for each question and clicks **Next**.
4. The application checks the answers and calculates the score.
5. At the end, a dialog displays the score.

## Project Structure

```text
OnlineExaminationSystem/
├── Main.java
└── README.md
```

## Notes
- This is a beginner-level demonstration project.
- The login credentials are stored directly in the source code.
- The questions and answers are defined in arrays in `Main.java`.

## Author
Your Name

## License
For learning and educational use.
