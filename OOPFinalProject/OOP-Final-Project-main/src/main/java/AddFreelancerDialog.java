/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */
// File: AddFreelancerDialog.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddFreelancerDialog extends JDialog {
    private JTextField nameField;
    private JTextField skillField;
    private JTextField emailField;
    private JTextField rateField;
    private JTextArea experienceArea;

    private Freelancer freelancerResult = null;

    public AddFreelancerDialog(Frame parent) {
        super(parent, "Tambah Freelancer", true);
        initializeComponents();
        layoutComponents();
        setupEventHandlers();
    }

    private void initializeComponents() {
        nameField = new JTextField(20);
        skillField = new JTextField(20);
        emailField = new JTextField(20);
        rateField = new JTextField(10);
        experienceArea = new JTextArea(3, 20);
        experienceArea.setLineWrap(true);
        experienceArea.setWrapStyleWord(true);
    }

    private void layoutComponents() {
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0; gbc.gridy = 0;
        inputPanel.add(new JLabel("Nama:"), gbc);
        gbc.gridx = 1;
        inputPanel.add(nameField, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        inputPanel.add(new JLabel("Skill:"), gbc);
        gbc.gridx = 1;
        inputPanel.add(skillField, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        inputPanel.add(new JLabel("Email:"), gbc);
        gbc.gridx = 1;
        inputPanel.add(emailField, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        inputPanel.add(new JLabel("Rate Per Jam (Rp):"), gbc);
        gbc.gridx = 1;
        inputPanel.add(rateField, gbc);

        gbc.gridx = 0; gbc.gridy = 4;
        inputPanel.add(new JLabel("Pengalaman:"), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.BOTH;
        inputPanel.add(new JScrollPane(experienceArea), gbc);
        gbc.fill = GridBagConstraints.NONE;

        add(inputPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton okButton = new JButton("OK");
        JButton cancelButton = new JButton("Cancel");

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validateInput()) {
                    freelancerResult = new Freelancer(
                            nameField.getText().trim(),
                            skillField.getText().trim(),
                            emailField.getText().trim(),
                            Double.parseDouble(rateField.getText().trim()),
                            experienceArea.getText().trim()
                    );
                    dispose();
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);
        add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(getParent());
    }

    private void setupEventHandlers() {
        // Event handler sudah diatur di ActionListener tombol OK dan Cancel
    }

    private boolean validateInput() {
        if (nameField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nama wajib diisi.", "Validasi Gagal", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (skillField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Skill wajib diisi.", "Validasi Gagal", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (emailField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Email wajib diisi.", "Validasi Gagal", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        try {
            Double.parseDouble(rateField.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Rate Per Jam harus berupa angka.", "Validasi Gagal", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (experienceArea.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pengalaman wajib diisi.", "Validasi Gagal", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    public Freelancer getFreelancerResult() {
        return freelancerResult;
    }
}
