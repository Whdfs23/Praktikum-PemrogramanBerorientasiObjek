/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author LENOVO
 */
public class Project {
    private String title;
    private String description;
    private double budget;

    public Project(String title, String description, double budget) {
        this.title = title;
        this.description = description;
        this.budget = budget;
    }

    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public double getBudget() { return budget; }

    @Override
    public String toString() {
        return title + " ($" + budget + ")";
    }
}