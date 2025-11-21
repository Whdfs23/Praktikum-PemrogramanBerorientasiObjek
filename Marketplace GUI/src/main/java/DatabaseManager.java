import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.*;
import com.mongodb.client.model.*;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

public class DatabaseManager {
    private static String connectionString = "mongodb+srv://danarhusain_db_user:DanaHussinFirmansyah@cluster0.tv83pzd.mongodb.net/?appName=Cluster0";
    
    private static MarketplaceGUI gui;
    private static MongoClient mongoClient;
    private static MongoDatabase database;
    private static MongoCollection<Document> freelancers;
    private static MongoCollection<Document> projects;
    private static boolean isError = false;

    private static ServerApi serverApi = ServerApi.builder()
            .version(ServerApiVersion.V1)
            .build();

    private static MongoClientSettings settings = MongoClientSettings.builder()
            .applyConnectionString(new ConnectionString(connectionString))
            .serverApi(serverApi)
            .build();

    public DatabaseManager(MarketplaceGUI gui) {
        this.gui = gui;
        if (isError) {
            gui.displayDatabaseError();
        }
    }

    static {
        try {
            mongoClient = MongoClients.create(settings);
            database = mongoClient.getDatabase("oop");
            freelancers = database.getCollection("freelancers");
            projects = database.getCollection("projects");
        } catch (Throwable t) {
            isError = true;
        }
    }

    public List<Freelancer> getAllFreelancers() {
        List<Freelancer> result = new ArrayList<>();
        for (Document doc : freelancers.find()) {
            Freelancer freelancer = new Freelancer(
                doc.getObjectId("_id"),
                doc.getString("name"),
                doc.getString("skill"),
                doc.getDouble("ratePerHour"),
                doc.getDouble("rating")
            );
            result.add(freelancer);
        }
        return result;
    }

    public List<Project> getAllProjects() {
        List<Project> result = new ArrayList<>();
        for (Document doc : projects.find()) {
            Project project = new Project(
                doc.getObjectId("_id"),
                doc.getString("title"),
                doc.getString("description"),
                doc.getDouble("budget"),
                doc.getString("companyName"),
                doc.getString("status"),
                doc.getObjectId("assignedFreelancerId"),
                doc.getString("assignedFreelancerName")
            );
            result.add(project);
        }
        return result;
    }

    public void insertFreelancer(Freelancer freelancer) {
        Document doc = new Document("name", freelancer.getName())
            .append("skill", freelancer.getSkill())
            .append("ratePerHour", freelancer.getRatePerHour())
            .append("rating", freelancer.getRating());
        freelancers.insertOne(doc);
        gui.refreshFreelancers();
    }

    public void insertProject(Project project) {
        Document doc = new Document("title", project.getTitle())
            .append("description", project.getDescription())
            .append("budget", project.getBudget())
            .append("companyName", project.getCompanyName())
            .append("status", project.getStatus())
            .append("assignedFreelancerId", null)
            .append("assignedFreelancerName", null);
        projects.insertOne(doc);
        gui.refreshProjects();
    }

    public void updateFreelancer(Freelancer freelancer, String name, String skill, double rate, double rating) {
        Bson filter = Filters.eq("_id", freelancer.getId());
        Bson update = Updates.combine(
            Updates.set("name", name),
            Updates.set("skill", skill),
            Updates.set("ratePerHour", rate),
            Updates.set("rating", rating)
        );
        freelancers.updateOne(filter, update);
        gui.refreshFreelancers();
    }

    public void updateProject(Project project, String title, String company, String desc, double budget) {
        Bson filter = Filters.eq("_id", project.getId());
        Bson update = Updates.combine(
            Updates.set("title", title),
            Updates.set("companyName", company),
            Updates.set("description", desc),
            Updates.set("budget", budget)
        );
        projects.updateOne(filter, update);
        gui.refreshProjects();
    }

    public void deleteFreelancer(ObjectId id) {
        freelancers.deleteOne(new Document("_id", id));
        gui.refreshFreelancers();
    }

    public void deleteProject(ObjectId id) {
        projects.deleteOne(new Document("_id", id));
        gui.refreshProjects();
    }

    // === FITUR BARU: assign project ke freelancer ===
    public void assignProject(Project project, Freelancer freelancer) {
        if (project == null || freelancer == null) return;
        Bson filter = Filters.eq("_id", project.getId());
        Bson update = Updates.combine(
            Updates.set("status", "In Progress"),
            Updates.set("assignedFreelancerId", freelancer.getId()),
            Updates.set("assignedFreelancerName", freelancer.getName())
        );
        try {
            projects.updateOne(filter, update);
            gui.refreshProjects();
        } catch (MongoException e) {
            e.printStackTrace();
            gui.displayDatabaseError();
        }
    }

    // === FITUR BARU: unassign project dari freelancer ===
    public void unassignProject(Project project) {
        if (project == null) return;
        Bson filter = Filters.eq("_id", project.getId());
        Bson update = Updates.combine(
            Updates.set("status", "Open"),
            Updates.set("assignedFreelancerId", null),
            Updates.set("assignedFreelancerName", null)
        );
        try {
            projects.updateOne(filter, update);
            gui.refreshProjects();
        } catch (MongoException e) {
            e.printStackTrace();
            gui.displayDatabaseError();
        }
    }

    // === FITUR BARU: Tandai project sudah selesai ===
    public void completeProject(Project project) {
        if (project == null) return;
        Bson filter = Filters.eq("_id", project.getId());
        Bson update = Updates.set("status", "Completed");
        try {
            projects.updateOne(filter, update);
            gui.refreshProjects();
        } catch (MongoException e) {
            e.printStackTrace();
            gui.displayDatabaseError();
        }
    }
}

