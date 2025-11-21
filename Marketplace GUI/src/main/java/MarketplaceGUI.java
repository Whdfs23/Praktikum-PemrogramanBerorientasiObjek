import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class MarketplaceGUI extends JFrame {
    // --- Data Model ---
    private List<Freelancer> freelancers = new ArrayList<>();
    private List<Project> projects = new ArrayList<>();
    private DatabaseManager mongoDriver = new DatabaseManager(this);

    private DefaultListModel<Freelancer> freelancerListModel;
    private DefaultListModel<Project> projectListModel;
    private JList<Freelancer> jlistFreelancers;
    private JList<Project> jlistProjects;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MarketplaceGUI frame = new MarketplaceGUI();
            frame.setVisible(true);
        });
    }

    public MarketplaceGUI() {
        setTitle("Marketplace Freelancer Mini");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        initComponents();

        // Load awal
        for (Freelancer freelancer : mongoDriver.getAllFreelancers()) {
            freelancers.add(freelancer);
            freelancerListModel.addElement(freelancer);
        }
        for (Project project : mongoDriver.getAllProjects()) {
            projects.add(project);
            projectListModel.addElement(project);
        }
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        JButton btnRegisterFreelancer = new JButton("Registrasi Freelancer Baru");
        JButton btnPostProject = new JButton("Buat Proyek Baru");
        JButton btnFreelancerVisibility = new JButton("Sembunyikan Freelancer");
        JButton btnProjectVisibility = new JButton("Sembunyikan Proyek");
        buttonPanel.add(btnRegisterFreelancer);
        buttonPanel.add(btnPostProject);
        buttonPanel.add(btnFreelancerVisibility);
        buttonPanel.add(btnProjectVisibility);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setEnabled(false);
        splitPane.setResizeWeight(0.5);

        JPanel leftPanel = new JPanel(new GridBagLayout());
        JPanel rightPanel = new JPanel(new GridBagLayout());

        GridBagConstraints gbcTop = new GridBagConstraints();
        gbcTop.gridx = 0; gbcTop.gridy = 0;
        gbcTop.fill = GridBagConstraints.BOTH;
        gbcTop.weightx = 1.0; gbcTop.weighty = 1.0;

        GridBagConstraints gbcOther = new GridBagConstraints();
        gbcOther.gridx = 0;
        gbcOther.fill = GridBagConstraints.BOTH;
        gbcOther.weightx = 1.0; gbcOther.weighty = 0.0;

        // Freelancer
        freelancerListModel = new DefaultListModel<>();
        jlistFreelancers = new JList<>(freelancerListModel);
        jlistFreelancers.setCellRenderer(new FreelancerRenderer());
        JScrollPane freelancerScrollPane = new JScrollPane(jlistFreelancers);
        freelancerScrollPane.setBorder(BorderFactory.createTitledBorder("Freelancer Tersedia"));
        leftPanel.add(freelancerScrollPane, gbcTop);

        JSplitPane buttonSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        buttonSplitPane.setEnabled(false);
        buttonSplitPane.setResizeWeight(0.5);
        gbcOther.gridy = 1;
        JButton btnDeleteFreelancer = new JButton("Hapus");
        JButton btnUpdateFreelancer = new JButton("Update");
        buttonSplitPane.setLeftComponent(btnDeleteFreelancer);
        buttonSplitPane.setRightComponent(btnUpdateFreelancer);
        leftPanel.add(buttonSplitPane, gbcOther);

        // Project
        projectListModel = new DefaultListModel<>();
        jlistProjects = new JList<>(projectListModel);
        jlistProjects.setCellRenderer(new ProjectRenderer());
        JScrollPane projectScrollPane = new JScrollPane(jlistProjects);
        projectScrollPane.setBorder(BorderFactory.createTitledBorder("Proyek"));
        rightPanel.add(projectScrollPane, gbcTop);

        JSplitPane buttonSplitPaneProject = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        buttonSplitPaneProject.setEnabled(false);
        buttonSplitPaneProject.setResizeWeight(0.5);
        gbcOther.gridy = 1;
        JButton btnDeleteProject = new JButton("Hapus");
        JButton btnUpdateProject = new JButton("Update");
        buttonSplitPaneProject.setLeftComponent(btnDeleteProject);
        buttonSplitPaneProject.setRightComponent(btnUpdateProject);
        rightPanel.add(buttonSplitPaneProject, gbcOther);

        // --- Tambahan Assignment/Complete/Unassign ---
        gbcOther.gridy = 2;
        JButton btnAssignProject = new JButton("Tugaskan Freelancer");
        rightPanel.add(btnAssignProject, gbcOther);
        gbcOther.gridy = 3;
        JButton btnCompleteProject = new JButton("Set Project Completed");
        rightPanel.add(btnCompleteProject, gbcOther);
        gbcOther.gridy = 4;
        JButton btnUnassignProject = new JButton("Unassign Freelancer");
        rightPanel.add(btnUnassignProject, gbcOther);

        splitPane.setLeftComponent(leftPanel);
        splitPane.setRightComponent(rightPanel);

        mainPanel.add(buttonPanel, BorderLayout.NORTH);
        mainPanel.add(splitPane, BorderLayout.CENTER);
        add(mainPanel);

        // --- Listener tombol utama ---
        btnRegisterFreelancer.addActionListener((ActionEvent e) -> {
            showRegisterFreelancerDialog("Add");
        });
        btnPostProject.addActionListener((ActionEvent e) -> {
            showPostProjectDialog("Add");
        });
        btnUpdateFreelancer.addActionListener((ActionEvent e) -> {
            showRegisterFreelancerDialog("Update");
        });
        btnUpdateProject.addActionListener((ActionEvent e) -> {
            showPostProjectDialog("Update");
        });
        btnDeleteFreelancer.addActionListener((ActionEvent e) -> {
            int index = jlistFreelancers.getSelectedIndex();
            if (index >= 0) showDeleteFreelancerConfirmation(index, freelancers.get(index).getName());
        });
        btnDeleteProject.addActionListener((ActionEvent e) -> {
            int index = jlistProjects.getSelectedIndex();
            if (index >= 0) showDeleteProjectConfirmation(index, projects.get(index).getTitle());
        });
        btnFreelancerVisibility.addActionListener((ActionEvent e) -> {
            freelancerScrollPane.setVisible(!freelancerScrollPane.isVisible());
            if (freelancerScrollPane.isVisible()) {
                splitPane.setDividerLocation(0.5);
                btnFreelancerVisibility.setText("Sembunyikan Freelancer");
            } else {
                splitPane.setDividerLocation(0);
                btnFreelancerVisibility.setText("Tampilkan Freelancer");
            }
            splitPane.revalidate();
            splitPane.repaint();
        });
        btnProjectVisibility.addActionListener((ActionEvent e) -> {
            projectScrollPane.setVisible(!projectScrollPane.isVisible());
            if (projectScrollPane.isVisible()) {
                splitPane.setDividerLocation(0.5);
                btnProjectVisibility.setText("Sembunyikan Proyek");
            } else {
                splitPane.setDividerLocation(1.0);
                btnProjectVisibility.setText("Tampilkan Proyek");
            }
            splitPane.revalidate();
            splitPane.repaint();
        });

        // --- ACTION BARU ---
        // Tombol assign
        btnAssignProject.addActionListener((ActionEvent e) -> {
            int projectIndex = jlistProjects.getSelectedIndex();
            if (projectIndex < 0) {
                JOptionPane.showMessageDialog(this, "Pilih proyek yang ingin ditugaskan!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                return;
            }
            Project selectedProject = projects.get(projectIndex);
            if (!selectedProject.getStatus().equals("Open")) {
                JOptionPane.showMessageDialog(this, "Proyek hanya dapat ditugaskan jika statusnya 'Open'.", "Peringatan", JOptionPane.WARNING_MESSAGE);
                return;
            }
            JComboBox<Freelancer> freelancerComboBox = new JComboBox<>();
            for (Freelancer f : freelancers) {
                boolean isBusy = false;
                for (Project p : projects) {
                    if (p.getAssignedFreelancerName() != null && p.getAssignedFreelancerName().equals(f.getName())
                        && p.getStatus().equals("In Progress")) {
                        isBusy = true;
                        break;
                    }
                }
                if (!isBusy) freelancerComboBox.addItem(f);
            }
            if (freelancerComboBox.getItemCount() == 0) {
                JOptionPane.showMessageDialog(this, "Tidak ada freelancer yang tersedia!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                return;
            }
            JPanel panel = new JPanel(new BorderLayout(5, 5));
            panel.add(new JLabel("Pilih Freelancer untuk proyek ini:"), BorderLayout.NORTH);
            panel.add(freelancerComboBox, BorderLayout.CENTER);
            int result = JOptionPane.showConfirmDialog(this, panel, "Assign Freelancer", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (result == JOptionPane.OK_OPTION) {
                Freelancer selectedFreelancer = (Freelancer) freelancerComboBox.getSelectedItem();
                if (selectedFreelancer == null) {
                    JOptionPane.showMessageDialog(this, "Freelancer belum dipilih!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                mongoDriver.assignProject(selectedProject, selectedFreelancer);
            }
        });

        // Tombol complete project
        btnCompleteProject.addActionListener((ActionEvent e) -> {
            int projectIndex = jlistProjects.getSelectedIndex();
            if (projectIndex < 0) {
                JOptionPane.showMessageDialog(this, "Pilih proyek terlebih dahulu!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                return;
            }
            Project selectedProject = projects.get(projectIndex);
            if (!selectedProject.getStatus().equals("In Progress")) {
                JOptionPane.showMessageDialog(this, "Proyek hanya dapat diselesaikan jika statusnya 'In Progress'.", "Peringatan", JOptionPane.WARNING_MESSAGE);
                return;
            }
            String ratingStr = JOptionPane.showInputDialog(this, "Beri rating (1.0 - 5.0) untuk freelancer?", "5.0");
            try {
                double rating = Double.parseDouble(ratingStr);
                if (rating < 1.0 || rating > 5.0) throw new NumberFormatException();
                mongoDriver.completeProject(selectedProject);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Rating tidak valid!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Tombol unassign freelancer
        btnUnassignProject.addActionListener((ActionEvent e) -> {
            int projectIndex = jlistProjects.getSelectedIndex();
            if (projectIndex < 0) {
                JOptionPane.showMessageDialog(this, "Pilih proyek terlebih dahulu!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                return;
            }
            Project selectedProject = projects.get(projectIndex);
            if (!selectedProject.getStatus().equals("In Progress")) {
                JOptionPane.showMessageDialog(this, "Hanya proyek 'In Progress' yang bisa di-unassign.", "Peringatan", JOptionPane.WARNING_MESSAGE);
                return;
            }
            int result = JOptionPane.showConfirmDialog(this, "Yakin ingin unassign freelancer dari proyek ini?", "Konfirmasi", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                mongoDriver.unassignProject(selectedProject);
            }
        });
    }

    // --- Dialog & Helper ---
    private void showRegisterFreelancerDialog(String type) {
        JPanel panel = new JPanel(new GridLayout(4, 2, 5, 5));
        JTextField nameField = new JTextField();
        JTextField skillField = new JTextField();
        JTextField rateField = new JTextField("0.0");
        JTextField ratingField = new JTextField("5.0");
        panel.add(new JLabel("Nama:")); panel.add(nameField);
        panel.add(new JLabel("Skill Utama:")); panel.add(skillField);
        panel.add(new JLabel("Tarif per Jam (Rp):")); panel.add(rateField);
        panel.add(new JLabel("Rating Awal:")); panel.add(ratingField);

        String dialogTitle = (type.equals("Add")) ? "Registrasi Freelancer" : "Update Freelancer";
        if (type.equals("Update")) {
            int index = jlistFreelancers.getSelectedIndex();
            Freelancer current = freelancers.get(index);
            nameField.setText(current.getName());
            skillField.setText(current.getSkill());
            rateField.setText(Double.toString(current.getRatePerHour()));
            ratingField.setText(Double.toString(current.getRating()));
        }

        int result = JOptionPane.showConfirmDialog(this, panel, dialogTitle, JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            try {
                String name = nameField.getText();
                String skill = skillField.getText();
                double rate = Double.parseDouble(rateField.getText());
                double rating = Double.parseDouble(ratingField.getText());
                if (name.isEmpty() || skill.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Nama dan Skill tidak boleh kosong!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (type.equals("Add")) {
                    mongoDriver.insertFreelancer(new Freelancer(name, skill, rate, rating));
                } else if (type.equals("Update")) {
                    int index = jlistFreelancers.getSelectedIndex();
                    Freelancer current = freelancers.get(index);
                    mongoDriver.updateFreelancer(current, name, skill, rate, rating);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Tarif dan Rating harus angka!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void showPostProjectDialog(String type) {
        JPanel panel = new JPanel(new GridLayout(4, 2, 5, 5));
        JTextField titleField = new JTextField();
        JTextField companyField = new JTextField();
        JTextField descField = new JTextField();
        JTextField budgetField = new JTextField("0.0");
        panel.add(new JLabel("Judul Proyek:")); panel.add(titleField);
        panel.add(new JLabel("Nama Perusahaan:")); panel.add(companyField);
        panel.add(new JLabel("Deskripsi Singkat:")); panel.add(descField);
        panel.add(new JLabel("Budget (Rp):")); panel.add(budgetField);

        String dialogTitle = (type.equals("Add")) ? "Buat Proyek Baru" : "Update Proyek";
        if (type.equals("Update")) {
            int index = jlistProjects.getSelectedIndex();
            Project current = projects.get(index);
            titleField.setText(current.getTitle());
            companyField.setText(current.getCompanyName());
            descField.setText(current.getDescription());
            budgetField.setText(Double.toString(current.getBudget()));
        }

        int result = JOptionPane.showConfirmDialog(this, panel, dialogTitle, JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            try {
                String title = titleField.getText();
                String company = companyField.getText();
                String desc = descField.getText();
                double budget = Double.parseDouble(budgetField.getText());
                if (title.isEmpty() || company.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Judul dan Perusahaan tidak boleh kosong!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (type.equals("Add")) {
                    mongoDriver.insertProject(new Project(title, desc, budget, company));
                } else if (type.equals("Update")) {
                    int index = jlistProjects.getSelectedIndex();
                    Project current = projects.get(index);
                    mongoDriver.updateProject(current, title, company, desc, budget);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Budget harus angka!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void showDeleteFreelancerConfirmation(int index, String name) {
        int response = JOptionPane.showConfirmDialog(this, "Hapus " + name + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION && index >= 0) {
            mongoDriver.deleteFreelancer(freelancers.get(index).getId());
        }
    }

    private void showDeleteProjectConfirmation(int index, String title) {
        int response = JOptionPane.showConfirmDialog(this, "Hapus " + title + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION && index >= 0) {
            mongoDriver.deleteProject(projects.get(index).getId());
        }
    }

    public void refreshFreelancers() {
        freelancers.clear();
        freelancerListModel.clear();
        for (Freelancer freelancer : mongoDriver.getAllFreelancers()) {
            freelancers.add(freelancer);
            freelancerListModel.addElement(freelancer);
        }
    }

    public void refreshProjects() {
        projects.clear();
        projectListModel.clear();
        for (Project project : mongoDriver.getAllProjects()) {
            projects.add(project);
            projectListModel.addElement(project);
        }
    }

    public void displayDatabaseError() {
        JOptionPane.showMessageDialog(this,
                "Terjadi kesalahan saat menghubungkan ke database.\nHarap coba lagi atau periksa pengaturan koneksi.",
                "Kesalahan Koneksi Database", JOptionPane.ERROR_MESSAGE);
    }

    // --- Renderer ---
    class FreelancerRenderer extends JPanel implements ListCellRenderer<Freelancer> {
        private JLabel lblName = new JLabel();
        private JLabel lblSkill = new JLabel();
        private JLabel lblDetails = new JLabel();

        public FreelancerRenderer() {
            setLayout(new BorderLayout(5, 5));
            setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            JPanel westPanel = new JPanel(new GridLayout(2, 1));
            westPanel.add(lblName); westPanel.add(lblSkill);
            add(westPanel, BorderLayout.CENTER); add(lblDetails, BorderLayout.EAST);
            lblName.setFont(new Font("Arial", Font.BOLD, 14));
            lblSkill.setFont(new Font("Arial", Font.ITALIC, 12));
            lblDetails.setFont(new Font("Arial", Font.PLAIN, 12));
        }
        @Override
        public Component getListCellRendererComponent(JList<? extends Freelancer> list, Freelancer freelancer, int index,
                                                     boolean isSelected, boolean cellHasFocus) {
            lblName.setText(freelancer.getName());
            lblSkill.setText(freelancer.getSkill());
            lblDetails.setText(String.format("Rp%.2f/jam | %.1f Bintang", freelancer.getRatePerHour(), freelancer.getRating()));
            setBackground(isSelected ? list.getSelectionBackground() : list.getBackground());
            setForeground(isSelected ? list.getSelectionForeground() : list.getForeground());
            return this;
        }
    }
    class ProjectRenderer extends JPanel implements ListCellRenderer<Project> {
        private JLabel lblTitle = new JLabel();
        private JLabel lblCompany = new JLabel();
        private JLabel lblBudget = new JLabel();
        public ProjectRenderer() {
            setLayout(new BorderLayout(5, 5));
            setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            JPanel westPanel = new JPanel(new GridLayout(2, 1));
            westPanel.add(lblTitle); westPanel.add(lblCompany);
            add(westPanel, BorderLayout.CENTER); add(lblBudget, BorderLayout.EAST);
            lblTitle.setFont(new Font("Arial", Font.BOLD, 14));
            lblCompany.setFont(new Font("Arial", Font.ITALIC, 12));
            lblBudget.setFont(new Font("Arial", Font.BOLD, 12));
            lblBudget.setForeground(new Color(0, 100, 0));
        }
        @Override
        public Component getListCellRendererComponent(JList<? extends Project> list, Project project, int index,
                                                     boolean isSelected, boolean cellHasFocus) {
            lblTitle.setText(project.getTitle());
            lblCompany.setText("oleh " + project.getCompanyName());
            lblBudget.setText(String.format("Budget: Rp%.2f", project.getBudget()));
            setBackground(isSelected ? list.getSelectionBackground() : list.getBackground());
            setForeground(isSelected ? list.getSelectionForeground() : list.getForeground());
            return this;
        }
    }
}