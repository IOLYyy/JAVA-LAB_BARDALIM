package edu.course.lab03;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class TaskPrioritizerTest {

    private final ProjectTask bigTask = new ProjectTask("Big", 10, "NEW");
    private final ProjectTask smallTask = new ProjectTask("Small", 2, "IN_PROGRESS");

    @Test
    void effortPolicyChoosesTaskWithMoreEffort() {
        TaskPrioritizer prioritizer = new TaskPrioritizer(new EffortPriorityPolicy());
        assertEquals(bigTask, prioritizer.chooseMoreImportant(bigTask, smallTask));
    }

    @Test
    void statusPolicyChoosesNewOverInProgress() {
        TaskPrioritizer prioritizer = new TaskPrioritizer(new StatusPriorityPolicy());
        // NEW имеет приоритет 3, IN_PROGRESS — 2
        assertEquals(bigTask, prioritizer.chooseMoreImportant(bigTask, smallTask));
    }

    @Test
    void statusPolicyChoosesInProgressOverDone() {
        ProjectTask doneTask = new ProjectTask("Done", 1, "DONE");
        TaskPrioritizer prioritizer = new TaskPrioritizer(new StatusPriorityPolicy());
        assertEquals(smallTask, prioritizer.chooseMoreImportant(smallTask, doneTask));
    }

    @Test
    void policyCanBeSwapped() {
        // При EffortPolicy побеждает bigTask (10 > 2),
        // но при StatusPolicy: bigTask NEW(3) > smallTask IN_PROGRESS(2) — тоже bigTask.
        // Создадим задачу, где результаты различаются.
        ProjectTask lowEffortNew = new ProjectTask("LowEffortNew", 1, "NEW");
        ProjectTask highEffortDone = new ProjectTask("HighEffortDone", 100, "DONE");

        TaskPrioritizer effortPrioritizer = new TaskPrioritizer(new EffortPriorityPolicy());
        assertEquals(highEffortDone, effortPrioritizer.chooseMoreImportant(lowEffortNew, highEffortDone));

        TaskPrioritizer statusPrioritizer = new TaskPrioritizer(new StatusPriorityPolicy());
        assertEquals(lowEffortNew, statusPrioritizer.chooseMoreImportant(lowEffortNew, highEffortDone));
    }
}