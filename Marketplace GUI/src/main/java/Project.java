import org.bson.types.ObjectId;

public class Project {

    private ObjectId id;
    private String title;
    private String description;
    private double budget;
    private String companyName;

    // --- FITUR BARU ---
    private String status; // "Open", "In Progress", "Completed"
    private ObjectId assignedFreelancerId;
    private String assignedFreelancerName;
    // -------------------

    // Constructor lengkap untuk membaca dari Database
    public Project(ObjectId id, String title, String description, double budget, String companyName,
                  String status, ObjectId assignedFreelancerId, String assignedFreelancerName) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.budget = budget;
        this.companyName = companyName;
        this.status = status;
        this.assignedFreelancerId = assignedFreelancerId;
        this.assignedFreelancerName = assignedFreelancerName;
    }

    // Constructor simpel untuk membuat proyek BARU (dari GUI)
    public Project(String title, String description, double budget, String companyName) {
        this.title = title;
        this.description = description;
        this.budget = budget;
        this.companyName = companyName;
        this.status = "Open";
        this.assignedFreelancerId = null;
        this.assignedFreelancerName = null;
    }

    // Getters
    public ObjectId getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public double getBudget() { return budget; }
    public String getCompanyName() { return companyName; }
    public String getStatus() { return status; }
    public ObjectId getAssignedFreelancerId() { return assignedFreelancerId; }
    public String getAssignedFreelancerName() { return assignedFreelancerName; }

    @Override
    public String toString() {
        return title + " (" + companyName + ")";
    }
}
