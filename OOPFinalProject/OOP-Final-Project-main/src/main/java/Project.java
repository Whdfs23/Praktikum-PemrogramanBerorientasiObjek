// File: Project.java
import org.bson.types.ObjectId;

public class Project {
    private ObjectId id;
    private String title;
    private String companyName;
    private String description;
    private String requiredSkills;
    private double budget;
    private ObjectId assignedFreelancerId;
    private String assignedFreelancerName;
    private boolean isTaken;
    private String progress;

    public Project(String title, String companyName, String description, String requiredSkills, double budget) {
        this.id = new ObjectId();
        this.title = title;
        this.companyName = companyName;
        this.description = description;
        this.requiredSkills = requiredSkills;
        this.budget = budget;
        this.assignedFreelancerId = null;
        this.assignedFreelancerName = null;
        this.isTaken = false;
        this.progress = "Belum Dikerjakan";
    }

    public Project() {
        this.id = new ObjectId();
        this.progress = "Belum Dikerjakan";
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRequiredSkills() {
        return requiredSkills;
    }

    public void setRequiredSkills(String requiredSkills) {
        this.requiredSkills = requiredSkills;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public ObjectId getAssignedFreelancerId() {
        return assignedFreelancerId;
    }

    public String getAssignedFreelancerName() {
        return assignedFreelancerName;
    }

    public boolean isTaken() {
        return isTaken;
    }

    public String getProgress() {
        return progress;
    }

    public void setAssignedFreelancer(ObjectId freelancerId, String freelancerName) {
        this.assignedFreelancerId = freelancerId;
        this.assignedFreelancerName = freelancerName;
        this.isTaken = (freelancerId != null);
    }

    public void setTaken(boolean taken) {
        this.isTaken = taken;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    @Override
    public String toString() {
        String takenInfo = isTaken ? " | Taken by: " + (assignedFreelancerName != null ? assignedFreelancerName : assignedFreelancerId) : " | Available";
        return title + " (" + companyName + ")" + takenInfo + " | Budget: Rp " + budget + " | Status: " + progress;
    }
}