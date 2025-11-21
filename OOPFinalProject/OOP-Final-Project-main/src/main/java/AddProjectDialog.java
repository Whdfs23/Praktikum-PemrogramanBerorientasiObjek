// File: AddProjectDialog.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddProjectDialog extends JDialog {
    private JTextField titleField;
    private JTextField companyField;
    private JTextArea descArea;
    private JTextField skillsField;
    private JTextField budgetField;

    private Project projectResult = null;

    public AddProjectDialog(Frame parent) {
        super(parent, "Tambah Proyek", true); // Modal
        initializeComponents();
        layoutComponents();
        setupEventHandlers();
    }

    private void initializeComponents() {
        titleField = new JTextField(25);
        companyField = new JTextField(25);
        descArea = new JTextArea(4, 25);
        descArea.setLineWrap(true);
        descArea.setWrapStyleWord(true);
        skillsField = new JTextField(25);
        budgetField = new JTextField(15);
    }

    private void layoutComponents() {
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0; gbc.gridy = 0;
        inputPanel.add(new JLabel("Judul Proyek:"), gbc);
        gbc.gridx = 1;
        inputPanel.add(titleField, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        inputPanel.add(new JLabel("Perusahaan:"), gbc);
        gbc.gridx = 1;
        inputPanel.add(companyField, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        inputPanel.add(new JLabel("Deskripsi:"), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.BOTH;
        inputPanel.add(new JScrollPane(descArea), gbc);
        gbc.fill = GridBagConstraints.NONE;

        gbc.gridx = 0; gbc.gridy = 3;
        inputPanel.add(new JLabel("Skill yang Dibutuhkan:"), gbc);
        gbc.gridx = 1;
        inputPanel.add(skillsField, gbc);

        gbc.gridx = 0; gbc.gridy = 4;
        inputPanel.add(new JLabel("Budget (Rp):"), gbc);
        gbc.gridx = 1;
        inputPanel.add(budgetField, gbc);

        add(inputPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton okButton = new JButton("OK");
        JButton cancelButton = new JButton("Cancel");

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validateInput()) {
                    projectResult = new Project(
                            titleField.getText().trim(),
                            companyField.getText().trim(),
                            descArea.getText().trim(),
                            skillsField.getText().trim(),
                            Double.parseDouble(budgetField.getText().trim())
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
        if (titleField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Judul Proyek wajib diisi.", "Validasi Gagal", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (companyField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nama Perusahaan wajib diisi.", "Validasi Gagal", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (descArea.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Deskripsi wajib diisi.", "Validasi Gagal", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (skillsField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Skill yang Dibutuhkan wajib diisi.", "Validasi Gagal", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        try {
            Double.parseDouble(budgetField.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Budget harus berupa angka.", "Validasi Gagal", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    public Project getProjectResult() {
        return projectResult;
    }
}