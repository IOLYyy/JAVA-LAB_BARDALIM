package edu.course.lab02;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProjectTaskTest {
    @Test
    void testCreateTask() {
        ProjectTask task = new ProjectTask("1", "Лаба", 10);
        assertEquals("1", task.getId());
        assertEquals(TaskStatus.NEW, task.getStatus());
        assertFalse(task.isCompleted());
    }

    @Test
    void testChangeStatus() {
        ProjectTask task = new ProjectTask("2", "Лаба", 5);
        task.changeStatus(TaskStatus.DONE);
        assertTrue(task.isCompleted());
    }

    @Test
    void testIncreaseHours() {
        ProjectTask task = new ProjectTask("3", "Лаба", 5);
        task.increaseEstimate(3);
        assertEquals(8, task.getEstimatedHours());
    }

    @Test
    void testErrors() {
        assertThrows(IllegalArgumentException.class, () -> new ProjectTask("", "T", 5));
        assertThrows(IllegalArgumentException.class, () -> new ProjectTask("1", "", 5));
        assertThrows(IllegalArgumentException.class, () -> new ProjectTask("1", "T", -1));
    }
}