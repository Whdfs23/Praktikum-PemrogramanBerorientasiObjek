// File: DatabaseManager.java
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.*;
import com.mongodb.client.model.*;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private static String connectionString = "mongodb+srv://danarhusain_db_user:DanaHussinFirmansyah@cluster0.zvkcqyo.mongodb.net/?appName=Cluster0";

    private static MongoClient mongoClient;
    private static MongoDatabase database;
    private static MongoCollection<Document> freelancersCollection;
    private static MongoCollection<Document> projectsCollection;

    private static ServerApi serverApi = ServerApi.builder()
            .version(ServerApiVersion.V1)
            .build();

    private static MongoClientSettings settings = MongoClientSettings.builder()
            .applyConnectionString(new ConnectionString(connectionString))
            .serverApi(serverApi)
            .build();

    public DatabaseManager() {
        try {
            mongoClient = MongoClients.create(settings);
            database = mongoClient.getDatabase("oop");
            freelancersCollection = database.getCollection("freelancers");
            projectsCollection = database.getCollection("projects");
        } catch (Exception e) {
            System.err.println("Kesalahan koneksi ke MongoDB: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // --- Freelancer Operations ---
    public List<Freelancer> getAllFreelancers() {
        List<Freelancer> result = new ArrayList<>();
        for (Document doc : freelancersCollection.find()) {
            // Ambil data, periksa null dan gunakan default
            String name = doc.getString("name");
            if (name == null) name = "Nama Tidak Diset";

            String skill = doc.getString("skill");
            if (skill == null) skill = "Skill Tidak Diset";

            String email = doc.getString("email");
            if (email == null) email = "Email Tidak Diset";

            Double ratePerHour = doc.getDouble("ratePerHour");
            if (ratePerHour == null) ratePerHour = 0.0; // Gunakan Double, lalu unbox ke double

            String experience = doc.getString("experience");
            if (experience == null) experience = "Pengalaman Tidak Diset";

            Freelancer f = new Freelancer(name, skill, email, ratePerHour, experience);
            f.setId(doc.getObjectId("_id")); // ID selalu ada di MongoDB

            // Ambil daftar proyek yang diambil, jika ada
            if (doc.containsKey("takenProjects") && doc.get("takenProjects") instanceof List) {
                @SuppressWarnings("unchecked")
                List<ObjectId> projectIds = (List<ObjectId>) doc.get("takenProjects");
                f.setTakenProjects(projectIds);
            } else {
                f.setTakenProjects(new ArrayList<>()); // Atur ke list kosong jika tidak ada
            }
            result.add(f);
        }
        return result;
    }

    public List<Freelancer> searchFreelancerBySkillOrName(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return getAllFreelancers();
        }
        List<Freelancer> result = new ArrayList<>();
        Bson filter = Filters.or(
                Filters.regex("name", keyword, "i"),
                Filters.regex("skill", keyword, "i")
        );
        for (Document doc : freelancersCollection.find(filter)) {
             String name = doc.getString("name");
             if (name == null) name = "Nama Tidak Diset";

             String skill = doc.getString("skill");
             if (skill == null) skill = "Skill Tidak Diset";

             String email = doc.getString("email");
             if (email == null) email = "Email Tidak Diset";

             Double ratePerHour = doc.getDouble("ratePerHour");
             if (ratePerHour == null) ratePerHour = 0.0;

             String experience = doc.getString("experience");
             if (experience == null) experience = "Pengalaman Tidak Diset";

             Freelancer f = new Freelancer(name, skill, email, ratePerHour, experience);
             f.setId(doc.getObjectId("_id"));

             if (doc.containsKey("takenProjects") && doc.get("takenProjects") instanceof List) {
                  @SuppressWarnings("unchecked")
                  List<ObjectId> projectIds = (List<ObjectId>) doc.get("takenProjects");
                  f.setTakenProjects(projectIds);
             } else {
                 f.setTakenProjects(new ArrayList<>());
             }
             result.add(f);
        }
        return result;
    }

    public void insertFreelancer(Freelancer freelancer) {
        Document doc = new Document("name", freelancer.getName())
                .append("skill", freelancer.getSkill())
                .append("email", freelancer.getEmail())
                .append("ratePerHour", freelancer.getRatePerHour())
                .append("experience", freelancer.getExperience())
                .append("takenProjects", new ArrayList<>());
        freelancersCollection.insertOne(doc);
    }

    // --- Project Operations ---
    public List<Project> getAllProjects() {
        List<Project> result = new ArrayList<>();
        for (Document doc : projectsCollection.find()) {
            ObjectId assignedId = doc.getObjectId("assignedTo"); // Bisa null
            String assignedName = null;
            if (assignedId != null) {
                 Document freelancerDoc = freelancersCollection.find(Filters.eq("_id", assignedId)).first();
                 if (freelancerDoc != null) {
                     assignedName = freelancerDoc.getString("name");
                 }
            }

            // Ambil data, periksa null dan gunakan default
            String title = doc.getString("title");
            if (title == null) title = "Judul Tidak Diset";

            String companyName = doc.getString("companyName");
            if (companyName == null) companyName = "Perusahaan Tidak Diset";

            String description = doc.getString("description");
            if (description == null) description = "Deskripsi Tidak Diset";

            String requiredSkills = doc.getString("requiredSkills");
            if (requiredSkills == null) requiredSkills = "Skill Tidak Diset";

            Double budget = doc.getDouble("budget");
            if (budget == null) budget = 0.0; // Gunakan Double, lalu unbox ke double

            Project p = new Project(title, companyName, description, requiredSkills, budget);
            p.setId(doc.getObjectId("_id")); // ID selalu ada di MongoDB
            p.setAssignedFreelancer(assignedId, assignedName); // assignedId bisa null, OK untuk setter
            // Periksa progress juga
            String progress = doc.getString("progress");
            if (progress == null) progress = "Belum Dikerjakan";
            p.setProgress(progress);
            result.add(p);
        }
        return result;
    }

    public List<Project> getAvailableProjects() {
        List<Project> result = new ArrayList<>();
        Bson filter = Filters.eq("assignedTo", null);
        for (Document doc : projectsCollection.find(filter)) {
             String title = doc.getString("title");
             if (title == null) title = "Judul Tidak Diset";

             String companyName = doc.getString("companyName");
             if (companyName == null) companyName = "Perusahaan Tidak Diset";

             String description = doc.getString("description");
             if (description == null) description = "Deskripsi Tidak Diset";

             String requiredSkills = doc.getString("requiredSkills");
             if (requiredSkills == null) requiredSkills = "Skill Tidak Diset";

             Double budget = doc.getDouble("budget");
             if (budget == null) budget = 0.0;

             Project p = new Project(title, companyName, description, requiredSkills, budget);
             p.setId(doc.getObjectId("_id"));
             p.setTaken(false);
             String progress = doc.getString("progress");
             if (progress == null) progress = "Belum Dikerjakan";
             p.setProgress(progress);
             result.add(p);
        }
        return result;
    }

    public List<Project> searchProjectBySkill(String skill) {
        if (skill == null || skill.trim().isEmpty()) {
            return getAvailableProjects();
        }
        List<Project> result = new ArrayList<>();
        Bson filter = Filters.and(
                Filters.regex("requiredSkills", skill, "i"),
                Filters.eq("assignedTo", null)
        );
        for (Document doc : projectsCollection.find(filter)) {
             String title = doc.getString("title");
             if (title == null) title = "Judul Tidak Diset";

             String companyName = doc.getString("companyName");
             if (companyName == null) companyName = "Perusahaan Tidak Diset";

             String description = doc.getString("description");
             if (description == null) description = "Deskripsi Tidak Diset";

             String requiredSkills = doc.getString("requiredSkills");
             if (requiredSkills == null) requiredSkills = "Skill Tidak Diset";

             Double budget = doc.getDouble("budget");
             if (budget == null) budget = 0.0;

             Project p = new Project(title, companyName, description, requiredSkills, budget);
             p.setId(doc.getObjectId("_id"));
             p.setTaken(false);
             String progress = doc.getString("progress");
             if (progress == null) progress = "Belum Dikerjakan";
             p.setProgress(progress);
             result.add(p);
        }
        return result;
    }

    public List<Project> getProjectsByFreelancer(ObjectId freelancerId) {
        List<Project> result = new ArrayList<>();
        Bson filter = Filters.eq("assignedTo", freelancerId);
        for (Document doc : projectsCollection.find(filter)) {
            String freelancerName = null;
            Document freelancerDoc = freelancersCollection.find(Filters.eq("_id", freelancerId)).first();
            if (freelancerDoc != null) {
                freelancerName = freelancerDoc.getString("name");
            }

             String title = doc.getString("title");
             if (title == null) title = "Judul Tidak Diset";

             String companyName = doc.getString("companyName");
             if (companyName == null) companyName = "Perusahaan Tidak Diset";

             String description = doc.getString("description");
             if (description == null) description = "Deskripsi Tidak Diset";

             String requiredSkills = doc.getString("requiredSkills");
             if (requiredSkills == null) requiredSkills = "Skill Tidak Diset";

             Double budget = doc.getDouble("budget");
             if (budget == null) budget = 0.0;

             Project p = new Project(title, companyName, description, requiredSkills, budget);
             p.setId(doc.getObjectId("_id"));
             p.setAssignedFreelancer(freelancerId, freelancerName);
             String progress = doc.getString("progress");
             if (progress == null) progress = "Belum Dikerjakan";
             p.setProgress(progress);
             result.add(p);
        }
        return result;
    }

 // Di dalam class DatabaseManager
public void insertProject(Project project) {
    Document doc = new Document("title", project.getTitle())
            .append("companyName", project.getCompanyName())
            .append("description", project.getDescription())
            .append("requiredSkills", project.getRequiredSkills())
            .append("budget", project.getBudget())
            .append("assignedTo", null) // Awalnya belum diambil
            .append("progress", project.getProgress()); // Gunakan progress default dari objek
    projectsCollection.insertOne(doc);
}

    public boolean assignProjectToFreelancer(ObjectId projectId, ObjectId freelancerId) {
        Bson filter = Filters.and(
                Filters.eq("_id", projectId),
                Filters.eq("assignedTo", null)
        );
        Document freelancerDoc = freelancersCollection.find(Filters.eq("_id", freelancerId)).first();
        String freelancerName = freelancerDoc != null ? freelancerDoc.getString("name") : "Unknown";

        Bson update = Updates.combine(
                Updates.set("assignedTo", freelancerId),
                Updates.set("progress", "Sedang Dikerjakan"),
                Updates.set("assignedToName", freelancerName)
        );

        com.mongodb.client.result.UpdateResult result = projectsCollection.updateOne(filter, update);

        if (result.getModifiedCount() == 1) {
            freelancersCollection.updateOne(
                Filters.eq("_id", freelancerId),
                Updates.push("takenProjects", projectId)
            );
            return true;
        }
        return false;
    }

    public void updateProjectProgress(ObjectId projectId, String newProgress) {
        Bson filter = Filters.eq("_id", projectId);
        Bson update = Updates.set("progress", newProgress);
        projectsCollection.updateOne(filter, update);
    }

    public void deleteFreelancer(ObjectId id) {
        freelancersCollection.deleteOne(Filters.eq("_id", id));
    }

    public void deleteProject(ObjectId id) {
        projectsCollection.deleteOne(Filters.eq("_id", id));
    }
}