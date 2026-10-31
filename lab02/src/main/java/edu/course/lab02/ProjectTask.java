package edu.course.lab02;

public class ProjectTask {
    // 1. ПОЛЯ

    private final String id;
    private final String title;
    private TaskStatus status;
    private int estimatedHours;
// 2. КОНСТРУКТОР

    public ProjectTask(String id, String title, int estimatedHours) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("ID не может быть пустым");
        }
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Название не может быть пустым");
        }
        if (estimatedHours < 0) {
            throw new IllegalArgumentException("Оценка часов не может быть отрицательной");
        }

        this.id = id;
        this.title = title;
        this.estimatedHours = estimatedHours;
        this.status = TaskStatus.NEW;
        // По умолчанию всегда NEW
    }

// 3. ПОВЕДЕНИЕ
    public void changeStatus(TaskStatus newStatus) {
        if (newStatus == null) {
            throw new IllegalArgumentException("Статус не может быть null");
        }
        this.status = newStatus;
    }

    public boolean isCompleted() {
        return this.status == TaskStatus.DONE;
    }

    public void increaseEstimate(int extraHours) {
        if (extraHours <= 0) {
            throw new IllegalArgumentException("Добавить можно только положительное число часов");
        }
        this.estimatedHours += extraHours;
    }

// 4. ГЕТТЕРЫ
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public int getEstimatedHours() {
        return estimatedHours;
    }
}
