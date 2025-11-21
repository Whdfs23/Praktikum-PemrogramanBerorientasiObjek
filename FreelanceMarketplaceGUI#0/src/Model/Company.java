/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author LENOVO
 */
public class Company extends User {
    private String companyName;

    public Company(String name, String email, String companyName) {
        super(name, email);
        this.companyName = companyName;
    }

    public String getCompanyName() { return companyName; }

    @Override
    public void displayProfile() {
        System.out.println("Company: " + companyName);
    }
}
