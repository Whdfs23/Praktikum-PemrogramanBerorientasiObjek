// File: Freelancer.java
import org.bson.types.ObjectId;
import java.util.ArrayList;
import java.util.List;

public class Freelancer {
    private ObjectId id;
    private String name;
    private String skill;
    private String email;
    private double ratePerHour;
    private String experience;
    private List<ObjectId> takenProjects;

    public Freelancer(String name, String skill, String email, double ratePerHour, String experience) {
        this.id = new ObjectId();
        this.name = name;
        this.skill = skill;
        this.email = email;
        this.ratePerHour = ratePerHour;
        this.experience = experience;
        this.takenProjects = new ArrayList<>();
    }

    public Freelancer() {
        this.id = new ObjectId();
        this.takenProjects = new ArrayList<>();
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getRatePerHour() {
        return ratePerHour;
    }

    public void setRatePerHour(double ratePerHour) {
        this.ratePerHour = ratePerHour;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public List<ObjectId> getTakenProjects() {
        return takenProjects;
    }

    public void setTakenProjects(List<ObjectId> takenProjects) {
        this.takenProjects = takenProjects != null ? takenProjects : new ArrayList<>();
    }

    public void addTakenProject(ObjectId projectId) {
        if (!takenProjects.contains(projectId)) {
            takenProjects.add(projectId);
        }
    }

    public void removeTakenProject(ObjectId projectId) {
        takenProjects.remove(projectId);
    }

    @Override
    public String toString() {
        return name + " | Skill: " + skill + " | Rate: Rp " + ratePerHour + "/hr";
    }
}