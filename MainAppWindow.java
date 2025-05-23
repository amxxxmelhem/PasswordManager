import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class MainAppWindow extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField searchField;
    private List<PasswordEntry> passwordEntries = new ArrayList<>();
    private String masterPassword;

    public MainAppWindow(String masterPassword) {
        this.masterPassword = masterPassword;
        setTitle("Password Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        // Table setup
        tableModel = new DefaultTableModel(new Object[]{"Website", "Username", "Password"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        // Search field
        searchField = new JTextField(20);
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(e -> filterEntries());

        JButton addButton = new JButton("Add Password");
        addButton.addActionListener(e -> addPassword());

        JPanel controlPanel = new JPanel();
        controlPanel.add(new JLabel("Search:"));
        controlPanel.add(searchField);
        controlPanel.add(searchButton);
        controlPanel.add(addButton);

        add(controlPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        loadEntries();
        setVisible(true);
    }

    private void addPassword() {
        JTextField websiteField = new JTextField();
        JTextField usernameField = new JTextField();
        JTextField passwordField = new JTextField();
        Object[] message = {
            "Website:", websiteField,
            "Username/Email:", usernameField,
            "Password:", passwordField,
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Add New Password", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            PasswordEntry entry = new PasswordEntry(
                websiteField.getText(), usernameField.getText(), passwordField.getText()
            );
            passwordEntries.add(entry);
            saveEntries();
            refreshTable(passwordEntries);
        }
    }

    private void filterEntries() {
        String search = searchField.getText().toLowerCase();
        List<PasswordEntry> filtered = new ArrayList<>();
        for (PasswordEntry entry : passwordEntries) {
            if (entry.getWebsite().toLowerCase().contains(search)) {
                filtered.add(entry);
            }
        }
        refreshTable(filtered);
    }

    private void refreshTable(List<PasswordEntry> entries) {
        tableModel.setRowCount(0);
        for (PasswordEntry entry : entries) {
            tableModel.addRow(new Object[]{
                entry.getWebsite(), entry.getUsername(), entry.getPassword()
            });
        }
    }

    private void loadEntries() {
        try {
            passwordEntries = PasswordStorage.loadEntries(masterPassword);
        } catch (Exception e) {
            passwordEntries = new ArrayList<>();
        }
        refreshTable(passwordEntries);
    }

    private void saveEntries() {
        try {
            PasswordStorage.saveEntries(passwordEntries, masterPassword);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Failed to save entries.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}