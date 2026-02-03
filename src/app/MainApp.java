package app;

import javax.swing.*;
import java.awt.*;

import app.features.AppInfoFeature;
import app.features.StudyTipFeature;
import app.features.MotivationFeature;
import app.features.FunFactFeature;

public class MainApp {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainApp::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Campus Companion");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 420);
        frame.setLocationRelativeTo(null);

        // Title
        JLabel title = new JLabel("Campus Companion", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));

        JLabel subtitle = new JLabel("A simple Java desktop application", SwingConstants.CENTER);
        subtitle.setFont(new Font("Arial", Font.PLAIN, 13));

        JPanel header = new JPanel(new GridLayout(2, 1));
        header.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        header.add(title);
        header.add(subtitle);

        // Output area
        JTextArea output = new JTextArea();
        output.setEditable(false);
        output.setLineWrap(true);
        output.setWrapStyleWord(true);
        output.setFont(new Font("Consolas", Font.PLAIN, 14));
        output.setText(
                "Welcome to Campus Companion.\n\n"
              + "Use the buttons above to view study tips,\n"
              + "motivational messages, and fun facts."
        );

        JScrollPane scrollPane = new JScrollPane(output);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Output"));

        // Buttons panel
        JButton btnAppInfo = new JButton("App Info");
        JButton btnStudyTip = new JButton("Study Tip");
        JButton btnMotivation = new JButton("Motivation");
        JButton btnFunFact = new JButton("Fun Fact");

        // Actions
        btnAppInfo.addActionListener(e -> output.setText(AppInfoFeature.run()));
        btnStudyTip.addActionListener(e -> output.setText(StudyTipFeature.run()));
        btnMotivation.addActionListener(e -> output.setText(MotivationFeature.run()));
        btnFunFact.addActionListener(e -> output.setText(FunFactFeature.run()));

        JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        buttonPanel.setBorder(BorderFactory.createTitledBorder("Features"));
        buttonPanel.add(btnAppInfo);
        buttonPanel.add(btnStudyTip);
        buttonPanel.add(btnMotivation);
        buttonPanel.add(btnFunFact);

        JPanel center = new JPanel(new BorderLayout(10, 10));
        center.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        center.add(buttonPanel, BorderLayout.NORTH);
        center.add(scrollPane, BorderLayout.CENTER);

        frame.getContentPane().add(header, BorderLayout.NORTH);
        frame.getContentPane().add(center, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
