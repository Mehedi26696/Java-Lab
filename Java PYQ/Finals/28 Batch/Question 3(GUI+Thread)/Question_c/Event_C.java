
// (c) Explain the concept of Event Triggering with an example related to Java Graphical User Interface (GUI). Analyze the importance and explain how it brings additional
// improvement to an application.

// Event triggering is a concept in which an event is triggered when a certain action is performed. In Java, event triggering is used in GUI applications to handle user
// interactions. When a user interacts with a GUI component, an event is triggered. For example, when a user clicks a button, an action event is triggered. This event is
// then handled by an event listener, which executes the appropriate code in response to the event.

// Example:
// Consider a simple Java GUI application that has a button. When the user clicks the button, a message is displayed on the screen. In this case, the button click event
// triggers an action that displays the message.

import javax.swing.*;
import java.awt.event.*;

public class Event_C {
    private static int counter = 0;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Event Triggering Example");
        JButton button = new JButton("Click Me");
        JLabel label = new JLabel("Button clicked 0 times");

        // ActionListener for button click event
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                counter++;
                label.setText("Button clicked " + counter + " times");
            }
        });

        frame.setLayout(new java.awt.FlowLayout());
        frame.add(button);
        frame.add(label);
        frame.setSize(600, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

// Importance of Event Triggering:

// User Interaction: It enables dynamic responses to user actions, enhancing the
// interactivity of the application.

// Separation of Concerns: It decouples the GUI from the underlying logic,
// allowing independent development and easier maintenance of both.

// Responsiveness: It ensures that the application remains responsive to user
// inputs, improving performance by handling events asynchronously.

// Maintainability and Scalability: Event-driven design simplifies extending and
// modifying the application, as event handlers are modular and easily managed.