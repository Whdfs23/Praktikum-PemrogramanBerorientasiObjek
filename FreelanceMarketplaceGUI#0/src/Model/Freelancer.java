/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author LENOVO
 */
import java.util.List;
import java.util.ArrayList;
// import java.util.stream.Stream; // Dihapus karena sudah tidak dipakai setelah method duplikat dihapus

public class Freelancer extends User {
    private final List<String> skills;
    private final double ratePerHour;
    private final double rating;

    public Freelancer(String name, String email, List<String> skills, double ratePerHour, double rating) {
        super(name, email);
        this.skills = new ArrayList<>(skills);
        this.ratePerHour = ratePerHour;
        this.rating = rating;
    }

    public List<String> getSkills() { return new ArrayList<>(skills); }
    public double getRatePerHour() { return ratePerHour; }
    public double getRating() { return rating; }

    @Override
    public void displayProfile() {
        System.out.println("Freelancer: " + name + " | Rating: " + rating);
    }

    public boolean hasSkill(String skill) {
        return skills.stream().anyMatch(s -> s.equalsIgnoreCase(skill));
    }

    @Override
    public String toString() {
        return String.format("%s (Rate: $%.2f/hr, Rating: %.1f)", name, ratePerHour, rating);
    }
}