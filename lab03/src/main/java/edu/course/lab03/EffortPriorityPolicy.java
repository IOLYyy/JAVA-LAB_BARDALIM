package edu.course.lab03;

public class EffortPriorityPolicy implements PriorityPolicy {
    @Override
    public int calculatePriority(ProjectTask task) {
        // Чем больше effort, тем выше приоритет
        return task.getEffort();
    }
}