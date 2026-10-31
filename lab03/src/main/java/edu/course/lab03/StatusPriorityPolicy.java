package edu.course.lab03;

public class StatusPriorityPolicy implements PriorityPolicy {
    @Override
    public int calculatePriority(ProjectTask task) {
        return switch (task.getStatus()) {
            case "NEW" -> 3;
            case "IN_PROGRESS" -> 2;
            case "DONE" -> 1;
            default -> 0;
        };
    }
}