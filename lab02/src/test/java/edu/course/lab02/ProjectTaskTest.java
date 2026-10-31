package edu.course.lab02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class ProjectTaskTest {

    @Test
    void createValidTask() {
        ProjectTask task = new ProjectTask("T1", "Лаба", 10);
        assertEquals("T1", task.getId());
        assertEquals(TaskStatus.NEW, task.getStatus());
        assertFalse(task.isCompleted());
    }

    @Test
    void changeStatusToDoneMakesTaskCompleted() {
        ProjectTask task = new ProjectTask("T2", "Лаба", 5);
        task.changeStatus(TaskStatus.DONE);
        assertTrue(task.isCompleted());
    }

    @Test
    void increaseEstimateAddsHours() {
        ProjectTask task = new ProjectTask("T3", "Лаба", 5);
        task.increaseEstimate(3);
        assertEquals(8, task.getEstimatedHours());
    }

    @Test
    void constructorThrowsForInvalidData() {
        assertThrows(IllegalArgumentException.class, () -> new ProjectTask("", "Title", 5)); // Пустой ID
        assertThrows(IllegalArgumentException.class, () -> new ProjectTask("T4", " ", 5)); // Пустой Title
        assertThrows(IllegalArgumentException.class, () -> new ProjectTask("T5", "Title", -1)); // Минус часы
    }

    @Test
    void increaseEstimateThrowsForNonPositiveHours() {
        ProjectTask task = new ProjectTask("T6", "Title", 5);
        assertThrows(IllegalArgumentException.class, () -> task.increaseEstimate(0));
        assertThrows(IllegalArgumentException.class, () -> task.increaseEstimate(-2));
    }
}
