package src;

import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;	// Im not sure why this isnt inculded in swing.* 
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Main {

	static String grid = 	"+-----+-----+-----+-----+-----+-----+-----+-----+\n"+
							"|     |     |     |     |     |     |     |     |\n"+
							"+-----+-----+-----+-----+-----+-----+-----+-----+\n"+
							"|     |     |     |     |     |     |     |     |\n"+
							"+-----+-----+-----+-----+-----+-----+-----+-----+\n"+
							"|     |     |     |     |     |     |     |     |\n"+
							"+-----+-----+-----+-----+-----+-----+-----+-----+\n"+
							"|     |     |     |     |     |     |     |     |\n"+
							"+-----+-----+-----+-----+-----+-----+-----+-----+\n"+
							"|     |     |     |     |     |     |     |     |\n"+
							"+-----+-----+-----+-----+-----+-----+-----+-----+\n"+
							"|     |     |     |     |     |     |     |     |\n"+
							"+-----+-----+-----+-----+-----+-----+-----+-----+\n"+
							"|     |     |     |     |     |     |     |     |\n"+
							"+-----+-----+-----+-----+-----+-----+-----+-----+\n"+
							"|     |     |     |     |     |     |     |     |\n"+
							"+-----+-----+-----+-----+-----+-----+-----+-----+\n";

	public static void main(String[] args) throws FileNotFoundException, IOException {

		SwingUtilities.invokeLater(() -> {

            JFrame frame = new JFrame("Mini Spreadsheet");
            frame.setSize(590, 570);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Display area
            JTextArea display = new JTextArea();
            display.setEditable(false);
            display.setBackground(Color.BLACK);			// Background color of text/display area
            display.setForeground(Color.WHITE);			// Frreground color = text color
            display.setCaretColor(Color.WHITE);			// Caret color = color of the blinking line that tells you where you are typing
			display.setMargin(new Insets(10, 10, 10, 10));
            display.setFont(new Font("Monospaced", Font.PLAIN, 18));
			// Removes Scroll Bar Border
			JScrollPane scrollPane = new JScrollPane(display);
			scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        	scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
			// add(scrollPane, BorderLayout.CENTER);

            // Input field
            JTextField input = new JTextField("Insert Commands Here...");
            input.setBackground(Color.BLACK);
            input.setForeground(Color.WHITE);
            input.setCaretColor(Color.WHITE);
			// input.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
			// input.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
			Border outline = BorderFactory.createLineBorder(Color.WHITE, 2);
			Border margin = BorderFactory.createEmptyBorder(8, 8, 8, 8);
			input.setBorder(BorderFactory.createCompoundBorder(outline, margin));
            input.setFont(new Font("Monospaced", Font.PLAIN, 18));

			// Prompt Text
			input.addFocusListener(new FocusListener() {
				@Override
				public void focusGained(FocusEvent e) {
					// Clear the text only if it hasn't been changed by the user
					if (input.getText().equals("Insert Commands Here...")) {
						input.setText("");
					}
				}

				@Override
				public void focusLost(FocusEvent e) {
					// If the field is empty when focus is lost, restore the prompt
					if (input.getText().isEmpty()) {
						input.setText("Insert Commands Here...");
					}
            	}
			});

			// Handle input
            input.addActionListener(e -> {
                String command = input.getText();
                input.setText("");

                display.append("> " + command + "\n");
            });

			display.append(grid);

            frame.setLayout(new BorderLayout());
            frame.add(new JScrollPane(display), BorderLayout.CENTER);
            frame.add(input, BorderLayout.SOUTH);

            frame.setVisible(true);
        });
	}						
}
