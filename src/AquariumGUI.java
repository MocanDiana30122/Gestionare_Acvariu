import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class AquariumGUI {
    private JFrame frame;
    private JTextArea outputArea;
    private FishFeeder fishFeeder;

    public AquariumGUI() {
        // Initialize FishFeeder and AquariumController
        fishFeeder = new FishFeeder("BrandX", "ModelY", 5); // Example initialization
        new AquariumController("Aquarium Corp", "Model A", 0, fishFeeder);

        // Setup the GUI
        frame = new JFrame("Aquarium Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // Output Area
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        frame.add(new JScrollPane(outputArea), BorderLayout.CENTER);

        // Control Panel
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(3, 2));

        JButton feedButton = new JButton("Feed Fish");
        JButton fillButton = new JButton("Fill Feeder");
        JButton displayButton = new JButton("Show Status");

        controlPanel.add(feedButton);
        controlPanel.add(fillButton);
        controlPanel.add(displayButton);

        frame.add(controlPanel, BorderLayout.SOUTH);

        // Action Listeners
        feedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                feedFish();
            }
        });

        fillButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fillFeeder();
            }
        });

        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showStatus();
            }
        });

        frame.setVisible(true);
    }

    private void feedFish() {
        String message = fishFeeder.feed();
        outputArea.append(message + "\n");
    }

    private void fillFeeder() {
        String input = JOptionPane.showInputDialog(frame, "Enter number of meals to add:");
        try {
            int mealsToAdd = Integer.parseInt(input);
            String message = fishFeeder.fillup(mealsToAdd);
            outputArea.append(message + "\n");
        } catch (NumberFormatException e) {
            outputArea.append("Invalid number. Please enter a valid integer.\n");
        }
    }

    private void showStatus() {
        // Only show meals remaining without displaying full object states
        outputArea.append("Meals remaining: " + fishFeeder.getMeals() + "\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AquariumGUI();
            }
        });
    }
}
