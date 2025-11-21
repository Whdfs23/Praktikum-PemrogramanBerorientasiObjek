/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

/**
 *
 * @author LENOVO
 */
import Model.Freelancer;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MarketplaceGUI extends JFrame {
    private final List<Freelancer> freelancers;
    private final DefaultListModel<Freelancer> listModel;
    private final JList<Freelancer> freelancerList;
    private final JTextField searchField;

    public MarketplaceGUI() {
        setTitle("Freelance Marketplace - GUI");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Inisialisasi data dummy
        freelancers = createDummyFreelancers();
        listModel = new DefaultListModel<>();
        freelancers.forEach(listModel::addElement);
        freelancerList = new JList<>(listModel);
        freelancerList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        freelancerList.setCellRenderer(new FreelancerListCellRenderer());

        // Panel Pencarian
        JPanel topPanel = new JPanel(new BorderLayout());
        searchField = new JTextField(20);
        JButton searchBtn = new JButton("Cari Berdasarkan Skill");
        searchBtn.addActionListener(e -> performSearch());

        topPanel.add(new JLabel("Skill: "), BorderLayout.WEST);
        topPanel.add(searchField, BorderLayout.CENTER);
        topPanel.add(searchBtn, BorderLayout.EAST);

        // Tambahkan ke frame
        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(freelancerList), BorderLayout.CENTER);

        setVisible(true);
    }

    private void performSearch() {
        String skill = searchField.getText().trim();
        listModel.clear();
        if (skill.isEmpty()) {
            freelancers.forEach(listModel::addElement);
        } else {
            freelancers.stream()
                .filter(f -> f.hasSkill(skill))
                .forEach(listModel::addElement);
        }
    }

    private List<Freelancer> createDummyFreelancers() {
        List<Freelancer> list = new ArrayList<>();
        list.add(new Freelancer("Andi", "andi@email.com", List.of("Java", "Spring"), 30.0, 4.7));
        list.add(new Freelancer("Budi", "budi@email.com", List.of("Python", "Django"), 25.0, 4.5));
        list.add(new Freelancer("Citra", "citra@email.com", List.of("UI/UX", "Figma"), 35.0, 4.9));
        list.add(new Freelancer("Dewi", "dewi@email.com", List.of("Java", "React"), 28.0, 4.3));
        return list;
    }

    // Renderer kustom agar tampilan list lebih informatif
    private static class FreelancerListCellRenderer extends JLabel implements ListCellRenderer<Freelancer> {
        @Override
        public Component getListCellRendererComponent(JList<? extends Freelancer> list, Freelancer value,
                int index, boolean isSelected, boolean cellHasFocus) {
            setText(value.toString() + " | Skills: " + String.join(", ", value.getSkills()));
            setOpaque(true);
            setBackground(isSelected ? Color.LIGHT_GRAY : Color.WHITE);
            setForeground(isSelected ? Color.BLACK : Color.DARK_GRAY);
            setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            return this;
        }
    }
}