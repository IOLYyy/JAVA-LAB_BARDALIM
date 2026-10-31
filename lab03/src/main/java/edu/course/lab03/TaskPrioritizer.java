package edu.course.lab03;

public class TaskPrioritizer {
    private final PriorityPolicy policy;

    public TaskPrioritizer(PriorityPolicy policy) {
        this.policy = policy;
    }

    public ProjectTask chooseMoreImportant(ProjectTask first, ProjectTask second) {
        return policy.calculatePriority(first) >= policy.calculatePriority(second)
                ? first
                : second;
    }
}