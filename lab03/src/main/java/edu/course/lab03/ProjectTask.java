package edu.course.lab03;

public class ProjectTask {
    private final String name;
    private final int effort;   // условная «трудоёмкость»
    private final String status; // "NEW", "IN_PROGRESS", "DONE"

    public ProjectTask(String name, int effort, String status) {
        this.name = name;
        this.effort = effort;
        this.status = status;
    }

    public String getName() { return name; }
    public int getEffort() { return effort; }
    public String getStatus() { return status; }
}
