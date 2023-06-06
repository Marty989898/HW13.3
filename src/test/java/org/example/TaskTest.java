package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    public void testSimpleTaskfound() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("родителям");
        Assertions.assertTrue(actual);
    }

    @Test
    public void testSimpleTaskNOTfound() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("бабушке");
        Assertions.assertFalse(actual);
    }


    @Test
    public void testEpicNOTfound() {
       String[] subtasks = {"Молоко, Яйца, Хлеб"};
       Epic epic = new Epic(55, subtasks);
       Epic epicEmpty = new Epic(55, new String[]{});
        Assertions.assertTrue(epic.matches("Хлеб"));
        Assertions.assertFalse(epic.matches("Хлеба"));
        Assertions.assertTrue(epic.matches("Яйца"));
        Assertions.assertFalse(epic.matches("Яйцо"));
        Assertions.assertFalse(epic.matches("сметана"));

    }

    @Test
    public void testmeetingNOTfound() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");

        Assertions.assertTrue(meeting.matches("приложения"));
        Assertions.assertFalse(meeting.matches("прилажение"));
        Assertions.assertTrue(meeting.matches("НетоБанка"));
        Assertions.assertFalse(meeting.matches("НатаБанка"));
        Assertions.assertFalse(meeting.matches("среда"));
        Assertions.assertTrue(meeting.matches("Выкатка"));
        Assertions.assertFalse(meeting.matches("Выкатака"));
    }

}