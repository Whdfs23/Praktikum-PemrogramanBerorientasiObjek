// File: MarketplaceGUI.java
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import org.bson.types.ObjectId;

public class MarketplaceGUI extends JFrame {
    private DatabaseManager db;

    // UI Components
    private JTextField txtSearchFreelancer;
    private DefaultListModel<Freelancer> freelancerListModel;
    private JList<Freelancer> jlistFreelancers;

    private JTextField txtSearchProject;
    private DefaultListModel<Project> projectListModel;
    private JList<Project> jlistProjects;

    private DefaultListModel<Project> takenProjectListModel;
    private JList<Project> jlistTakenProjects;

    public MarketplaceGUI() {
        db = new DatabaseManager();
        initComponents();
        loadAllData();
    }

    private void initComponents() {
        setTitle("Marketplace Freelancer - Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocationRelativeTo(null);

        JPanel root = new JPanel(new BorderLayout(10, 10));
        root.setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentPane(root);

        // --- Left Panel: Freelancers ---
        JPanel leftPanel = new JPanel(new BorderLayout(5, 5));
        leftPanel.setPreferredSize(new Dimension(350, 0));
        leftPanel.setBorder(BorderFactory.createTitledBorder("Freelancer"));

        // Search Freelancer
        JPanel searchFreelancerPanel = new JPanel(new BorderLayout(5, 0));
        txtSearchFreelancer = new JTextField();
        JButton btnCariFreelancer = new JButton("Cari Skill/Nama");
        searchFreelancerPanel.add(txtSearchFreelancer, BorderLayout.CENTER);
        searchFreelancerPanel.add(btnCariFreelancer, BorderLayout.EAST);
        leftPanel.add(searchFreelancerPanel, BorderLayout.NORTH);

        // Add Freelancer Button
        JButton btnTambahFreelancer = new JButton("Tambah Freelancer");
        leftPanel.add(btnTambahFreelancer, BorderLayout.SOUTH); // Tombol Tambah Freelancer

        // Freelancer List
        freelancerListModel = new DefaultListModel<>();
        jlistFreelancers = new JList<>(freelancerListModel);
        JScrollPane scrollFreelancer = new JScrollPane(jlistFreelancers);
        leftPanel.add(scrollFreelancer, BorderLayout.CENTER);

        // --- Right Panel: Projects ---
        JPanel rightPanel = new JPanel(new BorderLayout(5, 5));
        rightPanel.setBorder(BorderFactory.createTitledBorder("Proyek Tersedia"));

        // Search Project
        JPanel searchProjectPanel = new JPanel(new BorderLayout(5, 0));
        txtSearchProject = new JTextField();
        JButton btnCariProyek = new JButton("Cari Proyek by Skill");
        searchProjectPanel.add(txtSearchProject, BorderLayout.CENTER);
        searchProjectPanel.add(btnCariProyek, BorderLayout.EAST);
        rightPanel.add(searchProjectPanel, BorderLayout.NORTH);

        // Project List
        projectListModel = new DefaultListModel<>();
        jlistProjects = new JList<>(projectListModel);
        JScrollPane scrollProjects = new JScrollPane(jlistProjects);
        rightPanel.add(scrollProjects, BorderLayout.CENTER);

        // --- Panel Tombol Proyek (Termasuk Tambah Proyek) ---
        JPanel projectButtonsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); // FlowLayout untuk tombol sejajar

        JButton btnTambahProyek = new JButton("Tambah Proyek"); // Tombol Tambah Proyek
        JButton btnAmbilProyek = new JButton("Ambil Proyek");
        JButton btnRefresh = new JButton("Refresh Semua");

        projectButtonsPanel.add(btnTambahProyek);
        projectButtonsPanel.add(btnAmbilProyek);
        projectButtonsPanel.add(btnRefresh);

        rightPanel.add(projectButtonsPanel, BorderLayout.SOUTH); // Tambahkan panel tombol ke bagian bawah rightPanel

        // --- Bottom Panel: Taken Projects ---
        JPanel bottomPanel = new JPanel(new BorderLayout(5, 5));
        bottomPanel.setPreferredSize(new Dimension(0, 250));
        bottomPanel.setBorder(BorderFactory.createTitledBorder("Proyek yang Diambil oleh Freelancer Terpilih"));

        // Taken Project List
        takenProjectListModel = new DefaultListModel<>();
        jlistTakenProjects = new JList<>(takenProjectListModel);
        JScrollPane scrollTaken = new JScrollPane(jlistTakenProjects);
        bottomPanel.add(scrollTaken, BorderLayout.CENTER);

        // Action Buttons for Taken Projects
        JPanel actionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton btnUpdateProgress = new JButton("Update Progress");
        JButton btnViewDetail = new JButton("Detail Proyek");
        actionPanel.add(btnUpdateProgress);
        actionPanel.add(btnViewDetail);
        bottomPanel.add(actionPanel, BorderLayout.SOUTH);

        // --- Main Layout ---
        JSplitPane mainSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
        mainSplitPane.setDividerLocation(350);
        root.add(mainSplitPane, BorderLayout.CENTER);
        root.add(bottomPanel, BorderLayout.SOUTH);

        // --- Event Listeners ---

        // Cari Freelancer
        btnCariFreelancer.addActionListener(e -> {
            String kw = txtSearchFreelancer.getText();
            List<Freelancer> res = db.searchFreelancerBySkillOrName(kw);
            refreshFreelancerList(res);
        });

        // Cari Proyek
        btnCariProyek.addActionListener(e -> {
            String skill = txtSearchProject.getText();
            List<Project> res = db.searchProjectBySkill(skill);
            refreshProjectList(res);
        });

        // Tambah Freelancer (Menggunakan Form Dialog)
        btnTambahFreelancer.addActionListener(e -> {
            AddFreelancerDialog dialog = new AddFreelancerDialog(this);
            dialog.setVisible(true);

            Freelancer newFreelancer = dialog.getFreelancerResult();
            if (newFreelancer != null) {
                db.insertFreelancer(newFreelancer);
                JOptionPane.showMessageDialog(this, "Freelancer berhasil ditambahkan!");
                loadAllData();
            }
        });

        // --- Tambah Proyek ---
        btnTambahProyek.addActionListener(e -> { // Aksi untuk tombol Tambah Proyek
            AddProjectDialog dialog = new AddProjectDialog(this);
            dialog.setVisible(true);

            Project newProject = dialog.getProjectResult();
            if (newProject != null) {
                db.insertProject(newProject);
                JOptionPane.showMessageDialog(this, "Proyek berhasil ditambahkan!");
                loadAllData();
            }
        });

        // Ambil Proyek
        btnAmbilProyek.addActionListener(e -> {
            Project p = jlistProjects.getSelectedValue();
            Freelancer f = jlistFreelancers.getSelectedValue();
            if (p == null) {
                JOptionPane.showMessageDialog(this, "Pilih proyek terlebih dahulu.");
                return;
            }
            if (f == null) {
                JOptionPane.showMessageDialog(this, "Pilih freelancer terlebih dahulu.");
                return;
            }
            if (p.isTaken()) {
                JOptionPane.showMessageDialog(this, "Proyek ini sudah diambil.");
                return;
            }
            boolean ok = db.assignProjectToFreelancer(p.getId(), f.getId());
            if (ok) {
                JOptionPane.showMessageDialog(this, "Berhasil! Proyek diambil oleh " + f.getName());
                loadAllData();
            } else {
                JOptionPane.showMessageDialog(this, "Gagal mengambil proyek. Mungkin sudah diambil oleh orang lain.");
                loadAllData();
            }
        });

        btnRefresh.addActionListener(e -> loadAllData());

        // Update Progress
        btnUpdateProgress.addActionListener(e -> {
            Project p = jlistTakenProjects.getSelectedValue();
            if (p == null) {
                JOptionPane.showMessageDialog(this, "Pilih proyek yang diambil untuk update.");
                return;
            }
            String[] options = {"Belum Dikerjakan", "Sedang Dikerjakan", "Selesai"};
            String sel = (String) JOptionPane.showInputDialog(this,
                    "Pilih status baru:", "Update Progress",
                    JOptionPane.QUESTION_MESSAGE, null, options, p.getProgress());
            if (sel != null && !sel.isEmpty()) {
                db.updateProjectProgress(p.getId(), sel);
                JOptionPane.showMessageDialog(this, "Progress proyek diperbarui.");
                loadAllData();
            }
        });

        // View Detail
        btnViewDetail.addActionListener(e -> {
            Project p = jlistTakenProjects.getSelectedValue();
            if (p == null) {
                JOptionPane.showMessageDialog(this, "Pilih proyek untuk melihat detail.");
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Judul: ").append(p.getTitle()).append("\n");
            sb.append("Perusahaan: ").append(p.getCompanyName()).append("\n");
            sb.append("Deskripsi: ").append(p.getDescription()).append("\n");
            sb.append("Skill Dibutuhkan: ").append(p.getRequiredSkills()).append("\n");
            sb.append("Budget: Rp ").append(p.getBudget()).append("\n");
            sb.append("Progress: ").append(p.getProgress()).append("\n");
            sb.append("Diambil oleh: ").append(p.getAssignedFreelancerName() != null ? p.getAssignedFreelancerName() : "N/A").append("\n");
            JOptionPane.showMessageDialog(this, sb.toString(), "Detail Proyek", JOptionPane.INFORMATION_MESSAGE);
        });

        // Listen for freelancer selection to update taken projects list
        jlistFreelancers.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                Freelancer f = jlistFreelancers.getSelectedValue();
                if (f != null) {
                    List<Project> taken = db.getProjectsByFreelancer(f.getId());
                    refreshTakenProjectList(taken);
                } else {
                    takenProjectListModel.clear();
                }
            }
        });
    }

    private void loadAllData() {
        List<Freelancer> allF = db.getAllFreelancers();
        refreshFreelancerList(allF);

        List<Project> availableP = db.getAvailableProjects();
        refreshProjectList(availableP);

        Freelancer selectedFreelancer = jlistFreelancers.getSelectedValue();
        if (selectedFreelancer != null) {
            List<Project> taken = db.getProjectsByFreelancer(selectedFreelancer.getId());
            refreshTakenProjectList(taken);
        } else {
            takenProjectListModel.clear();
        }
    }

    private void refreshFreelancerList(List<Freelancer> list) {
        freelancerListModel.clear();
        for (Freelancer f : list) {
            freelancerListModel.addElement(f);
        }
    }

    private void refreshProjectList(List<Project> list) {
        projectListModel.clear();
        for (Project p : list) {
            projectListModel.addElement(p);
        }
    }

    private void refreshTakenProjectList(List<Project> list) {
        takenProjectListModel.clear();
        for (Project p : list) {
            takenProjectListModel.addElement(p);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            MarketplaceGUI gui = new MarketplaceGUI();
            gui.setVisible(true);
        });
    }
}